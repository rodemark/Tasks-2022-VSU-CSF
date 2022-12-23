package ru.vsu.cs.rmv;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args){
        System.out.println(generate(4));

    }
    public static Set<String> da(int n){
        Set<String> result = new TreeSet<>();
        for (int i = 0; i <= n; i++){
            if (i == 0){
                result.add("");
            }
            else{
                for (String item : generate(n - i)) {
                    String str1 = "(" + ")" + item;
                    if (str1.length() == 2 * n){
                        result.add(str1);
                    }
                    String str2 = "(" + ")" + item;
                    if (str2.length() == 2 * n){
                        result.add(str2);
                    }
                    String str3 = "(" + ")" + item;
                    if (str3.length() == 2 * n){
                        result.add(str3);
                    }
                }
            }

        }
        return result;
    }
    public static Set<String> generate(int n) {
        Set<String> result = new TreeSet<>();
        if (n == 0) {
            result.add("");
        }
        for (int i = 1; i <= n; ++i) {
            for (String item : generate(n - i)) {
                result.add(String.join("", Collections.nCopies(i, "(")) + String.join("", Collections.nCopies(i, ")")) + item);
                result.add(String.join("", Collections.nCopies(i, "(")) + item + String.join("", Collections.nCopies(i, ")")));
                result.add(item + String.join("", Collections.nCopies(i, "(")) + String.join("", Collections.nCopies(i, ")")));
            }
        }
        return result;
    }
}
