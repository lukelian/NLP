package com.nju.lianhao;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.URL;  
import java.net.URLEncoder;  
import java.util.HashMap;  
import java.util.Map;

import org.apache.commons.lang3.StringUtils;  

public class Latitude {
	
public static final String KEY_1 = "y6wLxNTVqRQ4njwMNSp8L3xgQBRHtkpp";

	/**
	 * ���������ַ�ľ�γ������
	 * key lng(����),lat(γ��)
	 */
	public static Map<String,String> getGeocoderLatitude(String address){
		BufferedReader in = null;
		try {
			//����ַת����utf-8��16����
			address = URLEncoder.encode(address, "UTF-8");
//       ����д���Ҫ���ô���û�����ע��
//		System.setProperty("http.proxyHost","192.168.1.188");
//		System.setProperty("http.proxyPort","3128");
			URL tirc = new URL("http://api.map.baidu.com/geocoder?address="+ address +"&output=json&key="+ KEY_1);
			
			in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));
			String res;
			StringBuilder sb = new StringBuilder("");
			while((res = in.readLine())!=null){
				sb.append(res.trim());
			}
			String str = sb.toString();
			Map<String,String> map = null;
			if(StringUtils.isNotEmpty(str)){
				int lngStart = str.indexOf("lng\":");
				int lngEnd = str.indexOf(",\"lat");
				int latEnd = str.indexOf("},\"precise");
				if(lngStart > 0 && lngEnd > 0 && latEnd > 0){
					String lng = str.substring(lngStart+5, lngEnd);
					String lat = str.substring(lngEnd+7, latEnd);
					map = new HashMap<String,String>();
					map.put("lng", lng);
					map.put("lat", lat);
					return map;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		Map<String, String> json = Latitude.getGeocoderLatitude("����Ȫ�ݰ�Ϫ��ͷ����Ȫ�ݸ���Ȫ��");  
		//        ��Ϫ    
        System.out.println("lng : "+json.get("lng"));
        System.out.println("lat : "+json.get("lat"));
		
	}
	

}
