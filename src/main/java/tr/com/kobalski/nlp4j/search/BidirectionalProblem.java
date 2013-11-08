package tr.com.kobalski.nlp4j.search;


public interface BidirectionalProblem {
	Problem getOriginalProblem();

	Problem getReverseProblem();
}
