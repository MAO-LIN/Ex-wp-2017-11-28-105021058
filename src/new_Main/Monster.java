package new_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by jackwang on 2017/12/14.
 */
public class Monster extends JPanel implements Runnable {

    private BufferedImage image;
    // private Image image;
    private MainFrame mf;
    private  int imgW, imgH;
    private  int frmH,frmW,r1,r;
    private int x,y=0;
    private ImageIcon jump[]=new ImageIcon[3];
    private ImageIcon walk[]=new ImageIcon[6];
    private ImageIcon stand[]=new ImageIcon[6];
    private ImageIcon die[]=new ImageIcon[8];
    private ImageIcon hit[]=new ImageIcon[2];
    private int mapstart;
    private JProgressBar jpgbarHp=new JProgressBar();
    private boolean up,down,right,left,att=false;
    private JLabel jlb=new JLabel();
//    private JLabel jlbHp=new JLabel("1000000");
    private int nowHp=45;
    private int maxHp=45;
    private int attack=3;
    private JLabel jlbName=new JLabel("惡水靈");
//    private  Dimension place = new Dimension(50,30);
   // private ImageIcon[][] imgIcon={{new ImageIcon("slimetest/slime1.png")},{new ImageIcon("slimetest/slime.png")}};
private  boolean Flag = true;
    private  Timer t1;
    private  Timer walkT;
//    private  Timer walk1;
    private  Timer dieT;
    private  Timer hitT;
    private  Timer standT;
    private Random rand = new Random();
    // first
    private boolean firstFlag=true;
    private  Mob mob;
    private MonsterHitThread msrHt;
    private Thread msrTh;

    public Monster(int frmH, int frmW ,MainFrame mf){
        this.setLayout(new BorderLayout(5,5));
        jlb.setIcon(stand[0]);
        setMobAnimal();
        this.mf=mf;
        this.mapstart=mf.getMap().getMapDrawStart();
      //  this.setOpaque(false);
//        try{
//            image= ImageIO.read(new File("Slime/walk/left/move.1.png"));
//            // imgW= image.getWidth();
//            imgW= image.getWidth();
//            imgH = image.getHeight();
//            // imgH = 500;
//        }catch(IOException ie){
//            ie.printStackTrace();
//        }
        //setMonster HP
        jpgbarHp.setForeground(new Color(255, 0, 35));
        jpgbarHp.setMinimum(0);
        jpgbarHp.setMaximum(maxHp);
        jpgbarHp.setValue(nowHp);
        jpgbarHp.setSize(84,20);
//        jpgbarHp.setStringPainted(true);

        this.frmH= frmH;
        this.frmW = frmW;
        this.setOpaque(false);
//        jlbHp.setForeground(Color.orange);
//        jlbName.setForeground(Color.orange);
        x=rand.nextInt(frmW);
        //y=rand.nextInt(frmH-100);
       // y=390;
        y=600-101-100;
//        r=rand.nextInt(6);
        r=rand.nextInt(2);
//        System.out.println(r);

       // setMobAnimal();
        if(r==1) {
            this.Flag = false;
        }
       // this.setIcon(imgIcon[r][r1=rand.nextInt(1)]);
       this.setBounds(x,y,80,96);//panel大小
        jpgbarHp.setSize(84,10);
        jlb.setSize(84,91);
//        jlb.setPreferredSize(new Dimension(84,101));
//        jlbName.setSize(place);
        this.add(BorderLayout.NORTH,jpgbarHp);
        this.add(BorderLayout.CENTER,jlb);

        //msr Thread
        msrHt=new MonsterHitThread(Monster.this,mf);
        msrTh=new Thread(msrHt);

//        this.add(jlbName);

        //Timer
        walkT = new Timer(125/*走路速度*/, new ActionListener() {
            int t1Tmp = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Monster.this.Flag) {
                    if ((x - 10)-mapstart*10 > 0) {
                        //向左

                        jlb.setIcon(walk[t1Tmp % 3]);

                        left = true;//左
                        t1Tmp++;
                        x -= 10;
                        Monster.this.repaint();
                    } else {
                        Monster.this.Flag = !Monster.this.Flag;
                        r = 1;

                        x += 10;
                    }
                    Monster.this.setLocation(x-mapstart*10, y);
                    //   Monster.this.repaint();
                } else {

                    if ((x+jlb.getIcon().getIconWidth()+20-mapstart*10)<getFrmW()) {
                        //向右
                        jlb.setIcon(walk[t1Tmp % 3+3]);

                        right = true;//右
                        t1Tmp++;
                        x += 10;
                        //  Monster.this.repaint();
                    } else {
                        Monster.this.Flag = !Monster.this.Flag;
                        r = 0;
                        x -= 10;
                    }
                    Monster.this.setLocation(x-mapstart*10, y);
//                Monster.this.repaint();
                }
            }
        });
