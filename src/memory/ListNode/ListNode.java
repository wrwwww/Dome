package memory.ListNode;

public class ListNode {
    int val;
    public ListNode next;

        //方法重载
    public ListNode() {}

    public ListNode(int val) {
            this.val = val;
        }

        //set方法
    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

//    get方法
    public int getVal() {
            return val;
        }

    public ListNode getNext() {
        return next;
    }

    public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }



//    private void addEnd(ListNode next,ListNode root) {
//            while (root.next!=null){
//                root = root.next;
//            }
//        root.next = next;
//    }

    //链表遍历
    public void printf() {
            ListNode l2=this;
            while(l2!=null){
                System.out.println(l2.val);
                l2 = l2.next;
            }
    }



    //自动往链表结尾添加节点
    public void addNode(ListNode node){
        addNodes(node,this);
    }

    public void addNodes(ListNode node,ListNode root){
        while(root.next!=null){
            root = root.next;
        }
        root.next = node;
    }
}
