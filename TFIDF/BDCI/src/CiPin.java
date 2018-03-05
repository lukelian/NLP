import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.InputMap;


public class CiPin {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String pathRead = "D:\\研究生\\28.类案推荐论文\\wordmap.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\wordmap_sorted.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		Map<String, Integer> map = new TreeMap<String, Integer>();
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(" ");
			if(lineSplit.length==2){
				map.put(lineSplit[0].trim(), Integer.parseInt(lineSplit[1].trim()));
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
