package demo3;

import java.util.Arrays;



public class MyStack {
    private int[] a;

    public MyStack(){
        a=new int[0];
    }
    //入栈
    public void push(int element){
        if (a == null) {
            int[] temp = new int[1];
            temp[0] = element;
            a = temp;
        }
        int[] temp = new int[this.a.length + 1];
        //复制数组
        System.arraycopy(a, 0, temp, 0, a.length);
        temp[a.length] = element;
        a = temp;
    }

    //出栈
    public int pop(){
        if (a.length == 0) {
            System.out.println("栈溢出");
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] temp = new int[a.length-1];
        int element = a[a.length - 1];
        System.arraycopy(a, 0, temp, 0, temp.length);
        a = temp;
        return element;
    }

    //查看栈内元素
    public void allElement(){
        System.out.println(Arrays.toString(a));

    }

    //查看栈顶元素
    public int stackTop(){
        if (a.length == 0) {
            throw new ArrayIndexOutOfBoundsException();

        }
        return a[a.length-1];
    }


    public int stackLength(){
        return a.length;
    }

}
