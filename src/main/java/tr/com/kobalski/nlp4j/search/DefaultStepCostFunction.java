package tr.com.kobalski.nlp4j.search;


public class DefaultStepCostFunction implements StepCostFunction {

	public Double calculateStepCost(Object fromState, Object toState,
			String action) {

		return new Double(1);
	}

}