package yun;

import java.io.File;
import java.io.IOException;

import Demo.WordBag;

public class WordBagConstruction {
	
	//读取所有文件列表
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] fileList = getFileName("D:\\研究生\\23.云计算大作业\\数据预处理1\\word_all_n_adj");
		for(int i = 0;i<fileList.length;i++){
			String pathRead = "D:\\研究生\\23.云计算大作业\\数据预处理1\\word_all_n_adj\\"+fileList[i];
			String pathCopy = "D:\\研究生\\23.云计算大作业\\数据预处理1\\wordbag_n_adj\\"+fileList[i];
			WordBag wordbag = new WordBag(pathRead, pathCopy);
			wordbag.List();
		}
	}
}

