package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class quickSort {

    public static void main(String[] args) {
        int[] textArray = new int[11];
        for (int i = 0; i < textArray.length; i++) {
            textArray[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(textArray));
        quick(textArray,0, textArray.length-1);
        System.out.println(Arrays.toString(textArray));
        Arrays.sort(textArray);
        System.out.println(Arrays.toString(textArray));
    }
    //归并排序

     public static void quick(int[] nums, int start, int end){

            if (start == end - 1) {
                if (nums[start] > nums[end]) {
                    int temp = 0;
                    temp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = temp;

                }

            }

            if (start < end - 1) {
                int mid = end - ((end - start) >> 1);
                System.out.println(mid);
                quick(nums, start, mid);
                quick(nums, mid + 1, end);
                merger(nums, start, mid, end);
            }
        }


    static int[] temp ;

    public static void merger(int[] nums, int start, int mid, int end) {


            temp = new int[nums.length];
            System.arraycopy(nums, 0, temp, 0, nums.length);
            int p = mid+1 ;
            int src = start;
            //复制数组后开始操作传入得位置
            while (start <= mid && p <= end) {
                if (temp[start] < temp[p]) {
                    nums[src] = temp[start];
                    src++;
                    start++;
                } else {
                    nums[src] = temp[p];
                    p++;
                    src++;
                }
            }
            //可能有一队已经结束了所以剩下得直接赋值
            while (start <= mid) {
                nums[src] = temp[start];
                start++;
                src++;
            }
            while (p <= end) {
                nums[src] = temp[p];
                p++;
                src++;
            }

    }
}
