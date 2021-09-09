package demo3;

public class text {


    public static void main(String[] args) {

        /*
          栈测试
         */
        MyStack text = new MyStack();
        text.push(3);
        text.push(2);
        text.push(6);
        text.push(4);
        text.allElement();

        /*
        队列 栈实现的队列
         */
        MyQueue coded = new MyQueue();
        coded.push(3);
        coded.push(2);
        coded.push(6);
        coded.push(4);
        coded.check();
        coded.push(8);
        coded.check();
        System.out.println(coded.empty());

        /*
        郝夫曼编码
        */
//        Node man0 = new Node(45);
//        Node man1 = new Node(43);
//        Node man2 = new Node(5);
//        Node man3 = new Node(76);
//        Node man4 = new Node(4);
//        Node man5 = new Node(6);
//        Node man6 = new Node(8);
//        Node man7 = new Node(90);
//        Node man8 = new Node(35);
//        Node man9 = new Node(68);
//        man0.setLeftNode(man1);
//        man12.setLeftNode(man32);
//        man12.setRightNode(man3);
        //遍历二叉树 5,43,46,45
        int[] nums = new int[]{2,123,23,43,5,55,71,65};
        HuffmanTree zip = new HuffmanTree(nums);
        zip.peek();



    }
}
