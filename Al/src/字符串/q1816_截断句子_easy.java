package 字符串;

public class q1816_截断句子_easy {
    public static String truncateSentence(String s, int k) {
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') k--;
            pos = i;
            if(k == 0) break;
        }
        if(pos == s.length() - 1) return s;
        else return s.substring(0, pos);
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }
}
