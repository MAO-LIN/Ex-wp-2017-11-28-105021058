package new_Main;

public class Map {
    private int map[][];
    private int arrayW;
    private int arrayH;
    public Map(int winW,int winH){
        //10格為10px
        map=new int[arrayH=winH/10][arrayW=winW/10];
        for(int i=0;i<winH/10;i++){
            for(int j=0;j<winW/10;j++){
                map[i][j]=0;
            }
        }
        //floor
        //x:0 y:500 h:100 w:1000
        setObj(0,500,100,1000);
    }
    public void setObj(int x,int y,int h,int w){
        int startX=x/10;
        int startY=y/10;
        for(int i=0;i<h/10;i++){
            for(int j=0;j<w/10;j++){
                map[startY+i][startX+j]=1;
//                System.out.print("["+startY+i+"],["+startX+j+"]\t");
            }
//            System.out.println();
        }
    }
    public boolean setObjCheck(int x,int y,int h,int w){
        boolean flag=true;
        int startX=x/10;
        int startY=y/10;
        for(int i=0;i<h/10;i++){
            for(int j=0;j<w/10;j++){
               if( map[startY+i][startX+j]!=0){
                   flag=false;
               }
            }
        }
        if(flag==false){
            return false;
        }else{
            return true;
        }
    }
    public boolean setCharWalk(int x,int y,int n){
        boolean flag=true;
        //+charLabel h and w
        int startX =(x+84-10)/10;
//        System.out.println("setX");
        //y [49] =490~500 500為地板 490為人物
        int startY =(y+81-10)/10;
        System.out.println("setY:"+y);
        System.out.println("setstartY:"+(y+81-10)/10);
        if(n>=0){
            startX=startX+n/10;
            if(map[startY][startX]==1){
                flag=false;
            }
            if(flag==false){
                printMap();
                System.out.println(flag);
                System.out.println(startY+","+startX);
                return false;
            }else{
                System.out.println(flag);
                for(int i=0;i<81/10;i++){
                    map[(startY-7+i)][startX-(8)]=0;
                    map[(startY-7+i)][startX]=1;
                }
                printMap();
                System.out.println(startY+","+startX);
                return true;
            }

        }else{
            startX=(startX+n/10-8);
            if(map[startY][startX]==1){
                flag=false;
            }
            if(flag==false){
                printMap();
                System.out.println(flag);
                System.out.println(startY+","+startX);
                return false;
            }else{
                System.out.println(flag);
                for(int i=0;i<81/10;i++){
                    map[(startY-7+i)][startX]=1;
                    map[(startY-7+i)][startX+8]=0;
                }
                printMap();
                System.out.println(startY+","+startX);
                return true;
            }

        }

    }
    public boolean setCharJump(int x,int y,int n){
        boolean flag=true;
        //+charLabel h:81 and w:84
        int startX=(x+84)/10;
        int startY=(y+81)/10;
        startY=startY+n/10;
        if(map[startY][startX]==1){
            flag=false;
        }
        if(flag==false){
            return false;
        }else{
            return true;
        }
    }
    public void printMap() {
        System.out.println(arrayH+"\t"+arrayW);
        for(int j=0;j<arrayW;j++){
            System.out.print(j+"\t");
        }
        System.out.println();
       for(int i=0;i<arrayH;i++){
           System.out.print(i+"\t");
            for(int j=0;j<arrayW;j++){
                System.out.print(map[i][j]+"\t");
            }
           System.out.println();
       }
        System.out.print("/"+"\t");
        for(int j=0;j<arrayW;j++){
            System.out.print(j+"\t");
        }
        System.out.println();
    }

}
