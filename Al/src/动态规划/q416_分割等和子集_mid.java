package 动态规划;

import static java.lang.Integer.max;

public class q416_分割等和子集_mid {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 == 1) return false; //奇数不能放等分，直接返回
        sum /= 2;
        //找出数字中是否存在和为sum/2的
        int []dp = new int[sum+1];  //dp[i][j]表示从数组0-i任意取，可以达到的最大容量dp[j]
        // 初始化
        dp[0] = 0;
        //0-1背包递推
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        //打印
        for (int i = 0; i <= sum; i++) {
                System.out.print(dp[i]);
                System.out.print(' ');
        }
        if(dp[sum] == sum) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {12,6,6};
        System.out.println(canPartition(nums));
    }
}







