package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutApp {
	
	public static final CharSequence[] s = {"爱逛街","网易云音乐","图个乐","SE-1800移动APP","优播客"};
	public static int count = 0;
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void copyFile(String src,String obj) throws IOException{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(obj);
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			int b;
			while((b = fis.read())!=-1){
				fos.write(b);
			}
		} catch (Exception e) {
			System.out.println("失败~");
		}
		fis.close();
		fos.close();
		
	}
	
	public static void createFile(String path, String newFileName){
		File f = new File(path);
		if(!f.exists()){
			f.mkdir();
		}
		
		File file = new File(f,newFileName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void readTxtFile(String filePath, String str){
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	for(int i = 0;i<s.length;i++){
                    		if(lineTxt.contains(s[i])){
                                createFile("E:\\" + s[i], str + ".txt");
                                copyFile(filePath, "E:\\"+s[i]+"\\"+str+".txt");
                                break;
                            }
                    	}	
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        
    }
	
	public static void main(String[] args) {
		String[] str = getFileName("E:\\events");
		for(int i = 0;i<str.length;i++){
			readTxtFile("E:\\events\\" + str[i] + "\\kikAccessibility.txt", str[i]);
			count++;
			
		
		}
	}
}



















