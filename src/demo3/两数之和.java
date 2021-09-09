package demo3;

import java.util.Arrays;

public class 两数之和 {
    public static void main(String[] args) {
        int[] abc = new int[]{-1,-1,-3,-4,-5};
        System.out.println(Arrays.toString(sum(abc, -8)));
    }

    //暴力破解
    public static int[] sum(int[] nums,int target) {
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp2 = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == temp2) {
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return temp;
    }
}
