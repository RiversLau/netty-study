package vip.yoxiang.netty.chapter08;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Author: Rivers
 * Date: 2018/3/18 16:07
 */
public class TestSubscribeReqProto {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode : \r\n" + req.toString());

        SubscribeReqProto.SubscribeReq req1 = decode(encode(req));
        System.out.println("After decode : \n" + req1.toString());

        if (req.equals(req1)) {
            System.out.println("Equals!");
        }
    }

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] bytes) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(bytes);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("RiversLau");
        builder.setProductName("Netty Book");
        builder.setAddress("BeiJing LiShuiQiao");
        return builder.build();
    }
}
