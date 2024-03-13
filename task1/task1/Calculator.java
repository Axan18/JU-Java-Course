import java.util.Stack;

class Calculator extends CalculatorOperations{
    private int accumulator;
    private int[] memory;
    private Stack<Integer> stack;
    public Calculator(){
        this.accumulator = 0;
        this.memory = new int[MEMORY_SIZE];
        this.stack = new Stack<>();
    }
    @Override
    public void setAccumulator(int value) {
        this.accumulator = value;
    }

    @Override
    public int getAccumulator() {
        return this.accumulator;
    }

    @Override
    public int getMemory(int index) {
        return memory[index];
    }

    @Override
    public void accumulatorToMemory(int index) {
        memory[index] = this.accumulator;
    }

    @Override
    public void addToAccumulator(int value) {
        accumulator+= value;
    }

    @Override
    public void subtractFromAccumulator(int value) {
        accumulator-= value;
    }

    @Override
    public void addMemoryToAccumulator(int index) {
        accumulator+= memory[index];
    }

    @Override
    public void subtractMemoryFromAccumulator(int index) {
        accumulator-= memory[index];
    }

    @Override
    public void reset() {
        this.accumulator = 0;
        for(int i = 0; i < MEMORY_SIZE; i++)
            this.memory[i] = 0;

        while(stack.size() > 0) {stack.pop();}
    }

    @Override
    public void exchangeMemoryWithAccumulator(int index) {
        int temp = memory[index];
        memory[index] = accumulator;
        accumulator = temp;
    }

    @Override
    public void pushAccumulatorOnStack() {
        if(stack.size() < STACK_SIZE)
            stack.push(accumulator);
    }

    @Override
    public void pullAccumulatorFromStack() {
        accumulator = stack.pop();
    }
}
