public class ex2 {
    public static double solve(double x, int n){
        double result = 0;
        double xPow = x;
        for (int i = 1; i < n + 1; i++){
            result = result + (xPow / (x - i));
            xPow = xPow * x;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.print(solve(5, 0));
    }
}
