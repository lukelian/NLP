package Demo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RunWordBag {
	public static void main(String[] args) throws IOException {
		String pathAllCases = "D:\\data\\fenci_all_with_cixing.txt";
		String pathAllCasesCopy = "D:\\data\\word_bag_with_cixing.txt";
		WordBag wordBag = new WordBag(pathAllCases, pathAllCasesCopy);
		
		wordBag.List();
	}
}
