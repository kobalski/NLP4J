package tr.com.kobalski.nlp4j.search;


public class MapDemo {

	public static void main(String[] args) {
		newMapDemo();
	}

	private static void newMapDemo() {
	
		mapWithBreadthFirstSearch();
		
	}

	private static void mapWithBreadthFirstSearch() {
		System.out.println("\nMapDemo BFS -->");

		MapEnvironment me = new MapEnvironment(SimplifiedRoadMapOfPartOfRomania
				.getMapOfRomania());
		MapAgent ma = new MapAgent(me,
				new BreadthFirstSearch(new GraphSearch()), 2);
		me.addAgent(ma, SimplifiedRoadMapOfPartOfRomania.EFORIE);
		me.registerView(new BasicEnvironmentView());
		me.stepUntilNoOp();
	}

	



}