package demo2;

public class Hanoi {
    public static void main(String[] args) {
        //n个塔
        answer(4, 'a', 'b', 'c');
    }
    static void answer(int n,char from,char temp,char to){
        if (n == 1) {
            System.out.println(from + ">>" + to);
            return;
        }
        answer(n - 1, from, to, temp);
        //前面将n-1个数移动到了temp的位置
        //接下来将from移动到to
        System.out.println(from + ">>" + to);
        //接下来将temp上的n-1个弄到to上
        answer(n - 1, temp, from, to);

    }
}
