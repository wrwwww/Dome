package text;


import demo1.TreeNode;

import java.util.*;

public class binSearTree {
    public static void main(String[] args) {
        //int[] a1=Kmp.constructRectangle(4);
        //System.out.println(Arrays.toString(a1));
//        int[] test1 = new int[]{1,2,3,4,5,6,7};
//        TreeNode test = Kmp.toTree(test1);
//        test.outValue(test);
        System.out.println(Arrays.toString(Kmp.singleNumber(new int[]{1,1,3,5,6,6})));
        System.out.println(3 ^ 5);
    }
}
class Kmp{
    /**
     * kmp算法
     * 求众数
     * 矩形面积
     * @param haystack 目标字符串
     * @param needle   匹配子串
     * @return 目标在src中的下标位置
     */
    public static int kmp(String haystack, String needle) {
        if(Objects.equals(needle, ""))return 0;
        String src1 = ' ' + haystack;
        String target1 = ' ' + needle;
        int[] next = new int[target1.length()];
        char[] src = src1.toCharArray();
        char[] target = target1.toCharArray();

        //为匹配串构建next状态数组
        for (int i = 2, j = 0; i < target.length; i++) {
            while (j != 0 && target[j + 1] != target[i]) {
                j = next[j];
            }
            if (target[i] == target[j + 1]) {
                next[i] = j+1;
                j++;
            }

        }

        //开始匹配
        //如果匹配失败返回到next[i]的状态
        for (int i = 1, j = 0; i < src.length; i++) {
            while (j!=0&&target[j+1]!=src[i]){
                j = next[j];
            }
            if (target[j+1]==src[i]){
                j++;
            }
            if (j==target.length-1)return i-j;
        }
        return -1;
    }

    public static List<Integer> majorityElement(int[] nums) {
        int len=nums.length/3;
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> ls=new ArrayList<>();
        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, 0);
            else map.put(num, map.get(num )+1);
        }

        Set<Integer> st=map.keySet();
        Iterator<Integer> it = st.iterator();
        int a;
        while(it.hasNext()) {


            a = it.next();
            if (map.get(a) >= len) {
                ls.add(a);
            }
        }
        return ls;
    }
    public static int[] constructRectangle(int area) {
        int[] test=new int[2];
        int mid=area;
        for (int i = 1; i <= (int)Math.sqrt(area); i++) {
            //可以除干净
            if (area % i == 0) {
                int high = area / i;
                if (mid > high - i) {
                    test[0] = high;
                    test[1] = i;
                }
            }
        }


        return test;
    }

    public static void numTrees(int num){
        //列出所有可能的二叉树
        //从头开始列出所有的情况
//    二叉搜索树
//    首先选择根节点开始建立
//   中序遍历是从小到大的排列
        for (int i = 1; i <= num; i++) {
            //让所有的节点都有机会做根节点
            //可以先用数组排号最后数组转换树
            //广度转换
        }
    }
    public static TreeNode toTree(int[] nums){
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i=0;
        while(2*i+2<=nums.length-1) {
            TreeNode temp=queue.poll();
           // if(nums.length%2==0)
            temp.left=new TreeNode(nums[2*i+1]);
            queue.add(temp.left);

            temp.right=new TreeNode(nums[2*i+2]);
            queue.add(temp.right);
            i++;
        }
        return root;
    }

public static int jiecheng(int n){
        if(n==1)return 1;
        return n*jiecheng(n-1);
    }

    public static int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }

        int a=1;
        while((sum&1)!=1){
            sum=sum>>a;
            a++;
        }
        int[] num=new int[2];
        a=1<<(a-1);
        for (int i = 0; i < nums.length; i++) {
            if ((1 & (nums[i] >> (a - 1))) == 1) {
                num[0] = num[0] ^ nums[i];
            } else {
                num[1] = num[1] ^ nums[i];

            }
        }
        return num;
    }
}