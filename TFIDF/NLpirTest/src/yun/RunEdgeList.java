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
		String[] fileList = getFileName("D:\\研究生\\23.云计算大作业\\数据预处理1\\link_n_adj_0.6");
		for(int i = 0;i<fileList.length;i++){
			String pathRead = "D:\\研究生\\23.云计算大作业\\数据预处理1\\link_n_adj_0.6\\" + fileList[i];
			String pathCopy = "D:\\研究生\\23.云计算大作业\\数据预处理1\\edgelist_n_adj_0.6\\" + fileList[i];
			EdgeList edgeList = new EdgeList(pathRead, pathCopy);
			edgeList.CalEdgeList();
		}
	}
}
