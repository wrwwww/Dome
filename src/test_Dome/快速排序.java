package test_Dome;

import java.util.Arrays;

class Scratch {
    public static void main(String[] args) {
        //多项式求和
        System.out.println("这是测试程序");
        int[] arr = new int[9];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*1000)%100;
        }

        System.out.println(Arrays.toString(arr));
        QuickSort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void QuickSort(int[] nums) {
        sort(nums,0, nums.length-1);
    }

    static void sort(int[] nums, int left, int right){

        if (left == right+1) {
            return;
        }
        int a = left;
        int b = right;
        int temp = nums[left];
        while (left < right ) {

            while (nums[right] > temp && right > left) {
                right--;
            }
            if (nums[right] <= temp && right > left){
                nums[left] = nums[right];
                left++;}




            while (nums[left] < temp && left<right) {
                left++;
            }
            if (nums[left] >= temp && left<right)
            {
                nums[right] = nums[left];
                right--;
            }

        }
        nums[left] = temp;

            sort(nums, a, left - 1);
            sort(nums, left+1, b);

    }
    }
