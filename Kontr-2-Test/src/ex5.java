public class ex5 {
    public static void main(String[] args){
        int[] arr = {5, 0, 10, 5, 0 };
        System.out.println(getMaxNotNull(arr));
    }
    public static int getMaxNotNull(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        int max = Integer.MIN_VALUE;
        if (arr[0] > arr[1] && arr[1] != 0){
            max = arr[0];
        }
        if (arr[arr.length - 1] > arr[arr.length - 2] && arr[arr.length - 2] != 0){
            if (max < arr[arr.length - 1]){
                max = arr[arr.length - 1];
            }
        }

        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] > arr[i - 1]){
                if(arr[i - 1] != 0 && arr[i + 1] != 0){
                    if (max < arr[i]){
                        max = arr[i];
                    }
                }
            }
        }
        if(max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
