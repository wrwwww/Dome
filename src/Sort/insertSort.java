package Sort;

import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] raw = new int[10];


        //生成随机的数字测试
        for (int i = 0; i < raw.length; i++) {
            raw[i]= (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(raw));
        quick(raw);
//        insert(raw);
        System.out.println(Arrays.toString(raw));
//        shellSort(raw);
//        System.out.println(Arrays.toString(raw));
//        sort(raw);
//        System.out.println(Arrays.toString(raw));
//        int[] arrs = new int[]{0,1};
//
//        System.out.println(jump(arrs));
//        System.out.println(jump(new int[]{3,0,8,2,0,0,1}));
//        System.out.println(sf(arrs));
//        System.out.println(sf(new int[]{3,0,8,2,0,0,1}));
    }

    //插入排序方法
    static void insert(int[] arr){
        //从第二个元素开始遍历数组·····························
        for (int i = 1; i < arr.length; i++) {
           //当这个元素比前一个元素小的时候就往前对比
            //直到前一个元素比他大，那些比他大的元素一个一个往后移动
            if (arr[i] <= arr[i - 1]) {

                int temp=arr[i];
                int j=i-1;

                while(j>=0&&arr[j]>temp){
                    //往后移动
                    arr[j+1]=arr[j];
                    //往前推进
                    j--;
                }
                //元素归位
                arr[j+1]=temp;
            }
        }
    }

    /**
     *希尔排序
      */
    static void shellSort(int[] arr){
        //同插入排序一样只不过是不断缩小增量
        for (int i = arr.length / 2; i < arr.length && i >= 1; i /= 2) {

            for (int j = i; j >= 1 && j < arr.length; j++) {
                if (arr[j] <= arr[j - i]) {
                    int temp = arr[j];
                    int z = j - i;
                    while (z >= 0 && arr[z] > temp) {
                        arr[j] = arr[z];
                        z -= i;
                    }
                    arr[z + i] = temp;
                }
            }
        }
    }


    /**
     *选择排序
     * 每次选择一个最小的元素到左边
     */
    static void sort(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 快排
     *
     */
    public static void quick(int[] arr) {

        fun(arr, 0, arr.length-1);

    }
    static void fun(int[] arr, int start, int end){
        for (int i = start; i < end; i++) {
            int tempIndex = (end - start) / 2;
            if (arr[i] > arr[(end - start) / 2]) {
                int temp = arr[tempIndex];
                arr[tempIndex] = arr[i];
                tempIndex = i;
                

            }
        }
        fun(arr,start,end/2);
        fun(arr,end/2,end-1);
    }


    //跳跃游戏
    public static boolean jump(int[] nums){

        //当为一个元素时
        if (nums.length == 1) {
            return true;
        }
        //记录当前能到达的最远地方
        int maxIndex = 0;

        //当多个元素时
        for (int i = 0; i < nums.length; i++) {
            //存放当前这个数跳跃的最远距离
            //int temp = i + nums[i];

            if ((i + nums[i]) == i && maxIndex <= (i + nums[i])) {

                //3,0,8,2,0,0,1
                return false;
            }
            if ((i + nums[i]) > maxIndex) {
                maxIndex = i + nums[i];
                if (maxIndex>=nums.length-1){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean sf(int[] nums){
        int maxIndex=0;
        for (int i = 0; i <= maxIndex && maxIndex <= nums.length; i++) {

            int temp = nums[i] + i;
            if (temp >= maxIndex) {
                maxIndex = temp;
                if(maxIndex>= nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
