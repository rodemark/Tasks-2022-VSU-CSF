package git;

public class ex3 {
    public static void main(String[] args){
        int[][] arr = createAndFill(4, 5);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] createAndFill (int rowCount, int colCount){
        int[][] arr = new int[rowCount][colCount];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(i == j){
                    arr[i][j] = 0;
                }
                for(int k = 1; k < colCount; k++){
                    if(i - j == k || j - i == k){
                        arr[i][j] = k;
                    }
                }
            }
        }
        return arr;
    }
}
