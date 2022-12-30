public class ex1 {
    public static int solve(int x){
        int x1 = Math.abs(x % 10) ;
        int x2 = Math.abs(x / 10 % 10);
        int x3 = Math.abs(x / 100 % 10);
        if (x1 >= x2 && x1 >= x3){
            return x1;
        }
        if (x2 >= x3 && x2 >= x1){
            return x2;
        }
        return x3;
    }

    public static void main(String[] args){
        System.out.print(solve(22));
    }
}
