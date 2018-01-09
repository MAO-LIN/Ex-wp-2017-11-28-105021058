package new_Main;

public class MonsterHitThread implements Runnable {
    private Monster msr;
    private MainFrame mf;
    public MonsterHitThread (Monster msr,MainFrame mf){
        this.msr=msr;
        this.mf=mf;
    }
    @Override
    public void run() {
        while(true){
//            System.out.println("msrth is running");
            if( msr.getX()<mf.getchar().getX()+81&&msr.getX()>mf.getchar().getX()-84) {
//                System.out.println( msr.getX());
//                System.out.println(mf.getchar().getX()+81);
                System.out.println("hit");

            }
            if(msr.getX()<mf.getchar().getX()+100&&msr.getX()>mf.getchar().getX()-100&&mf.getNowC().equals("att")){
                System.out.println("Monster_hit");
                msr.setNowHp(mf.getchar().getCharAttack());
                if(msr.getNocHp()<=0){

                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
