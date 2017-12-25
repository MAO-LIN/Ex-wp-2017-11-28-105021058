package new_Main;

import javax.swing.*;

public class Obj extends JLabel implements Runnable{
    private MainFrame mf;
    public Obj(MainFrame mf){
        this.mf=mf;
    }

    @Override
    public void run() {
        while(true){
            if(mf.getNowC().equals("right")){
                this.setLocation(this.getX()-10,this.getY());
            }else if(mf.getNowC().equals("left")){
                this.setLocation(this.getX()+10,this.getY());
            }
            try {
                Thread.sleep(145);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
