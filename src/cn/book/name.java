package cn.book;

import java.io.*;

public class name {
    public static void main(String[] args)throws IOException {
        //在指定文件夹扫描,找到图书的信息
//        Scanner b = new Scanner(System.in);
//
//
//        System.out.println("请输入创建的名字");
//        String f=b.nextLine();
//        File in=new File("F:\\"+f);
//        //创建文件夹
//        try {
//            System.out.println("mkdir:" + in.createNewFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("是否删除y/n");
//
//        switch (b.nextLine()) {
//            case "y" -> System.out.println("delete:" + in.delete());
//            case "n" -> System.out.println("好的!!!");
//        }

        //获取目录文件
        File ff = new File("F:\\");
        File[] files = ff.listFiles();
        int i = 0;
        assert files != null;
        int gh = files.length;
        for (File filss:files) {
            System.out.println(i+". "+filss.getName());
            i++;
        }
        System.out.println("想获取几号文件");

//重命名文件
//        File w = new File("F:\\a.txt");
//        File www = new File("F:\\e\\");
        File r = new File("F:\\e\\book.jpg");
        File b = new File("F:\\book.jpg");
        //新建文件夹及文件夹
//        w.createNewFile();
//        www.mkdirs();
////        移动指定文件到指定文件夹
//        w.renameTo(r);
        //字节流
        FileInputStream inv = new FileInputStream(b);
        FileOutputStream out = new FileOutputStream(r);
        int c = (int) b.length();
        byte[] hh = new byte[c];

        System.out.println("读写:" + inv.read(hh));
        //字符流
        FileReader read = new FileReader("F:\\");

        out.write(hh);
        out.close();
        inv.close();



        //选择指定的文件开始相应的操作
        //重命名新书的文佳夹图片
        //b.close();
    }
}
