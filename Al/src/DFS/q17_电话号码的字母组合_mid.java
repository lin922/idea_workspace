package DFS;

import java.util.ArrayList;
import java.util.List;

public class q17_电话号码的字母组合_mid {
    public static void DFS(String digits, ArrayList<String> list, List<String> res, String s, int pos) {
        if(pos == digits.length()) {
            if(pos != 0) res.add(s);
            return;
        }
        //取得当前数字
        int n = digits.charAt(pos) - '0' - 2;
        for (int i = 0; i < list.get(n).length(); i++) {
            DFS(digits, list, res,s+list.get(n).charAt(i),pos+1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        // 怎么实现添加
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");
        DFS(digits, list, res, "", 0);
        return res;
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        String digits = "99";
        res = letterCombinations(digits);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        char d = 'a'-1;
//        for (int i = 2; i <= 9; i++) {
//            String s = "";
//            for (int j = 0; j < 3; j++) {
//                d += 1;
//                s += d;
//            }
//            list.add(s);
//        }