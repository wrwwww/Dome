package LeetCode;

public class 回文数 {
//    执行用时：
//            51 ms
//, 在所有 Java 提交中击败了
//5.44%
//    的用户
//    内存消耗：
//            38.1 MB
//, 在所有 Java 提交中击败了
//15.75%
//    的用户
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int temp=0;
        int i = 0;
        int y = x;
        while(y>9){
            temp = y % 10 + temp * 10;
            i++;
            y = y/10;
        }
        temp=temp*10+y;
        System.out.println(x);
        System.out.println(temp);
        return 0 == temp - x;

    }
}

