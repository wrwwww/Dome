package memory.ListNode;

public class ArrayToList {
    private int[] nums;
    private ListNode head;

    public ArrayToList(int[] nums){
        this.nums = nums;
        head=new ListNode(nums[0]);
        this.toList();
    }



    private void toList() {

        for (int num = 1; num<nums.length; num++) {
            this.head.addNode(new ListNode(nums[num]));
        }
    }

    public ListNode getHead() {
        return head;
    }

}
