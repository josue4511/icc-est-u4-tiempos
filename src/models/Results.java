package models;

public class Results {
    private int samplaSize;
    private String funtionName;
    private double timeResult;

    public Results(int samplaSize, String funtionName, double timeResult) {
        this.samplaSize = samplaSize;
        this.funtionName = funtionName;
        this.timeResult = timeResult;
    }

    public int getSamplaSize() {
        return samplaSize;
    }

    public void setSamplaSize(int samplaSize) {
        this.samplaSize = samplaSize;
    }

    public String getFuntionName() {
        return funtionName;
    }

    public void setFuntionName(String funtionName) {
        this.funtionName = funtionName;
    }

    public double getTimeResult() {
        return timeResult;
    }

    public void setTimeResult(double timeResult) {
        this.timeResult = timeResult;
    }

    @Override
    public String toString() {
        return "La funcion " + funtionName + " ejecutada con sample size " + samplaSize +
               " tuvo un tiempo de: " + timeResult;
    }
}
