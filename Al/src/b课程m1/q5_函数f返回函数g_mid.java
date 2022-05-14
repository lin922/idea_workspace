package b课程m1;

public class q5_函数f返回函数g_mid {
    //f1()函数等概率返回1-5之间数字
    public static int f1() {
        //Math.random()返回[0,1)之间double值,强转只取整数部分
        return (int) (Math.random() * 5) + 1;
    }
    //如何用f1等概率返回1-7数字g1()?---使用二进制
    //先将原函数转化成等概率返回0，1的函数
    public static int r01() {
        int res = f1();
        if(res == 3) r01();
        return res < 3 ? 0 : 1;
    }
    //1-7转化为0-6需要二进制3位
    public static int g1() {
        int res = 0;
        // <<左移操作相当于*2
        res = (r01() << 2) + (r01() << 1) + r01();
        if(res == 7) g1();
        return res + 1;
    }


    //f2()函数以p概率返回0，1-p概率返回1
    public static int f2( ) {
        double p = 0.55;
        return Math.random() < p ? 0 : 1;
    }
    //如何用f2实现g2等概率返回0和1?
    //返回两次f2 00 01 10 11 两次相等的概率为1/2
    public static int g2() {
        int res1 = f2();
        int res2 = f2();
        return res1 == res2 ? 0 : 1;
    }

    public static void main(String[] args) {
        System.out.println(f1());
        System.out.println(r01());
        System.out.println(g1());
        System.out.println(f2());
        System.out.println(g2());
    }
}
