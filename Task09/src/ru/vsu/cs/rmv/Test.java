package ru.vsu.cs.rmv;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/rodemark/Documents/Univer/Introduction-to-programming/Task09/src/input.txt";
        ArrayList<Integer> list = Utils.readListFromFile(path);

        int [] a = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            a[i] = list.get(i);
        }

        int ans = a[0],
                ans_l = 0,
                ans_r = 0,
                sum = 0,
                min_sum = 0,
                min_pos = -1,
                n = a.length;

        for (int r = 0; r < n; r++) {
            sum += a[r];

            int cur = sum - min_sum;

            if (cur > ans) {
                ans = cur;
                ans_l = min_pos + 1;
                ans_r = r;
            }

            if (sum < min_sum) {
                min_sum = sum;
                min_pos = r;
            }
        }

        System.out.println(list);
        System.out.println(ans_l);
        System.out.println(ans_r);
        System.out.println(sum);
        System.out.println(min_sum);
        System.out.println(min_pos);
    }
}
