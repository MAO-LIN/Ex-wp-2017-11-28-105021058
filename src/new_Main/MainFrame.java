package new_Main;

import javax.swing.*;

public class MainFrame extends JFrame{
    private JLayeredPane jlyPane=new JLayeredPane();
    public MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(200,200,700,500);
    }
}
