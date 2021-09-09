package demo3;

public class Node {
    int val;
    Node leftNode;
    Node rightNode;

    Node() {
        this.val = 0;

    }

    Node(int val){
        this.val = val;
    }




    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    //遍历节点
    void peekNode(Node root) {

        if (root.leftNode != null) {
            peekNode(root.leftNode);
        }
        if (root.rightNode != null) {
            peekNode(root.rightNode);
        }
        System.out.println(root.val);
    }


}
