package 数组;

public class q1725_可以形成最大正方形的矩形数目_easy {
    public static int countGoodRectangles(int[][] rectangles) {
        int count = 1;
        int min = Math.min(rectangles[0][0], rectangles[0][1]);
        for (int i = 1; i < rectangles.length; i++) {
            int tmp = Math.min(rectangles[i][0], rectangles[i][1]);
            if(min == tmp) count++;
            else if(tmp > min) {
                count = 1;
                min = tmp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{2,3},{4,3},{3,7},{3,7}};
        int res = countGoodRectangles(rectangles);
        System.out.println(res);
    }
}
