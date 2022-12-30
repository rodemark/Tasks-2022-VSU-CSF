package moodle;

public class ex4 {
    public static void main(String[] args){
        int[][] arr = solve(4, 6);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int rowCount, int colCount){
        int[][] arr = new int[rowCount][colCount];
        int num = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {

                arr[i][j] = num + j;
            }
            num++;
        }
        return arr;
    }
}
