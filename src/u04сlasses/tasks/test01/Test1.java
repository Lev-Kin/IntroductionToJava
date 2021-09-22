package u04сlasses.tasks.test01;

public class Test1 {

    private int variableFirst;
    private int variableSecond;

    public void setVariableFirst(int variableFirst) {
        this.variableFirst = variableFirst;
    }

    public void setVariableSecond(int variableSecond) {
        this.variableSecond = variableSecond;
    }

    public void print() {
        System.out.println("variableFirst  = " + variableFirst);
        System.out.println("variableSecond = " + variableSecond);
    }

    public int getSum() {
        return variableFirst + variableSecond;
    }

    public int getMax(){
        if(variableFirst > variableSecond)
            return variableFirst;

        return variableSecond;
    }
}