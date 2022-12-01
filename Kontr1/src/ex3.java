public class ex3 {
    public static int solve(int n){
        int x = 0;
        int i = 1;
        int step = 0;
        while (step < n){
           x += i;
           step++;
           if (step < n){
               x += i;
               i++;
               step++;
           }
           else{
               return x;
           }
        }
        return x;
    }

    public static void main(String[] args){
        System.out.print(solve(0));
    }
}
