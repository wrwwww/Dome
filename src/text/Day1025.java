package text;

import java.lang.reflect.Array;
import java.util.*;

class abc{
    int a;
    static int b;
}
public class Day1025 {
    public static void main(String[] args) {
//       abc c=new abc();
//        System.out.println(c.a);
//        int[] cc=Solution.nextGreaterElement(new int[]{3, 4, 5}, new int[]{1, 3, 4, 6, 5});
//        System.out.println(Arrays.toString(cc));
//        System.out.println(Solution.number());
//        Solution.add();
//        Solution.fen();
//        Solution.test();
        Scanner sc = new Scanner(System.in);
        double c=0.0;
        int b=0;
        try{
        while(true){
            c = sc.nextDouble();
            b = sc.nextInt();
            for (int i = 2; i <= b; i++) {
                c=c*c;
            }
            if(c==(int)c){
                System.out.println((int)c);
            }else System.out.println(c);
        }
        }catch (InputMismatchException e){

        }
    }
}
class Solution{
    public static boolean tarGet(int[][] nums,int target){

        for (int[] arr:nums) {
            for (int num : arr) {
                if (num==target)return true;
            }
        }
        return false;
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] a=new int[nums1.length];
        Map<Integer,Integer> map=new HashMap<>();
        //初始化返回的数组
        for (int i = 0; i < nums1.length; i++) {
            a[i]=-1;
        }
        //记录第一组元素在第二组的位置
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i+1);
        }
        for (int i = 0; i < nums1.length; i++) {
            int aaa;

            for (aaa=map.get(nums1[i]); aaa < nums2.length; aaa++) {

                if (nums2[aaa]>nums1[i]){
                    a[i]=nums2[aaa];
                    nums2[aaa]=0;
                    break;
//
                }

            }
        }
        return a;
    }
    public static boolean number(){
        StringBuffer s = new StringBuffer("0100110001010001");
//        StringBuffer s = new StringBuffer("aaab");
        Set<String> set=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i,j));
            }

        }
        System.out.println(set.size());
        return false;
    }
    public static void add(){
        final int A=20190324,B=10000;
        int one=1;
        int twe=1;
        int three=1;
        int four=0;
        for (int i = 4; i <= A; i++) {
            four = one + three + twe;
            four=four%B;
            one=twe;
            twe=three;
            three=four;
        }
        System.out.println(four);
    }
    public static void fen(){
        int nums=1000;//2,0,1,9
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, 0);
        }
        map.put(2, 1);
        map.put(0, 1);
        map.put(1, 1);
        map.put(9, 1);
        int sum=0;
        int ac=0;
        for (int i = 1; i <= nums; i++) {
            int test=i;
            while(test!=0){
                if(map.get(test%10)==1){
                    sum=sum+i;
                    ac++;
                    break;
                }
                test=test/10;
            }

        }
//        int zero=0;
//        for (int i = 1; i <= 5; i++) {
//            sum=sum+zero*4+12;
//            zero+=10;
//        }
//        12
//            10+12+11+19=4*10+12
        System.out.println(sum+"/"+ac);
    }
    public static void test(){
        int M=1;
        int N=1;
        int[] nums=new int[]{1,2,3};
        Arrays.sort(nums);
        int len=nums.length-1;
        int sum=0;
        while(M!=-1){
            sum=sum+nums[len];
            M--;
            len--;
        }
        while(len>=0){
            sum = sum - nums[len];
            len--;
        }
        System.out.println(sum);
    }
}