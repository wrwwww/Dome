package Sort;

public class 不重复的数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 5, 4, 4, 6, 6};
        int temp = 0;
        for (int num : nums) {
            temp = temp ^ num;
        }
        int bin=0;
        for (int i = 0; i < 31; i++) {
            int a = (temp >> i)&1;
            if (a==1){
                bin=i+1;
                break;
            }
        }
        //分组
        int temp_2=0;
        for (int num:nums) {
            if((num>>bin)==1){
                temp_2=num^temp_2;
            }
        }
        int temp_3=temp_2^temp;
        System.out.println(temp_3+" "+temp_2);
    }

}
