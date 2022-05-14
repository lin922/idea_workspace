package b课程m1;

public class q2_买苹果_mid {
    //普通解法
    public static int minBags1(int n) {
        if(n%2 == 1) return -1;  //奇数一定不能凑齐
        int min = n;
        //i表示8个每袋的袋数
        for (int i = n/8; i >= 0; i--) {
            //判断剩下的能否被6整除
            if((n - i*8)%6 == 0) {
                min = (n - i*8)/6 + i;
                break;
            }
        }
        return min == n ? -1 : min;
    }
    //优化解法
    //打表法，根据数学结果找规律
    public static void main(String[] args) {
        int n = 49;
        System.out.println(minBags1(n));
    }
}
