import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

class ProgrammableCalculator implements ProgrammableCalculatorInterface{
    private BufferedReader reader;
    private LineReader input;
    private LinePrinter output;
    private TreeMap<Integer,String> program = new TreeMap<>();
    private Map<String,Integer> variables = new HashMap<>();
    private Iterator<SortedMap.Entry<Integer,String>> iterator;
    private Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    private int depth = 0;
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
            iterator = program.entrySet().iterator();
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
                    String variable3 = command[3].toUpperCase();
                    String variable5 = command[5].toUpperCase();
                    int val1 = variables.containsKey(variable3) ? variables.get(variable3) : Integer.parseInt(command[3]);
                    int val2 = variables.containsKey(variable5) ? variables.get(variable5) : Integer.parseInt(command[5]);
                    switch (command[4]) {
                        case "+" -> variables.put(variable, val1 + val2);
                        case "-" -> variables.put(variable, val1 - val2);
                        case "*" -> variables.put(variable, val1 * val2);
                        case "/" -> variables.put(variable, val1 / val2);
                    }
                }
                break;
            case "PRINT":
                if (command[1].charAt(0) == '"') {
                    for (int i = 1; i < command.length; i++) {
                        sb.append(command[i]);
                        sb.append(" ");
                    }
                    output.printLine(sb.substring(1, sb.length() - 2));
                } else
                    output.printLine(String.valueOf(variables.get(command[1].toUpperCase())));
                sb.setLength(0);
                break;
            case "GOTO":
                return Integer.parseInt(command[1]);
            case "IF":
                String variable1 = command[1].toUpperCase();
                String operator = command[2];
                String variable2 = command[3].toUpperCase();
                int targetLine = Integer.parseInt(command[5]);
                int value1 = variables.containsKey(variable1) ? variables.get(variable1) : Integer.parseInt(command[1]);
                int value2 = variables.containsKey(variable2) ? variables.get(variable2) : Integer.parseInt(command[3]);

                switch (operator) {
                    case "=":
                        if (value1 == value2)
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
                }
                break;
            case "GOSUB":
                depth++;
                iterator = program.tailMap(line).entrySet().iterator();
                iterator.next();
                int nextLine = 0;
                if (iterator.hasNext()) {
                    Map.Entry<Integer, String> entry = iterator.next();
                    nextLine = entry.getKey();
                }
                stack.push(nextLine);
                return Integer.parseInt(command[1]);
            case "RETURN":
                if (depth > 0) {
                    depth--;
                    return stack.pop();
                }
                break;
            case "INPUT":
                variables.put(command[1].toUpperCase(), Integer.parseInt(input.readLine()));
                break;
            case "END":
                return 0;
        }
        iterator = program.tailMap(line).entrySet().iterator();
        iterator.next();
        int nextLine = 0;
        if (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            nextLine = entry.getKey();
            return nextLine;
        }
        return 0;
    }
}
