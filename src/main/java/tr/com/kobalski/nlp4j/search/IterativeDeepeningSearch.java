package tr.com.kobalski.nlp4j.search;

import java.util.ArrayList;
import java.util.List;



public class IterativeDeepeningSearch extends NodeExpander implements Search {
	
	private static String PATH_COST = "pathCost";

	private final int limit;

	private final Metrics iterationMetrics;

	public IterativeDeepeningSearch() {
		this.limit = Integer.MAX_VALUE;
		iterationMetrics = new Metrics();
		iterationMetrics.set(NODES_EXPANDED, 0);
		iterationMetrics.set(PATH_COST, 0);
	}

	// function ITERATIVE-DEEPENING-SEARCH(problem) returns a solution, or
	// failure
	// inputs: problem, a problem
	public List search(Problem p) throws Exception {
		iterationMetrics.set(NODES_EXPANDED, 0);
		iterationMetrics.set(PATH_COST, 0);
		// for depth <- to infinity do
		for (int i = 1; i <= limit; i++) {
			// result <- DEPTH-LIMITED-SEARCH(problem, depth)
			DepthLimitedSearch dls = new DepthLimitedSearch(i);
			List result = dls.search(p);
			iterationMetrics.set(NODES_EXPANDED, iterationMetrics
					.getInt(NODES_EXPANDED)
					+ dls.getMetrics().getInt(NODES_EXPANDED));
			// if result != cutoff then return result
			if (!cutOffResult(result)) {
				iterationMetrics.set(PATH_COST, dls.getPathCost());
				return result;
			}
		}
		return new ArrayList();// failure
	}

	private boolean cutOffResult(List result) { // TODO remove this duplication

		return result.size() == 1 && result.get(0).equals("cutoff");
	}

	@Override
	public Metrics getMetrics() {
		return iterationMetrics;
	}

}