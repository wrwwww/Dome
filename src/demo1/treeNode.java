package demo1;

public class treeNode {
     int val;
     treeNode leftNode=null;
     treeNode rightNode=null;

     treeNode(int value){
         this.val = value;
     }

     //左节点
    public void setLeftNode(treeNode leftNode) {
         this.leftNode = leftNode;
    }

    //右节点
    public void setRightNode(treeNode rightNode) {
        this.rightNode = rightNode;
    }

    public void outValue(treeNode rootNode) {
         //前序遍历
        System.out.println(rootNode.val);

        //递归调用遍历
        if (rootNode.leftNode != null) {
            rootNode.outValue(rootNode.leftNode);
        }
        if (rootNode.rightNode != null) {
            rootNode.outValue(rootNode.rightNode);
        }
    }
}
