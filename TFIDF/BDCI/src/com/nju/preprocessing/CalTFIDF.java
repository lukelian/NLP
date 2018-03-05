package com.nju.preprocessing;
/*
 * 修改while((line = buffReaderSingleArticle.readLine())!=null)后面循环中的范围
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
	//作为输出
//	String pathMatrixSingleArticle = "D:\\data\\matrix_test_single_article.txt";
//	String pathLocateInfo = "D:\\data\\locate_info.txt";
//	//作为输入
//	String pathAttribute = "D:\\data\\word_bag_only_hanzi2.txt";
//	String pathSingleArticle = "D:\\data\\test_all_fenci.txt";
	//数值列表
	int singleArticleNum = 0;
	int attributeNum = 0;
	//属性列表
	HashMap<String, Integer> attributes = new HashMap<String, Integer>();
	HashMap<String, Integer> attributesTemp = new HashMap<String, Integer>();
	//词出现矩阵：如果这个词在这篇文章出现，那么文档集中，这个词对应的文档数加一，用来计算IDF
	HashMap<String, Integer> attributesApperanceNum = new HashMap<String, Integer>();
	
	ArrayList<String> idf = new ArrayList<String>();
	ArrayList<ArrayList<String>> listTF = new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> listTFIDF = new ArrayList<ArrayList<String>>();
	ArrayList<String> listIDF = new ArrayList<String>();

//带返回值的
//	public ArrayList<ArrayList<String>> TF(String pathAttribute, String pathSingleArticle, String pathMatrixSingleArticle) throws IOException {
//不带返回值的
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
		//初始化词语在某篇文档中出现的次数矩阵
		while((line = buffReaderAttribute.readLine())!=null){
			//初始化次数矩阵
			
			//最后属性的排序按照这个来
			
			attributes.put(line, count);
			//属性次数序列要和属性序列的顺序保持统一
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
		//attributesTemp用来在循环结束时更新attributes
		attributesTemp.putAll(attributes);
		//用来控制循环次数
		int alreadyRead = 0;
		int wordCount = 0;
		while((line = buffReaderSingleArticle.readLine())!=null){
			
			if(alreadyRead>200) break;
			
			//循环结束后是文章总数
			this.singleArticleNum = this.singleArticleNum + 1;
//			alreadyRead++;
//			if(alreadyRead<=5000) continue;
			
			String[] lineSplit = line.split(" ");
			//当前文章的总词数
//			this.attributeNum = lineSplit.length;  //错误的吗？
			wordCount = lineSplit.length;
			int total = 0;
			for(int i = 0;i<lineSplit.length;i++){
				String temp = lineSplit[i].trim();
				if(attributes.containsKey(temp)){
					//当前文章具有的属性值个数
					total = total + 1;
					//更新这篇文章的词的出现次数列表
					int attributeNum = attributes.get(temp) + 1;
					attributes.put(temp, attributeNum);
				}
			}
			
			//构成tf矩阵的行
//			ArrayList<String> listTFLine = new ArrayList<String>();
			
			Iterator iter = attributes.entrySet().iterator();
			Iterator iter2 = attributesApperanceNum.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry entry = (Map.Entry)iter.next();
				Map.Entry entry2 = (Map.Entry)iter2.next();
				//用tf归一化的,注意要让分子分母都为double
				double attributeNum = Double.valueOf(String.valueOf((int) entry.getValue()))/(double)wordCount;
				/*
				if(attributeNum!=0){
					System.out.println(attributeNum);
				} 
				 */
				
				
				//没有归一化的
//				double attributeNum = ((int) entry.getValue());
				//用频次的，没有归一化
				String attributeName = (String) entry.getKey();
				int attributeNumTemp = (int) entry.getValue();
				//如果这个词在这篇文章出现，那么文档集中，这个词对应的文档数加一，用来计算IDF
				
				if(attributeNumTemp!=0){
					int temp = (int)entry2.getValue() + 1;
					this.attributesApperanceNum.put(attributeName, temp);
				}
				
				//将这篇文章每个词的计算结果加入该文章的结果集中，是double
//				listTFLine.add(String.valueOf(attributeNum));
				//输出的是词语在这篇文章中出现的次数
//				if(attributeNum!=0){
//					System.out.println(String.format("%.5f", attributeNum));
//				}
				outputStream.write((String.format("%.5f", attributeNum) + " ").getBytes("UTF-8"));
				
			}
			//将该行加入文档集tf中
//			this.listTF.add(listTFLine);
			allWriteLineCount++;
			outputStream.write((System.getProperty("line.separator")).getBytes("UTF-8"));
			//attributesTemp用来在循环结束时更新attributes
			attributes.putAll(attributesTemp);
			
			
			
		}
		
		
		
		outputStream.close();
		buffReaderAttribute.close();
		buffReaderSingleArticle.close();
		System.out.println(allWriteLineCount);
//		return this.listTF;
	}


//带返回值的
//	public ArrayList<String> IDF(){
//不带返回值的
	public void IDF(String pathIDF) throws IOException{
//读取磁盘的方案
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
		
//放到内存的方案		
/*
		//文档集上的属性值个数
		int attributeNum = this.attributeNum;
		//文档集的文档个数
		int articleNum = this.singleArticleNum;
		for(int i = 0;i<attributeNum;i++){
			int count = 0;
			for(int j = 0;j<articleNum;j++){
				//如果第j篇文章中出现了词i，则词i的个数+1
				if(Double.valueOf(this.listTF.get(j).get(i))!=0){
					count++;
				}
			}
			//计算该词下的逆文档频率
			double idf = Math.log(articleNum/(count + 1));
			//将该词的逆文档频率加入全局记录向量中
			this.listIDF.add(String.format("%.2f", idf));
		}
//		return this.listIDF;
*/
	}


//带返回值的
//	public ArrayList<ArrayList<String>> TFIDF(String tfidfMatrix) throws IOException{
//不带返回值的
	public void TFIDF(String pathTF, String tfidfMatrix) throws IOException{
		File tf = new File(pathTF);
		File fileTFIDFMatrix = new File(tfidfMatrix);
		if(!fileTFIDFMatrix.exists()) fileTFIDFMatrix.createNewFile();
		FileOutputStream outputTFIDFMatrix = new FileOutputStream(fileTFIDFMatrix);
		BufferedReader tfReader = new BufferedReader(new InputStreamReader(new FileInputStream(tf)));
		String line = null;
		
		//内存计算方案
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
		
		
		//磁盘读取的方案
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
