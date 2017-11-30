import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerFrame extends JFrame {
    private Container cp;
    protected JTextArea jtaTalkDate=new JTextArea();
    private JScrollPane jspTalkDate=new JScrollPane(jtaTalkDate);
    private JPanel center=new JPanel(new GridLayout(3,3,5,5));
    private JButton btn[]=new JButton[9];
    private JPanel east=new JPanel(new GridLayout(7,1,5,5));
    private JLabel jlbIP=new JLabel("Server IP:");
    protected JTextField jtfIP=new JTextField();
    private JLabel jlbPort =new JLabel("Port");
    protected JTextField jtfPort=new JTextField("1723");
    protected JButton start=new JButton("Start");
    private JButton stop=new JButton("Stop");
    private JButton exit=new JButton("Exit");
    private JPanel south=new JPanel(new GridLayout(1,2,5,5));
    private JTextField jtfTalk=new JTextField();
    protected JButton send=new JButton("Send");
    private Boolean flag=true;
    protected ServerSocket svs;
    protected Socket s;
    public ServerFrame(){
        initComp();
    }
    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(200,200,700,450);
        cp=getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(BorderLayout.CENTER,center);
        cp.add(BorderLayout.EAST,east);
        east.setPreferredSize(new Dimension(100,450));
        cp.add(BorderLayout.WEST,jspTalkDate);
        jspTalkDate.setPreferredSize(new Dimension(150,450));
        jtaTalkDate.setEnabled(false);
        cp.add(BorderLayout.SOUTH,south);
        for(int i=0;i<btn.length;i++){
            btn[i]=new JButton();
            btn[i].setName(Integer.toString(i));
            center.add(btn[i]);
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     JButton tmpBtn=(JButton)e.getSource();
                     if(flag==true){
                         tmpBtn.setText("O");
                         flag=!flag;
                     }else{
                         tmpBtn.setText("X");
                         flag=!flag;
                     }
                     flagFunction();
                }
            });
        }
        east.add(jlbIP);
        try {
            InetAddress idr = InetAddress.getLocalHost();
            jtfIP.setText(idr.getHostAddress());
        }catch(UnknownHostException e){
            JOptionPane.showMessageDialog(ServerFrame.this,"無法取得IP位址");
        }
        jtfIP.setEnabled(false);
        east.add(jtfIP);
        east.add(jlbPort);
        east.add(jtfPort);
        east.add(start);
        east.add(stop);
        east.add(exit);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                svs=new ServerSocket(Integer.parseInt(jtfPort.getText()));
                jtaTalkDate.setText(jtaTalkDate.getText()+"\n"+"等候客戶端的請求..");
                 s=svs.accept();
                 jtaTalkDate.setText(jtaTalkDate.getText()+"\n"+"客戶端已連線");
                }catch (Exception e){
                 System.out.println("erro"+e);
                 }
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    OutputStream out = s.getOutputStream();
                    jtaTalkDate.setText(jtaTalkDate.getText() + "\n" + "資料傳輸中..");
//                    out.write(jtfTalk.getText().getBytes());
                    out.write("5566".getBytes());
                    s.close();
                    System.out.println(jtaTalkDate.getText() + "\n" + "資料傳輸完畢");
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        });
        cp.add(BorderLayout.SOUTH,south);
        south.add(jtfTalk);
        south.add(send);
//        ruuun();

    }
    private void flagFunction(){
        if(!btn[0].getText().equals("")&&btn[0].getText().equals(btn[1].getText())&&btn[1].getText().equals(btn[2].getText())){
            JOptionPane.showMessageDialog(ServerFrame.this,btn[0].getText()+"  is win");
            stop();
        }else if(!btn[3].getText().equals("")&&btn[3].getText().equals(btn[4].getText())&&btn[4].getText().equals(btn[5].getText())){
            JOptionPane.showMessageDialog(ServerFrame.this,btn[0].getText()+"  is win");
            stop();
        }else if(!btn[6].getText().equals("")&&btn[6].getText().equals(btn[7].getText())&&btn[7].getText().equals(btn[8].getText())){
            JOptionPane.showMessageDialog(ServerFrame.this,btn[0].getText()+"  is win");
            stop();
        }else if(!btn[0].getText().equals("")&&btn[0].getText().equals(btn[4].getText())&&btn[4].getText().equals(btn[8].getText())){
            JOptionPane.showMessageDialog(ServerFrame.this,btn[0].getText()+"  is win");
            stop();
        }else if(!btn[2].getText().equals("")&&btn[2].getText().equals(btn[4].getText())&&btn[4].getText().equals(btn[6].getText())){
            JOptionPane.showMessageDialog(ServerFrame.this,btn[0].getText()+"  is win");
            stop();
        }
    }
    private void start(){
        for(int i=0;i<btn.length;i++){
            btn[i].setText("");
            btn[i].setEnabled(true);
        }
    }
    private void stop(){
        for(int i=0;i<btn.length;i++){
            btn[i].setEnabled(false);
        }
    }
//    protected void ruuun(){
//        try{
//            svs=new ServerSocket(Integer.parseInt(jtfPort.getText()));
//            jtaTalkDate.setText(jtaTalkDate.getText()+"\n"+"等候客戶端的請求..");
//            s=svs.accept();
//            jtaTalkDate.setText(jtaTalkDate.getText()+"\n"+"客戶端已連線");
//        }catch (Exception e){
//            System.out.println("erro"+e);
//        }
//    }
}
