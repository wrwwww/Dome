package Sort;

import java.util.Date;
import java.util.Scanner;

public class 斐波那契数列 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        System.out.println(fun(num));
        System.out.println(fun2(num));
        Date abc = new Date();
        in.close();
        System.out.println(abc.toString());
    }
    //递归
    static int fun(int num){

        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        return fun(num-1)+fun(num-2);
    }
    //尝试动态规划优化
    //0,1,1,2,3,5,8
    static int fun2(int num){
        int a = 0;
        int b = 1;
        int sum = 1;
        for (int i = 1; i < num; i++) {
            sum = a + b;//开始为1
            a = b;
            b=sum;

        }
        return sum;
    }

}
