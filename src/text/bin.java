package text;
//域名反写,项目,模块,类
import demo1.TreeNode;
import memory.ListNode.ListNode;

import java.util.*;

public class bin {

//链表的逆置
    private static ListNode re_sort(ListNode root) {
        if (root==null) return null;
        ListNode head;
        ListNode temp = null;

        while(root!=null){
            head=root;
            root=root.next;
            head.next=temp;
            temp=head;
        }
        return temp;
    }
    //树的最小深度
    public int minDepth(TreeNode root){
        if(root.left==null&&root.right!=null)return minDepthh(root.right)+1;
        else if(root.right==null&&root.left!=null)return minDepthh(root.left)+1;
        else return 0;
    }
    public int minDepthh(TreeNode root) {
        int a;
        int b;
        if (root.left==null&&root.right!=null)return 1;
        else if (root.right==null&&root.left!=null)return 1;
        else if (root.left==null)return 1;
        else{
        a=minDepthh(root.left);
        b=minDepthh(root.right);
        return (Math.min(a, b))+1;
        }
    }
    ListNode delNode(ListNode head,int k){
        ListNode pre= head;
        ListNode end= head;
        int a=0;
        while(pre!=null){
            if (a >= k) {
                end=end.next;
            }
            pre=pre.next;
            a++;

        }
        end.next=end.next.next;
        return head;
    }

    //二叉树的层序遍历
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<TreeNode,Integer> map=new HashMap<>();
        Queue<TreeNode> queque=new LinkedList<>();
        queque.add(root);
        List<List<Integer>> list1=new ArrayList<>();
        List<Integer> list2=new LinkedList<>();
        TreeNode temp;
        map.put(root, 0);
        while(!queque.isEmpty()){
            temp=queque.poll();

            if (list1.size()<=map.get(temp)){
                list1.add(0,new LinkedList<Integer>());
                list1.get(0).add(temp.val);
            }else {
                list1.get(0).add(temp.val);
            }
            if (temp.left!=null){
                queque.add(temp.left);
                map.put(temp.left, map.get(temp) + 1);
            }
            if (temp.right!=null){
                queque.add(temp.right);
                map.put(temp.right, map.get(temp) + 1);
            }
        }
        //全部进出栈了
        //全部都编号了

        return list1;
    }
