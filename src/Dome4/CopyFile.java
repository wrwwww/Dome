package Dome4;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile extends IOException {
    //这是一个负责复制文件从A>>B的类
    byte[] byt;
    FileInputStream sor;
    FileOutputStream aim;

     CopyFile(String sorFileName, String aimFileName) {
        //初始化各对象
        byt = new byte[1024 * 2];
        int len=0;
        //mak.createNewFile("c://",aimFileName);
        try {
            sor = new FileInputStream(sorFileName);
            aim = new FileOutputStream(aimFileName);
            while ((sor.read(byt)) != -1){
                aim.write(byt);
            }
            sor.close();
            aim.close();
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}
