package Demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CalIDF {
	
	public void IDF(String TFMatrix) throws IOException{
		String pathTFMatrix = TFMatrix;
		File fileTFMatrix = new File(TFMatrix);
		FileInputStream fileReaderTFMatrix = new FileInputStream(fileTFMatrix);
		InputStreamReader inputStreamTFMatrix = new InputStreamReader(fileReaderTFMatrix);
		BufferedReader buffReaderTFMatrix = new BufferedReader(inputStreamTFMatrix);
	}
	
}
