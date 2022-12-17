package ru.vsu.cs.rmv;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Solution {
    public static void genAll(ArrayList<Integer> elements, int k, int n){
        ArrayList<Integer> indexesForPrint = new ArrayList<>();
        generate(0,0, n, k, indexesForPrint, elements);
    }
    private static void generate(int counter, int lastIndex, int n, int k,
                                 ArrayList<Integer> indexesForPrint, ArrayList<Integer> elements){
        if (counter == k) {
            for (int i = 0; i < indexesForPrint.size(); i++){
                System.out.print(elements.get(indexesForPrint.get(i)) + " ");
            }
            System.out.println();
        }

        for (int i = lastIndex + 1; i <= n; i++){
            indexesForPrint.add(i - 1);
            generate(counter + 1, i, n, k, indexesForPrint, elements);
            indexesForPrint.remove(indexesForPrint.size() - 1);
        }
    }
}
