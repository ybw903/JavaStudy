package chaptor.ioBasednetwork.basic;

import chaptor.BasicExample;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample extends BasicExample {
    @Override
    public void run() {
        try {
            InetAddress local =InetAddress.getLocalHost();
            System.out.println("내컴퓨터 IP주소: " + local.getHostAddress());

            InetAddress[] isArr = InetAddress.getAllByName("www.naver.com");
            for(InetAddress remote : isArr) {
                System.out.println("www.naver.com IP주소: " + remote.getHostAddress());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
