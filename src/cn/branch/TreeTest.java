package cn.branch;

import math.Arrays_Random;
import java.util.Arrays;

public class TreeTest {
    public static void main(String[] args) {
        int[] nums=new int[10];
        //随机数组
        Arrays_Random ttt = new Arrays_Random(nums);
        ttt.toRandom(100);
        System.out.println(Arrays.toString(nums));

        //转化完全二叉树
        ArraysToTree tt = new ArraysToTree(nums);

    }
}
