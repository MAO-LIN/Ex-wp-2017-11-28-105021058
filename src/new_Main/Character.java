package new_Main;

import java.awt.*;

public class Character {
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
    //抓資料
    public String getId(){
        return id;
    }

}
