package moodle;

public class ex2 {
    public static void main(String[] args){
        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(solve(arr)[i] + " ");
        }
    }

    public static int[] solve(int[] arr){

        if(arr.length == 0){
            return arr;
        }
        int indexMax = 0;
        int indexMin = 0;

        int max = getMax(arr);
        int min = getMin(arr);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == max){
                indexMax = i;
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == min){
                indexMin = i;
            }
        }

        arr[indexMax] = min;

        arr[indexMin] = max;
        return arr;
    }
    private static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    private static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
