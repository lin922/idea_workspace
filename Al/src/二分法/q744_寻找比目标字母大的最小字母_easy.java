package 二分法;

public class q744_寻找比目标字母大的最小字母_easy {

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        if(letters[right] <= target) return letters[0];
        while(left < right) {
            int mid = left + (right - left)/2;
            if (letters[mid] <= target)    left = mid + 1;
            else if (letters[mid] > target)    right = mid;
        }
        return letters[right] ;
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char target = 'd';
        char res = nextGreatestLetter(letters, target);
        System.out.println(res);
    }
}
