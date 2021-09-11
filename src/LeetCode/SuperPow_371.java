package LeetCode;

import java.util.Stack;

public class SuperPow_371 {

    public static void main(String[] args) {
        //测试案例
        int[] nums = new int[]{2,0,0};

        for (int num:nums) {
            node.add(num);
        }

//        System.out.println(node.empty());
        System.out.println(powerful(Integer.MAX_VALUE,nums));
    }
    public static Stack<Integer> node=new Stack<Integer>();

    public static int powerful(int a, int[] nums) {

        int part1=1;
        int part2=1;
        if (node.empty()) return 1;
        else{
            part1 = mod(a, node.pop());
            if (!node.empty())
            part2 = mod(powerful(a, nums), 10);
        }
        return (part1 * part2) % 1337;
    }

    //k次
    //求莫公式
    //(a*b)%k=(a%k)(b%K)%k;
    public static int mod(int num,int k) {
        num = num % 1337;
        if (k == 0) return 1;
        else {
            int kk = 1;
            for (int i = 0; i < k; i++) {
                kk = kk * num;
                kk = kk % 1337;
            }
            return kk;
        }
    }

}


