package LeetCode;

import memory.ListNode.ArrayToList;
import memory.ListNode.ListNode;

public class 链表递增 {
    public static void main(String[] args) {
        ArrayToList abc = new ArrayToList(new int[]{2});
        ArrayToList abc1 = new ArrayToList(new int[]{3});
        ListNode l1 = abc.getHead();
        ListNode l2 = abc1.getHead();
//        l1.printf();
//        l2.printf();
        ListNode ac=mergeTwoLists(l1,l2);
        ac.printf();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ^ l2 == null) {
            if (l1 == null)
                return l2;
            else
                return l1;
        } else if (l1 == null )
            return null;
        ListNode top = new ListNode();
        ListNode head = top;
        // 只要一个不为空就循环添加
        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                top.next = l2;
                l2 = l2.next;
                top = top.next;

            } else {
                top.next = l1;
                l1 = l1.next;
                top = top.next;

            }

        }

        //有一个是null

        top.next=(null==l1)? l2:l1;
//        if(top==l1){
//            top.next=l1;
//        }else if(top==l2) top.next=l2;



        return head.next;
    }
}
