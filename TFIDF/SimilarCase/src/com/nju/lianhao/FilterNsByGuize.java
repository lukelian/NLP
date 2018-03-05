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
		
		Pattern pattern = Pattern.compile("机关(.*省){0,1}(.*市){0,1}(.*区){0,1}(.*县){0,1}.*(人民检察院|法院)");
		
		String pathRead = "C:\\Users\\SkyFucker\\Desktop\\BDCI\\dataset\\train.txt";
		String pathCopy = "D:\\研究生\\28.类案推荐论文\\guize\\location_by_guize.txt";
		
		File fileRead = new File(pathRead);
		File fileCopy = new File(pathCopy);
		BufferedReader buff = new BufferedReader(new InputStreamReader(new FileInputStream(fileRead), "UTF-8"));
		FileOutputStream fileOut = new FileOutputStream(fileCopy);
		
		String str1 = "179664	公诉机关湖南省南县人民检察院。被告人刘某因涉嫌犯开设赌场罪，经南县公安局决定，2014年7月24日被取保候审；经南县人民检察院决定，同年8月28日被继续取保候审；经本院决定，2014年10月10日被取保候审；现在居住地候审。被告人周某某因涉嫌犯开设赌场罪，经南县公安局决定，2014年7月24日被取保候审；经南县人民检察院决定，同年8月28日被继续取保候审；经本院决定，2014年10月10日被取保候审；现在居住地候审。南县人民检察院以南检刑诉（2014）239号起诉书指控被告人刘某、周某某涉嫌犯开设赌场罪，于2014年10月10日向本院提起公诉。本院依法适用简易程序，实行独任审判，公开开庭审理了本案。南县人民检察院指派代理检察员李磊出庭支持公诉，被告人刘某、周某某到庭参加了诉讼。本案现已审理终结。南县人民检察院起诉指控：2014年4月17日至2014年7月23日期间，被告人刘某、周某某伙同熊伏元（在逃）在南县南洲镇业旺街”聚贤楼”门面内摆设九台麻将机，采取打”转麻将”的形式开设赌场。被告人刘某、周某某负责赌场内抽取水资等日常经营活动。赌场每天招揽约20余人进行赌博，并从中抽头渔利，非法获利9.7万余元。刘某、周某某各分得赃款1.9万元。2014年7月23日，被告人刘某、周某某经公安机关传唤到案后，如实供认了上述罪行。案发后，公安机关已分别追缴被告人刘某、周某某违法所得人民币各1万元。上述事实，被告人刘某、周某某在开庭审理过程中亦无异议，且有证人证言，证据保全决定书及证据保全清单、扣押笔录，检查笔录及现场照片，行政处罚决定书，被告人刘某、周某某的户籍资料、到案说明及其供述和辩解等证据证实，足以认定.";
		String str2 = "566174	罪犯宋某，男，1974年8月31日出生于安徽省安庆市，汉族，初中文化。现在福建省仓山监狱四分监区服刑。福建省晋江市人民法院于2013年12月10日作出（2013）晋刑初字第3489号刑事判决，以被告人宋某犯假冒注册商标罪，判处有期徒刑三年，并处罚金人民币二十二万元。宣判后，被告人不服，提出上诉。福建省泉州市中级人民法院于2014年2月12日作出（2014）泉刑终字第94号刑事裁定：驳回上诉，维持原判，并交付执行。执行机关福建省仓山监狱于2016年3月15日以该犯在服刑期间确有悔改表现，提出减刑建议书，报送本院审理。本院依法组成合议进行了审理，现已审理终结。经审理查明，罪犯宋某在服刑期间，能认罪悔罪，认真遵守法律法规及监规，接受教育改造；积极参加思想、文化和职业技术教育；积极参加劳动，努力完成劳动任务。2015年获监狱改造积极分子，确有悔改表现。以上事实有罪犯月评审表、年度评审表等证据证实。另查明，罪犯宋某本次缴纳罚金人民币22100元.";
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
