package test_Dome;

import java.util.Arrays;

public class School {
    public static void main(String[] args) {
        int[] arr=new int[]{2,2,2,3,3};
        del(arr,2);
//        wap(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }
    static void del(int[] nums,int val){
        int end=nums.length-1;
        for (int i = 0; i <= end; i++) {
            if (nums[i]==val){
                wap(nums,i--,end--);
            }
        }
    }

    private static void wap(int[] nums, int i, int i1) {
        nums[i] = nums[i] ^ nums[i1];
        nums[i1] = nums[i1] ^ nums[i];
        nums[i] = nums[i] ^ nums[i1];

    }
}
