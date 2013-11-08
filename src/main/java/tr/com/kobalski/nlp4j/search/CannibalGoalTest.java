package tr.com.kobalski.nlp4j.search;


//Author ibrahim G�RSES
public class CannibalGoalTest implements GoalTest {
	
	private String goalState;

	public CannibalGoalTest(String goalState) {
		
		this.goalState = goalState;
	}

	public boolean isGoalState( Object currentState) {
		
		String state = currentState.toString();
		
		if (currentState instanceof Percept) {
			state = (String) ((Percept) currentState)
					.getAttribute("In");
		}
		
		
		return state.equals(goalState);
	}
}