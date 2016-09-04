//source:https://lists.cs.princeton.edu/pipermail/topic-models/2012-March/001788.html
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class punctuationReplacement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String csvFile = "/Users/Piyush1/Documents/Projects/Eclipse Workspace/Sharon Hsiao/ASUM/Demo/Data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = " ";
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb_1;
		
		File writer = new File("/Users/Piyush1/Documents/Projects/Eclipse Workspace/Sharon Hsiao/ASUM/Demo/Data_p.csv");
		
		 br = new BufferedReader(new FileReader(csvFile));
		 while ((line = br.readLine()) != null){
			 //if(line.length()!=0){
				 sb_1 = new StringBuilder();
				 sb_1.append(line.replaceAll("[\"]"," ").trim());
				 line = sb_1.toString();
				 try{
				 if(line.charAt(line.length()-1)=='.'){
					 
					 sb_1 = new StringBuilder(line);
					 sb_1.setCharAt(line.length()-1,' ');
					 line = sb_1.toString().trim();
				 }
				 }catch(Exception e){
					 System.out.println(line);
				 }
				 sb.append(line.replaceAll("[\",;()':?&/-?!@{}`~#]", "").replaceAll("\\d+", " ").replaceAll("\\-+", " ").replaceAll("\\[", " ").replaceAll("\\]", " ").trim().replaceAll("\\.{1,}", " . ").replaceAll(" +", " ")).append("\n");
			 //}
		 }
		 
		 
		 FileWriter fw_1 = new FileWriter(writer.getAbsoluteFile());
			BufferedWriter bw_1 = new BufferedWriter(fw_1);
			bw_1.write(sb.toString());
			bw_1.close();
			br.close();
		
		
	}

}
