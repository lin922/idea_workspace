package 贪心;

public class q343_整数拆分_mid {
    public static int integerBreak(int n) {
        int res = 1;
        if(n == 2)  return 1;
        if(n == 3)  return 2;
        while(n >= 5) {
            n -= 3;
            res *= 3;
        }
        if(n == 4) res *= 4;
        if(n == 3) res *= 3;
        if(n == 2) res *= 2;
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(integerBreak(n));
    }
}
