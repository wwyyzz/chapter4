package com.smart.resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.*;

public class FileSourceExample {

    public static void main(String[] args){
        try{
            String filePath = "/home/navy/IdeaProjects/masterSpring/code/chapter4/src/main/resources/conf/file1.txt";
            //1. 使用系统文件路径方式加载文件
            WritableResource res1 = new PathResource(filePath);

            //2. 使用类路径方式加载文件
            Resource res2 = new ClassPathResource("conf/file1.txt");

            //3. 使用WritableResource接口写资源文件
            OutputStream stream1 = res1.getOutputStream();
            stream1.write("welcome to your BBS".getBytes());
            stream1.close();

            //4. 使用Resource接口读资源文件
            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while((i=ins1.read()) != -1) {
                baos.write(i);
            }
            System.out.println(baos.toString());
            System.out.println("res1:" + res1.getFilename());
            System.out.println("res2:" + res2.getFilename());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
