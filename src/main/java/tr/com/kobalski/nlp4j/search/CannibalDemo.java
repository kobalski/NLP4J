package tr.com.kobalski.nlp4j.search;


import java.util.*;
import java.io.*;

//Author ibrahim G�RSES
public class CannibalDemo {

	public static void main (String[] args) {
		
		int numberOfCannibals;
		int numberOfMissionaries;
		int boatSize;
	
		Scanner scan = new Scanner(System.in);
		System.out.println ("Please Enter the Number of Cannibals:");
		numberOfCannibals = scan.nextInt();
		System.out.println ("Please Enter the Number of Missionaries:");	
		numberOfMissionaries = scan.nextInt();	
		System.out.println ("Please Enter the Boat Size:");	
		boatSize = scan.nextInt();
		newCannibalDemo(numberOfCannibals,numberOfMissionaries,boatSize);
		
	}


	private static void newCannibalDemo(int can, int mis, int boat) {
		String s ="";
		double start,stop;//used for timer
		s = s + Integer.toString(can) + Integer.toString(mis)+"00"
		
		 	+ Integer.toString(boat)+ "1";
	
		start = System.currentTimeMillis(); 	
		cannibalWithBreadthFirstSearch(s);
		stop = System.currentTimeMillis();
		System.out.println("Time passed in miliseconds: " + (stop-start));
		System.out.println();
		System.out.println ("End of BreadthFirst Search");
		System.out.println ("-----------------------------------");
		System.out.println();
		
		start = System.currentTimeMillis();
		cannibalWithDepthFirstSearch(s);
		stop = System.currentTimeMillis();
		System.out.println("Time passed in miliseconds: " + (stop-start));
		System.out.println();
		System.out.println ("End of DepthFirst Search");
		System.out.println ("-----------------------------------");
		System.out.println();
	
		start = System.currentTimeMillis();
		cannibalAStar(s);
		stop = System.currentTimeMillis();
		System.out.println("Time passed in miliseconds: " + (stop-start));
		System.out.println();
		System.out.println ("End of A* Search");
		System.out.println ("-----------------------------------");
		System.out.println();
		
		start = System.currentTimeMillis();
		cannibalWithNewHeuristic(s);
		stop = System.currentTimeMillis();
		System.out.println("Time passed in miliseconds: " + (stop-start));
		System.out.println();
		System.out.println ("End of A* Search with new heuristic");
		System.out.println ("-----------------------------------");
		System.out.println();
		
		start = System.currentTimeMillis();
		cannibalWithIterativeDeepeningSearch(s);
		stop = System.currentTimeMillis();
		System.out.println("Time passed in miliseconds: " + (stop-start));
		System.out.println();
		System.out.println ("End of IterativeDeepening Search");
		System.out.println ("-----------------------------------");
		System.out.println();
		
		
	}

