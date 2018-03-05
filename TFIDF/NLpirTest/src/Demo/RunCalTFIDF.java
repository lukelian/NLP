package Demo;

import java.io.IOException;
import java.util.ArrayList;

public class RunCalTFIDF {
	
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<String>> listTF_train = new ArrayList<ArrayList<String>>();
		ArrayList<String> listIDF_train = new ArrayList<String>();
		ArrayList<ArrayList<String>> listTFIDF_train = new ArrayList<ArrayList<String>>();
		
		ArrayList<ArrayList<String>> listTF_test = new ArrayList<ArrayList<String>>();
		ArrayList<String> listIDF_test = new ArrayList<String>();
		ArrayList<ArrayList<String>> listTFIDF_test = new ArrayList<ArrayList<String>>();
		
		CalTFIDF tfidf_train = new CalTFIDF();
		listTF_train = tfidf_train.TF("D:\\data\\word_bag_only_mingci.txt", "D:\\data\\fenci_all.txt", "D:\\data\\matrix_train_tf.txt");
		listIDF_train = tfidf_train.IDF();
		listTFIDF_train = tfidf_train.TFIDF("D:\\data\\matrix_train_tfidf.txt");
		
		CalTFIDF tfidf_test = new CalTFIDF();
		listTF_test = tfidf_test.TF("D:\\data\\word_bag_only_mingci.txt", "D:\\data\\test_all_fenci.txt", "D:\\data\\matrix_test_tf.txt");
		listIDF_test = tfidf_test.IDF();
		listTFIDF_test = tfidf_test.TFIDF("D:\\data\\matrix_test_tfidf.txt");
	}
}
