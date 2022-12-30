public class ex3 {
    public static void main(String[] args){
        int[][] arr = {
                { 7, 1, 3, 2, 3 },
                { 9, 3, 5, 2, 3 },
                { 2, 9, 4, 9, 1 }
        };
        System.out.println(solve(arr));
    }
    public static int solve(int[][] arr){
        int min = getMin(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == min){
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    public static int getMin(int[][] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] < min){
                    min = arr[i][j];
                }
            }

        }
        return min;
    }
}
