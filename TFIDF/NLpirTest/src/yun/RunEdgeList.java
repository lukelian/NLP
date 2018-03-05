package yun;

import java.io.File;
import java.io.IOException;

public class RunEdgeList {
	
	public static String[] getFileName(String path){
		File file = new File(path);
		String[] fileName = file.list();
		return fileName;
	}
	
	public static void main(String[] args) throws IOException {
		String[] fileList = getFileName("D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\link_n_adj_0.6");
		for(int i = 0;i<fileList.length;i++){
			String pathRead = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\link_n_adj_0.6\\" + fileList[i];
			String pathCopy = "D:\\�о���\\23.�Ƽ������ҵ\\����Ԥ����1\\edgelist_n_adj_0.6\\" + fileList[i];
			EdgeList edgeList = new EdgeList(pathRead, pathCopy);
			edgeList.CalEdgeList();
		}
	}
}
