public class ex1 {
    public static void main(String[] args){
        int[] arr = { -1, -1, -1, -1 };
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr){
        if (arr.length == 1){
            return Integer.MIN_VALUE;
        }

        boolean point = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[0] == arr[i]){
                point = true;
            }
            else{
                point = false;
                break;
            }
        }
        if(point){
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }

        boolean flag = false;
        int result = 0;

        for (int i = 1; ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == max - i){
                    result = arr[j];
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }

        }


        return result;

    }
}
