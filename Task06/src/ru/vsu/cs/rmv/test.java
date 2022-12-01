package ru.vsu.cs.rmv;

public class test {
    public static double pi(int n) {
        double mult = 1;
        double num = Math.sqrt(2);
        for (int i = 0; i < n; i++) {
            mult = mult * num / 2;
            num = Math.sqrt(2 + num);
        }

        return 2 / mult;
    }
    public static void main(String[] args){
        System.out.print(pi(10));
    }
}
