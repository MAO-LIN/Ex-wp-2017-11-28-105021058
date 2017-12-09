package new_Main;

import javafx.scene.layout.BackgroundImage;

import javax.swing.*;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class  MainFrame extends JFrame {
    private ImageIcon alert[]=new ImageIcon[6];
    private ImageIcon jump[]=new ImageIcon[2];
    private ImageIcon walk[]=new ImageIcon[8];
    private ImageIcon stand[]=new ImageIcon[6];
    private JLayeredPane jlyPane = new JLayeredPane();
    private ArrayList<Character> charList = new ArrayList<Character>();
    private JPanel backgroundP = new JPanel(new BorderLayout(0, 0));
    private JLabel backgroundImg = new JLabel();
    public JLabel character[] = new JLabel[2];
    private CharacterT CharacterT=new CharacterT(alert,jump,walk,stand,"alert",0);

    public MainFrame() {
        initComp();
    }

    private void initComp() {
        charList.add(new Character("aa",100,100,1));
        setCharAnimal(charList.get(0).getCharType());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 900, 600);
        ImageIcon imgTmp =new ImageIcon("background.jpg");
        imgTmp.setImage(imgTmp.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT));
        backgroundImg.setIcon(imgTmp);
        jlyPane = getLayeredPane();
        backgroundP.add(backgroundImg);
        backgroundImg.setOpaque(true);
        backgroundImg.setBounds(0,0,900,600);
        character[0]=new JLabel(stand[3]);
        character[0].setBounds(450-59,420,59,81);
        jlyPane.add(character[0], JLayeredPane.PALETTE_LAYER,new Integer(101));

        jlyPane.add(backgroundImg, JLayeredPane.DEFAULT_LAYER);

//        jlyPane.add(characterlb[1], JLayeredPane.PALETTE_LAYER,new Integer(102));

        this.addKeyListener(new KeyListener() {
            boolean flag=false;
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                if(flag==false) {
                    if (key == KeyEvent.VK_DOWN) {

                        flag=true;
                    } else if (key == KeyEvent.VK_UP) {

                        flag=true;
                    } else if (key == KeyEvent.VK_RIGHT) {

                        flag=true;
                    } else if (key == KeyEvent.VK_LEFT) {

                        flag=true;
                    }
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key=e.getKeyCode();
                if(flag==true) {
                    if (key == KeyEvent.VK_DOWN) {

                        flag=false;
                    } else if (key == KeyEvent.VK_UP) {

                        flag=false;
                    } else if (key == KeyEvent.VK_RIGHT) {

                        flag=false;
                    } else if (key == KeyEvent.VK_LEFT) {

                        flag=false;
                    }
                }

            }
        });
//        jlyPane.add(backgroundP, JLayeredPane.PALETTE_LAYER,new Integer(102));
//        jlyPane.add();
    }
    private void setCharAnimal(int charType){
        for(int i=0;i<3;i++){
            alert[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/alert/left/alert_"+Integer.toString(i)+".png");
            System.out.println("NewCharacter/Character0"+Integer.toString(charType)+"/alert/left/alert_"+Integer.toString(i)+".png");
        }
        System.out.println("NewCharacter/Character01/alert/left");
        for(int i=3;i<6;i++){
            alert[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/alert/right/alert_"+Integer.toString(i-3)+".png");
        }

        for(int i=0;i<4;i++){
            walk[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/walk/left/walk1_"+Integer.toString(i)+".png");
        }

        for(int i=4;i<8;i++){
            walk[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/walk/right/walk1_"+Integer.toString(i-4)+".png");
        }
        jump[0]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/jump/left/jump_"+Integer.toString(0)+".png");
        jump[0]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/jump/right/jump_"+Integer.toString(0)+".png");

        for(int i=0;i<3;i++){
            stand[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/stand/left/stand_"+Integer.toString(i)+".png");
            System.out.println("NewCharacter/Character0"+Integer.toString(charType)+"/stand/left/stand_1"+Integer.toString(i)+".png");
        }
//        System.out.println("NewCharacter/Character01/stand/left");
        for(int i=3;i<6;i++){
            stand[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/stand/right/stand1_"+Integer.toString(i-3)+".png");
        }
    }
    public void charWalk(int ,boolean charface){

    }
}
