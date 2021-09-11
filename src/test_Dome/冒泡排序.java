package test_Dome;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        //多项式求和
        System.out.println("这是测试程序");
        int[] arry = new int[10];
        for (int i = 0; i < arry.length; i++) {
            arry[i] = (int)(Math.random()*1000)%100;
        }

        System.out.println(Arrays.toString(arry));
        PpSort(arry);
        System.out.println(Arrays.toString(arry));

    }

    private static void PpSort(int[] arry) {
        int len= arry.length-1;
        for (int i = 0; i < len; i++) {

            for (int j = 0; j < len-i; j++) {
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                }
            }
        }
    }
}
