package memory.hash;

import java.util.*;

public class day0917 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(permute(test).toArray()));

    }

    /**
     * 全排列
     * @param nums 等待排列数组
     * @return 全排列的集合
     */
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ls = new LinkedList<>();
        Boolean[] bool = new Boolean[len];
        Arrays.fill(bool, false);
        for (int i = 0; i < len; i++) {
            bool[i] = true;
            List<Integer> set = new LinkedList<>();
            set.add(nums[i]);
            dfs(nums, bool, ls, set, len);
            bool[i] = false;
        }
        return ls;
    }

    public static void dfs(int[] nums, Boolean[] bool, List<List<Integer>> ls, List<Integer> set, int len) {
        for (int i = 0; i < len; i++) {
            if (!bool[i]) {
                bool[i]=true;
                set.add(nums[i] );
                dfs(nums, bool, ls, set, len);
                set.remove(set.size() - 1);
                bool[i] = false;
            }
        }
        if(set.size()==len){
            List<Integer> temp = new LinkedList<>(set);
            ls.add(temp);
        }
    }

}
