package ru.vsu.cs.rmv;

public class test {
    public static void main(String[] args) {
        int h = 11; // высота
        int w = 14; // ширина
        for (int i = 0; i < h; i++) {

            if ((i == 0) || i == h - 1) {
                System.out.print(" ");

                for (int j = 1; j < w - 1; j++) {
                    System.out.print("–");
                }

                System.out.print(" ");
                System.out.print("\n");
            } else {
                System.out.print("|");

                for (int j = 1; j < Math.min((w - 1) / 2, i); j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < w - i * 2; k++) {
                    System.out.print("*");
                }
                for (int j = 1; j < Math.min((w - 1) / 2, i); j++) {
                    System.out.print(" ");
                }

                System.out.print("|");
                System.out.print("\n");
            }
        }
    }
}
