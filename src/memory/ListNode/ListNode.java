package memory.ListNode;

public class ListNode {
        int val;
        ListNode next;
        ListNode temp;
        ListNode() {}

        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//        public ListNode(int[] nums) {
//            for (int num : nums) {
//                this.addElement(num);
//            }
//    }

    private void addElement(int val) {
            //创建一个链表自动往最后添加元素
        this.temp = new ListNode(val);
        addEnd(temp.next,this);
    }

    private void addEnd(ListNode next,ListNode root) {
            while (root.next!=null){
                root = root.next;
            }
        root.next = next;
    }


    public void printf() {
            ListNode l2=this;
            while(l2!=null){
                System.out.println(l2.val);
                l2 = l2.next;
            }
    }

    public void addNode(ListNode val){
            this.next=val;
    }
}
