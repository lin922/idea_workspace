package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import static java.lang.Math.sqrt;

public class q279_完全平方数_mid {
    public static int BFS(int n) {
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new TreeSet<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size-- != 0) {
                int tmp = queue.poll();
                for(int i = 1; tmp + i*i <= n; i++) {
                    if(tmp + i*i == n) return level;
                    if(!set.contains(tmp + i*i)) {
                        queue.offer(tmp + i*i);
                        set.add(tmp + i*i);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 7168;
        System.out.println(BFS(n));
    }
}

