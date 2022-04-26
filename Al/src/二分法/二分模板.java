package 二分法;

/*二分法主要关注点:
  左右边界的开闭，是否包含左右边界
  判断 > = < 三种情况下需要舍弃的段
 */

public class 二分模板 {
    /*
    普通二分法
     */
    public static int binarySearch(int[] nums , int target){
        int left = 0 , right = nums.length-1;//左闭右闭区间[left,right]
        while(left <= right){ //left == right时，区间[left,right]依然有效
            int mid = left + (right - left)/2; //防止溢出
            // 数组中找到目标值，直接返回下标
            if (nums[mid] == target)    return mid;
            // target 在左区间，所以[left, middle - 1]
            else if (nums[mid] > target)    right = mid - 1;
             // target 在右区间，所以[middle + 1, right]
            else if (nums[mid] < target)    left = mid + 1;
        }
        return -1;
    }

    /*
    左边界二分法
     */
    public static int leftBinarySearch(int[] nums , int target){
        int left = 0 , right = nums.length; //左闭右开区间
        while (left < right){  //left == right没有意义
            int mid = left + (right - left)/2;
            //target在左区间[left, mid)
            if (nums[mid] >= target)    right = mid;
            //target在右区间[mid+1, right)
            else if (nums[mid] < target)    left = mid + 1;
        }
        return left;
    }

    /*
    右边界二分法
     */
    public static int rightBinarySearch(int[] nums , int target){
        int left = 0 , right = nums.length;//左闭右开区间
        while (left < right){
            int mid = left + (right - left)/2;
            //target在右区间[mid+1, right)
            if (nums[mid] <= target)    left = mid + 1;
            //target在左区间[left, mid)
            else if (nums[mid] > target)    right = mid;
        }
        return right - 1;
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0 , right = 0;
        if (binarySearch(nums,target) == -1){
            left = -1;right = -1;
        } else {
            left = leftBinarySearch(nums,target) ;
            right = rightBinarySearch(nums,target);
        }
        int[] ans = {left,right};
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10} , target = 6;
        System.out.println(leftBinarySearch(nums,target));
    }
}

