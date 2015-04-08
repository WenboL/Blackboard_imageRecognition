/**
 * Created by Wenbo Liu on 15-03-20.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * This file is the entry to start the program, currently only calls the main UI window "FirstWindow"
 */

package CAS703.Blackboard.FruitRecongnition;

//import java.util.LinkedList;
//import java.util.List;

public class Start {
	
	MainWindow openwindow;
	Agent_ImageSource loadImageSource;
	
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
		openwindow = new MainWindow();

		openwindow.run();
		
		

	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();
	}

}
