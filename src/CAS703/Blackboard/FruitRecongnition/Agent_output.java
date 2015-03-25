package CAS703.Blackboard.FruitRecongnition;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Agent_output {

	public void run(BlackBoard blackboard) {

		ArrayList<String> fruits = blackboard.getIdentifiedFruits();
		double cost = 0;
		String fruit="";
		
		System.out.println("You are buying these fruits: "+fruits);
		for(int i=0 ;i < fruits.size(); i++ ){
			fruit = fruits.get(i);
			if (fruit == "apple"){
				cost += 0.5;
			}else if (fruit == "banana" ){
				cost += 0.7;
			}
		}
		DecimalFormat df = new DecimalFormat("#.##");      
		cost = Double.valueOf(df.format(cost));
		UI_Window frame = new UI_Window("The basket", 960, 480, blackboard, cost);
		System.out.println("Total cost is: $"+ cost);
		
		
	}	

}
