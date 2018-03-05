package yun;

import java.io.File;
import java.io.IOException;

public class RunLink {
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] commodityList = getFileName("D:\\研究生\\23.云计算大作业\\数据预处理1\\distance_n_adj");
		
		for(int i = 0;i<commodityList.length;i++){
			String pathRead = "D:\\研究生\\23.云计算大作业\\数据预处理1\\distance_n_adj\\" + commodityList[i];
			String pathCopy = "D:\\研究生\\23.云计算大作业\\数据预处理1\\link_n_adj_0.8\\" + commodityList[i];
			Link link = new Link(pathRead, pathCopy);
			link.LinkFile();
		}
		
		
	}
}
