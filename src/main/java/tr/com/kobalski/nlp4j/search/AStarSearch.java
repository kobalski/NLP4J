package tr.com.kobalski.nlp4j.search;


public class AStarSearch extends BestFirstSearch {

	public AStarSearch(QueueSearch search) {
		super(search, new AStarEvaluationFunction());
	}
}