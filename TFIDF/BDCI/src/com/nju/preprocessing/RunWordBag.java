package com.nju.preprocessing;

import java.io.FileNotFoundException;
import java.io.IOException;

public class RunWordBag {
	public static void main(String[] args) throws IOException {
		String pathAllCases = "D:\\研究生\\20.CCF比赛\\detail\\detail_all_fenci_with_cixing.txt";
		String pathAllCasesCopy = "D:\\研究生\\20.CCF比赛\\wordbag\\wordbag.txt";
		WordBag wordBag = new WordBag(pathAllCases, pathAllCasesCopy);
		
		wordBag.List();
	}
}
