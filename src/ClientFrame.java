import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFrame extends ServerFrame {
    public ClientFrame(){
        initComp();
    }
    private void initComp(){
        jtfIP.setEnabled(true);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                try{
//                    jtaTalkDate.setText(jtaTalkDate.getText()+"\n"+"正在與伺服器連線...");
//                    s=new Socket(jtfIP.getText(),Integer.parseInt(jtfPort.getText()));
//                    jtaTalkDate.setText( jtaTalkDate.getText()+"\n"+"已經與伺服器取得連線");
//
//
//                }catch (Exception e){
//                    System.out.println(e);
//                }
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                byte buff[]=new byte[1024];
                try {
                    InputStream in = s.getInputStream();
                    int n = in.read(buff);
                    jtaTalkDate.setText(jtaTalkDate.getText() + "\n" + "收到資料");
                    jtaTalkDate.setText(jtaTalkDate.getText() + "\n" + new String(buff, 0, n));
                    in.close();
                    s.close();
                }catch (Exception e){

                }
            }
        });

    }

//    @Override
//    protected void ruuun() {
//        try{
//            jtaTalkDate.setText(jtaTalkDate.getText()+"\n"+"正在與伺服器連線...");
//            s=new Socket(jtfIP.getText(),Integer.parseInt(jtfPort.getText()));
//            jtaTalkDate.setText( jtaTalkDate.getText()+"\n"+"已經與伺服器取得連線");
//
//
//        }catch (Exception e){
//            System.out.println("erro"+e);
//        }
//    }
}
