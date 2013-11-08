package tr.com.kobalski.nlp4j.search;


public interface StepCostFunction {
	Double calculateStepCost(Object fromState, Object toState, String action);
}