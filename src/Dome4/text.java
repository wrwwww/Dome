package Dome4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class text {
    public static void main(String[] args) throws IOException {
        //哈希函数
//        hash x = new hash();
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("博看书苑-书籍整合工具");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("输入书籍名称");

        Scanner input = new Scanner(System.in);
        String fileName = input.next();
        File book = new File("F://", fileName);
        //System.out.println("mkdir:"+book.mkdir());

        input.close();
        try {
            System.out.println("file creat:" + book.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("del:" + book.delete());
        /*
把a文件夹里的文件与文本匹配
        然后按照顺序重新命名
        并移动到新文件夹
        File file7 = new File("F:\\aaa\\bbb\\ccc.txt");
        System.out.println("mkdir:" + file7.mkdir()); //false
        File file = new File("aaa\\bbb\\b.txt");

        System.out.println("getAbsolutePath:" + file.getAbsolutePath());
        System.out.println("getPath:" + file.getPath());
        System.out.println("getName:" + file.getName());
        System.out.println("length:" + file.length());
        System.out.println("lastModified:" + file.lastModified());

        // 1428044959288
        Date d = new Date(1428044959288L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);
        File file = new File("d:\\");
 public String[] list():返回的是给定目录下的所有文件或者文件夹的名称数组。
        String[] strArray = file.list();
        for (String str : strArray) {
            System.out.println(str);
        }
*/
//      创建字节流
        FileInputStream fis;
        fis = new FileInputStream("F://329814.txt");

//      创建字符数组用来存字符串或者字节
        byte[] bys = new byte[1024];
        int len=0;
//      将数据读到字节数组
//        while ((len = fis.read(bys)) != -1) {
//
//            //String tree = new String(bys, 0, len);
//            //System.out.println("string:" + tree);
//        }
//        fis.close();

//        尝试复制文件
//        创建对象
        FileOutputStream copy = new FileOutputStream("F://"+fileName);
        while ((len = fis.read(bys)) != -1) {
            copy.write(bys);
        }
        fis.close();
        copy.close();
        System.out.println("操作完成！！！");
    }
}
