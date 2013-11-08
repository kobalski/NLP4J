package tr.com.kobalski.nlp4j.postagging;

import tr.com.kobalski.nlp4j.util.FileReaderUtility;
import tr.com.kobalski.nlp4j.util.StringUtility;

public class PosTagging {

	public static void main (String [] args) {
		
		System.out.println(FileReaderUtility.getCleanPathWithClassLoader(PosTagging.class));
		System.out.println(FileReaderUtility.getCleanPathWithUrlLocation(PosTagging.class));
		System.out.println(FileReaderUtility.getCurrentWorkingDir());

		String currentDir = FileReaderUtility.getCurrentWorkingDir();
		String trainingData = FileReaderUtility.readFile(currentDir + "/src/main/resources/training.txt");
		System.out.println(trainingData);
		System.out.println(StringUtility.tokenizeStringByNewLine(trainingData).size());
		
	}
	
}
