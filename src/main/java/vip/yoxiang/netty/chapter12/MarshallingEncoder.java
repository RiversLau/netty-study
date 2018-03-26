package vip.yoxiang.netty.chapter12;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.Marshaller;
import vip.yoxiang.netty.chapter09.MarshallingCodeCFactory;

/**
 * Author: Rivers
 * Date: 2018/3/26 21:57
 */
public class MarshallingEncoder {

    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    Marshaller marshaller;

    public MarshallingEncoder() {
        marshaller = MarshallingCodeCFactory.buildMarshalling();
    }

    protected void encode(Object msg, ByteBuf out) {
        int lengthPos = out.writerIndex();
        out.writeBytes(LENGTH_PLACEHOLDER);
        ChannelBufferByteOutput output = new ChannelBufferByteOutput(out);
    }
}
