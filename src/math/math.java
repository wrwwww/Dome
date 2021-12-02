package math;

public class math {

    /**
     * 牛顿迭代求开二次方
     * @param val be prescribe
     * @return outcome
     */
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

    /**
     *
     * @param arr 被查找的单调递增数组
     * @param target 目标值
     * @return 目标值在数组中的下标
     */
    public static int tweSearch(int[] arr,int target){

        int start=0;
        int end= arr.length-1;
        while (start <= end) {
            int mid=(start+end)>>1;
            if (arr[mid] == target) {
                return mid;
            }else if (arr[mid]>target){
                end=mid-1;
            }else start=mid+1;
        }
        return -1;

    }

}
