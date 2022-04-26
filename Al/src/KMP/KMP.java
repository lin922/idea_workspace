package KMP;

public class KMP {
    public static int KMP(String t, String p) {
        //寻找next数组
        int[] next = new int[p.length()];
        next[0] = -1;
        //模式串自身进行匹配
        int i = 0, j = -1;
        //i当前正在匹配的位置，从0开始
        //j表示可以和0-i段匹配几位
        while(i < p.length()-1){
            //如果匹配上或者j回到初始位置，此时ij都后移
            if( j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            }
            else {
                //如果未匹配上，i位置不变，j根据next数组回退
                j = next[j];
            }
        }
        //进行字符串匹配
        i = 0;
        j = 0;
        while(i < t.length() && j < p.length()) {
            if(j == -1 || t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }
        }
        if(j == p.length()) return i-j;
        else return -1;
    }
    public static void main(String[] args) {
        String t = "ababababca";
        String p = "babca";
        System.out.println(KMP(t, p));
    }
}
