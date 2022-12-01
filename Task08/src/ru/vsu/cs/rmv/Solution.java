package ru.vsu.cs.rmv;

    //
    // если выиграли нули - 0
    // если выиграли единицы - 1
    // если ничья - -1
    //


public class Solution {

    public static String checkWinner(String[][] table, String value) {

        boolean flag = false;
        int count;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {

                if (table[i][j].equals(value)) {
                    count = 0;
                    for (int k = 1; k < 5; k++) { // проверяет вправо
                        if (j + k >= 20){
                            break;
                        }
                        if (table[i][j + k].equals(value)) {
                            count++;
                            if (count == 4) {
                                flag = true;
                            }
                        }
                    }

                    count = 0;
                    for (int k = 1; k < 5; k++) { //проверяет вниз
                        if (i + k >= 20){
                            break;
                        }
                        if (table[i + k][j].equals(value)) {
                            count++;
                            if (count == 4) {
                                flag = true;
                            }
                        }
                    }

                    count = 0;
                    for (int k = 1; k < 5; k++) { //проверяет по диагонали
                        if ((j + k >= 20) || (i + k >= 20)){
                            break;
                        }
                        if (table[i + k][j + k].equals(value)) {
                            count++;
                            if (count == 4) {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        if (flag) {
            return "1";
        } else {
            return "0";
        }
    }

    public static String getWinner(String[][] table) {
        String amount0 = "0";
        String amount1 = "X";

        if (checkWinner(table, amount0).equals("1")){
            return amount0;
        }

        if (checkWinner(table, amount1).equals("1")){
            return amount1;
        }



        if (checkWinner(table, amount0).equals("0")){
            if (checkWinner(table, amount1).equals("1")){
                return amount1;
            }
            if (checkWinner(table, amount1).equals("0")){
                return "Ничья";
            }
        }

        if (checkWinner(table, amount1).equals("0")){
            if (checkWinner(table, amount0).equals("1")){
                return amount0;
            }
            if (checkWinner(table, amount0).equals("-1")){
                return "Ничья";
            }
        }
        return "error";
    }
}
