import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwMikolaj test = new SwMikolaj();
        List<String> nazwyKlas = new ArrayList<>();
        nazwyKlas.add("Test1");
        nazwyKlas.add("Test2");
        //nazwyKlas.add("Test3");
        Map<String, Integer> testMap = test.inwentaryzacja(nazwyKlas);
        System.out.println(testMap);
    }
}