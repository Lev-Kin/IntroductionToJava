package сlasses04.tasks.counter;

public class CounterInteger {
    private int currentValue;
    private final int minLimit = -100;
    private final int maxLimit = 100;

    public CounterInteger() {
        currentValue = 0;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public CounterInteger(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public boolean increase() {
        if (currentValue == maxLimit) {
            return false;
        }

        currentValue++;
        return true;
    }

    public boolean decrease() {
        if (currentValue == minLimit) {
            return false;
        }

        currentValue--;
        return true;
    }
}