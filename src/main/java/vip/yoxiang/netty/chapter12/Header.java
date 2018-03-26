package vip.yoxiang.netty.chapter12;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Rivers
 * Date: 2018/3/26 21:19
 */
public final class Header {

    private int crcCode = 0xabef0101;
    private int length;
    private long sessionId;
    private byte type;
    private byte priority;
    private Map<String, Object> attachment = new HashMap<>();

    public final int getCrcCode() {
        return crcCode;
    }

    public final void setCrcCode(int crcCode) {
        this.crcCode = crcCode;
    }

    public final int getLength() {
        return length;
    }

    public final void setLength(int length) {
        this.length = length;
    }

    public final long getSessionId() {
        return sessionId;
    }

    public final void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public final byte getType() {
        return type;
    }

    public final void setType(byte type) {
        this.type = type;
    }

    public final byte getPriority() {
        return priority;
    }

    public final void setPriority(byte priority) {
        this.priority = priority;
    }

    public final Map<String, Object> getAttachment() {
        return attachment;
    }

    public final void setAttachment(Map<String, Object> attachment) {
        this.attachment = attachment;
    }

    public String toString() {
        return "Header [crcCode=" + crcCode + ", length=" + length + ", sessionID=" +
                sessionId + ", type=" + type + ", priority=" + priority + ", attachment=" +
                attachment + "]";
    }
}
