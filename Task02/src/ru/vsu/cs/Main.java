package ru.vsu.cs;

import java.util.Scanner;

/*
28*
Для ввода данных, вычислений и вывода данных использовать отдельные функции (методы).
Не использовать глобальные переменные, все необходимые данные передавать в эти функции (методы).

В классе N мальчиков и M девочек. Необходимо разбить всех учеников на команды так,
чтобы в каждой команде было ровно по 3 человека (и мальчики и девочки).
Необходимо определить, какое максимальное кол-во команд, следуя данным правилам,
можно составить из учеников данного класса.
(Очевидно, что возможны ситуации, когда некоторые ученики не войдут ни в одну команду.)
 */

public class Main {
    private static int input(String text) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(text);

        return scanner.nextInt();

    }

    /*
    private static int inputN() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество мальчиков: ");
        int n = scanner.nextInt();

        return n;
    }

    private static int inputM(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество девочек: ");

        return scanner.nextInt();
    }

    public static int calculateTeams0(int m, int d) {
        int countTeams = 0;
        if (m > d) {
            while ((d > 0) && (m > 0)) {
                countTeams += 1;
                m = m - 2;
                d = d - 1;
            }

        } else {
            while ((m > 0) && (d > 0)) {
                countTeams += 1;
                m = m - 1;
                d = d - 2;
            }
        }
        return countTeams;
    }
*/

    public static int calculateTeams(int m, int d){
        int coupleM = m / 2;
        int coupleD = d / 2;
        if (m > d){
            return Math.min(coupleM,d);
        }
        else{
            return Math.min(coupleD, m);
        }
    }

    public static void main(String[] args) {
        int amountBoy = input("Введите количество девочек: ");
        int amountGirl = input("Введите количество мальчиков: ");

        System.out.println(calculateTeams(amountBoy, amountGirl));
    }
}
