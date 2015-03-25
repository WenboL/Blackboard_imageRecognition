package CAS703.Blackboard.FruitRecongnition;

//import java.util.LinkedList;
//import java.util.List;

public class Start {
	
	FirstWindow openwindow;
	
//	BlackBoard blackBoard =new BlackBoard();
////	List<KnowledgeSource> sourceList =new LinkedList<KnowledgeSource>();
//	KnowledgeSource knowledgeSource;
//	Agent_output output;	
//	
//	public void afterStart(){
//		knowledgeSource = new KnowledgeSource();
//		output = new Agent_output();
//		knowledgeSource.run(blackBoard);
//// 		UI_Window frame = new UI_Window("The basket", 960, 760, blackBoard);
//		output.run(blackBoard);
//	}
	
	public Start(){
		openwindow = new FirstWindow();
		openwindow.run();

	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();
	}

}
