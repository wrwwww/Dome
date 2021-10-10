package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import static game.MainActivity.*;
import static game.MyJPanel.board;


public class MainActivity {
    JFrame jf;//视图框架
    JPanel jp;//框架中的容器
    test txt;//鼠标监听器
    BufferedImage icon;//软件图标
    static final int WIGHT = 400;//游戏窗口的宽度
    static final int HIGH = 600;//游戏窗口的高度


    MainActivity() throws Exception {
        //初始化
        jf = new JFrame("弹弹弹");
        jp = new MyJPanel();
        txt = new test();
        icon = ImageIO.
                read(Objects.
                        requireNonNull(MainActivity.class.
                                getResource("bee.png")));

        //添加到框架中
        jf.add(jp);
        jf.addMouseMotionListener(txt);
        jf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);

                char op=e.getKeyChar();
                if (op=='a') {
                 board.setX(board.getX()-10);
                } else if (op=='d'){
                    board.setX(board.getX()+10);

                }
                e.consume();
            }
        });
        jp.setLayout(new FlowLayout());


        //设置基本参数
        jf.setSize(WIGHT, HIGH);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setAlwaysOnTop(true);
        jf.setIconImage(icon);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    //主函数
    public static void main(String[] args) throws Exception{

        //创建并初始化游戏
        //主活动
        MainActivity activity = new MainActivity();
        MyJPanel.myThead.join();
        JPanel jp = new JPanel();
        activity.jf.add(jp);


    }

}

//重写容器类以描绘游戏控件
class MyJPanel extends JPanel {
    static Ball ball;//小球
    static Board board;//弹板
    static MyThead myThead;//新的进程
Boolean bool;

    //构造方法
    MyJPanel() {
        //初始化
        ball = new Ball();
        board = new Board();
        myThead = new MyThead();
        myThead.setName("绘图");
        myThead.start();//开启新的进程用来刷新图形
bool=true;
        board.setColor(randomColor());//挡板的颜色
        board.setX(test.getX()-50);//设置挡板的位置为鼠标位置
        board.setY(HIGH-100);
        board.setLength(100);//挡板的长度
        board.setHigh(25);//挡板的高度

        ball.setLen(40);//小球的直径
        ball.setColor(randomColor());//小球的颜色
        ball.setX(randomNums(WIGHT));//小球开始的位置
        ball.setY(0);
        ball.setSpeed(5);//小球的速度

    }

    /**
     * @param num 随机数的范围
     * @return 0~num中的数字
     */
    public static int randomNums(int num) {
        return (int) (Math.random() * 10000) % num;
    }

    /**
     * @return 随机的颜色
     */
    Color randomColor() {
        return new Color(randomNums(255), randomNums(255), randomNums(255));
    }

    //重写画笔方法
    @Override
    public void paint(Graphics g) {
        //继承父类的方法
        super.paint(g);

        if (!bool) {
            g.setColor(Color.black);

            g.drawString("游戏结束", WIGHT/2, HIGH/2);

        }else {
            //设置小球的颜色
            g.setColor(ball.getColor());
            //画出小球
            g.fillOval(ball.getX(), ball.getY(), ball.getLen(), ball.getLen());
            //弹板的颜色
            g.setColor(board.getColor());
            //绘画弹板
            g.fillRect(board.getX(), board.getY(), board.getLength(), board.getHigh());
        }
    }

    class MyThead extends Thread {

        @Override
        public void run() {
            while (true) {

                //顶端
                if (ball.getY() <= 0) {

                    if (ball.getF() == 3)
                        ball.setF(0);
                    else ball.setF(1);

                }// 左端
                else if (ball.getX() <= 0) {

                    if (ball.getF() == 2)
                        ball.setF(3);
                    else ball.setF(0);
                }//右端
                else if (ball.getX() + ball.getLen() >= WIGHT) {

                    if (ball.getF() == 0)
                        ball.setF(1);
                    else ball.setF(2);

                }//挡板
                else if (board.getY() <= ball.getY() + ball.getLen()) {
                    if ((board.getLength() + board.getX() )>( ball.getX() + ball.getLen() / 2 )&& (ball.getX() + ball.getLen() / 2) > board.getX()&&ball.getY()+ball.getLen()<=board.getHigh()+ board.getY()) {

                        if (ball.getF() == 1) {
                            ball.setColor(randomColor());
                            ball.setF(2);
                        } else {
                            ball.setColor(randomColor());
                            ball.setF(3);
                        }
                    }
                    else{
                        if (ball.getY()>=HIGH) {
//                            ball.setY(0);
//                            ball.setColor(randomColor());
                            bool=false;
                            repaint();
                            break;
                        }
                    }
                }




                ball.move();
                repaint();
                try {
                    //noinspection BusyWait
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        }

    }
}


//鼠标监听器
class test implements MouseMotionListener {
    static int x = 0;

    public static int getX() {
        return x;
    }

    //鼠标的拖拽
    @Override
    public void mouseDragged(MouseEvent e) {


    }

    //鼠标移动
    @Override
    public void mouseMoved(MouseEvent e) {
//指数
/*
        if (e.getX() != x) {
            if (WIGHT + X + MyJPanel.board.getLength() >= MyJPanel.board.getX() + MyJPanel.board.getLength()) {
                MyJPanel.board.setX(MyJPanel.board.getX() + (e.getX() - x));
                x = e.getX();
            }
        }
        int x=e.getX();
        int y=e.getY();
        if (x<MyJPanel.board.getX()&&x<MyJPanel.board.getLength()&&y>=MyJPanel.board.getY()&&MyJPanel.board.getHigh()+MyJPanel.board.getY()<=y){
            MyJPanel.board.setY(e.getY()-y);
        }
*/
        board.setY(e.getY());
        board.setX(e.getX());
    }
}

