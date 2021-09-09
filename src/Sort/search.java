package Sort;

public class search {




    static int fun(int start, int end, int n, int[] arr) {
        int mid = end - start;
        if (arr[mid]==n){
            return mid;
        }
        if (arr[mid] > n) {
            return fun(start, mid, n, arr);
        }
        if (arr[mid] < n) {
            return fun(mid, end, n, arr);
        }

        return -1;

    }

    static int bin(int[] arr, int n) {

        return fun(0, arr.length - 1, n, arr);
    }

    public static void main(String[] args) {

        System.out.println(bin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3));
    }
}
