package b课程m1;

public class q3_牛牛排队涂色_mid {
    public static int minTimes(String s) {
        int n = s.length();
        int c = 0;
        int[] count = new int[n];
        //count[i][0]表示第i位及之前G的个数
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'G') count[i] = c++;
            else count[i] = c;
        }
        //遍历找出最小次数
        int min = n;
        for (int i = 0; i < n; i++) {
            //i及之前G的个数+i之后R的个数
            if(count[i] + n - count[n - 1] - (i + 1 - count[i])  < min) {
                min = count[i] + n - count[n - 1] - (i + 1 - count[i]);
            }
        }
        return min;
    }
    public static void main(String[] args) {
        String s = "RGRGR";
        System.out.println(minTimes(s));
    }
}
