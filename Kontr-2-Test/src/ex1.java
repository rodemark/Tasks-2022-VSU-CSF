import java.util.*;

public class ex1 {
    public static void main(String[] args){
        int[] arr = { 1, 7, 4, 7, 3, 1, 7, 7, 1, 3, 7, 3, 1};
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++){
            if (!result.containsKey(arr[i])){
                result.put(arr[i], 1);
            }
            else{
                int value = result.get(arr[i]);
                result.put(arr[i], ++value);
            }
        }
        int max = Integer.MIN_VALUE;
        System.out.println(result);

        Set<Integer> keys = result.keySet();
        for(int i = 0; i < keys.size(); i++){
            for(Integer key : keys){
                if (max < key){
                    max = key;
                }
            }
        }
        System.out.println(max);
    }
}
