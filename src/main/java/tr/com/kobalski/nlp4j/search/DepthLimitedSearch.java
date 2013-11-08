package tr.com.kobalski.nlp4j.search;



import java.util.ArrayList;
import java.util.List;


public class DepthLimitedSearch extends NodeExpander implements Search {
	private static String PATH_COST = "pathCost";

	private final int limit;

	public DepthLimitedSearch(int limit) {
		this.limit = limit;

	}

	// function DEPTH-LIMITED-SEARCH(problem, limit) returns a solution, or
	// failure/cutoff
	public List search(Problem p) throws Exception {
		clearInstrumentation();
		// return RECURSIVE-DLS(MAKE-NODE(INITIAL-STATE[problem]), problem,
		// limit)
		return recursiveDLS(new Node(p.getInitialState()), p, limit);
	}

	// function RECURSIVE-DLS(node, problem, limit) returns a solution, or
	// failure/cutoff
	private List recursiveDLS(Node node, Problem problem, int limit) {
		// cutoff_occurred? <- false
		boolean cutOffOccured = false;
		// if GOAL-TEST[problem](STATE[node]) then return SOLUTION(node)
		if (problem.isGoalState(node.getState())) {
			setPathCost(node.getPathCost());
			return SearchUtils.actionsFromNodes(node.getPathFromRoot());
			// else if DEPTH[node] = limit then return cutoff
		} else if (node.getDepth() == limit) {
			return createCutOffResult();
		} else {
			// else for each successor in EXPAND(node, problem) do
			List children = expandNode(node, problem);
			for (int i = 0; i < children.size(); i++) {
				Node child = (Node) children.get(i);
				// result <- RECURSIVE-DLS(successor, problem, limit)
				List result = recursiveDLS(child, problem, limit);
				// if result = cutoff then cutoff_occurred? <- true
				if (cutoffResult(result)) {
					cutOffOccured = true;
					// else if result != failure then return result
				} else if (!(failure(result))) {
					return result;
				}
			}
			// if cutoff_occurred? then return cutoff else return failure
			if (cutOffOccured) {
				return createCutOffResult();
			} else {
				return new ArrayList();
			}

		}

	}

	@Override
	public void clearInstrumentation() {
		super.clearInstrumentation();
		metrics.set(PATH_COST, 0);
	}

	public double getPathCost() {
		return metrics.getDouble(PATH_COST);
	}

	public void setPathCost(Double pathCost) {
		metrics.set(PATH_COST, pathCost);
	}

	private boolean failure(List result) {

		return result.size() == 0;
	}

	private boolean cutoffResult(List result) {

		return result.size() == 1 && result.get(0).equals("cutoff");
	}

	private List createCutOffResult() {
		List result = new ArrayList();
		result.add("cutoff");
		return result;
	}

}