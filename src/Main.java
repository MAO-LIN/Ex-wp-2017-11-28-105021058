import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            InetAddress adr=InetAddress.getLocalHost();
            System.out.println(adr.getHostAddress());

        }catch(UnknownHostException e){
            System.out.println("");
        }
    }
}
