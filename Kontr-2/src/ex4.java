public class ex4 {
    public static void main(String[] args){
        int[][] arr = solve(3, 4);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int rowCount, int colCount){
        int k = 0;
        int[][] arr= new int[rowCount][colCount];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int l = 0; l < i; l++) {
                    arr[arr.length - i - l][arr[i].length - j - l] = i + 1;
                }
            }
        }
        return arr;
    }
}
