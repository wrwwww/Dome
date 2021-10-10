package LeetCode;

import java.util.Iterator;

//顶端迭代器
public class 迭代器 implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer pointElement;

        public 迭代器(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            this.pointElement= iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return this.pointElement = iterator.next();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return this.iterator.next();
        }

        @Override
        public boolean hasNext() {

            return this.iterator.hasNext();
        }
    }
class fun{
    public static void main(String[] args) {
        int[] abc = new int[]{100, 200, 300};


        //迭代器 txt = new 迭代器();
    }
}


