package vip.yoxiang.aio_sample;

/**
 * Author: RiversLau
 * Date: 2018/3/14 17:21
 */
public class TimeClient {

    private static final Integer DEFAULT_PORT = 8888;

    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // do nothing
            }
        }

        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
    }
}
