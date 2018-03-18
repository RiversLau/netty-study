package vip.yoxiang.netty.chapter07;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Rivers
 * Date: 2018/3/18 11:15
 */
public class MsgPackIntroduction {

    public static void main(String[] args) throws IOException {
        List<String> strList = new ArrayList<>();
        strList.add("MsgPack");
        strList.add("ProtoBuf");
        strList.add("Thrift");
        MessagePack msgPack = new MessagePack();
        byte[] raw = msgPack.write(strList);
        System.out.println("byte array size is " + raw.length);
        List<String> resultList = msgPack.read(raw, Templates.tList(Templates.TString));
        for (String str : resultList) {
            System.out.println(str);
        }
    }
}
