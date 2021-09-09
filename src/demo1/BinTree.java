package demo1;

public class BinTree {
    treeNode root;

    BinTree(treeNode rootNode){
        root = rootNode;
    }

    public void out() {
        root.outValue(root);
    }
}
