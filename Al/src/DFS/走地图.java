package DFS;

import java.text.DateFormatSymbols;

public class 走地图 {

    //定义全局变量ans和step作比较
    static int ans = 1000000;
    //定义一个方向数组 上下左右
    static int [][] s = {{1,0},{-1,0},{0,1},{0,-1}};
    //参数 ij表示当前坐标，flag标记该点是否走过，step表示步数
    public static void DFS(int i, int j, int[][] map, int[][] flag, int step ) {
        //终止条件，如果到达终点，则保存较小的步数
        if(i == 4 && j == 4) {
            if(step < ans) ans = step;
            return;
        }

        //循环，上下左右四个方向递归
        for(int t = 0; t < 4; t++) {
            //如果满足（索引未越界&&该点没走过以防止陷入循环&&该点无障碍）就前进，否则不走
            if(i+s[t][0] >= 0 && i+s[t][0] < 5 && j+s[t][1] >= 0 && j+s[t][1] < 5
                    && flag[i+s[t][0]][j+s[t][1]] == 0 && map[i+s[t][0]][j+s[t][1]] == 0){
                //如果可以走，就标记该点为1
                flag[i+s[t][0]][j+s[t][1]] = 1;
                //继续在该点DFS
                DFS(i+s[t][0], j+s[t][1], map, flag, step+1);
                //回溯，避免另一条路走至该点，发现该点已标记，不能走的情况
                flag[i+s[t][0]][j+s[t][1]] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] map =  {{0,1,0,0,0},
                        {0,1,0,1,0},
                        {0,0,0,1,0},
                        {0,1,1,1,0},
                        {0,0,0,1,0}};
        int [][]flag = new int[5][5];
        DFS(0, 0, map, flag, 0);
        System.out.println(ans);
    }
}
