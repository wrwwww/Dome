package test_Dome;

public class day0928 {
    public static void main(String[] args) {
      String a=fun(-1);

        System.out.println(a);
//        System.out.println(Integer.toBinaryString(-268435456));
//        System.out.println((0xf)<<28);
    }
    public static String fun(int num){
        if(num==0)return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int a=num&0xf;
            num=num>>4;
            if(a<10){
                sb.append((char) ('0' + a));
            }else{

                sb.append((char) ('a' + a - 10));
            }
        }


        while(sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);

        }
        return sb.reverse().toString();
    }
}
//        int a=0xf<<28;
//        int b=0;
//        for (int i = 0; i < 8; i++) {
//            if((num&a)==0&b==0){
//
//            }else{
//                b=1;
//
//            }
//            a >>= 4;
//        }
//        System.out.println(sb.toString());
//        System.out.println(sb.length());