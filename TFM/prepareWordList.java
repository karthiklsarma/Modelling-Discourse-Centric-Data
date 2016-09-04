//https://lists.cs.princeton.edu/pipermail/topic-models/2012-March/001788.html
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
 
public class prepareWordList {
 
	HashSet<String> maps = new LinkedHashSet<String>();
	public static void main(String[] args) throws IOException {
 
	prepareWordList obj = new prepareWordList();
	obj.run();
 
  }
 
  public void run() throws IOException {
 
	String csvFile = "/Users/Piyush1/Documents/Projects/Eclipse Workspace/Sharon Hsiao/ASUM/Demo/Data_ps.csv";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = " ";
	int count = 1;
	
 
	try {
 
		ArrayList<String> commonwords = new ArrayList<String>();
		commonwords.add("a");
		commonwords.add("the");
		commonwords.add("and");
		commonwords.add("an");
		commonwords.add("so");
		commonwords.add("but");
		commonwords.add("ok");
		commonwords.add("to");
		commonwords.add("sure");
		commonwords.add("both");
		commonwords.add("sinc");
		commonwords.add("ani");
		commonwords.add("best");
		commonwords.add("free");
		commonwords.add("just");
		commonwords.add("such");
		commonwords.add("about");
		commonwords.add("more");
		commonwords.add("by");
		commonwords.add("on");
		commonwords.add("in");
		commonwords.add("mayb");
		commonwords.add("yet");
		commonwords.add("off");
		commonwords.add("why");
		commonwords.add("where");
		commonwords.add("what");
		commonwords.add("who");
		commonwords.add("that");
		commonwords.add("then");
		commonwords.add("thi");
		commonwords.add("i");
		commonwords.add("well");
		commonwords.add("onli");
		commonwords.add("no");
		commonwords.add("out");
		commonwords.add("up");
		commonwords.add("how");
		commonwords.add("when");
		commonwords.add("there");
		commonwords.add("as");
		commonwords.add("anywai");
		commonwords.add("\"");
		commonwords.add("?");
		commonwords.add(",");
		commonwords.add("'");
		commonwords.add("it");
		commonwords.add("it's");
		commonwords.add(".");
		commonwords.add("you");
		commonwords.add("what");
		commonwords.add("take");
		commonwords.add("e.g.");
		commonwords.add("eg");
		commonwords.add("e.g");
		commonwords.add("exampl");
		commonwords.add("us");
		commonwords.add("of");
		commonwords.add("could");
		commonwords.add("would");
		commonwords.add("doesn");
		commonwords.add("have");
		commonwords.add("has");
		commonwords.add("is");
		commonwords.add("from");
		commonwords.add("better");
		commonwords.add("worst");
		commonwords.add("might");
		commonwords.add("we");
		commonwords.add("mix");
		commonwords.add("be");
		commonwords.add("thought");
		commonwords.add("think");
		commonwords.add("got");
		commonwords.add("my");
		commonwords.add("some");
		commonwords.add("exampl");
		commonwords.add("like");
		
		StringBuilder sb_1 = new StringBuilder();
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
 
			// use comma as separator
			String[] text = line.split(cvsSplitBy);
			for(String key: text){
				if(!(commonwords.contains(key))&&!(maps.contains(key)) && !(key==" ")){
				maps.add(key);
				sb_1.append(key).append('\n');
				}
			}
		}
		File wordmap = new File("/Users/Piyush1/Documents/Projects/Eclipse Workspace/Sharon Hsiao/ASUM/Demo/WordList.txt");
		FileWriter fw_1 = new FileWriter(wordmap.getAbsoluteFile());
		BufferedWriter bw_1 = new BufferedWriter(fw_1);
		bw_1.write(sb_1.toString());
		bw_1.close();
 
		//loop map
//		for (Map.Entry<String, String> entry : maps.entrySet()) {
// 
//			System.out.println("Country [code= " + entry.getKey() + " , name="
//				+ entry.getValue() + "]");
// 
//		}
		br.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	int index;
	ArrayList<String> list = new ArrayList<String>(maps);
	StringBuilder sb = new StringBuilder();
	StringBuilder sb_2;
	br = new BufferedReader(new FileReader(csvFile));
	int line_count =0;
	int temp_count=0;
	while ((line = br.readLine()) != null) {
		System.out.println(temp_count++);
		
		// use comma as separator
		String[] text = line.split("\\.");
		line_count = text.length;
		sb.append(text.length);
		sb.append('\n');
		for(String key: text){
			key = key.trim();
			String[] words = key.split(" ");
			
			try{
			for(String key_words: words){
				index=list.indexOf(key_words);
				if(!(index<0)&&!(index==1781))
				sb.append(list.indexOf(key_words)).append(" ");
				
			}
			} catch(Exception e){}
			sb.append('\n');
		}
	}
	
	File bagsofsentences = new File("/Users/Piyush1/Documents/Projects/Eclipse Workspace/Sharon Hsiao/ASUM/Demo/BagOfSentences.txt");
	
	if (!bagsofsentences.exists()) {
		bagsofsentences.createNewFile();
	}

	FileWriter fw = new FileWriter(bagsofsentences.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	bw.write(sb.toString());
	bw.close();
	
	
	
	System.out.println("Done");
  }
 
}