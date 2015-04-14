/**
 * Created by Wenbo Liu on 05-03-20.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: KnowledgeSource.java
 * This file is the knowledge source management file that will call all the agents one by one 
 * Used blackboard value: getFruitNumber, getImagelists,
 */
package CAS703.Blackboard.FruitRecongnition;

import java.util.ArrayList;

public class KnowledgeSource{

	BlackBoard blackBoard =new BlackBoard();
	
	//Initialize Agents Add new agent here
	InputGenerator input;
	Agent_Pixel pixel;
	Agent_RGB rgb;
	Agent_ResultChecker checker;
	Agent_FastBitmap bitmap;
	
	public void run(BlackBoard blackboard){
		//add new agent here
//		input =new Input();
		pixel =new Agent_Pixel();
		rgb = new Agent_RGB();
		checker = new Agent_ResultChecker();
		bitmap = new Agent_FastBitmap();
		
		int j = blackboard.getFruitNumber();
		for (int i=0; i<j; i++){

			ArrayList<String> imgs = blackboard.getImagelists();
			String img = imgs.get(i);
			blackboard.setImg(img);
			//input.run(blackBoard);			
			pixel.run(blackBoard);
			rgb.run(blackBoard);
			bitmap.run(blackboard);
			checker.run(blackBoard);
			
			
		}
	}


//public abstract class KnowledgeSource implements Runnable {
//	boolean run_flag = false;
//		
//	protected BlackBoard blackboard = null;
//	
//	public void run(){
//		while(true){
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			//
//			onNotify();
//			if(!run_flag)  {
//				//System.out.print("Complete component: "+ this.getClass().getName());
//				//break;
//			}
//		}
//	}
//	
//	public void start(){
//		if(this.run_flag == false ){
//			this.run_flag =true;
//			Thread thread = new Thread(this);			
//			thread.start();
//		}
//	}
//	
//	public void stop(){
//		this.run_flag =false;
//	}
//	
//	abstract protected void onNotify();
//	
//	public void attach(BlackBoard blackBoard){
//		this.blackboard = blackBoard;
//		//System.out.println("BB="+this.blackboard.toString());
//	}

}
