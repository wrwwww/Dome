package test_Dome;

import java.util.Arrays;
import java.util.Stack;

public class ArrayText {
    public static void main(String[] args) {
//        int[] arr1 = new int[10];
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i] = i + 1;
//            System.out.println(arr1[i]);
//        }
//        int[] arr2 = {2, 5, 8};
//        int[] arr3 = new int[]{2, 5, 8};
//
//        int[] ff = new int[]{100, 200, 300};
////        ff[3]=400;
//        System.out.println(ff[ff.length-1]);

//        int[] arr = new int[100];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 10000 % 100);
//        }
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        int max = arr[0];
//        for (int i: arr) {
//            if(i>max){
//                max=i;
//            }
//        }
//        System.out.println(max);

        Stack<Integer> abc=new Stack<Integer>();
        for (int i = 0; i < 10; i++) {
            abc.add(i + 1);
        }
        System.out.println(abc.pop());
        System.out.println(abc.pop());
        System.out.println();


    }
}
