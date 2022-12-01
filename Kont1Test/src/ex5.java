public class ex5 {

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

                repeat(i-1, " ");
                System.out.println("*");
            }
            else{
                if (i == 1){
                    System.out.print("*");
                    repeat(spaceInside, "-");
                    System.out.print("*");
                    repeat(spaceInside, "-");
                    System.out.print("*");
                    return;
                }
                repeat(i-1, " ");
                System.out.print("/");
                repeat(spaceInside, " ");
                System.out.print("|");
                repeat(spaceInside, " ");
                System.out.println("\\");
                }
            spaceInside++;
            }
        }
    static public void main(String[] args){
        solve(6);
    }
}