//整数的英语表示
    public static String numberToWords(int num) {
        //1-19
        if (num==0)return "Zero";
        List<String>  ls = Arrays.asList("", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen");
        //20-90的10的倍数
        List<String> ty = Arrays.asList("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                "Eighty", "Ninety");
        StringBuffer sb = new StringBuffer();

        List<String> cap = Arrays.asList("","Hundred", "Thousand", "Million", "Billion");
        Deque<Integer> queue = new LinkedList<>();

        while(num!=0){
            queue.add(num % 10);
            num = num / 10;
        }
        int len = queue.size();//数字的长度
        int len2=0;
if (len>=1&&len<=3)len2=1;
else if (len<=6)len2=2;
else if (len<=9)len2=3;
else len2=4;


        if (len % 3 != 0&&len>3) {
            //  两位数的时候
            if (len % 3 == 2) {
                if (queue.peekLast() > 1) {
                    sb.append(ty.get(queue.pollLast()));
                    sb.append(" ");
                    if (queue.peekLast()!=0){
                        sb.append(ls.get(queue.pollLast())).append(" ");
                        sb.append(cap.get(len2--)).append(" ");
                    }
                    else {queue.pollLast();
                        sb.append(cap.get(len2--)).append(" ");
//                        len2--;
                    }




                }else {
                    int nums=queue.pollLast()*10+ queue.pollLast();
                   if (nums!=0){
                    sb.append(ls.get(nums));

                    sb.append(" ");
                    sb.append(cap.get(len2--)+" ");
                   }

                }
            }

            else {

                sb.append(ls.get(queue.pollLast()));
                sb.append(" ");
                sb.append(cap.get(len2--) + " ");

                }

            //为一位

        }
        //剩下的就是三的倍数
        while(queue.size()%3!=0){
            queue.add(0);
        }
        while(len2!=0){
            int[]  c=new int[3];
            int cdd=0;
            for (int i = 0; i < 3; i++) {
                c[i]= queue.pollLast();
                cdd=cdd*10+c[i];
            }
            for (int i = 2; i >=0; i--) {
                queue.add(c[i]);
            }



            for (int i = 0; i < 3; i++) {
                if (queue.peekLast()!=0) {
                    if (i==0)
                    sb.append(ls.get(queue.pollLast())).append(" ").append(cap.get(1)).append(" ");
                    else if (i==1){
                        int nums=queue.pollLast()*10+ queue.pollLast();
                        if (nums > 19) {

                                sb.append(ty.get(nums/10)).append(" ");
                                if (nums%10!=0)
                                sb.append(ls.get(nums%10)).append(" ");
                            break;
                        }
                        else {sb.append(ls.get(nums)+" ");break;}
                    }else {sb.append(ls.get(queue.pollLast())+" ");break;}

                }
                else queue.pollLast();
            }
            if (len2 != 1&&cdd!=0) {
                sb.append(cap.get(len2)).append(" ");
            }
            len2--;
        }

        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    public static void main(String[] args) {

//        String st=numberToWords(30205068);
////        String st4=numberToWords(1000000);
//        System.out.println(st);
////        System.out.println(st4);
//        System.out.println(3%3);
//        System.out.println(longestSubsequence(new int[]{1,2,3,3,4}, 1));
        System.out.println(missingNumber(new int[]{0,4,3,1}));
        System.out.println(toBin(10));
        System.out.println(toBin(9));
        System.out.println(toBin(8));
        System.out.println(toBin(1));
        System.out.println(toBin(-10));
        long a= 0b1000_0000_0000_0000_0000_0000_0000_0000;
long aa= 2147483649l;
        System.out.println(toBin02(-1));
//        System.out.println((long)Math.pow(2,32));
//        System.out.println(toBin02(aa));
        System.out.println(toBin02(4294967296l-1));
        Deque<Integer> st=new LinkedList<>();
    }
    public static int maxCount(int m, int n, int[][] ops) {
        int[] hhh=new int[2];
        hhh[0] = ops[0][0];
        hhh[1] = ops[0][1];
//        for (int i = 1; i < ops.length; i++) {
//            int[] a=ops[i];
//            hhh[0]=hhh[0]+(hhh[0]-a[0]);
//            hhh[1]=hhh[1]+(hhh[1]-a[1]);
//        }
        for (int i = 1; i < ops.length; i++) {
            for (int j = 0; j < ops[0].length; j++) {
                if (ops[i][0]<hhh[0]){
                    hhh[0] = ops[i][0];
                }
                if (ops[i][1]<hhh[1]){
                    hhh[1] = ops[i][1];
                }
            }
        }
        return (hhh[0]+1)*(hhh[1]+1);
    }
//落单的数
    public static int missingNumber(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum=sum^nums[i]^(i+1);
        }
        return sum;
    }
    //进制转换
    public static String toBin02(long num){
        long a=0;
        long b=1;
        StringBuffer sb=new StringBuffer();
if (num<0){
    num=(long)(Math.pow(2,32)+num);
}
        while (num != 0) {
            a = num % 2;
            sb.append((char)('0' + a));
            num = num / 2;
        }
        return sb.reverse().toString();
    }
    public static int toBin(int num){
        int a=0;
        int b=1;
        while (num != 0) {
            a = a + num % 2 * b;
            b *= 10;
            num = num / 2;
        }
        return a;
    }
    

    public static String getHint(String secret, String guess) {
        StringBuffer sb=new StringBuffer();

        char[] sc=secret.toCharArray();
        char[] gu=guess.toCharArray();
        int len=sc.length;
        int a=0;
        int b=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (sc[i] == gu[i]) {
                sc[i] = '*';
                a++;
            }else{
            if (map.get(gu[i]) == null)
                map.put(gu[i], 1);
            else {
                //计数
                map.put(gu[i],map.get(gu[i])+1);
            }
            }
        }
        for (int i = 0; i < len; i++) {
            char temp=sc[i];
            if(temp=='*')continue;
            if (map.get(temp)!=null&&map.get(temp)!=0){
                map.put(temp,map.get(temp)-1);
                b++;
            }
        }
        String ls = Integer.toString(a);
        sb.append(ls);
        sb.append("A");
        ls = Integer.toString(b);
        sb.append(ls);
        sb.append("B");
        return sb.toString();
    }
}
