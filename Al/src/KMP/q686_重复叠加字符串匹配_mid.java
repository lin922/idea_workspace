package KMP;

public class q686_重复叠加字符串匹配_mid {
    //重叠字符串匹配
    public static int repeatedStringMatch(String a, String b) {
        KMP kmp = new KMP();
        int n1 = a.length(), n2 = b.length();
        String s = "";
        while(s.length() < b.length()) {
            s += a;
        }
        if(kmp.KMP(s, b) != -1) {
            return s.length()/a.length();
        }
        else{
            s += a;
            if(kmp.KMP(s, b) != -1) {
                return s.length()/a.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "ab", b = "babababa";
        System.out.println(repeatedStringMatch(a, b));
    }
}
