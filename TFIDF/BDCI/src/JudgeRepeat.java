import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class JudgeRepeat {
	public static void main(String[] args) throws IOException {
		String pathTrainSerial = "D:\\研究生\\20.CCF比赛\\detail\\train_serial.txt";
		String pathTestSerial = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset_split\\train_serial.txt";
		File fileTrainSerial = new File(pathTrainSerial);
		File fileTestSerial = new File(pathTestSerial);
		BufferedReader buffTrainSerial = new BufferedReader(new InputStreamReader(new FileInputStream(fileTrainSerial)));
		BufferedReader buffTestSerial = new BufferedReader(new InputStreamReader(new FileInputStream(fileTestSerial)));
		ArrayList<String> arrTrain = new ArrayList<String>();
		ArrayList<String> arrTest = new ArrayList<String>();
		
		String[] lineTrain = buffTrainSerial.readLine().split(" ");
		for(int i = 0;i<lineTrain.length;i++){
			arrTrain.add(lineTrain[i].trim());
		}
		String[] lineTest = buffTestSerial.readLine().split(" ");
		for(int i = 0;i<lineTest.length;i++){
			arrTest.add(lineTest[i].trim());
		}
		buffTrainSerial.close();
		buffTestSerial.close();
		arrTest.retainAll(arrTrain);
		System.out.println(arrTest.size());
	}

}
