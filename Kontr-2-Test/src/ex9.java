public class ex9 {
    public static void main(String[] args){
        int rowCount = 4;
        int colCount = 5;
        int [][] arr = createAndFillArt2(rowCount, colCount);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] createAndFillArt2(int rowCount, int colCount){
        int [][] result = new int[rowCount][colCount];
        int n = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++){


            }
        }
        return result;
    }
}
