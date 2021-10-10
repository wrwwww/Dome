package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 竖式除法 {
    public static void main(String[] args) {
//        System.out.println(4%3);
//        System.out.println(4/333);
//        List<Long> jj = fractionToDecimal(1,
//                2);
//        for (Long i:jj
//             ) {
//            System.out.println(i);
//        }
        System.out.println(fractionToDecimal(Integer.MIN_VALUE,1));
        System.out.println(fractionToDecimal(-100,10));
    }

//    /分子numerator 分母 denominator
    public static String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        //存放余数
        long rand = 0;
        long temp = 0;
        //先处理整数
        //什么情况会有小数
        //a/b有余数

        StringBuilder sb=new StringBuilder();
if (den<0&&num<0){
//    sb.append('-');
    num=-num;
    den=-den;
}
else if (den<0&&num>0){
    sb.append('-');
    den=-den;
}
else if (num<0&&den>0){
    sb.append('-');
    num=-num;
}

        if (num % den == 0) {
            //没有余数
              sb.append(Long.toString((num/den)));
              return sb.toString();



        } else {//有余数的情况
//整数部分
            long gg = num / den;
            sb.append(Long.toString(gg));



            sb.append('.');

            Map<Long, Integer> mp = new HashMap<Long,Integer>();
            int i=sb.length();
//            if (num<0)num=-num;
            temp = num % den;
            do {
                //添加余数到hash表,遇到相同的余数就可以加括号返回了
                //添加时查看是否有元素,否则添加



                if (mp.get(temp)==null){
//                    有的话说明有循环,直接跳出,并且加括号在指定范围内
                    mp.put(temp, i);
                    i++;
                }else{
//插入括号

                    sb.insert(mp.get(temp).intValue(), '(');
                    sb.insert(i+1, ')');
                    break;
                }
                num = temp * 10;
                rand = num / den;
                //收集RAND构成小数部分
               // if (num<0)
                 //   sb.append('-');
                sb.append(Long.toString( rand));
                temp = num % den;
            }//当余数为0时退出,或者相同的元素
            while(temp!=0);

            return sb.toString();

        }





    }

}
