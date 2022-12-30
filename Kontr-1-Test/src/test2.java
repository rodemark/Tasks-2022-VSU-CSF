import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {
    public static void main(String[] args){
        String names1 ="a b c d e";
        String names2 ="f g h i j";
        String[][] arr = new String[2][names1.length()];

        String[] items1 = names1.split("");
        String[] items2 = names2.split("");

        for(int i = 0; i < items1.length; i++){
            arr[0][i] = items1[i];
        }
        for(int i = 0; i < items2.length; i++){
            arr[1][i] = items2[i];
        }

        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }


    }
}
