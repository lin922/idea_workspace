package BFS;

import java.util.Queue;
import java.util.LinkedList;

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
};

public class 走地图 {
    //map为给定地图，path存放图中各点距离出发点的距离
    public static void BFS(int[][] map, int[][] path) {
        int m = map.length, n = map[0].length;
        int [][]s = {{1,0}, {-1,0}, {0,1}, {0,-1}}; //定义并初始化一个方向数组
        Queue<Node>queue = new LinkedList<>(); //定义一个队列
        queue.offer(new Node(0, 0)); //将出发点存入队列
        while(queue.peek() != null) { //队列不为空，从队首依次层层扩张
            Node node = queue.poll(); //返回队列的第一个元素并从队列中删除
            if(node.x == n-1 && node.y == m-1) break;
            //判断是否可以往下层(上下左右)扩张
            for(int t = 0; t < 4; t++) {
                int x = node.x + s[t][0];
                int y = node.y + s[t][1];
                //如果满足（索引未越界&&该位置没走过&&该位置非障碍点）即可继续走，否则不走
                if(x >= 0 && x < m && y >= 0 && y < n && path[x][y] == 0 && map[x][y] == 0) {
                    queue.offer(new Node(x, y));  //新扩展的点存入队列
                    path[x][y] = path[node.x][node.y] + 1; //路径数组对应位置较之前+1
                }
            }
        }
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++) {
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] map =  {{0,1,0,0,0},
                        {0,1,0,1,0},
                        {0,0,0,1,0},
                        {0,1,1,1,0},
                        {0,0,0,1,0}};
        int m = map.length, n = map[0].length;
        int [][]path = new int[5][5];
        BFS(map, path);
        System.out.println(path[m-1][n-1]);
    }
}
