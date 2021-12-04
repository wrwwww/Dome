package LeetCode;

import java.util.Arrays;

public class move {
    public static void main(String[] args) {
        int[] num = new int[]{5};
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            while (num[left] <= 3) {
                left++;
            }
            if (left < right) {
                while (num[right] > 3) {
                    right--;
                }
                if (left < right) {
                    int temp = num[left];
                    num[left] = num[right];
                    num[right] = temp;
                }
            }
        }
        num = Arrays.copyOf(num, left);
        System.out.println(Arrays.toString(num));

    }
}
