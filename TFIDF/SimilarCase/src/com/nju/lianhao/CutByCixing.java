package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutByCixing {
	
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
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\detail_train.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\fenci\\fenci_reduction_cixing_stopwords.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		String line = null;
		String matchStr = ".*(/n|/vn|/nt|/ns|/v|/a|/ad|/an|/d|/f|/i|/j|/l|/m|/nz|/q|/r|/s|/t|/vd|/z)";
		Map<String, Integer> map = new TreeMap<String, Integer>();
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				String word = lineSplit[i];
				if(word.contains("/")){
					String chinese = word.substring(0, word.lastIndexOf("/"));
					if(word.matches(matchStr)&&chinese.trim().length()>1){
						if(map.containsKey(word)){
							int value = map.get(word);
							value = value + 1;
							map.put(word, value);
						}else{
							int value = 1;
							map.put(word, value);
						}
					}
				}
			}
		}
		Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		};
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list, valueComparator);
		for(Map.Entry<String, Integer> entry: list){
			fileOut.write((entry.getValue() + " " + entry.getKey()).getBytes("UTF-8"));
			fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		buff.close();
		fileOut.close();
	}
}
