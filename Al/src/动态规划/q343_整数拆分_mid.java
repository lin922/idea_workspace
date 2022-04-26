package 动态规划;

public class q343_整数拆分_mid {
    public static int integerBreak(int n) {
        //dp[i]表示i拆分后可以得到的最大乘积
        int []dp = new int[n+1];
        //初始化
        //递推关系:dp[i]=max(dp[1]*dp[i-1],dp[2]*dp[i-2],...)
        if(n == 2) dp[2] = 1;
        else if(n == 3) dp[3] = 2;
        else {
            dp[1] = 1;
            for (int i = 4; i <= n; i++) {
                int max = 0;
                for (int j = 1; j <= i/2; j++) {
                    int tmp = dp[j] * dp[i - j];
                    if(tmp > max) max = tmp;
                }
                dp[i] = max;
            }
        }

        //打印
        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i]);
            System.out.print(' ');
        }
        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(integerBreak(n));
    }
}
