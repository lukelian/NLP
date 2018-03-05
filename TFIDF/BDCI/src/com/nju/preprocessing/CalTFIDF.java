package com.nju.preprocessing;
/*
 * �޸�while((line = buffReaderSingleArticle.readLine())!=null)����ѭ���еķ�Χ
 * 
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CalTFIDF {
	//��Ϊ���
//	String pathMatrixSingleArticle = "D:\\data\\matrix_test_single_article.txt";
//	String pathLocateInfo = "D:\\data\\locate_info.txt";
//	//��Ϊ����
//	String pathAttribute = "D:\\data\\word_bag_only_hanzi2.txt";
//	String pathSingleArticle = "D:\\data\\test_all_fenci.txt";
	//��ֵ�б�
	int singleArticleNum = 0;
	int attributeNum = 0;
	//�����б�
	HashMap<String, Integer> attributes = new HashMap<String, Integer>();
	HashMap<String, Integer> attributesTemp = new HashMap<String, Integer>();
	//�ʳ��־���������������ƪ���³��֣���ô�ĵ����У�����ʶ�Ӧ���ĵ�����һ����������IDF
	HashMap<String, Integer> attributesApperanceNum = new HashMap<String, Integer>();
	
	ArrayList<String> idf = new ArrayList<String>();
	ArrayList<ArrayList<String>> listTF = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> listTFIDF = new ArrayList<ArrayList<String>>();
	ArrayList<String> listIDF = new ArrayList<String>();

//������ֵ��
//	public ArrayList<ArrayList<String>> TF(String pathAttribute, String pathSingleArticle, String pathMatrixSingleArticle) throws IOException {
//��������ֵ��
	public void TF(String pathAttribute, String pathSingleArticle, String pathMatrixSingleArticle, String pathAttributeOrder) throws IOException {
		
		File fileSingleArticle = new File(pathSingleArticle);
		File fileMatrixSingleArticle = new File(pathMatrixSingleArticle);
		File fileAttriFile = new File(pathAttribute);
		File fileAttributeOrder = new File(pathAttributeOrder);
		
		if(!fileMatrixSingleArticle.exists()) fileMatrixSingleArticle.createNewFile();
		if(!fileAttributeOrder.exists()) fileAttributeOrder.createNewFile();
		BufferedReader buffReaderSingleArticle = new BufferedReader(new InputStreamReader(new FileInputStream(fileSingleArticle), "UTF-8"));
		BufferedReader buffReaderAttribute = new BufferedReader(new InputStreamReader(new FileInputStream(fileAttriFile), "UTF-8"));
		FileOutputStream outputStream = new FileOutputStream(fileMatrixSingleArticle);
		FileOutputStream outputAttributeOrderStream = new FileOutputStream(fileAttributeOrder);
		int allWriteLineCount = 0;
		int count = 0;
		String line = null;
		//��ʼ��������ĳƪ�ĵ��г��ֵĴ�������
		while((line = buffReaderAttribute.readLine())!=null){
			//��ʼ����������
			
			//������Ե������������
			
			attributes.put(line, count);
			//���Դ�������Ҫ���������е�˳�򱣳�ͳһ
			attributesApperanceNum.put(line, count);
		}
		
		Iterator iterAttributeOrder = attributes.entrySet().iterator();
		while(iterAttributeOrder.hasNext()){
			Map.Entry entry = (Map.Entry)iterAttributeOrder.next();
			String attributeOrder = (String)entry.getKey();
			outputAttributeOrderStream.write(attributeOrder.getBytes("UTF-8"));
			outputAttributeOrderStream.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		outputAttributeOrderStream.close();
		
		this.attributeNum = this.attributes.size();
		//attributesTemp������ѭ������ʱ����attributes
		attributesTemp.putAll(attributes);
		//��������ѭ������
		int alreadyRead = 0;
		int wordCount = 0;
		while((line = buffReaderSingleArticle.readLine())!=null){
			
			if(alreadyRead>200) break;
			
			//ѭ������������������
			this.singleArticleNum = this.singleArticleNum + 1;
//			alreadyRead++;
//			if(alreadyRead<=5000) continue;
			
			String[] lineSplit = line.split(" ");
			//��ǰ���µ��ܴ���
//			this.attributeNum = lineSplit.length;  //�������
			wordCount = lineSplit.length;
			int total = 0;
			for(int i = 0;i<lineSplit.length;i++){
				String temp = lineSplit[i].trim();
				if(attributes.containsKey(temp)){
					//��ǰ���¾��е�����ֵ����
					total = total + 1;
					//������ƪ���µĴʵĳ��ִ����б�
					int attributeNum = attributes.get(temp) + 1;
					attributes.put(temp, attributeNum);
				}
			}
			
			//����tf�������
//			ArrayList<String> listTFLine = new ArrayList<String>();
			
			Iterator iter = attributes.entrySet().iterator();
			Iterator iter2 = attributesApperanceNum.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry entry = (Map.Entry)iter.next();
				Map.Entry entry2 = (Map.Entry)iter2.next();
				//��tf��һ����,ע��Ҫ�÷��ӷ�ĸ��Ϊdouble
				double attributeNum = Double.valueOf(String.valueOf((int) entry.getValue()))/(double)wordCount;
				/*
				if(attributeNum!=0){
					System.out.println(attributeNum);
				} 
				 */
				
				
				//û�й�һ����
