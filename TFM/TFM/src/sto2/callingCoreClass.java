package sto2;

import java.io.File;

public class callingCoreClass {

	public static void main(String[] args) throws Exception{
		File folder = new File("/Users/Piyush1/Documents/Projects/Eclipse Workspace/Hasan Davulcu/Resources/BagOfSentencesFolder/");
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        String sentences = file.getName();
		        // for mac computer because of reading of hidden files
		        if(!(sentences.equalsIgnoreCase(".DS_Store"))){
		        	String out = "/Users/Piyush1/Documents/Projects/Eclipse Workspace/Hasan Davulcu/Resources/OutputFiles/"+sentences.substring(0,sentences.indexOf(".")); 
			        File file2 = new File(out);
			        file2.mkdir();
			        out += "/";
			        STO2Core.mainclass(out,sentences);
		        }
		        
		    }
		}
	}
}
