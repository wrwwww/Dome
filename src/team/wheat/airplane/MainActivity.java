package team.wheat.airplane;

import team.wheat.airplane.res.PlayGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;



public class MainActivity {


    public static void main(String[] args)throws IOException {
        new BasisActivity();

    }

}
class BasisActivity{
    JFrame basis;
    JPanel cap;
    static int WIDTH=400;
    static int HEIGHT=Toolkit.getDefaultToolkit().getScreenSize().height;

    BasisActivity() throws IOException{

        basis=new JFrame("飞机大战");
        cap=new PlayGame();
        //项目图标
        basis.setIconImage(
                get_icon("" +
                        "E:\\Dome\\src\\team\\wheat\\airplane\\res\\draw\\bee.png"));
        basis.setLocationRelativeTo(null);
        basis.setSize(WIDTH, HEIGHT);

        basis.add(cap);
        basis.addKeyListener((KeyListener) cap);

        cap.setVisible(true);
        basis.setVisible(true);
        basis.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


    public static Image get_icon(String image) throws IOException{
        Image icon;
        icon = ImageIO.read(new File(image));
        return icon;
    }
}



