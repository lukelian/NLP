package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Test {
	public static void main(String[] args) throws IOException {
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\human_filter\\法律总目_案由_罪行\\crime_done.txt";
		File fileRead = new File(pathRead);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		System.out.println(buff.readLine());
		buff.close();
	}
}
