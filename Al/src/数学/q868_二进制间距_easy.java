package 数学;

public class q868_二进制间距_easy {
    public static int binaryGap(int n) {
        int res = 0, m = 0, left = 0, right = 0;
        while(n != 0) {
            m ++;  //m表示当前的长度
            if(n%2 == 1) {
                if(left == 0) left = m;  //将左指针指向第一个1的位置
                else { //再遇到1，进行比较，并移动左指针
                    res = Math.max(m - left, res);
                    left = m;
                }
            }
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 10000;
        System.out.println(binaryGap(n));
    }

}