	public static void cannibalWithBreadthFirstSearch(String currentState) 
	{
		
		System.out.println("\nCannibalDemo BFS -->");
		String[] goalTest = new String [1];
		int misR = Integer.parseInt( ""+ currentState.charAt (0));
	 	int canR = Integer.parseInt( ""+ currentState.charAt (1));
	 	int boatSize = Integer.parseInt( "" + currentState.charAt (4));
	 	goalTest[0] = "00" + misR + canR +  boatSize + "0";
	 		
	 	try {
			Problem problem = new Problem(currentState,
							new CannibalSuccessorFunction(),
							new CannibalGoalTest(goalTest[0]),
							new CannibalStepCostFunction(),
							new CannibalHeuristicFunction() );
			Search search = new BreadthFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			if(agent.getActions().size() == 0)
			{
				System.out.println ("Sorry No Solution exists");
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
			else{
			    System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	
		
	}
	
	private static void cannibalWithDepthFirstSearch(String currentState) {
		System.out.println("\nCannibalDemo DFS -->");
		
		
		String[] goalTest = new String [1];
		int misR = Integer.parseInt( ""+ currentState.charAt (0));
	 	int canR = Integer.parseInt( ""+ currentState.charAt (1));
	 	int boatSize = Integer.parseInt( "" + currentState.charAt (4));
	 	goalTest[0] = "00" + misR + canR +  boatSize + "0";
	 	
	 	try {
			Problem problem = new Problem(currentState,
							new CannibalSuccessorFunction(),
							new CannibalGoalTest(goalTest[0]),
							new CannibalStepCostFunction(),
							new CannibalHeuristicFunction() );
			Search search = new DepthFirstSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			if(agent.getActions().size() == 0)
			{
				System.out.println ("Sorry No Solution exists");
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
			else{
			
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}
	
		
	private static void cannibalAStar( String currentState) {
		
		System.out.println("\nCannibalDemo with A* Search  -->");
		String[] goalTest = new String [1];
		int misR = Integer.parseInt( ""+ currentState.charAt (0));
	 	int canR = Integer.parseInt( ""+ currentState.charAt (1));
	 	int boatSize = Integer.parseInt( "" + currentState.charAt (4));
	 	goalTest[0] = "00" + misR + canR +  boatSize + "0";
			
		try {
			Problem problem = new Problem(currentState,
							new CannibalSuccessorFunction(),
							new CannibalGoalTest(goalTest[0]),
							new CannibalStepCostFunction(),
							new CannibalHeuristicFunction() );
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			if(agent.getActions().size() == 0)
			{
				System.out.println ("Sorry No Solution exists!");
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
			else{
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void cannibalWithNewHeuristic( String currentState){
			
			
		System.out.println("\nCannibalDemo with A* Search with new heuristic -->");
		String[] goalTest = new String [1];
		int misR = Integer.parseInt( ""+ currentState.charAt (0));
	 	int canR = Integer.parseInt( ""+ currentState.charAt (1));
	 	int boatSize = Integer.parseInt( "" + currentState.charAt (4));
	 	goalTest[0] = "00" + misR + canR +  boatSize + "0";
			
		try {
			Problem problem = new Problem(currentState,
							new CannibalSuccessorFunction(),
							new CannibalGoalTest(goalTest[0]),
							new CannibalStepCostFunction(),
							new CannibalNewHeuristicFunction() );
			Search search = new AStarSearch(new GraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			if(agent.getActions().size() == 0)
			{
				System.out.println ("Sorry No Solution exists!");
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
			else{
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	private static void cannibalWithIterativeDeepeningSearch(String currentState) {
	
		System.out.println("\nCannibalDemo with Iterative deepening search Search  -->");
		String[] goalTest = new String [1];
		int misR = Integer.parseInt( ""+ currentState.charAt (0));
	 	int canR = Integer.parseInt( ""+ currentState.charAt (1));
	 	int boatSize = Integer.parseInt( "" + currentState.charAt (4));
	 	goalTest[0] = "00" + misR + canR +  boatSize + "0";
			
		try {
			Problem problem = new Problem(currentState,
							new CannibalSuccessorFunction(),
							new CannibalGoalTest(goalTest[0]),
							new CannibalStepCostFunction(),
							new CannibalHeuristicFunction() );
			Search search = new IterativeDeepeningSearch();
			SearchAgent agent = new SearchAgent(problem, search);
			printActions(agent.getActions());
			if(agent.getActions().size() == 0)
			{
				System.out.println ("Sorry No Solution exists");
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
			else{
				System.out.println ();
				printInstrumentation(agent.getInstrumentation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	
	private static void printInstrumentation(Properties properties)throws Exception {
		Iterator keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
		
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List actions) {
		for (int i = 0; i < actions.size(); i++) {
			
			BasicEnvironmentView env = new BasicEnvironmentView();
			String action = (String) actions.get(i);
			env.envChanged(action);
		}
	}
}