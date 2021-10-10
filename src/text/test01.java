package text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test01 {
    public static void main(String[] args) {


        List<String> temp=new ArrayList<String>();
        StringBuffer sb=new StringBuffer();
//        for (int i = 0; i < num.length(); i++) {
//            sb.append(num.charAt(i));
//            if(i!=(num.length()-1))
//            sb.append('+');
//        }

        int len=(int)'0';
        sb.replace(3, 4, "*");

            int sum = sb.charAt(0)-len;
        for (int i = 2; i < sb.length(); i += 2) {

            char it = sb.charAt(i - 1);
            int nums = (int) sb.charAt(i) - len;
            if (it == '+') {
                sum = sum + nums;
            } else if (it == '-')
                sum = sum - nums;
            else
                sum = sum * nums;

        }

        System.out.println(sb.toString());
        System.out.println(sum);

    }
}
