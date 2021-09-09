package math;

public class Prescribe {
    //牛顿迭代
    public static void main(String[] args) {
        Object answer=Prescribe01(18);
        System.out.println(answer);
        System.out.println(Math.sqrt(8));
        System.out.println(Double.MAX_VALUE);
    }

    public static Object Prescribe01(int val) {
        double mid = val >> 1;
        double e=mid;
        mid = 0.5*(mid+val/mid);
        while((mid-e)<(1e-15)) {
            e = mid;
            mid = 0.5*(mid+val/mid);

        }
        return mid;
    }
}
