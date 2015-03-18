package CAS703.Blackboard.FruitRecongnition;

//import java.util.LinkedList;
//import java.util.List;

public class Start {
	
	BlackBoard blackBoard =new BlackBoard();
//	List<KnowledgeSource> sourceList =new LinkedList<KnowledgeSource>();
	KnowledgeSource knowledgeSource;
	Agent_output output;

	
	public Start(){

		knowledgeSource = new KnowledgeSource();
		output = new Agent_output();

		knowledgeSource.run(blackBoard);
		UI_Window frame = new UI_Window("The basket", 1280, 760, blackBoard);
		output.run(blackBoard);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();

		
	}

}
