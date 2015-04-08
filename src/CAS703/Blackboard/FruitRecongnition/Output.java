/**
 * Created by Wenbo Liu.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: Output.java
 * In this file, it will set and calculate all the needed value for final display, and call the UI_Window.
 * Used blackboard value: getIdentifiedFruits 
 */
package CAS703.Blackboard.FruitRecongnition;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Output {

	public void run(BlackBoard blackboard) {

		ArrayList<String> fruits = blackboard.getIdentifiedFruits();
		double cost = 0;
		String fruit="";
		//calculating price
		System.out.println("You are buying these fruits: "+fruits);
		for(int i=0 ;i < fruits.size(); i++ ){
			fruit = fruits.get(i);
			if (fruit == "apple"){
				cost += 0.5;
			}else if (fruit == "banana" ){
				cost += 0.7;
			}
		}
		//print log and open UI window
		DecimalFormat df = new DecimalFormat("#.##");      
		cost = Double.valueOf(df.format(cost));
		@SuppressWarnings("unused")
		OutputWindow frame = new OutputWindow("The basket", 640, 480, blackboard, cost);
		System.out.println("Total cost is: $"+ cost);
		
		
	}	

}
