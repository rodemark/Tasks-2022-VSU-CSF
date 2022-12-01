package ru.vsu.cs.rmv;

import java.util.Scanner;

/*

Даны два момента времени в виде троек чисел (h1, m1, s1) и (h2, m2, s2) -
соответственно час, минута, секунда (считать, что числа вводятся корректно, т.е. 0 <= h <= 23 и т. д.).
Вычислить сколько пройдет секунд момента времени 1 до момента времени 2. Условный оператор не использовать.
(((h2 - h1 + 24) * 3600 + (m2 - m1) * 60 + s2 - s1) / 86400)

 */

public class Main {

    public static int calculation(int h2, int h1, int m2, int m1, int s2, int s1) {
        int firstMomentTime = h1 * 3600 + m1 * 60 + s1;
        int secondMomentTime = (h2 + 24) * 3600 + m2 * 60 + s2;
        int delta = (secondMomentTime - firstMomentTime) % 86400;
        return delta;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Первый момент времени: ");
        int h1, m1, s1;
        h1 = scanner.nextInt();
        m1 = scanner.nextInt();
        s1 = scanner.nextInt();

        System.out.println("Второй момент премени: ");
        int h2, m2, s2;
        h2 = scanner.nextInt();
        m2 = scanner.nextInt();
        s2 = scanner.nextInt();

        System.out.printf("Разница во времени: %d", calculation(h2, h1, m2, m1, s2, s1));

    }
}