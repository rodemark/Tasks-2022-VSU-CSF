package ru.vsu.cs.rmv;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<String>> getListsResult(ArrayList<ArrayList<String>> lists, double pointAverage, int minAmountStudents){

        ArrayList<Integer> indexForRemove = new ArrayList<>(); // list индексов для удаления
        Utils.listsSorted(lists);

        for(int i = 0; i < lists.size(); i++){
            if (Double.parseDouble(lists.get(i).get(3)) < pointAverage){
                indexForRemove.add(i);
            }
        }

        int indexOffset = 0; // смещение индекса из-за того, что размер листа уменьшается
        int amountStudentsForRemove = lists.size() - minAmountStudents; // кол-во студентов для отчисления

        if (indexForRemove.size() <= amountStudentsForRemove){ // если фактическое кол-во на отчисление меньше чем макисмальное
            for(int i = 0; i < indexForRemove.size(); i++){
                lists.remove(indexForRemove.get(i) - indexOffset);
                indexOffset++;
            }
        }

        else{ // если отчислить нужно больше чем нужно
            boolean flag = true ;
            for(int i = 0; i <= amountStudentsForRemove-1; i++){
                if (!lists.get(i).get(3).equals(lists.get(i + 1).get(3))) {
                    flag = false;
                    break;
                }
            }

            if (!flag){
                for(int i = 0; i < amountStudentsForRemove; i++){
                    lists.remove(indexForRemove.get(i) - indexOffset);
                    indexOffset++;
                }
            }
        }
        return lists;

    }
}
