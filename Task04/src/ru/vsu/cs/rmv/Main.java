package ru.vsu.cs.rmv;

/*
14
 */


import java.util.Scanner;

public class Main {

    public static int input(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextInt();
    }

    public static double calculationFunction(int x, int n){
        if (x - 2 * n - 1 == 0){
            throw new NullPointerException("Знаменатель равен 0!");
        }

        double valueFunction = 1.0;

        for (int i = 0; i < n + 1; i++){
            valueFunction = valueFunction * (x - 2 * i) / (x - 2 * i - 1);
        }
        return valueFunction;
    }
    public static void main (String[] args){
        int x = input("Введите x: ");
        int n = input("Введите n: ");
        System.out.printf("%.3f",(calculationFunction(x, n)));
    }
}