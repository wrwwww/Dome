package demo3;

import java.util.Arrays;

public class insert {

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,6,3,5,67,74,3,5,9};
        int[] text = new int[nums.length];
        int a=0;
        System.arraycopy(nums,0,text,0,nums.length);
        for (int i = 0; i < text.length; i++) {
            a = a ^ text[i];
        }
        sort(nums);
            for (int i = 0; i < text.length; i++) {
                a = a ^ nums[i];
            }
            System.out.println(Arrays.toString(nums));
        System.out.println(a);

    }
    public static void sort(int[] nums){
        //插入排序
        for (int i = 1; i < nums.length ; i++) {

            //当当前指针的值小于前一个的值时这个值往前插直到前一个数比他大
            if (nums[i] < nums[i - 1]) {


                int temp = nums[i];
                int j = i - 1;
                while (j > -1 && temp < nums[j]) {

                    //前一个数后移
                    //创建临时变量存这个值
                    nums[j+1] = nums[j];
                    j--;
                }
                nums[j + 1] = temp;
            }
        }


    }
}
