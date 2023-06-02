package com.hubstc.listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileTest {

    public static void main(String[] args) throws IOException {
    	URL url = FileTest.class.getResource("/res/student.txt");
        File file = new File(url.getPath()); // 指定文件路径
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line); // 输出每一行的内容
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*      FileInputStream in = new FileInputStream(file);
        byte[] a=new byte[100];
        int n;
        while((n=in.read(a,0,100))!=-1){
        	String s = new String(a,0,100);
        	System.out.println(s);
        }
        in.close();
*/
    }
}
