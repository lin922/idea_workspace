package Test;

public class SwapNumbers {
    public int a;
    public int b;

    public void swap(int a, int b) {
        this.a = b;
        this.b = a;
    }

    public void main(String[] args) {
        System.out.println("-------成员变量交换---------");
        System.out.println(a);
        System.out.println(b);
        SwapNumbers sn = new SwapNumbers();
        sn.swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }
}
