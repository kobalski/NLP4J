package tr.com.kobalski.nlp4j.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtility {

	public static List<String> tokenizeStringByNewLine(String text){
		
		List<String> output = new ArrayList<String>();
		StringTokenizer stringTokenizer = new StringTokenizer(text,"\n");
		while(stringTokenizer.hasMoreTokens()){
			output.add(stringTokenizer.nextToken());
		}
		return output;
		
	}
	
	
}
