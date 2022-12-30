public class exTest {

    public static void repeat(int amount, String symbol) {
        if (amount <= 0){
            amount = 0;
        }
        for (int i = 1; i <= amount; i++) {
            System.out.print(symbol);
        }
    }
    public static void solve(int h){
        int spaceInside = -1;
        for (int i = h; i != 0; i--){
            if (i == h){
                for (int k = 1; k <= i-1; k++) {
                    System.out.print(" ");
                }
                System.out.println("*");
            }
            else{
                if (i == 1){
                    System.out.print("*");
                    for (int k = 1; k <= spaceInside; k++) {
                        System.out.print("-");
                    }
                    System.out.print("*");
                    for (int k = 1; k <= spaceInside; k++) {
                        System.out.print("-");
                    }
                    System.out.print("*");
                    return;
                }
                for (int k = 1; k <= i - 1; k++) {
                    System.out.print(" ");
                }
                System.out.print("/");
                for (int k = 1; k <= spaceInside; k++) {
                    System.out.print(" ");
                }
                System.out.print("|");
                for (int k = 1; k <= spaceInside; k++) {
                    System.out.print(" ");
                }
                System.out.println("\\");
            }
            spaceInside++;
        }
    }
    static public void main(String[] args){
        solve(6);
    }
}
