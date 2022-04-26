package 数学;

import java.util.ArrayList;
import java.util.List;

public class q398_随机数索引_mid {
    static int[] arr;
    public q398_随机数索引_mid(int[] nums) {
        arr = nums.clone();
    }
    public static int pick(int target) {
        List<Integer>list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                list.add(i);
            }
        }
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        int target = 3;
        q398_随机数索引_mid obj = new q398_随机数索引_mid(nums);
        int param_1 = obj.pick(target);
        System.out.println(param_1);
    }
}
