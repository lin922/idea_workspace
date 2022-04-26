package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N皇后 {
    static List<List<String>> res = new ArrayList<>();
    
    //判断位置是否合法函数
    public static boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            //若该列其他行存在Q，则不满足
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线 对角线存在Q不满足
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //回溯函数，找出皇后位置
    public static void backTrack(int n, int row, char[][] chessboard) {
        //终止条件 找到了解决方案(n行都放下了Q)
        if(row == n) {
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; ++col) {
            if (isValid (row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row+1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    //填充结果函数，将棋盘数组填充进list
    public static List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public static List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        //将棋盘全部填充为'.'
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backTrack(n, 0, chessboard);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        res = solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                System.out.print(res.get(i).get(j));
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
