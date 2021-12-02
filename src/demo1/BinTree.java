package demo1;

import java.util.LinkedList;
import java.util.Queue;

public class BinTree {
    TreeNode root;

    public BinTree(TreeNode rootNode){
        root = rootNode;
    }

    public void out() {
        root.outValue(root);
    }

    /**
     *
     * @return root of the TreeNode read
     */
    @Override
    public String toString() {
        if(root==null) return "[]";
        StringBuilder b = new StringBuilder();
        Queue<TreeNode> tree=new LinkedList<>();
        TreeNode temp;
        b.append('[');
        tree.add(this.root);
        while(!tree.isEmpty()){
            temp=tree.poll();
            b.append(temp.val);
            b.append(',');
            if (temp.left != null) {
                tree.add(temp.left);
            }
            if (temp.right != null) {
                tree.add(temp.right);
            }
        }
        b.deleteCharAt(b.length() - 1);
        b.append(']');
        return b.toString();
    }


}
