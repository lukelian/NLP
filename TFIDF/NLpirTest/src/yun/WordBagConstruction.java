package yun;

import java.io.File;
import java.io.IOException;

import Demo.WordBag;

public class WordBagConstruction {
	
	//��ȡ�����ļ��б�
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] fileList = getFileName("D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\word_all_n_adj");
		for(int i = 0;i<fileList.length;i++){
			String pathRead = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\word_all_n_adj\\"+fileList[i];
			String pathCopy = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\wordbag_n_adj\\"+fileList[i];
			WordBag wordbag = new WordBag(pathRead, pathCopy);
			wordbag.List();
		}
	}
}

