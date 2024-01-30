package com.hspedu.qqcommon;

/**
 * @author Solider
 * @version 1.0
 */
public class FileMessage extends Message {
    private String getterPath; // 需要向对方写入文件的路径
    private byte[] data; // 传送的文件数据

    public String getGetterPath() {
        return getterPath;
    }

    public void setGetterPath(String getterPath) {
        this.getterPath = getterPath;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
