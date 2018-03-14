package vip.yoxiang.aio_sample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Author: RiversLau
 * Date: 2018/3/14 15:43
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;
    AsynchronousServerSocketChannel asyncChannel;

    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            asyncChannel = AsynchronousServerSocketChannel.open();
            asyncChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server will start with the port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        asyncChannel.accept(this, new AcceptCompletionHandler());
    }
}
