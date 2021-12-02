package LeetCode;

public class 牛顿迭代开二次根号 {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        long x= input.nextInt();
//        input.close();
        System.out.println(root(2147395599));


    }
    static int root(int x){
        double random;
//        double y0;
//        double k;
        random = (double) x / 2;

        for (int i = 0; i < 100; i++) {
//
//            y0 = random * random - (double) x;
//            k = 2 * random;
//            random = random-y0/
            random=(random+x/random)/2;
        }
        return (int) random;
    }
}
