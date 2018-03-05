package Demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	
	public static boolean isChinese(String str) {
		String regEx = "^[\u4e00-\u9fa5]{0,}$";//[\u3002\uff1b\uff0c\uff1a\u201c\u201d\uff08\uff09\u3001\uff1f\u300a\u300b]
		String regEx2 = "\\nr";
		Pattern pat = Pattern.compile(regEx);
		Pattern pat2 = Pattern.compile(regEx2);
		Matcher matcher = pat.matcher(str);
		Matcher matcher2 = pat2.matcher(str);
		boolean flg = false;
		if (matcher.find()&&matcher2.find())
			flg = true;

		return flg;
	}
	
	public static void main(String[] args) {
		
		String s1 = "1324adf";
		String s2 = "¾ÝÅ¶¸½¼þÎå\\nr";
		String s3 = ",,";
		String s4 = "dfas";
		String s5 = "4465465";
		String s6 = "LJJLJ";
		
//		System.out.println(isChinese(s1));
//		System.out.println(isChinese(s2));
//		System.out.println(isChinese(s3));
//		System.out.println(isChinese(s4));
//		System.out.println(isChinese(s5));
//		System.out.println(isChinese(s6));
		
		String s = "fsfds/fsaf";
		System.out.println(s);
		String[] s9 = s.split("/");
		System.out.println(s9[0]);
		System.out.println(s9[1]);
		
//		double a = 0.000000000;
//		System.out.println(a==0);
//		
//		System.out.println("/z");
	}
}
