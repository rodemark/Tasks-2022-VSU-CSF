package ru.vsu.cs.rmv;

public class InputArgs {

    private final String windowOrCmd;
    private final String inputFilePath;
    private final String minAmountStudents;
    private final String minPointAverage;

    public InputArgs(String windowOrCmd, String inputFilePath, String minAmountStudents, String minPointAverage) {
        this.windowOrCmd = windowOrCmd;
        this.inputFilePath = inputFilePath;
        this.minAmountStudents = minAmountStudents;
        this.minPointAverage = minPointAverage;

    }

    public String getWindowOrCmd() {
        return windowOrCmd;
    }
    public String getInputFilePath() {
        return inputFilePath;
    }
    public String getMinAmountStudents(){return minAmountStudents;}
    public String getMinPointAverage(){return  minPointAverage;}
}
