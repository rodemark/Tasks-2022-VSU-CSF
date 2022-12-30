public class ex3 {
    public static int solve(int n) {
        int x = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 != 0 || i == 0) {
                x = x + 5;
            }

            if (i % 3 == 0 && i != 0) {
                x = x - 9;
            }
        }
        return x;
    }
    public static void main(String[] args){
        System.out.print(solve(6));
    }
}
