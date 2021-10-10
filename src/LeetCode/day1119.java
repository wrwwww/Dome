package LeetCode;


import java.util.HashMap;
import java.util.Map;

class text{
    public static void main(String[] args) {
        System.out.println(2147483647 + "需要:" + day1119.integerReplacement(1234));

    }
}

public class day1119 {
    /**
     *
     * @param n 输入一个数字偶数直接/2,奇数可以加一或者减一
     * @return 这个数字变成一的需要的步数
     */
    public static int integerReplacement(int n) {
        if (n==1) return 0;


            if (n%2==0){
                return integerReplacement(n >>>1)+1;
            }else {
                return Math.min(integerReplacement((n -1)>>>1),integerReplacement((n +1)>>>1))+2;
            }
    }

    public static int findLHS(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        Object[] len=map.keySet().toArray();
        int length=0;

        for (Object o : len) {
            int aa = (int) o;
            if (map.get(aa + 1) != null) {
                int temp = map.get(aa) + map.get(aa + 1);
                if (temp > length) {
                    length = temp;
                }
            } else if (map.get(aa - 1) != null) {
                int temp = map.get(aa) + map.get(aa - 1);
                if (temp > length) {
                    length = temp;
                }
            }
        }
        return length;
    }
}
