package git;

public class ex4 {
//    которая посчитает в массиве целых чисел кол-во локальных
//    максимумов (елементы, соседи которых меньше данного элемента).
    public static void main(String[] args){
        int[] arr1 = { 3, 9, 5, 8, 7, 3, 2, 9, 9, 2, 4, 9, 4 };
        int[] arr2 = {7, 3, 6};
        int[] arr3 = {4, 4, 5, 7, 7};
        int[] arr4 = {4};
        System.out.println(countLocaleMaximum(arr1));
        System.out.println(countLocaleMaximum(arr2));
        System.out.println(countLocaleMaximum(arr3));
        System.out.println(countLocaleMaximum(arr4));
    }
    public static int countLocaleMaximum(int[] arr){
        int count = 0;
        if (arr.length == 1){
            return 0;
        }
        if (arr[0] > arr[1]){
            count++;
        }
        if(arr[arr.length - 1] > arr[arr.length - 2]){
            count++;
        }
        for(int i = 1; i < arr.length - 1; i++){
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                count++;
            }
        }
        return count;
    }

}
