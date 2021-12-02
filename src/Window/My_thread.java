package Window;

public class My_thread implements Runnable {
    static int nums=100;
    public static void main(String[] args) {
        My_thread by01=new My_thread();
        Thread by02=new Thread(by01,"01");
        Thread by03=new Thread(by01,"02");
        Thread by04=new Thread(by01,"3");

//        by02.setPriority(10);
//        by03.setPriority(1);
//        by04.setPriority(1);
        by04.start();
        by02.start();
        by03.start();
        System.out.println("剩余"+My_thread.nums);
    }


    @Override
    public void run() {
//        super.run();
        while(true){
            synchronized (this) {
                if(nums>0)
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + nums-- + "张票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
