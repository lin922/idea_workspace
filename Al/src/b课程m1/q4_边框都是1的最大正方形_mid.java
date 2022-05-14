package b课程m1;

public class q4_边框都是1的最大正方形_mid {
    //n4次方复杂度
    public static int maxSquares1(int[][] matrix) {
        int max = 1;
        int n = matrix.length;
        //以 每个点 为左顶点找符合条件的正方形
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) { //左顶点为1能构成的最大正方形
                    //枚举边长长度
                    for (int k = 2; k <= n - i && k <= n - j; k++) {
                        //判断是否构成正方形
                        int flag = 1;
                        for (int l = 1; l < k; l++) {
                            //不能构成，做标记，退出
                            if(matrix[i+l][j] != 1 || matrix[i][j+l] != 1 ||
                                matrix[i+k-1][j+l] != 1 || matrix[i+l][j+k-1] != 1) {
                                    flag = 0;
                                    break;
                            }
                        }
                        //如果能构成，记录最大边长
                        if(flag == 1 && k > max) max = k;
                    }
                }
            }
        }
        return max;
    }
    //空间换取时间
    public static int maxSquares2(int[][] matrix) {
        int max = 1;
        int n = matrix.length;
        //生成right[]和down[]矩阵记录连续1个数
        int right[][] = new int[n][n];
        int down[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                if(j == n-1) {
                    if(matrix[i][j] == 1) right[i][j] = 1;
                    else right[i][j] = 0;
                }
                else {
                    if(matrix[i][j] == 1) right[i][j] = right[i][j+1]+1;
                    else right[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = n-1; i >= 0; i--) {
                if(i == n-1) {
                    if(matrix[i][j] == 1) down[i][j] = 1;
                    else down[i][j] = 0;
                }
                else {
                    if(matrix[i][j] == 1) down[i][j] = down[i+1][j]+1;
                    else down[i][j] = 0;
                }
            }
        }
        //以 每个点 为左顶点找符合条件的正方形
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //枚举边长长度
                for (int k = Math.min(n-i, n-j); k >= 2; k--) {
                    //判断是否构成正方形
                    if(right[i][j] >= k && right[i+k-1][j] >= k && down[i][j] >= k && down[i][j+k-1] >= k && k > max){
                        max = k;
                        break;
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int matrix[][] = {{0,1,1,1,1},
                          {0,1,0,0,1},
                          {0,1,1,1,1},
                          {0,1,1,1,1},
                          {0,1,0,1,1}};
        System.out.println(maxSquares1(matrix));
        System.out.println(maxSquares2(matrix));
    }
}