//
//    walk1 = new Timer(500, new ActionListener() {
//        int t1Tmp = 0;
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            if (r == 1) {
//
//
//                left = true;//左
//                t1Tmp++;
//                // Monster.this.repaint();
//            } else {
//
//
//                right = true;//右
//                t1Tmp++;
//
//            }
//            Monster.this.repaint();
//        }
//
//    });
        standT = new Timer(400, new ActionListener() {
            int t1Tmp = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (r == 1) {
                    jlb.setIcon(stand[t1Tmp % 3+3]);

                    left = true;
                    t1Tmp++;
                    if(t1Tmp==6){
                        standT.stop();

                        walkT.start();
                        t1Tmp=0;
                    }
                    // Monster.this.repaint();
                } else {
                    jlb.setIcon(stand[t1Tmp % 3]);
                    right = true;
                    t1Tmp++;
                    if(t1Tmp==6){
                        standT.stop();

                        walkT.start();
                        t1Tmp=0;
                    }

                }
//            Monster.this.repaint();
//            System.out.println(t1Tmp);
            }

        });
        t1 = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r1 = rand.nextInt(60000);
                if (r1 > 10000) {

                } else {
                    // walk1.stop();
                    walkT.stop();
                    standT.start();
                }
            }
        });
    }
    @Override
    public  void run(){
        msrTh.start();
        t1.start();

    }


    private  void  setMobAnimal(){

        for(int i=0;i<3;i++){

            walk[i]=new ImageIcon("Slime/walk/left/move."+Integer.toString(i)+".png");

        }

        for(int i=3;i<6;i++){

            walk[i]=new ImageIcon("Slime/walk/right/move."+Integer.toString(i-3)+".png");

        }

        for(int i=0;i<3;i++) {

            jump[i] = new ImageIcon("Slime/jump/left/move." + Integer.toString(i) + ".png");

        }

        for(int i=0;i<3;i++) {

            jump[i]=new ImageIcon("Slime/jump/right/move."+Integer.toString(i-3)+".png");

        }

        for(int i=0;i<3;i++) {

            stand[i] = new ImageIcon("Slime/stand/left/stand." + Integer.toString(i) + ".png");

        }

        for(int  i=3;i<6;i++) {

            stand[i]=new ImageIcon("Slime/stand/right/stand."+Integer.toString(i-3)+".png");

        }
        for(int  i=0;i<4;i++) {
            die[i]=new ImageIcon("Slime/die/right/die."+Integer.toString(i)+".png");
        }
        for(int  i=4;i<8;i++) {
            die[i]=new ImageIcon("Slime/die/left/die."+Integer.toString(i-4)+".png");
        }
        hit[0]=new ImageIcon("Slime/die/right/hit.0.png");
        hit[1]=new ImageIcon("Slime/die/right/hit.0.png");


    }

    public int getMapstart(){
        return mapstart;
    }
    public void setMapstart(int mapstart1){
        this.mapstart=mapstart1;
    }
    public  int getImgWidth(){return imgW;}
    public int getImgHeight(){
        return imgH;
    }
    public int getAttack(){
        return  attack;
    }
    public void setNowHp(int charAtt){
        nowHp=nowHp-charAtt;
        jpgbarHp.setValue(nowHp);
    }
    public JLabel getJlb(){
        return jlb;
    }
    public ImageIcon getHit(int index) {
        return hit[index];
    }
    public int getNocHp(){
        return  nowHp;
    }
//    public  int getx(){
//        return x;
//    }
//    public int gety(){
//        return y;
//    }
        @Override
    protected  void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        super.paintComponent(g);
        g2d.drawImage(image,0,0,null);
    }
    public Timer getT1(){
        return t1;
    }
    public Timer getWalkT(){
        return t1;
    }
    public Timer getStandT(){
        return t1;
    }

    public int getTmpX(){
        return x;
    }
    public void setTmpX(int x1){
        this.x=x1;
    }

    public MainFrame getMf() {
        return mf;
    }
    public int getFrmW(){
        return frmW;
    }
}

