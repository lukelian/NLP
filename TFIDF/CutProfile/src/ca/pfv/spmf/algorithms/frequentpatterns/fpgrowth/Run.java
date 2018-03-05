package ca.pfv.spmf.algorithms.frequentpatterns.fpgrowth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import ca.pfv.spmf.algorithms.associationrules.agrawal94_association_rules.AlgoAgrawalFaster94;
import ca.pfv.spmf.patterns.itemset_array_integers_with_count.Itemsets;

public class Run {
	
	private String input = null;
	private String output = null;
	
	private double start = 0.0;
	private double end = 0.0;
	private double stepLength = 0.0;
	
	public Run(String input, String output, double start, double end, double stepLength) {
		this.input = input;
		this.output = output;
		this.start = start;
		this.end = end;
		this.stepLength = stepLength;
	}
	
	public Run(){}
	
	public void FP_Growth() throws IOException{
		
		for(int i = 0;i<((end - start)/stepLength + 1);i++){
			double minsupp = i*stepLength + start;
			AlgoFPGrowth fpgrowth = new AlgoFPGrowth();
			String outputText = output + "\\" + String.valueOf(i) + ".txt";
			File fileOutput = new File(outputText);
			if(!fileOutput.exists()) fileOutput.createNewFile();
			Itemsets patterns = fpgrowth.runAlgorithm(input, outputText, minsupp);
			int databaseSize = fpgrowth.getDatabaseSize();
//			fpgrowth.printStats();
		}
	}
	
	public void FP_Growth_singlefile(String input, String output, double minsupp) throws IOException{
		AlgoFPGrowth fpgrowth = new AlgoFPGrowth();
		File fileOutput = new File(output);
		if(!fileOutput.exists()) fileOutput.createNewFile();
		Itemsets patterns = fpgrowth.runAlgorithm(input, output, minsupp);
		int databaseSize = fpgrowth.getDatabaseSize();
	}
	
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		String input = "E:\\matrix_3\\matrix_3.txt";
//		String output = "E:\\matrix_3";
//		
//		double stepLength = 0;
//		double start = 0;
//		double end = 0;
//		
//		for(int i = 0;i<((end - start)/stepLength + 1);i++){
//			double minsupp = i*stepLength + start;
//			AlgoFPGrowth fpgrowth = new AlgoFPGrowth();
//			String outputText = output + "\\" + String.valueOf(i) + ".txt";
//			File fileOutput = new File(outputText);
//			if(!fileOutput.exists()) fileOutput.createNewFile();
//			Itemsets patterns = fpgrowth.runAlgorithm(input, outputText, minsupp);
//			int databaseSize = fpgrowth.getDatabaseSize();
//			fpgrowth.printStats();
//		}
//		
//		
//		
//		// STEP 1: Applying the FP-GROWTH algorithm to find frequent itemsets
////		double minsupp = 0.15;
////		AlgoFPGrowth fpgrowth = new AlgoFPGrowth();
////		Itemsets patterns = fpgrowth.runAlgorithm(input, output, minsupp);
//////		patterns.printItemsets(database.size());
////		int databaseSize = fpgrowth.getDatabaseSize();
////		fpgrowth.printStats();
//		
//		// STEP 2: Generating all rules from the set of frequent itemsets (based on Agrawal & Srikant, 94)
//		/*
//		 * double  minlift = 0.1;
//		 * double  minconf = 0.50; 
//		 * AlgoAgrawalFaster94 algoAgrawal = new AlgoAgrawalFaster94();
//		 * algoAgrawal.runAlgorithm(patterns, output, databaseSize, minconf, minlift);
//		 * algoAgrawal.printStats();
//		 * 
//		 * */
//	}
}
