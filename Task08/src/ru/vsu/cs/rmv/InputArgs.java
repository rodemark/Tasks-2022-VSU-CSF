package ru.vsu.cs.rmv;

public class InputArgs {
    private final String inputFilePath;
    private final String windowOrCmd;

    public InputArgs(String inputFilePath, String windowOrCmd) {
        this.inputFilePath = inputFilePath;
        this.windowOrCmd = windowOrCmd;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getWindowOrCmd() {
        return windowOrCmd;
    }
}
