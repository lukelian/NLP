package classify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reduction {
	String pathTarget = null;
	String pathCommon = null;
	String pathCopy = null;
	
	public Reduction(String pathTarget, String pathCommon, String pathCopy){
		this.pathTarget = pathTarget;
		this.pathCommon = pathCommon;
		this.pathCopy = pathCopy;
	}
	
	public void CutSameLine() throws IOException{
		File fileTarget = new File(pathTarget);
		File fileCommon = new File(pathCommon);
		File fileCopy = new File(pathCopy);
		
		if(!fileCopy.exists()) fileCopy.createNewFile();
		FileReader fileReaderTarget = new FileReader(fileTarget);
		FileReader fileReaderCommon = new FileReader(fileCommon);
		BufferedReader bufferedReaderTarget = new BufferedReader(fileReaderTarget);
		BufferedReader bufferedReaderCommon = new BufferedReader(fileReaderCommon);
		
		FileOutputStream fileOutputStream = new FileOutputStream(fileCopy);
		
		String line = null;
		ArrayList<String[]> target = new ArrayList<String[]>();
		ArrayList<String[]> common = new ArrayList<String[]>();
		
		while((line = bufferedReaderTarget.readLine())!=null){
			String[] lineSplit = line.split(" ");
			target.add(lineSplit);
		}
		bufferedReaderTarget.close();
		
		while((line = bufferedReaderCommon.readLine())!=null){
			String[] lineSplit = line.split(" ");
			common.add(lineSplit);
		}
		bufferedReaderCommon.close();
		
		for(int i = 0;i<target.size();i++){
			String[] targetLine = target.get(i);
			for(int j = 0;j<common.size();j++){
				String[] commonLine = common.get(j);
				if(target.get(i).length!=common.get(j).length){
					break;
				}else{
					int flag = 0;
					for(int k = 0;k<targetLine.length;k++){
						if(!targetLine[k].equals(commonLine[k])){
							flag = 1;
							break;
						}
					}
					if(flag == 1){
						continue;
					}else{
						target.remove(i);
						break;
					}
				}
			}
		}
		
		for(int i = 0;i<target.size();i++){
			String[] targetLine = target.get(i);
			for(int j = 0;j<targetLine.length;j++){
				fileOutputStream.write((targetLine[j] + " ").getBytes("UTF-8"));
			}
			fileOutputStream.write(System.getProperty("line.separator").getBytes("UTF-8"));
		}
		fileOutputStream.close();
	}
}
