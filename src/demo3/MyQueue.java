package demo3;



public class MyQueue {

    private MyStack stIn;
    private MyStack stOut;

    /** Initialize your data structure here. */
    public MyQueue() {
        //输入栈
        stIn = new MyStack();
        //输出栈
        stOut = new MyStack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        stIn.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stIn.stackLength()!=0) {
            while(stIn.stackLength()>0)
                stOut.push(stIn.pop());
        }
       return stOut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stIn.stackLength()!=0){
            while(stIn.stackLength()>0)
                stOut.push(stIn.pop());
        }

        return 0;
    }


    public void check() {
        if (stIn.stackLength()!=0) {
            while(stIn.stackLength()>0)
                stOut.push(stIn.pop());
        }
        while (stOut.stackLength() != 0) {
            System.out.println(stOut.pop());
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stIn.stackLength()!=0) {
            while(stIn.stackLength()>0)
                stOut.push(stIn.pop());
        }
        if (stOut.stackLength() == 0) {
            return true;
        }
        return false;
    }
}
