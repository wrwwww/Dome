package memory.hash;

import demo1.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class day0917 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(permute(test).toArray()));
//        buildTree(test, test);
        System.out.println(Arrays.toString(findAnagrams("abab","ab").toArray()));
        System.out.println("[bab".indexOf("ab"));
    }

    /**
     * 全排列
     * @param nums 等待排列数组
     * @return 全排列的集合
     */
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ls = new LinkedList<>();
        Boolean[] bool = new Boolean[len];
        Arrays.fill(bool, false);
        for (int i = 0; i < len; i++) {
            bool[i] = true;
            List<Integer> set = new LinkedList<>();
            set.add(nums[i]);
            dfs(nums, bool, ls, set, len);
            bool[i] = false;
        }
        return ls;
    }

    public static void dfs(int[] nums, Boolean[] bool, List<List<Integer>> ls, List<Integer> set, int len) {
        for (int i = 0; i < len; i++) {
            if (!bool[i]) {
                bool[i]=true;
                set.add(nums[i] );
                dfs(nums, bool, ls, set, len);
                set.remove(set.size() - 1);
                bool[i] = false;
            }
        }
        if(set.size()==len){
            List<Integer> temp = new LinkedList<>(set);
            ls.add(temp);
        }
    }

    /**
     *
     * @param a1 先序遍历
     * @param a2 中序遍历
     * @return root 构建的树的根节点
     */
    public static TreeNode buildTree(int[] a1,int[] a2){
        TreeNode root = new TreeNode(1);
        int len = a2.length;
        Map<Integer, Integer> map = IntStream.range(0, len).
                boxed().
                    collect(
                        Collectors.
                                toMap(i -> a2[i], i -> i, (a, b) -> b, Hashtable::new));
        boolean[] bool = new boolean[len];
        IntStream.range(0, len).forEachOrdered(i -> bool[i] = false);
        root.val = a1[0];
        root.left = left(a1, a2, bool, map);
        root.right = right(a1, a2, bool, map);
        return root;
    }

    public static TreeNode left(int[] a1, int[] a2, boolean[] bool, Map<Integer, Integer> map) {
        TreeNode root = new TreeNode(1);
        return root;

    }
    public static TreeNode right (int[] a1, int[] a2, boolean[] bool, Map<Integer, Integer> map) {
        TreeNode root=new TreeNode(1);
        return root;

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<>();
        List<String> str = permute2(p);
        for (String str1 : str) {
            String sss = s.toString();
            int index = 0;
            index = sss.indexOf(str1);
            while (index!=-1){
                list.add(index);
                char[] temp = sss.toCharArray();
                temp[index] = '0';
                sss = Arrays.toString(temp);
                String ss = new String(sss);
                index = ss.indexOf(str1);
            }
        }

        return list;
    }
    public static List<String> permute2(String str) {
        char[] string = str.toCharArray();
        int len = string.length;
        List<String> ls = new LinkedList<>();
        Boolean[] bool = new Boolean[len];
        Arrays.fill(bool, false);
        for (int i = 0; i < len; i++) {
            bool[i] = true;
            StringBuilder set = new StringBuilder();
            set.append(string[i]);
            dfs2(string, bool, ls, set, len);
            bool[i] = false;
        }
        return ls;
    }

    public static void dfs2(char[] string, Boolean[] bool, List<String> ls, StringBuilder set, int len) {

        for (int i = 0; i < len; i++) {
            if (!bool[i]) {
                bool[i] = true;
                StringBuilder sb = new StringBuilder(set.toString());
                sb.append(string[i]);
                dfs2(string, bool, ls, sb, len);
                bool[i] = false;
            }
        }
        if (set.length() == len) {
            String str = set.toString();
            ls.add(str);
        }
    }
}
