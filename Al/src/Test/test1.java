package Test;

public class test1 {

    public static int[][] rotate(int[][] matrix) {
        //逆时针交换
        int n = matrix.length;
        SwapNumbers sn = new SwapNumbers();
        //交换n/2圈
        for (int i = 0; i < n/2; i++) { //循环圈数
            int t = n - 1 - i;  //i = 0第1圈, t = 3 //i = 1第2圈，t = 2
            for (int k = 0, j = t; k < t && j > 0; k++, j--) {  //0-t-1每圈循环位置
                sn.swap(matrix[k][0], matrix[t][k]);
                sn.swap(matrix[t][k], matrix[j][t]);
                sn.swap(matrix[j][t], matrix[0][j]);
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int n = matrix.length;
        int[][] res = rotate(matrix);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
