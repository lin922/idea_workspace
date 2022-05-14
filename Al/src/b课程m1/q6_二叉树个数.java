package b课程m1;

public class q6_二叉树个数 {
    //左树个数*右数个数
    public static int BinaryTreeCounts1(int n) {
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int leftWays = BinaryTreeCounts1(i);
            int rightWays = BinaryTreeCounts1(n - 1 - i);
            res += leftWays*rightWays;
        }
        return res;
    }

    //动态规划
    public static int BinaryTreeCounts2(int n) {
        //dp[n]表示n个点可以构成的二叉树个数
        int dp[] = new int[n+1];
        //初始条件
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(BinaryTreeCounts1(n));
        System.out.println(BinaryTreeCounts2(n));
    }
}
