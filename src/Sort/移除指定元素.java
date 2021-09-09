package Sort;

public class 移除指定元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,3,3};
//        int[] nums = new int[]{3,2,2,3};
        int len = fun(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    private static int fun(int[] nums,int val){
        int top = 0;
        int end = nums.length ;
        while (top<end){
            if (nums[top]==val){
                while (end >top) {
                    if (nums[--end]!=val){
                        wap(nums,top,end);

                        top++;
                        break;
                    }
                }

            }else{
                top++;
            }
        }
        return top;

    }

    //数组值的交换
    static void wap(int[] nums,int wap_1,int wap_2){
        int temp = nums[wap_2];
        nums[wap_2] = nums[wap_1];
        nums[wap_1] = temp;


    }
}
