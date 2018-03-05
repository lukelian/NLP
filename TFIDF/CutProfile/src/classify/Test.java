package classify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth.Run;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		
		
//		for(int i = 0;i<15;i++){
//			String pathTarget = "E:\\data_processing\\6_event_sequence_without_dumplication\\SE-1800移动APP\\SE-1800移动APP_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathCommon = "E:\\data_processing\\6_event_sequence_without_dumplication\\four\\four_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathCopy = "E:\\data_processing\\9_specific_features_SE1800\\" + "SE1800_specific_features" + String.valueOf(i) + ".txt";
//			Reduction reduction  = new Reduction(pathTarget, pathCommon, pathCopy);
//			reduction.CutSameLine();
//		}
		
		String input = "E:\\data_processing\\4_activity_matrix_with_timestamps\\four\\four_EventWithTimeStamps.txt";
		String output = "E:\\data_processing\\1.txt";
		String pathPatternWithoutDuplicate = "E:\\data_processing\\2.txt";
		String pathCorrespondSupport = "E:\\data_processing\\3.txt";
		
		Run FP_Growth = new Run();
		FP_Growth.FP_Growth_singlefile(input, output, 0.1);
		
		CutDuplicate cutDuplicate = new CutDuplicate(output, pathPatternWithoutDuplicate, pathCorrespondSupport);
		cutDuplicate.DeDumplication();
		
		String pathTarget = "E:\\data_processing\\6_event_sequence_without_dumplication\\SE-1800移动APP\\SE-1800移动APP_subsequence_without_duplication0.txt";
		String pathCommon = "E:\\data_processing\\2.txt";
		String pathCopy = "E:\\data_processing\\4.txt";
		
		Reduction reduction  = new Reduction(pathTarget, pathCommon, pathCopy);
		
		reduction.CutSameLine();
		
		
		
//		String pathRead = "E:\\file2features_test\\features3.txt";
//		String pathCopy = "E:\\file2features_test\\matrix.txt";
//		Build01Matrix build = new Build01Matrix(pathRead, pathCopy);
//		build.Build();
		
//		String input = "E:\\matrix_3\\matrix_3.txt";
//		String output = "E:\\matrix_3";
//		
//		double start = 0.2;
//		double end = 0.3;
//		double stepLength = 0.01;
//		
//		Run test = new Run(input, output, start, end, stepLength);
//		test.FP_Growth();
		
//		Subsection s1 = new Subsection();
//		
//		Subsection1 s = new Subsection1(new Subsection2());
		
//		String s = "kdsahf";
//		System.out.println(s.indexOf("k"));
//		
//		s.substring(2);
//		System.out.println(s.substring(2));
//		
//		String[] s1 = {"1","2","3"};
//		String[] s2 = {"1","2","3"};
//		String[] s3 = {"2","2","3"};
//		String[] s4 = {"1","2","3",""};
//		System.out.println(Arrays.equals(s1, s2));
//		System.out.println(Arrays.equals(s1,s3));
//		System.out.println(Arrays.equals(s1,s4));
//		
//		ArrayList<String> temp = new ArrayList<String>();
//		
//		System.out.println(Arrays.toString(s1));
//		
//		String s6 = "25  26 27     29      ";
//		System.out.println(s6.split(" "));
		
//		int[] i = new int[20];
//		Arrays.fill(i, 0);
//		for(int j = 0;j<20;j++){
//			System.out.println(i[j]);
//		}
		
//		HashMap<Integer, int[]> location = new HashMap<Integer, int[]>();
//		System.out.println(location.size());
	}
	
}
