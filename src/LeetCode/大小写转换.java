package LeetCode;

public class 大小写转换 {
    public static void main(String[] args) {
        System.out.println(toLowerCase("WWWWGHJjdks"));
        System.out.println((int)'a'+" "+" "+(int)'A');
        System.out.println((char)65);
    }
        public static String toLowerCase(String s) {
            return cof(s,0,s.length()-1);
        }
        static String cof(String s,int start,int len){
            if (len == start) {

                if (s.charAt(start) <= 90) {
                    return "" + ((char) ((int)(s.charAt(start)) + 32));
                } else
                    return "" + s.charAt(start);
            }
            if(s.charAt(start)<=90){
                return ((char)((int)(s.charAt(start)) + 32))+cof(s, start+1,len);
            }
            else
                return s.charAt(start)+cof(s, start+1,len);


        }


}
