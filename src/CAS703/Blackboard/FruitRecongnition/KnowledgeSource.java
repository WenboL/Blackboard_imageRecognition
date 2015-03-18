package CAS703.Blackboard.FruitRecongnition;

public class KnowledgeSource{

	BlackBoard blackBoard =new BlackBoard();
	
	//Initialize Agents Add new agent here
	Input input;
	Agent_pixel pixel;
	Agent_RGB rgb;
	Agent_ResultChecker checker;
	
	public void run(BlackBoard blackboard){
		//add new agent here
		input =new Input();
		pixel =new Agent_pixel();
		rgb = new Agent_RGB();
		checker = new Agent_ResultChecker();
		
		for (int i=0; i<9; i++){
			input.run(blackBoard);			  
			pixel.run(blackBoard);
			rgb.run(blackBoard);
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
