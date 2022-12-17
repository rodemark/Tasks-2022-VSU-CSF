package ru.vsu.cs.rmv;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static ru.vsu.cs.rmv.Util.factorial;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = args[0];

        ArrayList<Integer> elements = Util.readListFromFile(path);

        System.out.println(elements);

        final int n = elements.size();
        final int k = Integer.parseInt(args[1]);

        int c = factorial(n) / (factorial(k) * factorial(n - k));

        System.out.printf("Количество сочетаний из %d элементов по %d = %d", elements.size(), k, c);
        System.out.println();

        Solution.genAll(elements, k, n);
    }
}
