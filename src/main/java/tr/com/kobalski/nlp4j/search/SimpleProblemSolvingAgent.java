package tr.com.kobalski.nlp4j.search;



import java.util.ArrayList;
import java.util.List;

public abstract class SimpleProblemSolvingAgent extends Agent {

	// seq, an action sequence, initially empty
	private List<String> seq = new ArrayList<String>();

	//
	private boolean formulateGoalsIndefinitely = true;

	private int maxGoalsToFormulate = 1;

	private int goalsFormulated = 0;

	public SimpleProblemSolvingAgent() {
		formulateGoalsIndefinitely = true;
	}

	public SimpleProblemSolvingAgent(int maxGoalsToFormulate) {
		formulateGoalsIndefinitely = false;
		this.maxGoalsToFormulate = maxGoalsToFormulate;
	}

	// function SIMPLE-PROBLEM-SOLVING-AGENT(percept) returns an action
	@Override
	public String execute(Percept p) {
		String action = NO_OP;

		// state <- UPDATE-STATE(state, percept)
		Object state = updateState(p);
		// if seq is empty then do
		if (0 == seq.size()) {
			if (formulateGoalsIndefinitely
					|| goalsFormulated < maxGoalsToFormulate) {
				if (goalsFormulated > 0) {
					notifyViewOfMetrics();
				}
				// goal <- FORMULATE-GOAL(state)
				Object goal = formulateGoal();
				goalsFormulated++;
				// problem <- FORMULATE-PROBLEM(state, goal)
				Problem problem = formulateProblem(goal);
				// seq <- SEARCH(problem)
				seq.addAll(search(problem));
				if (0 == seq.size()) {
					// Unable to identify a path
					seq.add(NO_OP);
				}
			} else {
				// Agent no longer wishes to
				// achieve any more goals
				die();
				notifyViewOfMetrics();
			}
		}

		if (seq.size() > 0) {
			// action <- FIRST(seq)
			action = Util.first(seq);
			// seq <- REST(seq)
			seq = Util.rest(seq);
		}

		return action;
	}

	//
	// PROTECTED METHODS
	//
	protected abstract Object updateState(Percept p);

	protected abstract Object formulateGoal();

	protected abstract Problem formulateProblem(Object goal);

	protected abstract List<String> search(Problem problem);

	protected abstract void notifyViewOfMetrics();
}