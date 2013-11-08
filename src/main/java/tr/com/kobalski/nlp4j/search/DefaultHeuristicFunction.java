package tr.com.kobalski.nlp4j.search;


public class DefaultHeuristicFunction implements HeuristicFunction {

	public double getHeuristicValue(Object state) {
		throw new IllegalStateException(
				"Should not be depending on the DefaultHeuristicFunction.");
		// return 1;
	}

}