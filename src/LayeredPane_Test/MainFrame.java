package LayeredPane_Test;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JLayeredPane jlyPane =new JLayeredPane();
    private JLabel[] label=new JLabel[7];
    private Point position=new Point(10,10);
    Color[] colors={
            Color.red,Color.blue,Color.magenta,Color.cyan,Color.yellow,
            Color.green,Color.pink
    };
    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(100,200,700,500);
        jlyPane=getLayeredPane();
        for(int i=0;i<7;i++){
            label[i]=new JLabel(Integer.toString(i),JLabel.CENTER);
            position.x=position.x+20;
            position.y=position.y+20;
            label[i].setBounds(position.x,position.y,100,100);
            label[i].setOpaque(true);
            label[i].setBackground(colors[i]);
            jlyPane.add(label[i],JLayeredPane.PALETTE_LAYER,
                    new Integer(101+i));
        }
    }
}
