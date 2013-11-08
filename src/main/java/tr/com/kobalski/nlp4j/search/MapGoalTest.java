package tr.com.kobalski.nlp4j.search;



public class MapGoalTest implements GoalTest {
	private String goalState = null;

	public MapGoalTest(String goalState) {
		this.goalState = goalState;
	}

	public boolean isGoalState(Object currentState) {

		String location = currentState.toString();
		if (currentState instanceof Percept) {
			location = (String) ((Percept) currentState)
					.getAttribute(MapEnvironment.STATE_IN);
		}

		return goalState.equals(location);
	}
}
