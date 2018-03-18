package vip.yoxiang.netty.chapter07;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Author: Rivers
 * Date: 2018/3/18 12:00
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private final int sendNumber;

    public EchoClientHandler(int sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] infos = userInfos();
        for (UserInfo info : infos) {
            ctx.write(info);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msgpack msg : " + msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private UserInfo[] userInfos() {
        UserInfo[] infos = new UserInfo[sendNumber];
        UserInfo info = null;
        for (int i = 0; i < sendNumber; i++) {
            info = new UserInfo();
            info.setAge(i);
            info.setName("ABCDEFG-->" + i);
            infos[i] = info;
        }
        return infos;
    }
}
