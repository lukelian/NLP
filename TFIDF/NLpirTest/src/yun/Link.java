package yun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Link {
	
	private String pathRead = null;
	private String pathCopy = null;
	
	public Link(String pathRead, String pathCopy) {
		this.pathCopy = pathCopy;
		this.pathRead = pathRead;
	}
	
	public void LinkFile() throws IOException {
		
		File fileRead = new File(this.pathRead);
		File fileCopy = new File(this.pathCopy);
		if(!fileCopy.exists()) fileCopy.createNewFile();
		
		FileOutputStream outputFile = new FileOutputStream(fileCopy);
		
		FileInputStream inputFile = new FileInputStream(fileRead);
		InputStreamReader inputStream = new InputStreamReader(inputFile);
		BufferedReader buffReader = new BufferedReader(inputStream);	
		
		ArrayList<Map<String, String>> relation = new ArrayList<Map<String, String>>();
		
		String line = null;
		while((line = buffReader.readLine())!=null){
			String[] lineSplit = line.split(" ");
			//arraylist序号是from节点序号，第一个String代表to节点序号，第二个String是这条边的weight
//			ArrayList<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
			Map<String, String> filter = new HashMap<String, String>();
			for(int i = 0;i<lineSplit.length;i++){
				if(Double.valueOf(lineSplit[i])<0.8&&Double.valueOf(lineSplit[i])!=0){
					filter.put(String.valueOf(i), lineSplit[i]);
				}
//				mapList.add(filter);
			}
			relation.add(filter);
		}
		buffReader.close();
		
		for(int i = 0;i<relation.size();i++){
//			ArrayList<Map<String, String>> temp = new ArrayList<Map<String, String>>();
			Map<String, String> map = relation.get(i);
			Iterator iter = map.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry entry = (Map.Entry) iter.next();
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				outputFile.write((String.valueOf(i) + "," + key + "," + value).getBytes("UTF-8"));
				outputFile.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
			
		}
		outputFile.close();
	}
}
