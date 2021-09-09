package LeetCode;

import java.util.Arrays;

/**
 *
 * 给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。
 *
 * 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j < arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。
 *
 * 如果无法让 arr1 严格递增，请返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-array-strictly-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class arrayAdd {
    //传递俩数组利用第二个数组使得第一个数组变得有序
    //给第二个数组排序
    //遍历第一个数组，找到数组中比后一个元素大的元素
    //在数组2中找更小或者相等的数
    //赋值给数组一

    public static void main(String[] args) {
        //[1,5,3,6,7]
        //[1,6,3,3]
//        int[] arr1 = new int[]{1, 5, 3, 6, 7};
//        int[] arr2 = new int[]{4,3,1};
        int[] arr1 = new int[]{0, 11, 6, 1, 4, 3};
        int[] arr2 = new int[]{5,4,11,10,1,0};
        //在我想的最简单的寻找方法之后进入另一种查找
        //不一定要比后面的小，因为可以后面换大他所以
        //需要再次扫描没有用过的数字
        //为此需要有个下标来记录这个数字有没有被用过

//        int[] arr2 = new int[]{1, 6, 3, 3};

        System.out.println(1/3);
        System.out.println(2/3);
        System.out.println(3/3);
        System.out.println(4/3);
        System.out.println(1162261467%6);
        //System.out.println(makeArrayIncreasing(arr1, arr2));
        //System.out.println(Arrays.toString(arr1));

    }
    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int j = 0;
        int minNums = 0;

        //排序
        Arrays.sort(arr2);
        if (arr1[0]>arr1[1]){
            while (j < arr2.length && arr2[j]>arr1[1]) j++;
            if (arr2[j]<arr1[1]) {
                arr1[0]=arr2[j];
                minNums += 1;
            }
            if (arr2[j] > arr1[2] ) return -1;
            j += 1;

        }


        //从第二个数开始遍历第一个数组
        for (int i = 1; i < arr1.length-1; i++) {
            //如果这个数比后面的大，需要被替换
            //不可以等于前一个数,可以等于后一个数
            if (arr1[i] > arr1[i+1]||arr1[i]==arr1[i-1]) {

                //寻找比后一个数小的数，且大于前一个数的数
                //当第二个数组的数大于后一个数，小于前一个数的时候继续寻找
                if (j == arr2.length) {

                    return -1;
                }
                while (j < arr2.length && (arr2[j] > arr1[i + 1] || arr2[j] <= arr1[i - 1])) j++;
                //可能找到也可能没有
                // arr1[i-1] < arr2[j] =< arr1[i+1]
                if (j == arr2.length) {

                    return -1;
                }
                if (j < arr2.length && (arr2[j] > arr1[i + 1] || arr2[j] <= arr1[i - 1])) return -1;
                //找到就替换
                arr1[i] = arr2[j];

                j += 1;

//                j += 1;
                minNums = minNums + 1;
            }

        }
//        if  (j == arr2.length) return -1;
//        //返回最小操作数
        return minNums;
    }
}
