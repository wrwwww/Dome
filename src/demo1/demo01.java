package demo1;

public class demo01 {
    public static void main(String[] args) {

        //创建节点
        treeNode text1=new treeNode(5);
        treeNode text2=new treeNode(2);
        treeNode text3=new treeNode(80);
        treeNode text6=new treeNode(78);
        treeNode text8=new treeNode(56);
        treeNode text7=new treeNode(45);

        //创建二叉树
        BinTree green = new BinTree(text1);

        //设置左右节点
        text1.setLeftNode(text2);
        text1.setRightNode(text3);
        text2.setLeftNode(text6);
        text2.setRightNode(text7);
        text3.setRightNode(text8);

        //遍历节点
       green.out();
        //text1.outValue(text1);
    }
}
