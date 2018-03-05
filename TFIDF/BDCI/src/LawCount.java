import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class LawCount {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\train_law.txt";
		File fileRead = new File(pathRead);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split(",");
			if(map.containsKey(lineSplit.length)){
				int temp = map.get(lineSplit.length);
				temp = temp + 1;
				map.put(lineSplit.length, temp);
			} else{
				map.put(lineSplit.length, 1);
			}
		}
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Entry) iter.next();
			int key = (int) entry.getKey();
			int value = (int) entry.getValue();
			System.out.println(String.valueOf(key) + ":  " + String.valueOf(value));
		}
		buff.close();
	}
}
