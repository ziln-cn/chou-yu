package com.hubstc.lottery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileinfoUtils {
	public static void getFileInfo(int personType) throws IOException{
		//根据用户类型判断，读文件的路径
		String filePath="/res/";
		
		if(personType==Person.TYPE_STUDENT){
			filePath=filePath+"student.txt";
		}else if(personType==Person.TYPE_TEACHER){
			filePath=filePath+"teacher.txt";
		}
		
		URL url = MainFrameApp.class.getResource(filePath);
        File file = new File(url.getPath()); // 反射指定文件路径
        
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line); // 输出每一行的内容
            }
            in.close();
	    
	}
}
