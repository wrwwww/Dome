package test_Dome;

import memory.hash.HashFun;

import java.util.Arrays;

//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/two-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Hash_test {
    public static void main(String[] args) {
        HashFun map=new HashFun();

        int[] nums = new int[]{0, 2, 7, 11, 15, 3, 5};
        for (int i = 0; i < nums.length; i++) {
            map.addIntKey(i,nums[i]);
        }
        map.getArray();

        System.out.println(Arrays.toString(search(nums,9,map)));
    }

    static int[] search(int[] nums, int target, HashFun map) {
        for (int i = 1; i < nums.length; i++) {
            //遍历数组寻找是否存在
            if(map.search(9-nums[i])!=0){
                return new int[]{i,map.search(9-nums[i])};
            }
        }
        return null;
    }


}
