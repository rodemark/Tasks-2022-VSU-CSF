package ru.vsu.cs.Game;

public class GameParams {
    private static int sizeField;

    public GameParams(int size) {
        this.sizeField = size;
    }

    public GameParams() {
        this(4);
    }

    public static int getSizeField() {
        return sizeField;
    }

    public void setSizeField(int sizeField) {
        int sizeField1 = sizeField;
    }
}
