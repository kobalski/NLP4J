package tr.com.kobalski.nlp4j.search;

//Author ibrahim G�RSES

public class CannibalHeuristicFunction implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		
		//Number of the people at the left bank -1
		String currentState = state.toString();
		int h = Integer.parseInt(""+currentState.charAt (0))
					+ Integer.parseInt(""+currentState.charAt(1)) -1;
		
		return h;	
		
	}

}