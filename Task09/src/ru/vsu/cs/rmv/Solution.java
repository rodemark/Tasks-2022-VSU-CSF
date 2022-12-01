package ru.vsu.cs.rmv;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> createNewList(ArrayList<Integer> list){
        int sum = 0;
        int sumMax = -Integer.MAX_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        int sumBack = 0;

        ArrayList<Integer> listResult = new ArrayList<Integer>();
        ArrayList<Integer> listResult1 = new ArrayList<Integer>();
        ArrayList<Integer> listResult2 = new ArrayList<Integer>();
        ArrayList<Integer> subsequence = new ArrayList<Integer>();
        int index = 0;

/*
        for (int i = 0; i < list.size() - 1; i++){
            sum += list.get(i);
            subsequence.add(list.get(i));

            if (sum > sumMax){
                sumMax = sum;
                listResult = new ArrayList<Integer>(subsequence.size());
                listResult.addAll(subsequence);
            }
        }

 */

        for (int i = 0; i < list.size(); i++){
            sum += list.get(i);
            subsequence.add(list.get(i));

            if (sum > sumBack){
                listResult1 = new ArrayList<>();
                listResult1.addAll(subsequence);
            }
            else{
                listResult1 = new ArrayList<>();
                sum = 0;
            }

            sumBack = sum;
        }
        return listResult1;
    }

}
