package demo3;

import java.util.Arrays;

public class HuffmanTree {
    Node root;

    public HuffmanTree(int[] nums) {
//        传入数组调用方法
//        生成树并返回根节点
        root = setRoot(nums);
    }

    public void peek() {
//      调用根节点的遍历
        root.peekNode(root);
    }

    //郝夫曼树的创建
    public Node setRoot(int[] nums){
//      创建了Node数组并赋值节点
        Node[] root1;
        root1= new Node[nums.length];
        for (int i = 0; i < root1.length; i++) {
            root1[i]=new Node(nums[i]);
        }

//      重复排序选择创建节点部分
        while(root1.length>2) {
//          选择最小的两个节点创建一个新节点
//          对节点通过value的值的大小排序
            sort(root1);
//          创建新节点
//          新节点替换旧节点
//          删除旧节点，添加新节点
            root1=addElement(root1, setNode(root1[0], root1[1]));

            //循环
        }
        root1=addElement(root1, setNode(root1[0], root1[1]));
        //直到最后一个节点跳出循环return最后一个节点
        return root1[0];
    }

    public Node setNode(Node value,Node value2){
//        传入最最小的两个节点
//        创建新节点
        Node temp;
//        赋值
        temp = new Node(value.val + value2.val);
//        将传入的节点赋值给新节点的左右节点
        temp.setLeftNode(value);
        temp.setRightNode(value2);
//        返回新节点
        return temp;
    }

    public void sort(Node[] nums){
        //插入排序
        for (int i = 1; i < nums.length ; i++) {

            //当当前指针的值小于前一个的值时这个值往前插直到前一个数比他大

            if (nums[i].val < nums[i - 1].val) {
                //创建临时变量存这个值
//                Node temp=new Node(nums[i].val);

                int temp = nums[i].val;
                int j = i - 1;
                while (j > -1 && temp < nums[j].val) {

//                    前一个数后移
                    nums[j + 1].val = nums[j].val;

                    //接着往前遍历
                    j--;

                    nums[j + 1].val = temp;
                }
            }
        }

    }

    /**
     * 将新元素后将新元素节点添加到旧的节点
     * 并删除旧的节点
     *
     */
    public Node[] addElement(Node[] nums,Node addNode) {

//        最后这两个节点应该被一个新节点替换
        if (nums.length == 2) {
            Node[] temp0;
            temp0=new Node[nums.length-1];
            Node temp3=new Node();
            temp3.val = addNode.val;
            temp3.leftNode = addNode.leftNode;
            temp3.rightNode = addNode.rightNode;
            temp0[0] = temp3;
            return temp0;
        }
        Node[] temp;
        temp=new Node[nums.length-1];

        for (int i = 1; i < temp.length; i++) {
            int j=i+1;
            Node temp2=new Node(nums[j].val);
            temp[i] = temp2;

            if (i == temp.length-1) {
                Node temp3=new Node();
                temp3.val = addNode.val;
                temp3.leftNode = addNode.leftNode;
                temp3.rightNode = addNode.rightNode;
                temp[0] = temp3;
            }
        }
        //把新的空间代替就的空间，会让旧的空间里的节点丢失
        //怎么做才能不代替空间的过程
        return temp;

    }
}
