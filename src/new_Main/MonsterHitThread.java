package new_Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonsterHitThread implements Runnable {
    private Monster msr;
    private MainFrame mf;
    private Timer monsterHitT;
    public MonsterHitThread (Monster msr,MainFrame mf){
        this.msr=msr;
        this.mf=mf;
        monsterHitT=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMsr().getT1().start();
                monsterHitT.stop();
            }
        });
    }
    @Override
    public void run() {
        while(true){
            if(msr.getX()<mf.getchar().getX()+150&&msr.getX()>mf.getchar().getX()-150&&mf.getNowC().equals("att")){
                System.out.println("Monster_hit");
                msr.setNowHp(mf.getchar().getCharAttack());
                if(msr.getNocHp()<=0){

                }
                if(msr.getX()<mf.getchar().getX()+150){
                    msr.getT1().stop();
                    monsterHitT.start();
                    msr.setLocation(msr.getX()+10,msr.getY());
//                    msr.setTmpX(msr.getX()+10);
                    msr.getJlb().setIcon(msr.getHit(0));
                }else{
                    msr.getT1().stop();
                    monsterHitT.start();
                    msr.setLocation(msr.getX()-10,msr.getY());
//                    msr.setTmpX(msr.getX()-10);
                    msr.getJlb().setIcon(msr.getHit(1));
                }
                try {
                    Thread.sleep(125);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            System.out.println("msrth is running");
            if( msr.getX()<mf.getchar().getX()+50&&msr.getX()>mf.getchar().getX()-50) {
//                System.out.println( msr.getX());
//                System.out.println(mf.getchar().getX()+81);
                mf.getchar().setHit(true);
                System.out.println("hit");
                mf.getchar().setNowHp(mf.getchar().getNowHp()-msr.getAttack());
//                System.out.println(mf.getchar().getNowHp());
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public Monster getMsr(){
        return msr;
    }
}
