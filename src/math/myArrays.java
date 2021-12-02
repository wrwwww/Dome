package math;

public class myArrays {

/**
*生成随机数组
* @param arr a array;
*
 */
    public static void random(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000) % 100;
        }


    }

    public static void random(int[] arr, int limit) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000) % limit;
        }

    }

    /**
     * 删除有序数组中的重复元素
     * @param arr 目标数组
     * @return new arr 没有重复元素的数组
     */
    public static int[] removeDuplicates(int[] arr){
        int j=1;
        for (int i = 0; j < arr.length; ) {
            if(arr[j]==arr[i]){
                j++;
            }else {
                arr[++i]=arr[j];
                j++;
            }
            if ((j == arr.length - 1)) {
                j = i + 1;
            }
        }
        int[] temp=new int[j];
        System.arraycopy(arr,0,temp,0,temp.length);
        arr=temp;
        return arr;

    }

}
