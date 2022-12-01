package ru.vsu.cs.rmv;
/*
При некоторых заданных x (допустимые значения x – интервал (-R, R)), n и e, определяемых вводом, вычислить:
1) сумму n слагаемых заданного вида;
2) сумму тех слагаемых, которые по абсолютной величине больше e;
3) сумму тех слагаемых, которые по абсолютной величине больше e/10;
4) значение функции с помощью методов Math.
 */

import java.util.Scanner;

public class Main {

    public static float input(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextInt();
    }

    public static double getValueNumber(int indexNumber, double x){ // - значение n-го члена выражения
        int pow = 0;
        double number = 1; // - n-й член выражения
        for (int i = 1; i < indexNumber ; i++){
            pow += 2;
            number = number * (pow - 1) / (pow);
        }
        return number * Math.pow(x, pow);
    }

    public static double getSumTerms(int n, double x){ //сумма n слагаемых
        double sum = 0;
        for (int i = 1; i < n + 1; i++){
            sum = sum + getValueNumber(i, x);
        }
        return sum;
    }

    public static double sumMoreE(double x, double e){
        double sum = 0;
        int i = 1;
        while (sum < e){
            sum = sum + getValueNumber(i, x);
            i++;
        }
        return sum;
    }

    public static double sumMoreEdivTen(double x, double e){
        double sum = 0;
        int i = 1;
        while (sum < e/10){
            sum = sum + getValueNumber(i, x);
            i++;
        }
        return sum;
    }

    public static double valueOriginalExpression(double x){ //начальное выражение
        return (1 / Math.sqrt(1 - Math.pow(x, 2)));
    }

    public static void main(String[] args){
        //System.out.print(getValueNumber(3, 1));
        //float x = input("Введите x: ");
        //float n = input("Введите n: ");
        //float e = input("Введите e: ");

        System.out.println(getSumTerms(1000, 0.999));
        System.out.println(sumMoreE(0.999, 5));
        System.out.println(sumMoreEdivTen( 0.999, 20));
        System.out.println(valueOriginalExpression(0.999));
    }
}
