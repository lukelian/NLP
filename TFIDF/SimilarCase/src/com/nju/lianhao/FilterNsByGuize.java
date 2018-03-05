package com.nju.lianhao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterNsByGuize {
	
	public static void main(String[] args) throws IOException {
		
		Pattern pattern = Pattern.compile("����(.*ʡ){0,1}(.*��){0,1}(.*��){0,1}(.*��){0,1}.*(������Ժ|��Ժ)");
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		String pathCopy = "D:\\�о���\\28.�స�Ƽ�����\\guize\\location_by_guize.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String str1 = "179664	���߻��غ���ʡ����������Ժ����������ĳ�����ӷ�����ĳ�������ع����־�����2014��7��24�ձ�ȡ�����󣻾�����������Ժ������ͬ��8��28�ձ�����ȡ�����󣻾���Ժ������2014��10��10�ձ�ȡ���������ھ�ס�غ��󡣱�������ĳĳ�����ӷ�����ĳ�������ع����־�����2014��7��24�ձ�ȡ�����󣻾�����������Ժ������ͬ��8��28�ձ�����ȡ�����󣻾���Ժ������2014��10��10�ձ�ȡ���������ھ�ס�غ�������������Ժ���ϼ����ߣ�2014��239��������ָ�ر�������ĳ����ĳĳ���ӷ�����ĳ����2014��10��10����Ժ�����ߡ���Ժ�������ü��׳���ʵ�ж������У�������ͥ�����˱���������������Ժָ�ɴ�����Ա���ڳ�֧ͥ�ֹ��ߣ���������ĳ����ĳĳ��ͥ�μ������ϡ��������������սᡣ����������Ժ����ָ�أ�2014��4��17����2014��7��23���ڼ䣬��������ĳ����ĳĳ��ͬ�ܷ�Ԫ�����ӣ�������������ҵ���֡�����¥�������ڰ����̨�齫������ȡ��ת�齫������ʽ����ĳ�����������ĳ����ĳĳ����ĳ��ڳ�ȡˮ�ʵ��ճ���Ӫ����ĳ�ÿ������Լ20���˽��жĲ��������г�ͷ�������Ƿ�����9.7����Ԫ����ĳ����ĳĳ���ֵ��߿�1.9��Ԫ��2014��7��23�գ���������ĳ����ĳĳ���������ش�����������ʵ�������������С������󣬹��������ѷֱ�׷�ɱ�������ĳ����ĳĳΥ����������Ҹ�1��Ԫ��������ʵ����������ĳ����ĳĳ�ڿ�ͥ����������������飬����֤��֤�ԣ�֤�ݱ�ȫ�����鼰֤�ݱ�ȫ�嵥����Ѻ��¼������¼���ֳ���Ƭ���������������飬��������ĳ����ĳĳ�Ļ������ϡ�����˵�����乩���ͱ���֤��֤ʵ�������϶�.";
		String str2 = "566174	�ﷸ��ĳ���У�1974��8��31�ճ����ڰ���ʡ�����У����壬�����Ļ������ڸ���ʡ��ɽ�����ķּ������̡�����ʡ����������Ժ��2013��12��10��������2013�����̳��ֵ�3489�������о����Ա�������ĳ����ðע���̱���д�����ͽ�����꣬������������Ҷ�ʮ����Ԫ�����к󣬱����˲�����������ߡ�����ʡȪ�����м�����Ժ��2014��2��12��������2014��Ȫ�����ֵ�94�����²ö����������ߣ�ά��ԭ�У�������ִ�С�ִ�л��ظ���ʡ��ɽ������2016��3��15���Ը÷��ڷ����ڼ�ȷ�лڸı��֣�������̽����飬���ͱ�Ժ������Ժ������ɺ���������������������սᡣ������������ﷸ��ĳ�ڷ����ڼ䣬���������������ط��ɷ��漰��棬���ܽ������죻�����μ�˼�롢�Ļ���ְҵ���������������μ��Ͷ���Ŭ������Ͷ�����2015����������������ӣ�ȷ�лڸı��֡�������ʵ���ﷸ����������������֤��֤ʵ����������ﷸ��ĳ���ν��ɷ��������22100Ԫ.";
		Matcher matcher1 = pattern.matcher(str1);
		Matcher matcher2 = pattern.matcher(str2);
		if(matcher1.find()){
			System.out.println(matcher1.group(1) + matcher1.group(2) + matcher1.group(3) + matcher1.group(4));
		}
		if(matcher2.find()){
			System.out.println(matcher2.group(1));
		}
		
		/*
		String line = null;
		while((line = buff.readLine())!=null){
			String[] lineSplit = line.split("\t");
			String location = null;
			if(lineSplit.length == 4){
				String s = lineSplit[1];
				Matcher matcher = pattern.matcher(s);
				if(matcher.find()){
					location = matcher.group(2) + matcher.group(3) + matcher.group(4) + matcher.group(5);
				}
			}
			if(location!=null){
				fileOut.write((lineSplit[0] + " " + location + " " + lineSplit[2] + " " + lineSplit[3]).getBytes("UTF-8"));
				fileOut.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			}
		}
		*/
		
		buff.close();
		fileOut.close();
		
	}

}
