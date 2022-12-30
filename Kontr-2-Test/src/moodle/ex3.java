package moodle;

public class ex3 {
    public static void main(String[] args){
        System.out.println();
    }

    private static int solve(int[][] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(checkEvenAndNotEvenStringArr(arr[i])){
                count++;
            }
        }
        return count;
    }
    private static boolean checkEvenAndNotEvenStringArr(int[] str){
        boolean flagEven = false;
        boolean flagNotEven = false;
        for(int i = 0; i < str.length; i++){
            if(str[i] % 2 == 0){
                flagEven = true;
            }
            if(str[i] % 2 != 0){
                flagNotEven = true;
            }
        }
        return flagEven && flagNotEven;
    }
}
