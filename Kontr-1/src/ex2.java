public class ex2 {
    public static double solve(double x, int n){
        double result = 1;
        double add = 0;
        double xPow = x;
        for (int i = 1; i < n + 1; i++){
            if (i % 2 != 0){
                add = -1 / (xPow + i);
            }
            else{
                add = 1 / (xPow + i);
            }
            result += add;
            xPow = x * xPow;
        }
        return result;
    }


    public static void main(String[] args){
        System.out.print(solve(5, 0));
    }
}
