package new_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterT implements Runnable {
    private ImageIcon alert[]=new ImageIcon[6];
    private ImageIcon jump[]=new ImageIcon[2];
    private ImageIcon walk[]=new ImageIcon[8];
    private ImageIcon stand[]=new ImageIcon[6];
    private ImageIcon attack[]=new ImageIcon[8];
    private Timer walkT;
    private Timer alertT;
    private Timer standT;
    private Timer jumpT;
    private Timer attackT;
    private Character charactor;
    private MainFrame mf;
    private int imageTmp=0;
    private boolean timerFlag=false;
    public  CharacterT(Character charactor1,MainFrame mf1){
        this.charactor=charactor1;
        this.mf=mf1;
        setCharAnimal(1);
        walkT=new Timer(120, new ActionListener() {
            int imageTmp=1;
            @Override
            public void actionPerformed(ActionEvent e) {
                setTimerFlag(true);
                if(!mf.getNowC().equals("right")&&!mf.getNowC().equals("left")){
                    imageTmp=1;
                    setTimerFlag(false);
                    walkT.stop();
                }
                if(charactor.getCharface()){
                    mf.getchar().setIcon(walk[imageTmp%4]);
                    mf.getchar().setLocation(mf.getchar().getX()-8,mf.getchar().getY());
                }else{
                    mf.getchar().setIcon(walk[imageTmp%4+4]);
                    mf.getchar().setLocation(mf.getchar().getX()+8,mf.getchar().getY());
                }
                imageTmp++;
            }
        });
//        alertT=new Timer(500, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
        standT=new Timer(495, new ActionListener() {
            int imageTmp=1;
            @Override
            public void actionPerformed(ActionEvent e) {
                setTimerFlag(true);
                if(!mf.getNowC().equals("stand")){
                    imageTmp=1;
                    setTimerFlag(false);
                    standT.stop();
                }
                if(charactor.getCharface()){
                    mf.getchar().setIcon(stand[imageTmp%3]);
                }else{
                    mf.getchar().setIcon(stand[imageTmp%3+3]);
                }
                imageTmp++;
            }
        });
        jumpT=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        attackT=new Timer(120, new ActionListener() {
            int imageTmpa=1;
//            boolean finish=false;
            @Override
            public void actionPerformed(ActionEvent e) {
                setTimerFlag(true);
                if(imageTmpa==4||charactor.getHit()){
                    imageTmpa=1;
                    attackT.stop();
                    setTimerFlag(false);
                    charactor.setAtt(false);
                }
                if(charactor.getCharface()){
                    mf.getchar().setIcon(attack[imageTmpa%4]);
                }else{
                    mf.getchar().setIcon(attack[imageTmpa%4+4]);
                }
                imageTmpa++;
            }
        });
    }
    @Override
    public void run() {
        while(true){
            if(!timerFlag) {
                if (mf.getNowC().equals("Rup")) {

                } else if (mf.getNowC().equals("Lup")) {

                } else if (mf.getNowC().equals("up")) {

                } else if (mf.getNowC().equals("down")) {

                } else if (mf.getNowC().equals("right")) {
                    setWalkT();
                } else if (mf.getNowC().equals("left")) {
                    setWalkT();
                } else if (mf.getNowC().equals("att")) {
                    setAtt();
                } else if (mf.getNowC().equals("stand")) {
                    setStandT();
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setWalkT(){
        if(charactor.getCharface()){
            mf.getchar().setIcon(walk[0]);
        }else{
            mf.getchar().setIcon(walk[4]);
        }
        walkT.start();
    }
    public void setStandT(){
        if(charactor.getCharface()){
            mf.getchar().setIcon(stand[0]);
        }else{
            mf.getchar().setIcon(stand[3]);
        }
        standT.start();
    }
    public void setAtt(){
        if(charactor.getCharface()){
            mf.getchar().setIcon(attack[0]);
        }else{
            mf.getchar().setIcon(attack[4]);
        }
        attackT.start();
    }
    public void setJumpT(){
        walkT.start();
    }
    public int getImageTmp(){
        return imageTmp;
    }
    public void setImageTmp(){
        imageTmp++;
    }
    public void setTimerFlag(boolean timerFlag1){
        this.timerFlag=timerFlag1;
    }
    public boolean getTimerFlag(){
        return timerFlag;
    }
//    public void setWalkT(){
//        walkT.start();
//    }
//    public void setWalkT(){
//        walkT.start();
//    }


    private void setCharAnimal(int charType){
        for(int i=0;i<3;i++){
            alert[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/alert/left/alert_"+Integer.toString(i)+".png");
//            System.out.println("NewCharacter/Character0"+Integer.toString(charType)+"/alert/left/alert_"+Integer.toString(i)+".png");
        }
//        System.out.println("NewCharacter/Character01/alert/left");
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
//            System.out.println("NewCharacter/Character0"+Integer.toString(charType)+"/stand/left/stand1_"+Integer.toString(i)+".png");
        }
//        System.out.println("NewCharacter/Character01/stand/left");
        for(int i=3;i<6;i++){
            stand[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/stand/right/stand1_"+Integer.toString(i-3)+".png");
        }
        for(int i=0;i<2;i++){
            attack[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/attack/left/stabO1_"+Integer.toString(i)+".png");
        }
        for(int i=2;i<4;i++){
            attack[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/attack/left/stabO2_"+Integer.toString(i-2)+".png");
        }
        for(int i=4;i<6;i++){
            attack[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/attack/right/stabO1_"+Integer.toString(i-4)+".png");
        }
        for(int i=6;i<8;i++){
            attack[i]=new ImageIcon("NewCharacter/Character0"+Integer.toString(charType)+"/attack/right/stabO2_"+Integer.toString(i-6)+".png");
        }
        for(int i=12;i<15;i++){

        }
        for(int i=15;i<18;i++){

        }
    }
}
