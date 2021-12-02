package LeetCode;

import memory.hash.Hash_String;


/*
求最长子字符串
滑动窗口
 */
public class StringSearch {
    public static void main(String[] args) {
        String string = "abcabcbb";

        Hash_String ccw = new Hash_String();

        for (int i = 0; i <= 10; ) {
            for (int j = i; j < string.length(); j++) {
                char temp = string.charAt(j);

                if (ccw.getElement(temp)!=0){
                    ccw.addElement(temp, j);
                }else {
                    //替换原来的重复元素
                    ccw.addElement(temp, j);

                }
            }
        }



        ccw.PrintfString();
    }
}
