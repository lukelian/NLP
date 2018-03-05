package com.nju.preprocessing;

import java.io.IOException;

public class RunReductionByCixing {
	public static void main(String[] args) throws IOException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail_fenci.txt";
		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\law\\law_detail_fenci_reduction.txt";
//		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\fenci_all.txt";
//		String pathCopy = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\fenci\\fenci_all_reduction_by_cixing.txt";
		ReductionByCixing re = new ReductionByCixing(pathRead, pathCopy);
		re.Cal();
	}
}
