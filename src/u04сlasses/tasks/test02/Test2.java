package u04сlasses.tasks.test02;

public class Test2 {

    private int variableFirst;
    private int variableSecond;

    public Test2() {
        this.variableFirst = variableFirst;
        this.variableSecond = variableSecond;
    }

    public Test2(int variableFirst, int variableSecond) {
        this.variableFirst = variableFirst;
        this.variableSecond = variableSecond;
    }

    public void setVariableFirst(int variableFirst) {
        this.variableFirst = variableFirst;
    }

    public void setVariableSecond(int variableSecond) {
        this.variableSecond = variableSecond;
    }

    public int getVariableFirst() {
        return variableFirst;
    }

    public int getVariableSecond() {
        return variableSecond;
    }

    public void print() {
        System.out.println("variableFirst  = " + variableFirst);
        System.out.println("variableSecond = " + variableSecond);
    }
}