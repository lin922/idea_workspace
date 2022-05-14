package b课程m1;

public class q1_切割绳子_mid {
    public static int maxPoint(int[] arr, int L) {
        int max = 0;
        int i = 0, j = 0;
        while (i <= j && j < arr.length) {
            if(arr[j] - arr[i] <= L) {
                if(j - i + 1 > max) {
                    max = j - i + 1;
                }
                j++;
            }
            else i++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,8,10};
        int L = 8;
        System.out.println(maxPoint(arr, L));
    }
}
