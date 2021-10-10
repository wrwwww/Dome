package LeetCode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 第三大的数 {
    public static int thirdMax(int[] nums) {
        //用相同的数组判断结果是否正确
        int[] num = new int[nums.length];
        Map<Integer,Integer> map= new HashMap<>();
        int j=0;
        for (int k : nums) {
            if (map.get(k) == null) {
                map.put(k, 1);
                num[j] = k;
                j++;
            }
        }

        if(j<3){
            Arrays.sort(num);
            return num[num.length-1];
        }


        fun(num, 0, j-1 ,j-3);
        return num[j-3];
    }

    public static void fun(int[] nums,int top,int end,int san){
        //像二分法一样只选择一半, 时间复杂度O(log2n)
        //不过需要像快排一样划分大小
//        if(top==san||end==san)return;
        int pivotKey = nums[top];

        int low = top;
        int high = end;
        while(low<high){

            while (nums[high] >= pivotKey && high > low) {

                high--;
            }
            if(high==low)break;
            nums[low] = nums[high];
            low++;
            while (nums[low] < pivotKey && low < high) {

                low++;
            }
            if (high == low) {
                break;
            }

            nums[high]=nums[low];
            high--;



        }
        nums[low] = pivotKey;
        if(low==san){

        }else if(low>san){
            fun(nums,top,low-1,san);
        }else fun(nums,low+1,end,san);
    }

    public static void main(String[] args) {
        //Arrays_Random aa=new Arrays_Random(new int[10]);
//        aa.toRandom(100);
//        int[] abc=aa.getArray();
        int[] abc = new int[]{8, 8};
        System.out.println(thirdMax(abc));
//        Arrays.sort(abc);
//        System.out.println(Arrays.toString(abc));
//        System.out.println(abc[abc.length-3]);
    }
}
