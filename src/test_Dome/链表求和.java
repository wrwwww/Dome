package test_Dome;

import memory.ListNode.ArrayToList;
import memory.ListNode.ListNode;

public class 链表求和 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3};
        int[] nums2 = new int[]{5, 6, 4};
        ArrayToList ac=new ArrayToList(nums);
        ListNode l=ac.getHead();
        ArrayToList ac2=new ArrayToList(nums2);
        ListNode l2=ac2.getHead();
        l.printf();
        l2.printf();
        ListNode ll = addTwoNumbers(l, l2);
ll.printf();

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        int push = 0;
//        当两个链表只要有一个没有结束就继续循环
        while (l1 != null || l2 != null) {
            //考虑到可能一条链表会比较短所以短的直接按零处理
            int a = (l1 == null) ? 0 : l1.getVal();
            int b = (l2 == null) ? 0 : l2.getVal();

            //相加
            int sum = (a + b + push) % 10;
            l3.next = new ListNode(sum);
//            l4= l3;
            l3 = l3.next;
            //考虑进位
            push = ((a + b + push) > 9) ? 1 : 0;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if(push==1){
            l3.next= new ListNode(push);
        }
        return l4.next;
    }
}
