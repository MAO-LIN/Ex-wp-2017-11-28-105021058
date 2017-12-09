package new_Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Character extends Thread implements KeyListener{
    private ImageIcon alert[]=new ImageIcon[6];
    private ImageIcon jump[]=new ImageIcon[2];
    private ImageIcon walk[]=new ImageIcon[8];
    private String id;
    private int nowHp,maxHp;
    private boolean charface;
    private Point local;
    private int charType;
    private String nowC;
    public Character(String id,int nowHp,int maxHp,boolean charface,Point local,int charType,String nowC){
        this.id=id;
        this.nowHp=nowHp;
        this.maxHp=maxHp;
        this.charface=charface;
        //角色面方向
        this.local=local;
        //位置
        this.charType=charType;
        //哪隻角色
        this.nowC=nowC;
        //正在使用的指令
    }

    @Override
    public void run() {

    }
    public void setId(String id){
        this.id=id;
    }

    public String getId(String id){
        return id;
    }
    public void setNowHp(int NowHp){
        this.nowHp=nowHp;
    }

    public int getNowHp(int nowHp){
        return nowHp;
    }
    public void setMaxHp(int maxHp){
        this.maxHp=maxHp;
    }

    public int getMaxHp(int maxHp){
        return maxHp;
    }
    public void setCharface(boolean charface){
        this.charface=charface;
    }

    public boolean getCharface(boolean charface){
        return charface;
    }
    public void setLocal(Point local){
        this.local=local;
    }

    public Point getLocal(Point local){
        return local;
    }
    public void setCharType(int charType){
        this.charType=charType;
    }

    public int getCharType(int charType ){
        return charType;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
