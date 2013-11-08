package tr.com.kobalski.nlp4j.search;


public interface EvaluationFunction {
	Double getValue(Problem p, Node n);
}
