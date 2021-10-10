package demo1;

public class TreeNode {
     public int val;
     public TreeNode left=null;
     public TreeNode right=null;

     public TreeNode(int value){
         this.val = value;
     }

     //左节点
    public void setleft(TreeNode left) {
         this.left = left;
    }

    //右节点
    public void setright(TreeNode right) {
        this.right = right;
    }

    public  void outValue(TreeNode rootNode) {
         //前序遍历
        System.out.println(rootNode.val);

        //递归调用遍历
        if (rootNode.left != null) {
            rootNode.outValue(rootNode.left);
        }
        if (rootNode.right != null) {
            rootNode.outValue(rootNode.right);
        }
    }


}
