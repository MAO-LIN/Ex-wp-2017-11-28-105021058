package new_Main;

import javax.swing.*;
import java.awt.*;

public class UIpanel extends JPanel implements Runnable{
    private MainFrame mf;
    private JPanel p1=new JPanel(new GridLayout(1,2,5,5));
    private JPanel p2=new JPanel(new GridLayout(2,1,5,5));
    private JPanel p3=new JPanel(new GridLayout(1,3,5,5));
    private JLabel lbLv=new JLabel();
    private JLabel lbName=new JLabel();
    private JProgressBar jpgbarHp=new JProgressBar();
    private JProgressBar jpgbarMp=new JProgressBar();
    private JButton jbtn1=new JButton("能力表");
    private JButton jbtn2=new JButton("幫助");
    private JButton jbtn3=new JButton("系統");
    public UIpanel(MainFrame mf){
        this.setLayout(new GridLayout(1,3,5,5));
        this.add(p1);
        this.add(p2);
        this.add(p3);
        p1.add(lbLv);
        p1.add(lbName);
        p2.add(jpgbarHp);
        p2.add(jpgbarMp);
        p3.add(jbtn1);
        p3.add(jbtn2);
        p3.add(jbtn3);
        lbLv.setText("LV:"+mf.getchar().getLv());
        lbName.setText(mf.getchar().getid());
        jpgbarHp.setForeground(new Color(255, 0, 35));
        jpgbarHp.setMinimum(0);
        jpgbarHp.setMaximum(mf.getchar().getMaxHp());
        jpgbarHp.setStringPainted(true);
        jpgbarHp.setValue(mf.getchar().getNowHp());
        jpgbarMp.setForeground(new Color(10, 72,255));
        jpgbarMp.setMinimum(0);
        jpgbarMp.setMaximum(mf.getchar().getMaxMp());
        jpgbarMp.setStringPainted(true);
        jpgbarMp.setValue(mf.getchar().getNowMp());
        //關閉焦點
        jbtn1.setFocusable(false);
        jbtn2.setFocusable(false);
        jbtn3.setFocusable(false);
    }

    @Override
    public void run() {
        while(true){
            mf.getchar();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public JButton getJbtn1() {
        return jbtn1;
    }
}
