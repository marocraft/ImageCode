package ma.craft.imagecode.generation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Generate {
	public static void generateTextFile() {
		   
		  //Write data in file using PrintWriter
		  PrintWriter pwFile=null;
	  	  try {
	  		 pwFile = new PrintWriter(new File("code-react-native.txt"));
	  		 pwFile.write("");
	 		 pwFile.flush();
		  } catch (FileNotFoundException e) {
				e.printStackTrace();
		  }finally{
			  pwFile.close();
		  }
	 	}
	
	  
     
	} 


