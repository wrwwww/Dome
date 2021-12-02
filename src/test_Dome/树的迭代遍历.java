package test_Dome;


import demo1.TreeNode;

import java.util.*;

public class 树的迭代遍历 {


    //用队列遍历二叉树
    //广度优先
    public static void jout(TreeNode root){
        TreeNode temp;

        Queue<TreeNode> queue=new LinkedList<>();

        List<List<Integer>> re=new LinkedList<>();
        Map<TreeNode, Integer> abc=new HashMap<>();

        //根节点进队出队的时候将左右子节点进队
        queue.add(root);
        //abc.put(root,0);

int num=0;
        while(!queue.isEmpty()){
            //左侧出队
            temp=queue.poll();
            //System.out.println(abc.get(temp));

//            int a=abc.get(temp);
            //如果空间存在
//        if(a<=re.size()-1){
//            re.get(a).add(temp.val);
//        }else{
//            re.add(a,new LinkedList<>());
//            re.get(a).add(temp.val);
//        }
            //左,右节点进队
            if (temp.left != null) {

                re.get(re.size()-1).add(temp.left.val);
                queue.add(temp.left);

            }
           if (temp.right != null) {
//               abc.put(temp.rightNode,abc.get(temp)+1);
               re.get(re.size()-1).add(temp.right.val);
               queue.add(temp.right);
            }

        }
        System.out.println(re.toString());


    }
}
