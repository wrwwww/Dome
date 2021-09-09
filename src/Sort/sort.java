package Sort;

import java.util.Arrays;

class sort {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //排序练习
        //快速排序
        int[] nums = new int[10];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(nums));
        sortText(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));

    }

    private static void sortText(int[] nums, int top, int end) {
//        if (top==end+1||top==end) return;

            //        存放参考值
        int pivotKey = nums[top];

        int low = top;
        int high = end;
        while(low<high){

            while (nums[high] >= pivotKey && high > low) {

                high--;
            }
            nums[low] = nums[high];
            low++;
            while (nums[low] < pivotKey && low < high) {

                low++;
            }
            nums[high]=nums[low];
            high--;



        }
        nums[low] = pivotKey;
        if(top==high-1)return;
        else {
            sortText(nums, top, high - 1);
            sortText(nums, high + 1, end);
        }



        }


    private static void wap(int[] nums, int a, int b) {
        //借用临时变量
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
        //位运算
//        nums[a] ^= nums[b];
//        nums[b] ^= nums[a];
//        nums[a] ^= nums[b];

    }
}

