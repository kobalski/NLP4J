package tr.com.kobalski.nlp4j.search;


//Author: kobalski
public class CannibalStepCostFunction implements StepCostFunction {
	

	private static double constantCost = 1.0;

	public CannibalStepCostFunction() {
	}

	public Double calculateStepCost(Object fromCurrentState,
			Object toNextState, String action) {

	
		return constantCost;
	}
}
