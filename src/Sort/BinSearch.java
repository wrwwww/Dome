package Sort;

import com.sun.source.tree.ReturnTree;

import java.util.Arrays;


public class BinSearch {
    public static void main(String[] args) {
        System.out.println("结果"+binSearch(new int[]{1,2,3,4,5,8,9},4));
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        Arrays.sort(hand);
        System.out.println(Arrays.toString(hand));
        System.out.println(2%3);
    }

    //二分查找
    public static int binSearch(int[] nums, int target) {

        //调用递归二分查找  对于有序数组
        return search(nums, 0, nums.length - 1, target);
    }

    static int search(int[] nums, int start, int end,int target) {
        //当二分到最后进行判断
        if (start == end-1||start==end) {
            if (nums[start] == target) return start;
            if (nums[end]== target) return end;
            return -1;
        }
        //记录中间位置为之后二分做准备
        int midIndex = start + (end - start) / 2;
        if (nums[midIndex] == target) return midIndex;
        if (nums[midIndex] > target) return search(nums, start, midIndex, target);
        if (nums[midIndex] < target) return search(nums, midIndex, end, target);
        return -1;
    }

    /**
     * 爱丽丝有一手（hand）由整数数组给定的牌。
     * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
     * 如果她可以完成分组就返回 true，否则返回 false。
     */
    static  public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize != 0) return false;
        Arrays.sort(hand);
        int[] temp=new int[groupSize+1];

        for (int i = 0; i < hand.length; i++) {
            for (int j = 0; j < temp.length; j++) {

                hand[j] = hand[i];
                //遇到重复数字


            }

        }
        return false;
    }

    /**
     *
     */
    public static boolean queBinTree() {

        return false;
    }





}


