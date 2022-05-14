package BFS;

import java.util.*;

public class q433_最小基因变化_mid {
    public static int minMutation(String start, String end, String[] bank) {
        int step = 0;
        //将bank放进Set以便于快速查找
        Set<String> bank1 = new TreeSet<String>(Arrays.asList(bank));
        //建立另一个Set避免队列中出现重复
        Set<String> hs = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        char[] change = {'A', 'C', 'G', 'T'};
        queue.add(start);
        hs.add(start);
        while(queue.peek() != null) {
            int size = queue.size();
            step++;
            while(size-- != 0) {
                String cur = queue.poll();
                if (cur.equals(end)) return step-1;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        String cur1 = cur.substring(0, i) + change[j] + cur.substring(i+1);
                        //bank中存在该字符串，且之前队列没有存入过
                        if (bank1.contains(cur1) && !hs.contains(cur1)) {
                            queue.add(cur1);
                            hs.add(cur1);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int res = minMutation(start, end, bank);
        System.out.println(res);
    }
}
