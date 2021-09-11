package test_Dome;

import java.util.Arrays;

public class StringMatch {
    //KMP字符匹配算法
    //对于暴力破解避免了多余的匹配
    public  int Index_Kmp(String string,String pos){
        int[][] dp=match(pos);
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 90; j < 180; j++) {
//
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        Vertical_line nnnn=new Vertical_line(dp);
nnnn.wap();

        int len = string.length();

        int k=0;//k为状态
        for (int i = 0; i < len; i++) {
            //判断是推进还是倒退
            //切换状态
                k=dp[k][string.charAt(i)];

            //当状态到最后就退出
            if(k==pos.length()){
                return i - pos.length() + 1;
            }
        }
        //匹配失败
        return -1;
    }
    public int[][] match(String pos){
        //我该怎么才能找到返回位置
        int[][] nums = new int[pos.length()][256];
        int x = 0;
        nums[0][pos.charAt(0)] = 1;
        for (int i = 1; i < pos.length(); i++) {
            for (int j = 0; j < 256; j++) {
                if(j==(int)pos.charAt(i)){
                    nums[i][j] = i + 1;

                } else nums[i][j] = nums[x][j];
            }
            x = nums[x][pos.charAt(i)];

        }
        return nums;
    }

    //BF匹配 应该是暴力破解法
    public  int Index_BF(String string, String pos) {
        //转换为字符数组
        char[] s1 = string.toCharArray();
        char[] s2 = pos.toCharArray();
        int len = s1.length;
        //string.charAt(0);
        int ss = 0;
        //开始匹配
        while (ss <= (len - s2.length)) {
            for (int i = 0; i < s2.length; ) {
                if (s1[ss]==s2[i]){
                    ss++;
                }
                else {
                    ss = ss - i + 1;
                    break;
                }
                i++;
                if (i == s2.length) {
                    return ss - i ;
                }
            }
        }



        //匹配失败
        return -1;
    }

}
class test{
    public static void main(String[] args) {
        String s1 = "aaaaaaaab";
        String s2 = "abcabb";
        StringMatch ss = new StringMatch();

//        int sss = ss.Index_BF(s1, s2);
//        System.out.println(sss);
//        System.out.println(s1.indexOf(s2));
        long aaa;
        int sd;
        //时间
        aaa = System.currentTimeMillis();
        System.out.println(aaa);
        sd = ss.Index_Kmp(s1, s2);
        System.out.println(sd);
        aaa = System.currentTimeMillis();
        System.out.println(aaa);
    }

}
