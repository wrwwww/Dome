package test_Dome;

import memory.ListNode.ListNode;

public class 链表求和 {
    public static void main(String[] args) {
        int[] nums=new int[]{9,9,9,9};
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.addNode(l2);
        l2.addNode(l3);
        l1.printf();

    }
}
