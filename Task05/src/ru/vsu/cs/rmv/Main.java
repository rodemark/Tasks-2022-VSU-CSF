package ru.vsu.cs.rmv;
/*
таск 05 задача 8
 */

public class Main {

    public static void repeat(int amount, String symbol) {
        if (amount <= 0){
            amount = 0;
        }
        for (int i = 1; i <= amount; i++) {
            System.out.print(symbol);
        }
    }

        public static void getPicture(int h, int w) {
            for (int i = 0; i < h; i++) {
                if ((i == 0) || i == h - 1) {
                    System.out.print(" ");
                    repeat(w - 2, "–");
                    System.out.println(" ");
                }
                else {
                    System.out.print("|");

                    int amountStar = w - i * 2;
                    int amountSpace = w - 2 - amountStar;

                    if ((amountSpace >= w) || amountStar == -1) {
                        amountSpace = w - 2;
                        repeat(amountSpace, " ");
                        System.out.println("|");
                    }
                    else{
                        repeat(amountSpace / 2, " ");
                        repeat(amountStar, "*");
                        repeat(amountSpace / 2, " ");
                        System.out.println("|");
                    }

                }

            }
        }
        public static void main (String[] args){
            getPicture(70,100);
        }
}

