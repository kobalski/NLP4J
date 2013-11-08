package tr.com.kobalski.nlp4j.search;


public class BasicEnvironmentView {


	public void envChanged(String command) {
		
		if (!command.equals("NoOP")){
		
			System.out.println("Action: " + command);
			int pos = Integer.parseInt( ""+ command.charAt(2));
		
			if (pos == 1){
			
				System.out.println (command.charAt(0)+" Missionaries and "+
								command.charAt(1)+ " Cannibals are carried"
								+ " from right to left of the river");
			
			}
			else{
			
			System.out.println (command.charAt(0)+" Missionaries and "+
							command.charAt(1)+ " Cannibals are carried"
							+ " from left to rigth of the river");
		
			}
		}
		
	}

}