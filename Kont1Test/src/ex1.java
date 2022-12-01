public class ex1 {
    public static int solve(int v1, int v2, int v3){
        if (v1 >= 0){
            return v1;
        }
        if (v2 >= 0){
            return v2;
        }
        if (v3 >= 0){
            return v3;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.print(solve(-3, -2, -8));
    }
}
