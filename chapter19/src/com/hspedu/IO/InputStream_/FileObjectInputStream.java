package com.hspedu.IO.InputStream_;

import com.hspedu.IO.OutputStream_.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * @author Solider
 * @version 1.0
 * 使用ObjectInputStream反序列化文件
 */
public class FileObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath = "D:\\data.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath));
        // 进行反序列化读取操作时，需要按照顺序读取
        // 如果将序列化中的文件进行修改，则需要重新进行序列化，才能进行反序列化
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readUTF());
        Object obj = objectInputStream.readObject();

        System.out.println(obj);
        // 进行反序列化操作时，如果序列化时属性被定义为：static, transient
        // 执行为null，表示不被读取 <==> 不被反序列化

        Dog dog = (Dog) obj;
        // 如果需要使用到dog类中的方法，则需要将 公有的Dog类导入到本程序中
        System.out.println(dog.getName());
        objectInputStream.close();
    }
}