package new_Main;

import javafx.scene.layout.BackgroundImage;

import javax.swing.*;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private Timer walkT;
    private Timer alertT;
    private Timer standT;
    private Timer jumpT;
    private boolean keyFlag =false;
//    private CharacterT CharacterT=new CharacterT(alert,jump,walk,stand,"alert",0);

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

        walkT=new Timer(125, new ActionListener() {
            int t1Tmp=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(charList.get(0).getCharface()==true){
                    character[0].setIcon(walk[t1Tmp%4]);
                    t1Tmp++;
                    character[0].setLocation(character[0].getX()-10,character[0].getY());
                }else if(charList.get(0).getCharface()==false){
                    character[0].setIcon(walk[t1Tmp%4+4]);
                    t1Tmp++;
                    character[0].setLocation(character[0].getX()+10,character[0].getY());
                }
            }
        });
        alertT=new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        standT=new Timer(500, new ActionListener() {
            int t1Tmp=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(charList.get(0).getCharface()==true){
                    character[0].setIcon(stand[t1Tmp%3]);
                    t1Tmp++;
                }else if(charList.get(0).getCharface()==false){
                    character[0].setIcon(stand[t1Tmp%3+3]);
                    t1Tmp++;
                }
            }
        });
        jumpT=new Timer(30, new ActionListener() {
            int x= character[0].getX();
            int y= character[0].getY();
            boolean isTop=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(character[0].getY()>y-80&&isTop==false) {
                    character[0].setLocation(character[0].getX(), character[0].getY() - 10);
                }else if(character[0].getY()==y&&isTop==true){
                    if( charList.get(0).getCharface()==true){
                        character[0].setIcon(stand[0]);
                    }else{
                        character[0].setIcon(stand[3]);
                    }
                    isTop=false;
                    jumpT.stop();
                    standT.restart();
                }else if(character[0].getY()==y-80&&isTop==false){
                    isTop=true;
                    character[0].setLocation(character[0].getX(), character[0].getY() + 10);
                }else if(isTop==true){
                    character[0].setLocation(character[0].getX(), character[0].getY() + 10);
                }
            }
        });
        standT.start();

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key=e.getKeyCode();
                if(keyFlag==false) {
                    if (key == KeyEvent.VK_DOWN) {

                        keyFlag=true;
                    } else if (key == KeyEvent.VK_SPACE) {
                        System.out.println("Space");
                        if(charList.get(0).getCharface()==true){
                            character[0].setIcon(jump[0]);
                        }else{
                            character[0].setIcon(jump[1]);
                        }
                            standT.stop();
                            jumpT.start();
                        keyFlag=true;
                    } else if (key == KeyEvent.VK_RIGHT) {
                            charList.get(0).setCharface(false);
                            standT.stop();
                            walkT.start();
                        keyFlag=true;
                    } else if (key == KeyEvent.VK_LEFT) {
                            charList.get(0).setCharface(true);
                            standT.stop();
                            walkT.start();
                        keyFlag=true;
                    }
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key=e.getKeyCode();
                if(keyFlag==true) {
                    if (key == KeyEvent.VK_DOWN) {

                        keyFlag=false;
                    } else if (key == KeyEvent.VK_SPACE) {
//                        if(charList.get(0).getCharface()==true){
//                            character[0].setIcon(stand[0]);
//                        }else{
//                            character[0].setIcon(stand[3]);
//                        }
//                        jumpT.stop();
//                        standT.start();
                        System.out.println("SpaceEnd");
                    } else if (key == KeyEvent.VK_RIGHT) {
                        character[0].setIcon(stand[3]);
                        standT.restart();
                        walkT.stop();
                        keyFlag=false;
                    } else if (key == KeyEvent.VK_LEFT) {
                        character[0].setIcon(stand[0]);
                        standT.restart();
                        walkT.stop();
                        keyFlag=false;
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
        jump[1]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/jump/right/jump_"+Integer.toString(0)+".png");

        for(int i=0;i<3;i++){
            stand[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/stand/left/stand1_"+Integer.toString(i)+".png");
            System.out.println("NewCharacter/Character0"+Integer.toString(charType)+"/stand/left/stand1_"+Integer.toString(i)+".png");
        }
//        System.out.println("NewCharacter/Character01/stand/left");
        for(int i=3;i<6;i++){
            stand[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/stand/right/stand1_"+Integer.toString(i-3)+".png");
        }
    }
//    public void imgAminal(int start,int end,boolean charface){
//        for(){}
//
//    }
}
