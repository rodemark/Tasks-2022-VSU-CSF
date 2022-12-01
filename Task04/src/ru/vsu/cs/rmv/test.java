package ru.vsu.cs.rmv;

/*
28(*) Посчитать количество чисел от A до B (целые) таких, что цифры числа,
рассмотренные по порядку слева направо, образуют арифметическую или геометрическую прогрессию.
Будем считать, что все однозначные и двухзначные числа образуют арифметическую прогрессию.
Для определения, подходит ли число под требования задачи, реализовать функцию.
Также реализовать функцию для подсчета кол-ва таких чисел от 1 до n.
Запрещено использовать строки и массивы.
 */


import java.util.Scanner;

public class test {

    public static int input(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextInt();
    }

    public static boolean checkZeroInNumber(int number){
        boolean flag = false;
        while (number > 0){
            if (number % 10 == 0){
                flag = true;
                break;
            }
            else{
                flag = false;
            }
            number /= 10;
        }
        return flag;
    }

    public static boolean checkArithmeticProgression(int number) {
        int d = Math.abs((number % 10) - (number / 10 % 10)); // d - разность арифметической прогрессии
        boolean flag = false;
        int step = 0;
        int firstDigitOfNumbers = number % 10;

        if ((number % 10 - number / 10 % 10) > 0)  { //если возрастающая прогрессия
            while (number > 0) {
                if ((number % 10) == (firstDigitOfNumbers - d * step)) {
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
                step ++;
                number /= 10;
            }
        }
        else{ //убывающая
            while (number > 0) {
                if ((number % 10) == (firstDigitOfNumbers + d * step)) {
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
                step ++;
                number /= 10;
            }
        }
        return flag;
    }

    public static boolean checkGeometricProgression(int number) {
        if (!checkZeroInNumber(number)){
            float q; // - знаменатель прогрессии
            int firstDigitOfNumbers = number % 10; // первая цифра числа (тк в обратную сторону проверям число, то последняя)
            boolean flag = false;
            int step = 0; //  номер числа(шага)

            if ((number % 10 - number / 10 % 10) > 0){
                q = (number % 10) / (number / 10 % 10);
                while (number > 0) {
                    step++;
                    if (number / 10 == 0){ //проверка если остается одна цифра
                        if (number % 10 * Math.pow(q, step - 1) == firstDigitOfNumbers){
                            return true;
                        }
                    }
                    if (number % 10 / q == number /10 % 10){
                        flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                    number /= 10;
                }
            }
            else{
                q = (number / 10 % 10) / (number % 10);
                while (number > 0) {
                    step++;
                    if (number % 10 == firstDigitOfNumbers * Math.pow(q, step - 1)){
                        flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                    number /= 10;
                }
            }
            return flag;
        }
        else{
            return false;
        }
    }

    public static int amountNumbersFromAToB(int a, int b) {
        int count = 0;
        while (a < b + 1) {
            if ((checkArithmeticProgression(a)) || (checkGeometricProgression(a))) {
                count++;
            }
            a++;
        }
        return count;
    }

    public static int amountNumberFromOneToN(int n){
        int count = 0;
        int i = 1;
        while (i < n + 1) {
            if ((checkArithmeticProgression(i)) || (checkGeometricProgression(i))) {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main (String[] args){
        //int a = input("Введите a: ");
        //int b = input("Введите b: ");
        //int n = input("Введите n: ");
        System.out.println(amountNumbersFromAToB(100, 125)); // 3
        //System.out.println(amountNumberFromOneToN(n));
        //System.out.println(checkArithmeticProgression(369));
        System.out.println(checkGeometricProgression(125));

    }
}