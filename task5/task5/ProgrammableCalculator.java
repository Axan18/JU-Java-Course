import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

class ProgrammableCalculator implements ProgrammableCalculatorInterface{
    private BufferedReader reader;
    private LineReader input;
    private LinePrinter output;
    private Map<Integer,String> program = new HashMap<>();
    private Map<String,Integer> variables = new HashMap<>();
    private Iterator<Map.Entry<Integer,String>> iterator;
    Map<Integer, String> sortedMap = new HashMap<>();
    @Override
    public void programCodeReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void setStdin(LineReader input) {
        this.input = input;
    }

    @Override
    public void setStdout(LinePrinter output) {
        this.output = output;
    }

    @Override
    public void run(int line) {
        programLoader();
        while(line!=0){
            line = interpreter(line);
        }
    }
    private void programLoader() {
        String lineOfCode;
        try {
            while ((lineOfCode = reader.readLine()) != null && !lineOfCode.trim().equals("")){
                String[] split = lineOfCode.split(" ", 2);
                program.put(Integer.parseInt(split[0]), split[1]);
            }
            sortedMap = program.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            iterator = sortedMap.entrySet().iterator();
        } catch (Exception ignore) {
        }
    }
    private int interpreter(int line)
    {
        String[] command = program.get(line).split(" ");
        switch (command[0].toUpperCase()) {
            case "LET":
                if (command.length == 4) variables.put(command[1].toUpperCase(), Integer.parseInt(command[3]));
                else {
                    String variable = command[1].toUpperCase();
                    int val1 = variables.containsKey(command[3].toUpperCase()) ? variables.get(command[3].toUpperCase()) : Integer.parseInt(command[3]);
                    int val2 = variables.containsKey(command[5].toUpperCase()) ? variables.get(command[5].toUpperCase()) : Integer.parseInt(command[5]);

                    switch (command[4]) {
                        case "+":
                            variables.put(variable, val1 + val2);
                            break;
                        case "-":
                            variables.put(variable, val1 - val2);
                            break;
                        case "*":
                            variables.put(variable, val1 * val2);
                            break;
                        case "/":
                            variables.put(variable, val1 / val2);
                            break;
                    }
                }
                break;
            case "PRINT":
                if (command[1].charAt(0) == '"') {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < command.length; i++) {
                        sb.append(command[i]);
                        sb.append(" ");
                    }
                    output.printLine(sb.substring(1, sb.length() - 2));
                } else
                    output.printLine(String.valueOf(variables.get(command[1].toUpperCase())));
                break;
            case "GOTO":
                return Integer.parseInt(command[1]);
            case "IF":
                String variable1 = command[1].toUpperCase();
                String operator = command[2];
                String variable2 = command[3].toUpperCase();
                int targetLine = Integer.parseInt(command[5]);

                if (variables.containsKey(variable1) && variables.containsKey(variable2)) {
                    switch (operator) {
                        case "=":
                            if (Objects.equals(variables.get(variable1), variables.get(variable2)))
                                return targetLine;
                            break;
                        case "<":
                            if (variables.get(variable1) < variables.get(variable2))
                                return targetLine;
                            break;
                        case ">":
                            if (variables.get(variable1) > variables.get(variable2))
                                return targetLine;
                            break;
                        // Dodaj warunek dla operatora ==
                        case "==":
                            if (Objects.equals(variables.get(variable1), variables.get(variable2)))
                                return targetLine;
                            break;
                    }
                } else if (variables.containsKey(variable1) && !variables.containsKey(variable2)) {
                    int value2 = Integer.parseInt(command[3]);
                    switch (operator) {
                        case "=":
                            if (Objects.equals(variables.get(variable1), value2))
                                return targetLine;
                            break;
                        case "<":
                            if (variables.get(variable1) < value2)
                                return targetLine;
                            break;
                        case ">":
                            if (variables.get(variable1) > value2)
                                return targetLine;
                            break;
                        // Dodaj warunek dla operatora ==
                        case "==":
                            if (Objects.equals(variables.get(variable1), value2))
                                return targetLine;
                            break;
                    }
                } else if (!variables.containsKey(variable1) && variables.containsKey(variable2)) {
                    int value1 = Integer.parseInt(command[1]);
                    switch (operator) {
                        case "=":
                            if (Objects.equals(value1, variables.get(variable2)))
                                return targetLine;
                            break;
                        case "<":
                            if (value1 < variables.get(variable2))
                                return targetLine;
                            break;
                        case ">":
                            if (value1 > variables.get(variable2))
                                return targetLine;
                            break;
                        // Dodaj warunek dla operatora ==
                        case "==":
                            if (Objects.equals(value1, variables.get(variable2)))
                                return targetLine;
                            break;
                    }
                } else {
                    int value1 = Integer.parseInt(command[1]);
                    int value2 = Integer.parseInt(command[3]);
                    switch (operator) {
                        case "=":
                            if (Objects.equals(value1, value2))
                                return targetLine;
                            break;
                        case "<":
                            if (value1 < value2)
                                return targetLine;
                            break;
                        case ">":
                            if (value1 > value2)
                                return targetLine;
                            break;
                        // Dodaj warunek dla operatora ==
                        case "==":
                            if (Objects.equals(value1, value2))
                                return targetLine;
                            break;
                    }
                }
                break;


            case "INPUT":
                variables.put(command[1].toUpperCase(), Integer.parseInt(input.readLine()));
                break;
            case "END":
                return 0;
        }
        iterator = sortedMap.entrySet().iterator();
        int nextLine=0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            if (entry.getKey() >= line) {
                nextLine = entry.getKey();
                if(nextLine==line) continue;
                return nextLine;
            }
        }
        return 0;
    }
}
