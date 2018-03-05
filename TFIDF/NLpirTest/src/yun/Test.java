package yun;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nlp_interface.CLibrary;

import com.google.gson.Gson;
import com.sun.jna.Native;

public class Test {

	static String pathRead = "D:\\data\\phones.json";
	
	public static boolean isChinese(String str) {
		String regEx = "^[\u4e00-\u9fa5]{0,}$";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find())
			flg = true;

		return flg;
	}

	public static void main(String[] args) throws IOException {

		File file = new File(pathRead);
		
		
		FileInputStream inputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = null;
		Gson gson = new Gson();
		CLibrary instance = (CLibrary)Native.loadLibrary(System.getProperty("user.dir")+"\\source\\NLPIR", CLibrary.class);
		int init_flag = instance.NLPIR_Init("", 1, "0");
		String resultString = null;
		if(0 == init_flag){
			resultString = instance.NLPIR_GetLastErrorMsg();
			System.err.println("初始化失败！\n"+resultString);
			return;
		}
		
		int i = 0;
		while ((line = bufferedReader.readLine()) != null) {
			// System.out.println(line);
			//创建文件
			Comments comments = gson.fromJson(line, Comments.class);
			System.out.println(i++ + ":" + comments.getComments().size());
			String fileName = comments.getId();
			String pathCopy = "D:\\data\\"+fileName+".txt";
			String pathCopyTime = "D:\\data2\\"+fileName+".txt";
			String pathContentTimeSplit = "D:\\data3\\"+fileName+".txt";
			String pathContentReduction = "D:\\data4\\"+fileName+".txt";
			File fileCopy = new File(pathCopy);
			File fileCopyTime = new File(pathCopyTime);
			File fileContentTimeSplit = new File(pathContentTimeSplit);
			File fileContentReduction = new File(pathContentReduction);
			if(!fileCopy.exists()){fileCopy.createNewFile();}
			if(!fileCopyTime.exists()){fileCopy.createNewFile();}
			if(!fileContentTimeSplit.exists()){fileContentTimeSplit.createNewFile();}
			if(!fileContentReduction.exists()){fileContentReduction.createNewFile();}
			
			FileOutputStream lineOut = new FileOutputStream(fileCopy);
			FileOutputStream lineOutTime = new FileOutputStream(fileCopyTime);
			FileOutputStream lineContentTimeSplit = new FileOutputStream(fileContentTimeSplit);
			FileOutputStream lineContentReduction = new FileOutputStream(fileContentReduction);
			//创建某商品的评论List
			java.util.List<Comment> comment = comments.getComments();
			for(int j = 0;j<comment.size();j++){
				
				HashSet<String> wordBag = new HashSet<String>();
				ArrayList<String> wordBag_with_Dumplicate = new ArrayList<String>();
				
				String content = comment.get(j).getContent();
				String contentTime = comment.get(j).getCreateTime();
				String[] contentTimeSplit = contentTime.split(" ");
				String contentWithoutLabel = instance.NLPIR_ParagraphProcess(content, 0);
				String contentWithLabel = instance.NLPIR_ParagraphProcess(content, 1);
				String[] contentWithLabelArray = contentWithLabel.split(" ");
				String[] contentWithoutLabelArray = contentWithoutLabel.split(" ");
				
				for(int k = 0;k<contentWithLabelArray.length;k++){
					String[] temp = contentWithLabelArray[k].split("/");
					if(temp.length==2){
						if((temp[1].contains("a")||temp[1].contains("n"))&&(isChinese(temp[0]))){
//						if((temp[1].contains("a"))&&(isChinese(temp[0]))){
//						if((temp[1].contains("n"))&&(isChinese(temp[0]))){
							wordBag.add(temp[0]);
							wordBag_with_Dumplicate.add(temp[0]);
						}
					}
				}
				
//				Iterator<String> iter = wordBag.iterator();
				Iterator<String> iter = wordBag_with_Dumplicate.iterator();
				while(iter.hasNext()){
					lineContentReduction.write((iter.next() + " ").getBytes("UTF-8"));
				}
				lineContentReduction.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				
				lineOut.write(contentWithoutLabel.getBytes("UTF-8"));
				lineOutTime.write(contentTime.getBytes("UTF-8"));
				lineContentTimeSplit.write(contentTimeSplit[0].getBytes("UTF-8"));
				lineOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				lineOutTime.write((System.getProperty("line.separator")).getBytes("UTF-8"));
				lineContentTimeSplit.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			lineOutTime.close();
			lineOut.close();
			lineContentTimeSplit.close();
			lineContentReduction.close();
		}
		bufferedReader.close();
	}
}
