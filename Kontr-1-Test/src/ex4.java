public class ex4 {
    public static void solve(int n){
        int printedSymbols = 0;
        int repeat = 1;
        for (char ch = 'a'; ch <= 'z'; ch++){
            for (int i = 0; i < repeat; i++){
                if (printedSymbols == n){
                    System.out.println();
                    return;
                }
                System.out.print(ch);
                printedSymbols ++;
                if (printedSymbols == n){
                    System.out.println();
                    return;
                }
                System.out.print("-");
                printedSymbols ++;
            }
            repeat++;
        }
    }


    public static void main(String[] args){
        solve(5);
    }
}
