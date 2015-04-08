/**
 * Created by Wenbo Liu.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: Agent_ResultChecker.java
 * In this file, it checks the result from agents and give a final result to blackboard.
 * Used blackboard value: getPixelResult, getRGBResult, getIdentifiedFruits, setIdentifiedFruits
 * Improve dependency that no need to update it when adding new agent. 
 * ToDo: It will obtain the agent list, and their weight, apply these weight to result for more accuracy.
 */
package CAS703.Blackboard.FruitRecongnition;
import java.util.ArrayList;


public class Agent_ResultChecker {
	//simple check to see if the results are the same
//	public String identifier(String pixelResult, String rgbResult){
//		String result = "";
//		
//		if(pixelResult.equals(rgbResult)){
//			result = pixelResult;
//		}else result = "Unidentified";
//		return result;
//	}
	
	
	public String identifier(String[] results, int number){
		String result = "";
		
		for (int i=0; i<number; i++){
				if (results[0] == results[i]){
					result = results[0];
				}	else result = "Unidentified";
			}
		return result;

	}
	
	//update blackboard with the final answer to identified fruits list
	public void run(BlackBoard blackboard) {
		//update this number by adding 1 for adding new agents.
		int agentNumber = 2;
		String[] results=new String[agentNumber];
		
		//add new agent's answer grabber below
		String pixelResult = blackboard.getPixelResult();
		String rgb = blackboard.getRGBResult();
		//add new agent's answer to results
		results[0] = pixelResult;
		results[1] = rgb;
		
		
		
		ArrayList<String> identifiedFruits = blackboard.getIdentifiedFruits();
//		identifiedFruits.add(identifier(pixelResult, rgb));
		identifiedFruits.add(identifier(results, agentNumber));
		blackboard.setIdentifiedFruits(identifiedFruits);
	}
	
}
