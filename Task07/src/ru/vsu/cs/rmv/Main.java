package ru.vsu.cs.rmv;

/*
    Для вычислений использовать отдельную функцию solution
    (необходимые параметры и возвращаемое значение определяются условием конкретного варианта задачи).
    В некоторых задачах потребуются также дополнительные функции.
    Заранее придумать не менее 10 различных тестов, охватывающих как типичные,
    так и все возможные граничные (наиболее невероятные и показательные) ситуации.
    Программа при запуске должна прогонять эти тесты (для каждого теста распечатывать входной массив и результат),
    а также предлагать пользователю задать произвольный массив в качестве входных данных.
    Для ввода и, если необходимо, вывода одномерных массивов разработать отдельные функции.

    *5*
    Вводится массив целых чисел.
    Посчитать сумму элементов между последним четным и последним нечетным элементом.
*/

import util.ArrayUtils;

import java.util.Scanner;


public class Main {
    public static int input(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.nextInt();
    }
    public static int[] inputMassive(){
        int size = input("Размер массива: "); // размер массива
        int[] arrNum = new int[size];

        System.out.println("Элементы массива: "); // ввод массива
        for (int i = 0; i < size; i++) {
            arrNum[i] = input("");
        }

        return arrNum;
    }
    public static int solution(int[] arrNum) {
        int indexLastHonest = -1; // четные элементы
        int indexLastOdd = -1; // нечетные элементы

        for (int i = 0; i < arrNum.length; i++) { //определеленин последнего четного/нечетного
            if (arrNum[i] % 2 == 0) {
                indexLastHonest = i;
            }
            else {
                indexLastOdd = i;
            }
        }

        if (indexLastHonest == -1 || indexLastOdd == -1){ // когда нет четного или нечетного элемента
            return 0;
        }

        int sumElem = 0;
        for (int j = Math.min(indexLastHonest, indexLastOdd) + 1; j < Math.max(indexLastHonest, indexLastOdd); j++ ){ //сумма от одного к другому
            sumElem += arrNum[j];
        }
        return sumElem;
    }
    public static void tests(){
        int [] arrNum1 = {2, 4, 6, 7, 7, 7, 7}; // 21
        int [] arrNum2 = {1, 2, 3, 5, 8, 10, 12}; // 18
        int [] arrNum3 = {0, 0, 0, 0, 0}; // 0
        int [] arrNum4 = {1, 1, 1, 1};  // 0
        int [] arrNum5 = {2, 2, 2, 2}; // 0
        int [] arrNum6 = {2, 4, 6, 8, 10, 12}; // 0
        int [] arrNum7 = {1, 3, 5, 7, 9, 11 }; // 0
        int [] arrNum8 = {1, 2, 1, 2, 1, 2 }; // 0
        int [] arrNum9 = {2, 4, 3, 5, 7, 11}; // 15
        int [] arrNum10 = {1, 3, 4, 0, 3, 3, 3}; // 6
        System.out.println(ArrayUtils.toString(arrNum1) + ": " + solution(arrNum1));
        System.out.println(ArrayUtils.toString(arrNum2) + ": " + solution(arrNum2));
        System.out.println(ArrayUtils.toString(arrNum3) + ": " + solution(arrNum3));
        System.out.println(ArrayUtils.toString(arrNum4) + ": " + solution(arrNum4));
        System.out.println(ArrayUtils.toString(arrNum5) + ": " + solution(arrNum5));
        System.out.println(ArrayUtils.toString(arrNum6) + ": " + solution(arrNum6));
        System.out.println(ArrayUtils.toString(arrNum7) + ": " + solution(arrNum7));
        System.out.println(ArrayUtils.toString(arrNum8) + ": " + solution(arrNum8));
        System.out.println(ArrayUtils.toString(arrNum9) + ": " + solution(arrNum9));
        System.out.println(ArrayUtils.toString(arrNum10) + ": " + solution(arrNum10));
    }

    public static void main(String[] args){
        tests();
        System.out.println("--------------------------");
        int [] arrNum = inputMassive();
        System.out.println(ArrayUtils.toString(arrNum));
        System.out.printf("Result = %s ", solution(arrNum));
    }
}
