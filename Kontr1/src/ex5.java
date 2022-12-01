public class ex5 {
    public static void repeat(int amount, String symbol) {
        if (amount <= 0){
            amount = 0;
        }
        for (int j = 1; j <= amount; j++) {
            System.out.print(symbol);
        }
    }
    public static void solve(int h){
        if (h == 1){
            System.out.print("*");
            return;
        }
        for (int i = 1; i < h + 1; i++){
            if (i == 1){
                System.out.print("*");
                for (int j = 1; j <= h - i - 1; j++) {
                    System.out.print("-");
                }
                System.out.println("*");
            }
            else{
                if (i == h){
                    for (int j = 1; j <= i - 1; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    return;
                }
                for (int j = 1; j <= i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("\\");
                for (int j = 1; j <= h - i - 1; j++) {
                    System.out.print("*");
                }
                System.out.println("|");

            }

        }
    }
    public static void main(String[] args){
        solve(1);
    }
}
