package LeetCode;

import java.util.Arrays;

public class arrayAdd2 {
    public static void main(String[] args) {
//        int[] arr1 = new int[]{0, 11, 6, 1, 4, 3};
//        int[] arr2 = new int[]{5, 4, 11, 10, 1, 0};
        int[] arr1 = new int[]{5,16,19,2,1,12,7,14,5,16};

        int[] arr2 = new int[]{6,17,4,3,6,13,4,3,18,17,16,7,14,1,16};
        //输出5
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(fun(arr1, arr2));
        System.out.println(Arrays.toString(arr1));
    }

    static int fun(int[] arr1,int[] arr2){
        int[][] temp;
        temp = new int[arr2.length][2];
        Arrays.sort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            temp[i][0]=arr2[i];
        }

        if (arr1[0]>arr1[1]){
            for (int i = 0; i < arr2.length; i++) {
                if (temp[i][0]<=arr1[i+1]){
                    arr1[0]=temp[i][0];
                    temp[i][1]++;
                    break;
                }
            }

        }
        //如果找不到大于前一个数的数就return-1
//先判断这个数大于前一个么，大于后在看小于后一个么，大于后一个的话寻找比后一个小的，
//        可能遍历结束还是找不到，没关系可以找比前一个数大的最小的数替换这个值
//        第一个数单独判断
        for (int i = 1; i < arr1.length; i++) {
//            当这个数大于前一个数时候
            if (arr1[i] > arr1[i - 1]) {
                //如果大于后一个
                if (i == arr1.length - 1) {
                    break;
                }
                if (arr1[i] >= arr1[i + 1]) {
                    //寻找大于前一个数的最小数
                    for (int j = 0; j < arr2.length; j++) {
                        if (arr1[i-1] < temp[j][0] && temp[j][1] == 0) {
//                        替换
                            arr1[i]=temp[j][0];
                            temp[j][1]=1;

                            break;
                        }
                    }
                }
                continue;
            }

            //当这个树小于前一个树
//            经过第一个判断还能到这说明前面的数已经被修改过找到最佳值
            if (arr1[i] <= arr1[i - 1]) {
            //寻找一个大的
                for (int j = 0; j < arr2.length; j++) {
                    if (temp[j][0] > arr1[i - 1] && temp[j][1] == 0) {
                        arr1[i]=temp[j][0];
                        temp[j][1]=1;
                        break;
                    }

                }
                if (arr1[i]<=arr1[i-1])
                return -1;
            }



        }
        if (arr1[arr1.length - 1] <= arr1[arr1.length - 2]) {
            for (int i = 0; i < arr2.length; i++) {

            }
        }
        int minNums = 0;
//         最后遍历二维数组下标有几个1就return
        for (int i = 0; i < arr2.length; i++) {
            if (temp[i][1]==1)
                minNums += 1;
        }
        return minNums;
    }



}
