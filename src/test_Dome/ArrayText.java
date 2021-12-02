package test_Dome;

public class ArrayText {
    public static void main(String[] args) {
//        int[] arr1 = new int[10];
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i] = i + 1;
//            System.out.println(arr1[i]);
//        }
//        int[] arr2 = {2, 5, 8};
//        int[] arr3 = new int[]{2, 5, 8};
//
//        int[] ff = new int[]{100, 200, 300};
////        ff[3]=400;
//        System.out.println(ff[ff.length-1]);

//        int[] arr = new int[100];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 10000 % 100);
//        }
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        int max = arr[0];
//        for (int i: arr) {
//            if(i>max){
//                max=i;
//            }
//        }
//        System.out.println(max);

//        Stack<Integer> abc=new Stack<Integer>();
//        for (int i = 0; i < 10; i++) {
//            abc.add(i + 1);
//        }
//        List<List<String>> ttt = new ArrayList<List<String>>();
//        List<String> cd = new ArrayList<>();
//        cd.add("dfaf");
//        cd.add("sfsf");
//        HashMap<String, Integer> abd = new HashMap<String,Integer>();
//        abd.put("hgjh",0);
//        for (String atr:
//             cd) {
//            System.out.println(atr);
//        }
       // System.out.println((int)'1');
//
//        System.out.println(abc.pop());
//        System.out.println(abc.pop());
//        System.out.println(cd.get(0));
        StringBuffer temp=new StringBuffer();
//        temp.append('');
        // 48
        int num=Integer.MAX_VALUE;
        while(num!=0){
            int a=num%16;
            num=num/16;
            if(a<10)
            temp.append((char)(48+a));
            else temp.append((char)(a+87));
        }
        temp.reverse();
        System.out.println(temp);


//        System.out.println(toHex(-1));
//        System.out.println(toHex(-2));
        System.out.println(toHex(Integer.MAX_VALUE-7));
        System.out.println(0x80000000);

        System.out.println(0xfffffff0);
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
    }

        public static String toHex(int _num) {
            if (_num == 0) return "0";
            long num = _num;
            StringBuilder sb = new StringBuilder();
            if (num < 0) num = (long) (Math.pow(2, 32) + num);
            while (num != 0) {
                long u = num % 16;
                char c = (char) (u + '0');
                if (u >= 10) c = (char) (u - 10 + 'a');
                sb.append(c);
                num /= 16;
            }
            return sb.reverse().toString();
        }
}
