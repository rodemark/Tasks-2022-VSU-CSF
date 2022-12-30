package moodle;

public class ex1 {
    public static void main(String[] args){
        int[] arr = { 1, 2, 3, 3, 2, 1 };
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr){
        int max = Integer.MIN_VALUE;
        boolean flag = false;

        if(arr.length == 1){
            return arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            if(i == 0){
                if (arr[i + 1] != 0){
                    max = arr[i];
                }
                flag = true;
            }

            if(i == arr.length - 1){
                if(arr[i - 1] != 0){
                    if(arr[i] > max){
                        max = arr[i];
                    }
                }
                flag = true;
            }

            if(!flag){
                if(arr[i - 1] != 0 && arr[i + 1] != 0){
                    if(arr[i] > max){
                        max = arr[i];
                    }
                }
            }
        }

        if (max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