//				double attributeNum = ((int) entry.getValue());
				//��Ƶ�εģ�û�й�һ��
				String attributeName = (String) entry.getKey();
				int attributeNumTemp = (int) entry.getValue();
				//������������ƪ���³��֣���ô�ĵ����У�����ʶ�Ӧ���ĵ�����һ����������IDF
				
				if(attributeNumTemp!=0){
					int temp = (int)entry2.getValue() + 1;
					this.attributesApperanceNum.put(attributeName, temp);
				}
				
				//����ƪ����ÿ���ʵļ�������������µĽ�����У���double
//				listTFLine.add(String.valueOf(attributeNum));
				//������Ǵ�������ƪ�����г��ֵĴ���
//				if(attributeNum!=0){
//					System.out.println(String.format("%.5f", attributeNum));
//				}
				outputStream.write((String.format("%.5f", attributeNum) + " ").getBytes("UTF-8"));
				
			}
			//�����м����ĵ���tf��
//			this.listTF.add(listTFLine);
			allWriteLineCount++;
			outputStream.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			//attributesTemp������ѭ������ʱ����attributes
			attributes.putAll(attributesTemp);
			
			
			
		}
		
		
		
		outputStream.close();
		buffReaderAttribute.close();
		buffReaderSingleArticle.close();
		System.out.println(allWriteLineCount);
//		return this.listTF;
	}


//������ֵ��
//	public ArrayList<String> IDF(){
//��������ֵ��
	public void IDF(String pathIDF) throws IOException{
//��ȡ���̵ķ���
		File fileIDF = new File(pathIDF);
		if(!fileIDF.exists()) fileIDF.createNewFile();
		FileOutputStream fileOut = new FileOutputStream(fileIDF);
		Iterator iter = attributesApperanceNum.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			String value = String.valueOf((int) entry.getValue());
			double num = Math.log(((double)this.singleArticleNum)/(Double.valueOf(value) + 1));
//			if(num!=0){
//				System.out.println(String.format("%.5f", num));
//			}
			this.idf.add(String.format("%.5f", num));
			this.listIDF.add(String.format("%.5f", num));
			fileOut.write((String.format("%.5f", num) + " ").getBytes("UTF-8"));
//			fileOut.write();
		}
		fileOut.close();
		
//�ŵ��ڴ�ķ���		
/*
		//�ĵ����ϵ�����ֵ����
		int attributeNum = this.attributeNum;
		//�ĵ������ĵ�����
		int articleNum = this.singleArticleNum;
		for(int i = 0;i<attributeNum;i++){
			int count = 0;
			for(int j = 0;j<articleNum;j++){
				//�����jƪ�����г����˴�i�����i�ĸ���+1
				if(Double.valueOf(this.listTF.get(j).get(i))!=0){
					count++;
				}
			}
			//����ô��µ����ĵ�Ƶ��
			double idf = Math.log(articleNum/(count + 1));
			//���ôʵ����ĵ�Ƶ�ʼ���ȫ�ּ�¼������
			this.listIDF.add(String.format("%.2f", idf));
		}
//		return this.listIDF;
*/
	}


//������ֵ��
//	public ArrayList<ArrayList<String>> TFIDF(String tfidfMatrix) throws IOException{
//��������ֵ��
	public void TFIDF(String pathTF, String tfidfMatrix) throws IOException{
		File tf = new File(pathTF);
		File fileTFIDFMatrix = new File(tfidfMatrix);
		if(!fileTFIDFMatrix.exists()) fileTFIDFMatrix.createNewFile();
		FileOutputStream outputTFIDFMatrix = new FileOutputStream(fileTFIDFMatrix);
		BufferedReader tfReader = new BufferedReader(new InputStreamReader(new FileInputStream(tf)));
		String line = null;
		
		//�ڴ���㷽��
		/*
		int articleNum = this.singleArticleNum;
		for(int i = 0;i<articleNum;i++){
//			ArrayList<String> tfidfLine = new ArrayList<String>();
			for(int j = 0;j<attributeNum;j++){
				double tfidf = Double.valueOf(listTF.get(i).get(j)) * Double.valueOf(listIDF.get(j));
//				tfidfLine.add(String.format("%.5f", tfidf));
				outputTFIDFMatrix.write((String.format("%.5f", tfidf) + " ").getBytes("UTF-8"));
			}
			outputTFIDFMatrix.write((System.getProperty("line.separator")).getBytes("UTF-8"));
//			this.listTFIDF.add(tfidfLine);
		}
		*/
		
		
		//���̶�ȡ�ķ���
		while((line = tfReader.readLine())!=null){
			String[] lineSplit = line.split(" ");
			for(int i = 0;i<lineSplit.length;i++){
				double singleTFIDF = Double.valueOf(lineSplit[i])*Double.valueOf(this.idf.get(i));
				outputTFIDFMatrix.write((String.format("%.5f", singleTFIDF) + " ").getBytes("UTF-8"));
//				if(singleTFIDF!=0){
//					System.out.println(String.valueOf(singleTFIDF));
//				}
			}
			outputTFIDFMatrix.write((System.getProperty("line.separator")).getBytes("UTF-8"));
		}
		
		outputTFIDFMatrix.close();
		tfReader.close();
//		return this.listTFIDF;
	}
	

}
