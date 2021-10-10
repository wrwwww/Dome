package Window;

import demo1.TreeNode;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class testtt {
    public static void main(String[] args) {
//
//        Map<String ,Integer> map=new HashMap<>();
//        String str = new String("dfsd");
//        map.put(str, 34);
//        map.put(str+"fdsa", 3434);
//        for (String i: map.keySet()) {
//            System.out.println(i+" "+map.get(i));
//        }
//        System.out.println(map.get(str));
//        System.out.println(str.indexOf("sd"));
//        System.out.println(str.contains("sd"));
        MapSum a=new MapSum();
        a.insert("apple",3);
        System.out.println(a.sum("ap"));
    }
}
class MapSum {


    // private Map map;
    Map<String ,Integer> map;

    public MapSum() {
        map=new HashMap<String,Integer>();
    }

    public void insert(String key, int val) {

        map.put(key,val);
    }

    public int sum(String prefix) {
        int sum=0;

        for (String i: map.keySet()) {

                if (i.indexOf(prefix)==0){
                    sum=sum+map.get(i);
                }
        }
        return sum;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        else if (root.val==val){
            return root;
        }else if (root.val>val){
            return searchBST(root.left, val);
        }else{
            return searchBST(root.right, val);
        }

    }
}