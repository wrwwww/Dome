package team.wheat.airplane.res;

import javax.swing.*;
import java.awt.*;

public class Start extends JPanel {
    JButton button;
    public Start(){
        button = new JButton("开始游戏");
        this.add(button);
        button.addActionListener(e -> {
this.disable();
        });
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(0, 0, 10, 10);

    }
}
