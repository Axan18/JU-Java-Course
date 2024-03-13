public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setAccumulator(10);
        calc.addToAccumulator(5);
        calc.subtractFromAccumulator(3);
        calc.exchangeMemoryWithAccumulator(0);
        calc.addMemoryToAccumulator(0);
        calc.addToAccumulator(15);
        //calc.subtractMemoryFromAccumulator(0);
        //calc.accumulatorToMemory(0);
        System.out.println(calc.getMemory(0));
        System.out.println(calc.getAccumulator());
        Calculator calc1 = new Calculator();
        calc1.setAccumulator(13);
        calc1.addToAccumulator(5);
        calc1.subtractFromAccumulator(3);
        calc1.exchangeMemoryWithAccumulator(0);
        calc1.addMemoryToAccumulator(0);
        calc1.addToAccumulator(16);
        calc1.pushAccumulatorOnStack();
        calc1.pushAccumulatorOnStack();

        calc1.pushAccumulatorOnStack();

        calc1.pushAccumulatorOnStack();

        calc1.pushAccumulatorOnStack();

        //calc.subtractMemoryFromAccumulator(0);
        //calc.accumulatorToMemory(0);
        System.out.println(calc1.getMemory(0));
        System.out.println(calc1.getAccumulator());
    }
}
