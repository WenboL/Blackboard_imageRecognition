package CAS703.Blackboard.FruitRecongnition;
import java.util.ArrayList;

public class BlackBoard {
	static private String img = null;
	static private String fruitKind = null;
	static private String pixelResult = null;
	static private String rgbResult = null;
	static private Integer fruitNumber = 0;
	static private ArrayList<String> identifiedFruits = new ArrayList<String>() ;
	static private ArrayList<Integer> imagelist = new ArrayList<Integer>() ;	
	static private ArrayList<String> imagelists = new ArrayList<String>() ;	
	
	
	
	public String getImg() {
		return BlackBoard.img;
	}
	public String getFruitKind() {
		return BlackBoard.fruitKind;
	}
	public String getPixelResult() {
		return BlackBoard.pixelResult;
	}
	public String getRGBResult() {
		return BlackBoard.rgbResult;
	}
	public Integer getFruitNumber() {
		return BlackBoard.fruitNumber;
	}
	public ArrayList<String> getIdentifiedFruits() {
		return BlackBoard.identifiedFruits;
	}
	public ArrayList<Integer> getImagelist() {
		return BlackBoard.imagelist;
	}
	public ArrayList<String> getImagelists() {
		return BlackBoard.imagelists;
	}	
	//All set method are synchronized though no multi-thread in our cases---------------------------
	
	//pixelResult is the identified result from Agent pixel
	//Used in "Agent_Pixel"
	public synchronized void setPixelResult(String pixelResult) {
		BlackBoard.pixelResult = pixelResult;
	}
	
	//rgbResult is the identified reult from Agent RGB
	//Used in "Agent_RGB"
	public synchronized void setRGBResult(String rgbResult) {
		BlackBoard.rgbResult = rgbResult;
	}
	
	//
	//Used in
	public synchronized void setFruitKind(String fruitKind) {
		BlackBoard.fruitKind = fruitKind;
	}
	
	//To set the number of fruits user choosed
	//Used in "FirstWindow", "KnowledgeSource"
	public synchronized void setFruitNumber() {
		BlackBoard.fruitNumber = new Integer(BlackBoard.fruitNumber.intValue() + 1);
	}
	
	//identifiedFruits are the final result that identifed by result checker
	//Used in "Agent_ResultChecker" 
	public synchronized void setIdentifiedFruits(ArrayList<String> identifiedFruits) {
		BlackBoard.identifiedFruits = identifiedFruits;
	}
	
	//Set the currently working image, which will be used in pixel and rgb agent
	//Used in "KnowledgeSource", "Agent_Pixel", "Agent_RGB"
	public synchronized void setImg(String img) {
		BlackBoard.img = img;
	}
	
	//imagelist is the image number that system generates, 1 for apple, 2 for banana. 
	//Used in "Inputs"
	public synchronized void setImagelist(ArrayList<Integer> imagelist) {
		BlackBoard.imagelist = imagelist;
	}
	
	//imagelists is the address of images that user inputs, each indext is one input image.
	//Used in "KnowledgeSource", "FirstWindow"
	public synchronized void setImagelists(ArrayList<String> imagelists) {
		BlackBoard.imagelists = imagelists;
	}
}
