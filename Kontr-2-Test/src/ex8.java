import java.util.ArrayList;

public class ex8 {
    public static void main(String[] args){
        int[] arr = {3, 2, 3, 1, 3, 2, 3, 3, 5, 3, 5, 4, 7, 4, 4, 8};
        System.out.println(findSubsequence(arr));
    }
    public static int findLength(int[] arr, int index){
        int a = arr[index];
        int b = arr[index + 1];
        int count = 0;
        for(int i = index; i < arr.length; i++){
            if(arr[i] == a || arr[i] == b){
                count++;
            }
            else{
                return count;
            }
        }
        return count;
    }
    public static int findSubsequence(int[] arr){
        int max = Integer.MIN_VALUE;
        int value = 0;
        for (int i = 0; i < arr.length - 1; i++){
            value = findLength(arr, i);
            if (value > max){
                max = value;
            }
        }
        return max;
    }
}
