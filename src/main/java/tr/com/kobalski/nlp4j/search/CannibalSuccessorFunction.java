package tr.com.kobalski.nlp4j.search;


import java.util.ArrayList;
import java.util.List;

//Author: kobalski

public class CannibalSuccessorFunction implements SuccessorFunction {

	public CannibalSuccessorFunction() {

	}

	public List getSuccessors( Object aCurrentState)
	{
		String currentState = aCurrentState.toString();
	 	int misR,canR,misL,canL,boatSize,boatPosition;
	 	int tempMisR ,tempMisL,tempCanR,tempCanL,tempPos;
	 	String tempState;
	 		
	 	misR = Integer.parseInt( ""+ currentState.charAt (0));
	 	canR = Integer.parseInt( ""+ currentState.charAt (1));
	 	misL = Integer.parseInt( "" + currentState.charAt (2));
	 	canL = Integer.parseInt( "" +currentState.charAt (3));
	 	boatSize = Integer.parseInt( "" + currentState.charAt (4));
	 	boatPosition = Integer.parseInt( "" + currentState.charAt (5));
	 	 	
	 	tempMisR = misR;
		tempCanR = canR;
		tempMisL = misL;
		tempCanL = canL;
		tempPos = boatPosition;
		tempState = "";
	 	
		List<Successor> successors = new ArrayList<Successor>();
		List<String> states = new ArrayList <String> ();
		List<String> actions = new ArrayList <String> ();
		//First Control if the boat is on the left or Right
		if( boatPosition == 1){
			/*The two for loops creates all possible actions with the given 
			/boat size value*/
			for (int i = 0; i<= boatSize;i++){
			
				for (int j = 0; i+j <= boatSize; j++ )
				{ 
					if ( i+j != 0){
						
						tempMisR -= i;// Remove people form right
						tempCanR -= j;
						tempMisL += i;//Add people to the left
						tempCanL += j;
						tempPos = 0;
						if (tempMisR >= 0 && tempCanR >= 0)
							if( tempMisL <= (tempMisR+tempMisL) &&tempCanL <= (tempCanR+tempCanL) )
							{
								tempState = tempState + tempMisR + tempCanR + tempMisL+ tempCanL + boatSize + tempPos;
								if (checkForValidity ( tempState)){
									
									states.add(tempState);
									actions.add ("" + i + j + tempPos);
								}
							}
					}	
					tempMisR = misR;
					tempCanR = canR;
					tempMisL = misL;
					tempCanL = canL;
					tempPos = boatPosition;
					tempState = "";
				}
			}
		}
		else{
			
			for (int i = 0; i<= boatSize;i++){
			
				for (int j = 0; i+j <= boatSize; j++ )
				{ 
					if ( i+j != 0){
						
						tempMisR += i;// re
						tempCanR += j;
						tempMisL -= i;
						tempCanL -= j;
						tempPos = 1;
						
						if (tempMisL >= 0 && tempCanL >= 0)
							if( tempMisR <= (tempMisR+tempMisL) &&tempCanR <= (tempCanR+tempCanL) )
							{
								tempState = tempState + tempMisR + tempCanR + tempMisL+ tempCanL + boatSize + tempPos;
								if (checkForValidity ( tempState)){
									
									states.add(tempState);
									actions.add ("" + i + j + tempPos);
								}
								
							}
					}	
					tempMisR = misR;
					tempCanR = canR;
					tempMisL = misL;
					tempCanL = canL;
					tempPos = boatPosition;
					tempState = "";
				}
			}
		}	
		
		for (int i =0; i < states.size();i++ ){
			
			successors.add ( new Successor( actions.get(i), states.get(i)));
		}

		return successors;
	}
	
	//This methods checks the validity of a  state according to the
	//constraints of the Missionaries and Cannibals Problem
	private static boolean checkForValidity (String state ){
		
			int misR,canR,misL,canL,boatSize;		
	 		misR = Integer.parseInt( ""+ state.charAt(0));
	 		canR = Integer.parseInt( ""+ state.charAt (1));
	 		misL = Integer.parseInt( "" + state.charAt (2));
	 		canL = Integer.parseInt( "" + state.charAt (3));
	 	
		
			if((misR !=0)&&( misL!=0)) {
        		if((misR>= canR)&&( misL >= canL)) {
          	
          			return true;
        		}
        
      		}
      		else {
       			if( misR==0 ) {
          			if(canR >= misR) {
            			return true;
          			}
       			}
        		if( misL == 0) {
          			if( canL >= misL ) {
            			return true;
          			}
        		}
      		}
     		return false;
    		
			
	}
		

	
}
