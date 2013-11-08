package tr.com.kobalski.nlp4j.search;


//Author Ibrahim Gurses

public class CannibalNewHeuristicFunction implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		
		//h = h - 2* # of MisL -# of CanL + # of MisR + #of canR
		String currentState = state.toString(); 
		int h = 0;
		h-= 2*Integer.parseInt(""+currentState.charAt (0));
		h -= 2*Integer.parseInt(""+currentState.charAt (1));
		h += Integer.parseInt(""+currentState.charAt(2));
		h += Integer.parseInt(""+currentState.charAt (3)); 
				
		return h;	
		
	}

}