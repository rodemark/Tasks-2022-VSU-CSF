package ru.vsu.cs.rmv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Util {
    public static ArrayList<Integer> readListFromFile(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);
        Scanner scanner = new Scanner(fr);
        String[] str = scanner.nextLine().split(" ");

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < str.length; i++){
            numbers.add(Integer.parseInt(str[i]));
        }
        Collections.sort(numbers);
        return numbers;
    }
    public static int factorial(int n){
        return (n > 0) ? n * factorial(n - 1) : 1;
    }
}
