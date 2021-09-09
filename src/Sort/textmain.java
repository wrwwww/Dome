package Sort;


import java.util.Arrays;

class textMain extends insertSort{
    public static void main(String[] args) {
        System.out.println(jump(new int[]{0, 9, 8, 7, 8}));
        int[] abc=new int[11];
        for (int i = 0; i < abc.length; i++) {
            abc[i] = (int) (Math.random() * 100);
        }
        int[] temp=new int[11];
        System.arraycopy(abc, 0, temp, 0, temp.length);
        System.out.println(Arrays.toString(abc));
        QuickSort(abc);
        System.out.println(Arrays.toString(abc));
        int b=0;
        for (int j : temp) {
            b = b ^ j;
        }
        for (int j : abc) {
            b = b ^ j;
        }
        System.out.println(b);
        Arrays.sort(abc);
        System.out.println(Arrays.toString(abc));
    }
    /**
     * 快速排序
     */
    public static void QuickSort(int[] nums){
        Sort(nums,0, nums.length-1);
    }

     static void Sort(int[] nums, int start, int end) {
        if(start==end+1){
            return;
        }
        int temp = nums[start];
        int Index = start;
        int Index2 = end;

         while (start < end) {

             //左指针不动右指针先动寻找一个比temp小的数替换
             //一个指针不动另一个指针才动
             while (end != start && nums[end] > temp) {
                 end -= 1;
             }
             //找到一个小于temp得数
             //将这个数替换到前面
             nums[start] = nums[end];
             //前指针后移
             start += 1;
             while (end != start && nums[start] <= temp) {
                 start += 1;
             }

             //找到一个大于的数
             nums[end] = nums[start];

         }
         nums[end] = temp;

         Sort(nums,Index,end-1);
         Sort(nums,end+1,Index2);
    }

}
