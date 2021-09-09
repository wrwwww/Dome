package Dome4;

public class copy {
    public static void main(String[] args) {
//        CopyFile haha=new CopyFile("F://329814.txt","F://成功了.txt");
        //bin("wrwww");

        System.out.println(bin("Z"));//a*26+a*1


    }
    static int bin(String nums){
        int sum = 0;

        for (int i=0;i<nums.length();i++) {
            //System.out.println(nums.charAt(i));
//          AA=27 a*26+a=27
            int temp=nums.charAt(i)-'A'+1;

//            sum=sum+temp*key(26,lens);
            sum=sum*26+temp;

        }
        return sum;
    }
    static int key(int nums,int len){
        if (len == 0) {
            return 1;
        }
        for (int i = 0; i < len-1; i++) {
            nums=nums*26;
        }
        return nums;
    }
}
