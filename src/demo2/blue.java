package demo2;

import java.util.Arrays;

public class blue {
    public static void main(String[] args) {
        //斐波那契数列
        System.out.println(fib(3));
        String w= "qwerthhjhftftdry";
        System.out.println(gcc(w,w.length()-1));
        int[] arry = new int[]{5, 3, 2, 8, 5, 9, 1, 0};
        for (int i = 0; i < arry.length; i++) {
            arry[i]= (int) (Math.random()*100);
        }
        System.out.println(Arrays.toString(arry));
        insertSort(arry);
        System.out.println(Arrays.toString(arry));
        
    }

    //斐波那契数列
    static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    //字符逆转
    static String gcc(String sur ,int end){
        if (end == 0){
            return sur.charAt(end)+"";
        }
        return sur.charAt(end)+gcc(sur,end-1);
    }

    //插入排序
    static void insertSort(int[] arr){
        //从第二个元素开始遍历
        for (int i = 1; i < arr.length; i++) {
            //如果这个元素比前一个小
                //就和前面的元素比较直到有一个比他小的元素
            if (arr[i]<arr[i-1]){
                int temp = arr[i];
                //同前面的数字比较
                for (int j = i-1; j >=0; j--) {
                    if (arr[j] > temp) {
                        arr[j+1] = arr[j];
                        arr[j] = temp;
                    }
                    else {
//                        arr[j + 1] = temp;
                        break;
                    }

                }
            }


        }
    }

}

