package classify;

import java.io.IOException;

import ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth.Run;

public class MutipleMain {
	public static void main(String[] args) throws IOException {

//*****************************************STAGE_1*******************************************************************//
		
//		String pathScatterFile_SE_1800yidongAPP = "E:\\data_processing\\0_original_data\\SE-1800“∆∂ØAPP";
//		String pathSplitActivityColumn_SE_1800yidongAPP = "E:\\data_processing\\1_rough_column_activity\\SE-1800“∆∂ØAPP";
//		String pathSingleMatrix_SE_1800yidongAPP = "E:\\data_processing\\2_rough_matrix\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_rough_matrix.txt";
//		String pathSplitActivityLine_SE_1800yidongAPP = "E:\\data_processing\\3_activity_matrix_nonloss\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_matrix_nonloss.txt";
//		
//		String pathScatterFile_aiguangjie = "E:\\data_processing\\0_original_data\\∞Æπ‰Ω÷";
//		String pathSplitActivityColumn_aiguangjie = "E:\\data_processing\\1_rough_column_activity\\∞Æπ‰Ω÷";
//		String pathSingleMatrix_aiguangjie = "E:\\data_processing\\2_rough_matrix\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_rough_matrix.txt";
//		String pathSplitActivityLine_aiguangjie = "E:\\data_processing\\3_activity_matrix_nonloss\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_matrix_nonloss.txt";
//		
//		String pathScatterFile_tugele = "E:\\data_processing\\0_original_data\\Õº∏ˆ¿÷";
//		String pathSplitActivityColumn_tugele = "E:\\data_processing\\1_rough_column_activity\\Õº∏ˆ¿÷";
//		String pathSingleMatrix_tugele = "E:\\data_processing\\2_rough_matrix\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_rough_matrix.txt";
//		String pathSplitActivityLine_tugele = "E:\\data_processing\\3_activity_matrix_nonloss\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_matrix_nonloss.txt";
//		
//		String pathScatterFile_wangyiyunyinyue = "E:\\data_processing\\0_original_data\\Õ¯“◊‘∆“Ù¿÷";
//		String pathSplitActivityColumn_wangyiyunyinyue = "E:\\data_processing\\1_rough_column_activity\\Õ¯“◊‘∆“Ù¿÷";
//		String pathSingleMatrix_wangyiyunyinyue = "E:\\data_processing\\2_rough_matrix\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_rough_matrix.txt";
//		String pathSplitActivityLine_wangyiyunyinyue = "E:\\data_processing\\3_activity_matrix_nonloss\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_matrix_nonloss.txt";
//		
//		String pathScatterFile_youboke = "E:\\data_processing\\0_original_data\\”≈≤•øÕ";
//		String pathSplitActivityColumn_youboke = "E:\\data_processing\\1_rough_column_activity\\”≈≤•øÕ";
//		String pathSingleMatrix_youboke = "E:\\data_processing\\2_rough_matrix\\”≈≤•øÕ\\”≈≤•øÕ_rough_matrix.txt";
//		String pathSplitActivityLine_youboke = "E:\\data_processing\\3_activity_matrix_nonloss\\”≈≤•øÕ\\”≈≤•øÕ_matrix_nonloss.txt";
//		
//		String pathScatterFile_all = "E:\\data_processing\\0_original_data\\all";
//		String pathSplitActivityColumn_all = "E:\\data_processing\\1_rough_column_activity\\all";
//		String pathSingleMatrix_all = "E:\\data_processing\\2_rough_matrix\\all\\all_rough_matrix.txt";
//		String pathSplitActivityLine_all = "E:\\data_processing\\3_activity_matrix_nonloss\\all\\all_matrix_nonloss.txt";
		
//		String pathScatterFile_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\0_original_data\\four";
//		String pathSplitActivityColumn_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\1_rough_column_activity\\four";
//		String pathSingleMatrix_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\2_rough_matrix\\four\\four_rough_matrix.txt";
//		String pathSplitActivityLine_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\3_activity_matrix_nonloss\\four\\four_matrix_nonloss.txt";
		
//		Subsection subsection_SE_1800yidongAPP = new Subsection(pathScatterFile_SE_1800yidongAPP, pathSplitActivityColumn_SE_1800yidongAPP, pathSingleMatrix_SE_1800yidongAPP, pathSplitActivityLine_SE_1800yidongAPP);
//		Subsection subsection_aiguangjie = new Subsection(pathScatterFile_aiguangjie, pathSplitActivityColumn_aiguangjie, pathSingleMatrix_aiguangjie, pathSplitActivityLine_aiguangjie);
//		Subsection subsection_tugele = new Subsection(pathScatterFile_tugele, pathSplitActivityColumn_tugele, pathSingleMatrix_tugele, pathSplitActivityLine_tugele);
//		Subsection subsection_wangyiyunyinyue = new Subsection(pathScatterFile_wangyiyunyinyue, pathSplitActivityColumn_wangyiyunyinyue, pathSingleMatrix_wangyiyunyinyue, pathSplitActivityLine_wangyiyunyinyue);
//		Subsection subsection_youboke = new Subsection(pathScatterFile_youboke, pathSplitActivityColumn_youboke, pathSingleMatrix_youboke, pathSplitActivityLine_youboke);
//		Subsection subsection_all = new Subsection(pathScatterFile_all, pathSplitActivityColumn_all, pathSingleMatrix_all, pathSplitActivityLine_all);
//		Subsection subsection_FourApp_Except_SE_1800yidongAPP = new Subsection(pathScatterFile_FourApp_Except_SE_1800yidongAPP, pathSplitActivityColumn_FourApp_Except_SE_1800yidongAPP, pathSingleMatrix_FourApp_Except_SE_1800yidongAPP, pathSplitActivityLine_FourApp_Except_SE_1800yidongAPP);
		
//		subsection_SE_1800yidongAPP.BuildActivity();
//		subsection_aiguangjie.BuildActivity();
//		subsection_tugele.BuildActivity();
//		subsection_wangyiyunyinyue.BuildActivity();
//		subsection_youboke.BuildActivity();
//		subsection_all.BuildActivity();
//		subsection_FourApp_Except_SE_1800yidongAPP.BuildActivity();
		
//*****************************************STAGE_2************************************************************************************************************************************************************//		
		
//		String pathAcitivityLine_SE_1800yidongAPP = "E:\\data_processing\\3_activity_matrix_nonloss\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_matrix_nonloss.txt";
//		String pathActivityWithStamps_SE_1800yidongAPP = "E:\\data_processing\\4_activity_matrix_with_timestamps\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_EventWithTimeStamps.txt";
//		String pathAcitivityLine_aiguangjie = "E:\\data_processing\\3_activity_matrix_nonloss\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_matrix_nonloss.txt";
//		String pathActivityWithStamps_aiguangjie = "E:\\data_processing\\4_activity_matrix_with_timestamps\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_EventWithTimeStamps.txt";
//		String pathAcitivityLine_tugele = "E:\\data_processing\\3_activity_matrix_nonloss\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_matrix_nonloss.txt";
//		String pathActivityWithStamps_tugele = "E:\\data_processing\\4_activity_matrix_with_timestamps\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_EventWithTimeStamps.txt";
//		String pathAcitivityLine_wangyiyunyinyue = "E:\\data_processing\\3_activity_matrix_nonloss\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_matrix_nonloss.txt";
//		String pathActivityWithStamps_wangyiyunyinyue = "E:\\data_processing\\4_activity_matrix_with_timestamps\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_EventWithTimeStamps.txt";
//		String pathAcitivityLine_youboke = "E:\\data_processing\\3_activity_matrix_nonloss\\”≈≤•øÕ\\”≈≤•øÕ_matrix_nonloss.txt";
//		String pathActivityWithStamps_youboke = "E:\\data_processing\\4_activity_matrix_with_timestamps\\”≈≤•øÕ\\”≈≤•øÕ_EventWithTimeStamps.txt";
//		String pathAcitivityLine_all = "E:\\data_processing\\3_activity_matrix_nonloss\\all\\all_matrix_nonloss.txt";
//		String pathActivityWithStamps_all = "E:\\data_processing\\4_activity_matrix_with_timestamps\\all\\all_EventWithTimeStamps.txt";
//		String pathAcitivityLine_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\3_activity_matrix_nonloss\\four\\four_matrix_nonloss.txt";
//		String pathActivityWithStamps_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\4_activity_matrix_with_timestamps\\four\\four_EventWithTimeStamps.txt";
		
//		EventWithTimeStamps eventWithTimeStamps_SE_1800yidongAPP = new EventWithTimeStamps(pathAcitivityLine_SE_1800yidongAPP, pathActivityWithStamps_SE_1800yidongAPP);
//		EventWithTimeStamps eventWithTimeStamps_aiguangjie = new EventWithTimeStamps(pathAcitivityLine_aiguangjie, pathActivityWithStamps_aiguangjie);
//		EventWithTimeStamps eventWithTimeStamps_tugele = new EventWithTimeStamps(pathAcitivityLine_tugele, pathActivityWithStamps_tugele);
//		EventWithTimeStamps eventWithTimeStamps_wangyiyunyinyue = new EventWithTimeStamps(pathAcitivityLine_wangyiyunyinyue, pathActivityWithStamps_wangyiyunyinyue);
//		EventWithTimeStamps eventWithTimeStamps_youboke = new EventWithTimeStamps(pathAcitivityLine_youboke, pathActivityWithStamps_youboke);
//		EventWithTimeStamps eventWithTimeStamps_all = new EventWithTimeStamps(pathAcitivityLine_all, pathActivityWithStamps_all);
//		EventWithTimeStamps eventWithTimeStamps_FourApp_Except_SE_1800yidongAPP = new EventWithTimeStamps(pathAcitivityLine_FourApp_Except_SE_1800yidongAPP, pathActivityWithStamps_FourApp_Except_SE_1800yidongAPP);
		
//		eventWithTimeStamps_SE_1800yidongAPP.EventAppendTimeStamps();
//		eventWithTimeStamps_aiguangjie.EventAppendTimeStamps();
//		eventWithTimeStamps_tugele.EventAppendTimeStamps();
//		eventWithTimeStamps_wangyiyunyinyue.EventAppendTimeStamps();
//		eventWithTimeStamps_youboke.EventAppendTimeStamps();
//		eventWithTimeStamps_all.EventAppendTimeStamps();
//		eventWithTimeStamps_FourApp_Except_SE_1800yidongAPP.EventAppendTimeStamps();
		
//*****************************************STAGE_3************************************************************************************************************************************************************//

		double start = 0.15;
		double end = 0.30;
		double stepLength = 0.01;
		
//		String input_SE_1800yidongAPP = "E:\\data_processing\\4_activity_matrix_with_timestamps\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_EventWithTimeStamps.txt";
//		String input_aiguangjie = "E:\\data_processing\\4_activity_matrix_with_timestamps\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_EventWithTimeStamps.txt";
//		String input_tugele = "E:\\data_processing\\4_activity_matrix_with_timestamps\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_EventWithTimeStamps.txt";
//		String input_wangyiyunyinyue = "E:\\data_processing\\4_activity_matrix_with_timestamps\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_EventWithTimeStamps.txt";
//		String input_youboke = "E:\\data_processing\\4_activity_matrix_with_timestamps\\”≈≤•øÕ\\”≈≤•øÕ_EventWithTimeStamps.txt";
//		String input_all = "E:\\data_processing\\4_activity_matrix_with_timestamps\\all\\all_EventWithTimeStamps.txt";
//		String input_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\4_activity_matrix_with_timestamps\\four\\four_EventWithTimeStamps.txt";
		
//		String output_SE_1800yidongAPP = "E:\\data_processing\\5_fpgrowth\\SE-1800“∆∂ØAPP";
//		String output_aiguangjie = "E:\\data_processing\\5_fpgrowth\\∞Æπ‰Ω÷";
//		String output_tugele = "E:\\data_processing\\5_fpgrowth\\Õº∏ˆ¿÷";
//		String output_wangyiyunyinyue = "E:\\data_processing\\5_fpgrowth\\Õ¯“◊‘∆“Ù¿÷";
//		String output_youboke = "E:\\data_processing\\5_fpgrowth\\”≈≤•øÕ";
//		String output_all = "E:\\data_processing\\5_fpgrowth\\all";
//		String output_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\5_fpgrowth\\four";
		
//		Run FP_Growth_SE_1800yidongAPP = new Run(input_SE_1800yidongAPP, output_SE_1800yidongAPP, start, end, stepLength);
//		Run FP_Growth_aiguangjie = new Run(input_aiguangjie, output_aiguangjie, start, end, stepLength);
//		Run FP_Growth_tugele = new Run(input_tugele, output_tugele, start, end, stepLength);
//		Run FP_Growth_wangyiyunyinyue = new Run(input_wangyiyunyinyue, output_wangyiyunyinyue, start, end, stepLength);
//		Run FP_Growth_youboke = new Run(input_youboke, output_youboke, start, end, stepLength);
//		Run FP_Growth_all = new Run(input_all, output_all, start, end, stepLength);
//		Run FP_Growth_FourApp_Except_SE_1800yidongAPP = new Run(input_FourApp_Except_SE_1800yidongAPP, output_FourApp_Except_SE_1800yidongAPP, start, end, stepLength);
		
//		FP_Growth_SE_1800yidongAPP.FP_Growth();
//		FP_Growth_aiguangjie.FP_Growth();
//		FP_Growth_tugele.FP_Growth();
//		FP_Growth_wangyiyunyinyue.FP_Growth();
//		FP_Growth_youboke.FP_Growth();
//		FP_Growth_all.FP_Growth();
//		FP_Growth_FourApp_Except_SE_1800yidongAPP.FP_Growth();

//*****************************************STAGE_4************************************************************************************************************************************************************//

		for(int i = 0;i<(end - start)/0.01;i++){
//			String pathPatternWithDuplicate_SE_1800yidongAPP = "E:\\data_processing\\5_fpgrowth\\SE-1800“∆∂ØAPP\\" + String.valueOf(i) + ".txt";
//			String pathPatternWithDuplicate_aiguangjie = "E:\\data_processing\\5_fpgrowth\\∞Æπ‰Ω÷\\" + String.valueOf(i) + ".txt";
//			String pathPatternWithDuplicate_tugele = "E:\\data_processing\\5_fpgrowth\\Õº∏ˆ¿÷\\" + String.valueOf(i) + ".txt";
//			String pathPatternWithDuplicate_wangyiyunyinyue = "E:\\data_processing\\5_fpgrowth\\Õ¯“◊‘∆“Ù¿÷\\" + String.valueOf(i) + ".txt";
//			String pathPatternWithDuplicate_youboke = "E:\\data_processing\\5_fpgrowth\\”≈≤•øÕ\\" + String.valueOf(i) + ".txt";
//			String pathPatternWithDuplicate_all = "E:\\data_processing\\5_fpgrowth\\all\\" + String.valueOf(i) + ".txt";
//			String pathPatternWithDuplicate_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\5_fpgrowth\\four\\" + String.valueOf(i) + ".txt";
			
//			String pathPatternWithoutDuplicate_SE_1800yidongAPP = "E:\\data_processing\\6_event_sequence_without_dumplication\\SE-1800“∆∂ØAPP\\" + "SE-1800“∆∂ØAPP_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathPatternWithoutDuplicate_aiguangjie = "E:\\data_processing\\6_event_sequence_without_dumplication\\∞Æπ‰Ω÷\\" + "∞Æπ‰Ω÷_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathPatternWithoutDuplicate_tugele = "E:\\data_processing\\6_event_sequence_without_dumplication\\Õº∏ˆ¿÷\\" + "Õº∏ˆ¿÷_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathPatternWithoutDuplicate_wangyiyunyinyue = "E:\\data_processing\\6_event_sequence_without_dumplication\\Õ¯“◊‘∆“Ù¿÷\\" + "Õ¯“◊‘∆“Ù¿÷_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathPatternWithoutDuplicate_youboke = "E:\\data_processing\\6_event_sequence_without_dumplication\\”≈≤•øÕ\\" + "”≈≤•øÕ_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathPatternWithoutDuplicate_all = "E:\\data_processing\\6_event_sequence_without_dumplication\\all\\" + "all_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathPatternWithoutDuplicate_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\6_event_sequence_without_dumplication\\four\\" + "four_subsequence_without_duplication" + String.valueOf(i) + ".txt";
			
//			String pathCorrespondSupport_SE_1800yidongAPP = "E:\\data_processing\\6_event_sequence_without_dumplication\\SE-1800“∆∂ØAPP\\" + "SE-1800“∆∂ØAPP_correspond_support" + String.valueOf(i) + ".txt";
//			String pathCorrespondSupport_aiguangjie = "E:\\data_processing\\6_event_sequence_without_dumplication\\∞Æπ‰Ω÷\\" + "∞Æπ‰Ω÷_correspond_support" + String.valueOf(i) + ".txt";
//			String pathCorrespondSupport_tugele = "E:\\data_processing\\6_event_sequence_without_dumplication\\Õº∏ˆ¿÷\\" + "Õº∏ˆ¿÷_correspond_support" + String.valueOf(i) + ".txt";
//			String pathCorrespondSupport_wangyiyunyinyue = "E:\\data_processing\\6_event_sequence_without_dumplication\\Õ¯“◊‘∆“Ù¿÷\\" + "Õ¯“◊‘∆“Ù¿÷_correspond_support" + String.valueOf(i) + ".txt";
//			String pathCorrespondSupport_youboke = "E:\\data_processing\\6_event_sequence_without_dumplication\\”≈≤•øÕ\\" + "”≈≤•øÕ_correspond_support" + String.valueOf(i) + ".txt";
//			String pathCorrespondSupport_all = "E:\\data_processing\\6_event_sequence_without_dumplication\\all\\" + "all_correspond_support" + String.valueOf(i) + ".txt";
//			String pathCorrespondSupport_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\6_event_sequence_without_dumplication\\four\\" + "four_correspond_support" + String.valueOf(i) + ".txt";
			
//			CutDuplicate cutDumplicate_SE_1800yidongAPP = new CutDuplicate(pathPatternWithDuplicate_SE_1800yidongAPP, pathPatternWithoutDuplicate_SE_1800yidongAPP, pathCorrespondSupport_SE_1800yidongAPP);
//			CutDuplicate cutDumplicate_aiguangjie = new CutDuplicate(pathPatternWithDuplicate_aiguangjie, pathPatternWithoutDuplicate_aiguangjie, pathCorrespondSupport_aiguangjie);
//			CutDuplicate cutDumplicate_tugele = new CutDuplicate(pathPatternWithDuplicate_tugele, pathPatternWithoutDuplicate_tugele, pathCorrespondSupport_tugele);
//			CutDuplicate cutDumplicate_wangyiyunyinyue = new CutDuplicate(pathPatternWithDuplicate_wangyiyunyinyue, pathPatternWithoutDuplicate_wangyiyunyinyue, pathCorrespondSupport_wangyiyunyinyue);
//			CutDuplicate cutDumplicate_youboke = new CutDuplicate(pathPatternWithDuplicate_youboke, pathPatternWithoutDuplicate_youboke, pathCorrespondSupport_youboke);
//			CutDuplicate cutDumplicate_all = new CutDuplicate(pathPatternWithDuplicate_all, pathPatternWithoutDuplicate_all, pathCorrespondSupport_all);
//			CutDuplicate cutDumplicate_FourApp_Except_SE_1800yidongAPP = new CutDuplicate(pathPatternWithDuplicate_FourApp_Except_SE_1800yidongAPP, pathPatternWithoutDuplicate_FourApp_Except_SE_1800yidongAPP, pathCorrespondSupport_FourApp_Except_SE_1800yidongAPP);
			
//			cutDumplicate_SE_1800yidongAPP.DeDumplication();
//			cutDumplicate_aiguangjie.DeDumplication();
//			cutDumplicate_tugele.DeDumplication();
//			cutDumplicate_wangyiyunyinyue.DeDumplication();
//			cutDumplicate_youboke.DeDumplication();
//			cutDumplicate_all.DeDumplication();
//			cutDumplicate_FourApp_Except_SE_1800yidongAPP.DeDumplication();
		}
		
//*****************************************STAGE_5************************************************************************************************************************************************************//
		
//		String pathFile_SE_1800yidongAPP = "E:\\data_processing\\3_activity_matrix_nonloss\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_matrix_nonloss.txt";
//		String pathFile_aiguangjie = "E:\\data_processing\\3_activity_matrix_nonloss\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_matrix_nonloss.txt";
//		String pathFile_tugele = "E:\\data_processing\\3_activity_matrix_nonloss\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_matrix_nonloss.txt";
//		String pathFile_wangyiyunyinyue = "E:\\data_processing\\3_activity_matrix_nonloss\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_matrix_nonloss.txt";
//		String pathFile_youboke = "E:\\data_processing\\3_activity_matrix_nonloss\\”≈≤•øÕ\\”≈≤•øÕ_matrix_nonloss.txt";
//		String pathFile_all = "E:\\data_processing\\3_activity_matrix_nonloss\\all\\all_matrix_nonloss.txt";
//		String pathFile_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\3_activity_matrix_nonloss\\four\\four_matrix_nonloss.txt";
		
		for(int i = 0;i<(end-start)/0.01;i++){
//			String pathStandard_SE_1800yidongAPP = "E:\\data_processing\\6_event_sequence_without_dumplication\\SE-1800“∆∂ØAPP\\" + "SE-1800“∆∂ØAPP_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathStandard_aiguangjie = "E:\\data_processing\\6_event_sequence_without_dumplication\\∞Æπ‰Ω÷\\" + "∞Æπ‰Ω÷_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathStandard_tugele = "E:\\data_processing\\6_event_sequence_without_dumplication\\Õº∏ˆ¿÷\\" + "Õº∏ˆ¿÷_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathStandard_wangyiyunyinyue = "E:\\data_processing\\6_event_sequence_without_dumplication\\Õ¯“◊‘∆“Ù¿÷\\" + "Õ¯“◊‘∆“Ù¿÷_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathStandard_youboke = "E:\\data_processing\\6_event_sequence_without_dumplication\\”≈≤•øÕ\\" + "”≈≤•øÕ_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathStandard_all = "E:\\data_processing\\6_event_sequence_without_dumplication\\all\\" + "all_subsequence_without_duplication" + String.valueOf(i) + ".txt";
//			String pathStandard_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\6_event_sequence_without_dumplication\\four\\" + "four_subsequence_without_duplication" + String.valueOf(i) + ".txt";
			
//			String pathFeatures_SE_1800yidongAPP = "E:\\data_processing\\7_features_matrix\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_features" + String.valueOf(i) + ".txt";
//			String pathFeatures_aiguangjie = "E:\\data_processing\\7_features_matrix\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_features" + String.valueOf(i) + ".txt";
//			String pathFeatures_tugele = "E:\\data_processing\\7_features_matrix\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_features" + String.valueOf(i) + ".txt";
//			String pathFeatures_wangyiyunyinyue = "E:\\data_processing\\7_features_matrix\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_features" + String.valueOf(i) + ".txt";
//			String pathFeatures_youboke = "E:\\data_processing\\7_features_matrix\\”≈≤•øÕ\\”≈≤•øÕ_features" + String.valueOf(i) + ".txt";
//			String pathFeatures_all = "E:\\data_processing\\7_features_matrix\\all\\all_features.txt" + String.valueOf(i) + ".txt";
//			String pathFeatures_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\7_features_matrix\\four\\four_features.txt" + String.valueOf(i) + ".txt";
			
//			SequenceMatch sequenceMatch_SE_1800yidongAPP = new SequenceMatch(pathFile_SE_1800yidongAPP, pathStandard_SE_1800yidongAPP, pathFeatures_SE_1800yidongAPP);
//			SequenceMatch sequenceMatch_aiguangjie = new SequenceMatch(pathFile_aiguangjie, pathStandard_aiguangjie, pathFeatures_aiguangjie);
//			SequenceMatch sequenceMatch_tugele = new SequenceMatch(pathFile_tugele, pathStandard_tugele, pathFeatures_tugele);
//			SequenceMatch sequenceMatch_wangyiyunyinyue = new SequenceMatch(pathFile_wangyiyunyinyue, pathStandard_wangyiyunyinyue, pathFeatures_wangyiyunyinyue);
//			SequenceMatch sequenceMatch_youboke = new SequenceMatch(pathFile_youboke, pathStandard_youboke, pathFeatures_youboke);
//			SequenceMatch sequenceMatch_all = new SequenceMatch(pathFile_all, pathStandard_all, pathFeatures_all);
//			SequenceMatch sequenceMatch_FourApp_Except_SE_1800yidongAPP = new SequenceMatch(pathFile_FourApp_Except_SE_1800yidongAPP, pathStandard_FourApp_Except_SE_1800yidongAPP, pathFeatures_FourApp_Except_SE_1800yidongAPP);
			
//			sequenceMatch_SE_1800yidongAPP.File2features();
//			sequenceMatch_aiguangjie.File2features();
//			sequenceMatch_tugele.File2features();
//			sequenceMatch_wangyiyunyinyue.File2features();
//			sequenceMatch_youboke.File2features();
//			sequenceMatch_all.File2features();
//			sequenceMatch_FourApp_Except_SE_1800yidongAPP.File2features();
		}
		
//*****************************************STAGE_6************************************************************************************************************************************************************//
		
		for(int i = 0;i<(end - start)/0.01;i++){
			String pathCopy_SE_1800yidongAPP = "E:\\data_processing\\8_features_01matrix\\SE-1800“∆∂ØAPP\\" + "SE_1800yidongAPP_01Matrix" + String.valueOf(i) + ".txt";
			String pathCopy_aiguangjie = "E:\\data_processing\\8_features_01matrix\\∞Æπ‰Ω÷\\" + "aiguangjie_01Matrix" + String.valueOf(i) + ".txt";
			String pathCopy_tugele = "E:\\data_processing\\8_features_01matrix\\Õº∏ˆ¿÷\\" + "tugele_01Matrix" + String.valueOf(i) + ".txt";
			String pathCopy_wangyiyunyinyue = "E:\\data_processing\\8_features_01matrix\\Õ¯“◊‘∆“Ù¿÷\\" + "wangyiyunyinyue_01Matrix" + String.valueOf(i) + ".txt";
			String pathCopy_youboke = "E:\\data_processing\\8_features_01matrix\\”≈≤•øÕ\\" + "youboke_01Matrix" + String.valueOf(i) + ".txt";
			String pathCopy_all = "E:\\data_processing\\8_features_01matrix\\all\\" + "all_01Matrix" + String.valueOf(i) + ".txt";
			String pathCopy_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\8_features_01matrix\\four\\" + "four_01Matrix" + String.valueOf(i) + ".txt";
			
			String pathFeatures_SE_1800yidongAPP = "E:\\data_processing\\7_features_matrix\\SE-1800“∆∂ØAPP\\SE-1800“∆∂ØAPP_features" + String.valueOf(i) + ".txt";
			String pathFeatures_aiguangjie = "E:\\data_processing\\7_features_matrix\\∞Æπ‰Ω÷\\∞Æπ‰Ω÷_features" + String.valueOf(i) + ".txt";
			String pathFeatures_tugele = "E:\\data_processing\\7_features_matrix\\Õº∏ˆ¿÷\\Õº∏ˆ¿÷_features" + String.valueOf(i) + ".txt";
			String pathFeatures_wangyiyunyinyue = "E:\\data_processing\\7_features_matrix\\Õ¯“◊‘∆“Ù¿÷\\Õ¯“◊‘∆“Ù¿÷_features" + String.valueOf(i) + ".txt";
			String pathFeatures_youboke = "E:\\data_processing\\7_features_matrix\\”≈≤•øÕ\\”≈≤•øÕ_features" + String.valueOf(i) + ".txt";
			String pathFeatures_all = "E:\\data_processing\\7_features_matrix\\all\\all_features.txt" + String.valueOf(i) + ".txt";
			String pathFeatures_FourApp_Except_SE_1800yidongAPP = "E:\\data_processing\\7_features_matrix\\four\\four_features.txt" + String.valueOf(i) + ".txt";
			
			Build01Matrix features01Matrix_SE_1800yidongAPP = new Build01Matrix(pathFeatures_SE_1800yidongAPP, pathCopy_SE_1800yidongAPP);
			Build01Matrix features01Matrix_aiguangjie = new Build01Matrix(pathFeatures_aiguangjie, pathCopy_aiguangjie);
			Build01Matrix features01Matrix_tugele = new Build01Matrix(pathFeatures_tugele, pathCopy_tugele);
			Build01Matrix features01Matrix_wangyiyunyinyue = new Build01Matrix(pathFeatures_wangyiyunyinyue, pathCopy_wangyiyunyinyue);
			Build01Matrix features01Matrix_youboke = new Build01Matrix(pathFeatures_youboke, pathCopy_youboke);
			Build01Matrix features01Matrix_all = new Build01Matrix(pathFeatures_all, pathCopy_all);
			Build01Matrix features01Matrix_FourApp_Except_SE_1800yidongAPP = new Build01Matrix(pathFeatures_FourApp_Except_SE_1800yidongAPP, pathCopy_FourApp_Except_SE_1800yidongAPP);
			
			features01Matrix_SE_1800yidongAPP.Build();
			features01Matrix_aiguangjie.Build();
			features01Matrix_tugele.Build();
			features01Matrix_wangyiyunyinyue.Build();
			features01Matrix_youboke.Build();
			features01Matrix_all.Build();
			features01Matrix_FourApp_Except_SE_1800yidongAPP.Build();
		}
		
//************************************************************************************************************************************************************************************************************//
//		String pathStandard = "E:\\standard_test\\matrix_4_15.txt";
//		String pathFile = "E:\\matrix_2\\matrix_2.txt";
//		String pathCopy = "E:\\file2features_test\\features3.txt";
//		
//		SequenceMatch sequenceMatch = new SequenceMatch(pathFile, pathStandard, pathCopy);
//		sequenceMatch.File2features();
		
		
		
	}
}
