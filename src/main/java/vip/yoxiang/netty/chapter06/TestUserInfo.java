package vip.yoxiang.netty.chapter06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

/**
 * Author: Rivers
 * Date: 2018/3/18 10:24
 */
public class TestUserInfo {

    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserId(100).buildUserName("Welcome to netty.");

        testLength(info);
        System.out.println("====================优雅的分割线=======================");
        testPerformance(info);
    }

    public static void testLength(UserInfo info) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(info);
        oos.flush();
        oos.close();
        byte[] b = bos.toByteArray();
        System.out.println("The jdk serialization result length is " + b.length);
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("The byte array serialization result length is " + info.codeC().length);
    }

    public static void testPerformance(UserInfo info) throws IOException {
        int loop = 1000000;
        ByteArrayOutputStream bos;
        ObjectOutputStream oos;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(info);
            oos.flush();
            oos.close();
            byte[] b = bos.toByteArray();
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The jdk serialization cost time is " + (endTime - startTime));

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = info.codeC(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The byte array cost time is " + (endTime - startTime));
    }
}
