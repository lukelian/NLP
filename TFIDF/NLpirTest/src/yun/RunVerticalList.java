package yun;

import java.io.File;
import java.io.IOException;

public class RunVerticalList {
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		String[] fileList = getFileName("D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\word_all_n_adj");
		for(int i = 0;i<fileList.length;i++){
			String pathRead = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\word_all_n_adj\\" + fileList[i];
			String pathCopy = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\vertical_n_adj_0.6\\" + fileList[i];
			VerticalList verticalList = new VerticalList(pathRead, pathCopy);
			verticalList.Vertical();
		}
	}

}
