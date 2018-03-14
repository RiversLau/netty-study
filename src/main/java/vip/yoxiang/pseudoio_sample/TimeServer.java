package vip.yoxiang.pseudoio_sample;

import vip.yoxiang.bio_sample.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: RiversLau
 * Date: 2018/3/13 20:19
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
            TimeServerHandlerExecutePool executePool = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                socket = server.accept();
                executePool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                server.close();
                System.out.println("The time server shut down.");
            }
        }
    }
}
