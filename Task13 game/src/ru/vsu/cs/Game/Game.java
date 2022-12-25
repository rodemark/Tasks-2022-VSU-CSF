package ru.vsu.cs.Game;

import static javax.swing.JOptionPane.showMessageDialog;
import static ru.vsu.cs.Game.GameParams.getSizeField;
import static ru.vsu.cs.util.SwingUtils.showInfoMessageBox;

public class Game {

    static final int SIDE = getSizeField();
    public static int[][] gameField = null;
    public static int score = 0;


    public Game() {
    }

    private static int getRandomNumber(int n) {
        return (int) Math.round(Math.random() * n);
    }

    public static void createNewNumber() {
        int x = 0;
        int y = 0;


        do {
            x = getRandomNumber(SIDE - 1);
            y = getRandomNumber(SIDE - 1);
        }
        while (gameField[x][y] != 0);


        if (getRandomNumber(10) > 8) {
            gameField[x][y] = 4;
        } else {
            gameField[x][y] = 2;
        }
    }

    public static void newGame() {
        gameField = new int[getSizeField()][getSizeField()];
        createNewNumber();
        createNewNumber();
        score = 0;
    }

    public static void win(){
        if(findMaxElemGameField() == 2048){
            showInfoMessageBox("Победа!!!", "2048");
        }
    }

    public static void gameOver(){
        if(!canUserMove()){
            boolean isGameStopped = true;
            showInfoMessageBox("Все. Доигрался. Давай по новой.", "2048");
        }
    }
    public static int findMaxElemGameField(){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < SIDE; i++){
            for (int j = 0; j < SIDE; j++) {
                if(gameField[i][j] > max){
                    max = gameField[i][j];
                }
            }
        }
        return max;
    }

    public static boolean canUserMove() {
        boolean result = false;
        //Проверка что есть 0
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                }
            }
        }
        //Проверка 2-х соседних
        for (int i = 0; i < SIDE; i++) {
            for (int j = 1; j < SIDE; j++) {
                if ( gameField[i][j] ==gameField[i][j-1])
                {
                    return true;
                }
            }
        }
        rotateClockwise();
        for (int i = 0; i < SIDE; i++) {
            for (int j = 1; j < SIDE; j++) {
                if ( gameField[i][j] ==gameField[i][j-1])
                {
                    return true;
                }
            }
        }
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();

        return result;
    }

    private static boolean compressRow(int[] row) {
        boolean result = false;
        for (int j = 0; j < SIDE;j++) {
            for (int i = 1; i < SIDE; i++) {
                if (row[i - 1] == 0 && row[i] != 0) {
                    int temp = row[i - 1];
                    row[i - 1] = row[i];
                    row[i] = temp;
                    result = true;
                }
            }
        }
        return result;
    }

    private static boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 1; i < SIDE; i++) {
            if (row[i - 1] == row[i] && row[i] != 0) {
                row[i - 1] = row[i]*2;
                score += row[i - 1];
                row[i] = 0;
                result = true;
            }
        }
        return result;
    }

    private static void rotateClockwise() {
        int[][] result = new int[SIDE][SIDE];
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                result[i][j] = gameField[SIDE - j - 1][i];
            }

        }
        gameField = result;
    }

    public static void moveLeft() {
        boolean change = false;
        for (int i = 0; i < SIDE; i++) {
            if (compressRow(gameField[i])) change = true;
            if (mergeRow(gameField[i])) change = true;
            if (compressRow(gameField[i])) change = true;
        }
        if (change) createNewNumber();

    }

    public static void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    public static void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    public static void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

}
