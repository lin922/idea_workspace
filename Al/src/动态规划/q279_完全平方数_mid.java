package 动态规划;

import static java.lang.Math.sqrt;

public class q279_完全平方数_mid {
    //dp[i]表示组成i的完全平方数字的个数
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        //初始条件 dp[I^2]=1
        for(int i = 1; i <= sqrt(n); i++) {
            dp[i*i] = 1;
        }
        //递推公式dp[i]=min(dp[i-],dp[],dp[])+1;
        for(int i = 2; i <= n; i++) {
            int min = 100000;
            for(int j = 1; j <= sqrt(i); j++) {
                //循环找出min
                if(dp[i-j*j] < min) min = dp[i-j*j];
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }
}
