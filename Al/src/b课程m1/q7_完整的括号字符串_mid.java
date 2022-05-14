package b课程m1;

import java.util.Stack;

public class q7_完整的括号字符串_mid {
    public static int BracketsCounts1(String s) {
        Stack<Character> st = new Stack();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }
            else {
                //如果不为空
                if(!st.empty()) {
                    st.pop();
                }
                else {
                    count++;
                }
            }
        }
        count += st.size();
        return count;
    }

    public static int BracketsCounts2(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            }
            else {
                count--;
            }
            if(count < 0) {
                count += 1;
                res += 1;
            }
        }
        res += count;
        return res;
    }

    public static void main(String[] args) {
        String s = "(())(()))))";
        System.out.println(BracketsCounts1(s));
        System.out.println(BracketsCounts2(s));
    }
}
