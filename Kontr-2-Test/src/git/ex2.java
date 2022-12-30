package git;

public class ex2 {
//    Реализовать функцию (статический метод), которая для переданного двумерного массива посчитает кол-во строк,
//    в которых присутствуют как четные, так и нечетные элементы.
//    Обязательно должна быть реализована вспомогательная функция для проверки строки на соответствие указанному условию.
//    Постарайтесь придумать адекватное название для функции.

    public static void main(String[] args){
        int[][] arr = {
                {1, 2, 3},
                {4, 4, 4},
                {3, 3 ,3},
                {2, 5, 6}
        };
        System.out.println(countEvenAndNotEvenStringArr(arr));
    }
    private static int countEvenAndNotEvenStringArr(int[][] arr){
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
