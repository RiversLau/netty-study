package vip.yoxiang.bio_sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: RiversLau
 * Date: 2018/3/13 16:23
 */
public class TimeServer {

    private static final Integer DEFAULT_PORT = 8888;

    public static void main(String[] args) throws IOException {
        int port = DEFAULT_PORT;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // do nothing
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server will start with the port:" + port);
            Socket socket;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null) {
                server.close();
                System.out.println("The time server shut down.");
            }
        }
    }
}
