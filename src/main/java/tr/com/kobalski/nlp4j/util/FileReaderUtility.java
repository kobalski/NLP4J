package tr.com.kobalski.nlp4j.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class FileReaderUtility {
	
	
	public static String getCurrentWorkingDir(){
		
		return System.getProperty("user.dir");
	
	}
	
	public static<T extends Object> String getCleanPathWithClassLoader(Class<T> clz) {
	    
		ClassLoader classLoader = clz.getClassLoader();
	    File classpathRoot = new File(classLoader.getResource("").getPath());
	    return classpathRoot.getPath();
	}
	
	public static <T extends Object>  String getCleanPathWithUrlLocation(Class<T> clz) {

		URL location = clz.getProtectionDomain().getCodeSource().getLocation();
	    String path = location.getFile();
	    return new File(path).getParent();
	}
	
	public static String readFile(String filename)
	{
	   String content = null;
	   File file = new File(filename); 
	   try {
	       FileReader reader = new FileReader(file);
	       char[] chars = new char[(int) file.length()];
	       reader.read(chars);
	       content = new String(chars);
	       reader.close();
	   } catch (IOException e) {
	       e.printStackTrace();
	   }
	   return content;
	}

	

}
