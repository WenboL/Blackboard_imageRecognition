package CAS703.Blackboard.FruitRecongnition;
import java.util.ArrayList;


public class Agent_ResultChecker {
	//simple check to see if the results are the same
	public String identifier(String pixelResult, String rgbResult){
		String result = "";
		
		if(pixelResult.equals(rgbResult)){

			result = pixelResult;
		}else result = "Unidentified";
		return result;
	}
	
	//update blackboard with the final answer to identified fruits list
	public void run(BlackBoard blackboard) {
		String pixelResult = blackboard.getPixelResult();
		String rgb = blackboard.getRGBResult();
		ArrayList<String> identifiedFruits = blackboard.getIdentifiedFruits();
		identifiedFruits.add(identifier(pixelResult, rgb));
		blackboard.setIdentifiedFruits(identifiedFruits);
	}
	
}
