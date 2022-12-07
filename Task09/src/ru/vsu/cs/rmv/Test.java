package ru.vsu.cs.rmv;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/rodemark/Documents/Univer/Introduction-to-programming/Task09/src/input.txt";
        ArrayList<Integer> list = Utils.readListFromFile(path);

        int sumBack = list.get(0);
        int indexLeft = 0;
        int indexRight = 0;
        int sum = 0;
        int minPos = -1;
        int indexLeftBack = 0;
        int indexRightBack = Integer.MAX_VALUE;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            sum += list.get(i);

            if (sum > sumBack) {
                sumBack = sum;
                indexLeft = minPos;
                indexRight = i;
            }

            if (sum == sumBack){
                indexLeft = minPos;
                indexRight = i;
                if (indexRightBack - indexLeftBack < indexRight - indexLeft){
                    indexLeft = indexLeftBack;
                    indexRight = indexRightBack;
                }
                if (indexRightBack - indexLeftBack == indexRight - indexLeft){
                    if (indexLeftBack < indexRight){
                        indexLeft = indexLeftBack;
                        indexRight = indexRightBack;
                    }
                }
            }

            if (sum < 0) {
                indexLeftBack = indexLeft;
                indexRightBack = indexRight;
                sum = 0;
                minPos = i;
            }
        }

        System.out.println(indexLeft);
        System.out.println(indexRight);

        indexLeft  = indexLeft < 0 ? 0 : indexLeft + 1;

        for(int i = indexLeft ; i < indexRight + 1; i++){
            result.add(list.get(i));
        }

        System.out.println(result);

    }
}
