public class ex4 {
    public static void solve(int n){
        int printedSymbols = 0;
        int printed = 0;
        int i = 0;
        int flag = 1;
        for (int repeat = 1; ; repeat++){
            for (char ch = 'a'; ch <= 'a' + i; ch++){
                System.out.print(ch);
                printedSymbols++;
                if (printedSymbols == n){
                    System.out.println();
                    return;
                }
                if (printedSymbols - printed == 2){
                    flag = 1;
                }
                if (flag == 1){
                    System.out.print("-");
                    printedSymbols++;
                    printed = printedSymbols;
                    flag = 0;
                    }

                }
                flag = 1;
                printedSymbols++;
                if (printedSymbols == n){
                    System.out.println();
                    return;
                }
            i++;
            }


        }

    public static void main(String[] args){
        solve(30);
    }
}
