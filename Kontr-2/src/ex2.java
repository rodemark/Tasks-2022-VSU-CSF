public class ex2 {
    public static void main(String[] args){
        int[] arr = { -1, 0, -1, -1, -1, 0, -2, 0, 0, 0, -1, -2, -1, -1, -2, -2, 0, 0, -2, -2, 0, -1, 0, -1, -1, -1, 0, -2, 0 };
        int[] arr1 = {4, 8, 8, 8, 6, 8, 7};

        int[] test = arr;
        System.out.println(getMax(test));

        solve(arr);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
    }
    public static void solve(int[] arr){
        boolean flag = false;
        int max = getMax(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j]){
                    arr[j] = max;
                    flag = true;
                }
            }
            if (flag){
                arr[i] = max;
                flag = false;
            }
        }
    }
    public static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]){
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }

            }
        }
        return max;
    }
}
