/**
 * Created by Wenbo Liu on 05-03-20.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: BlackBoard.java
 * In this file, it is the blackboard, contains all the data and result, 
 * each agent will exchange information here.
 */
package CAS703.Blackboard.FruitRecongnition;
import java.util.ArrayList;

public class BlackBoard {
	
	//Set the currently working image, which will be used in pixel and rgb agent
	static private String img = null;
	static private String fruitKind = null;
	
	//pixelResult is the identified result from Agent pixel
	static private String pixelResult = null;
	
	//rgbResult is the identified reult from Agent RGB
	static private String rgbResult = null;
	
	//To set the number of fruits user choosed
	static private Integer fruitNumber = 0;
	
	//identifiedFruits are the final result that identifed by result checker
	static private ArrayList<String> identifiedFruits = new ArrayList<String>() ;
	
	//imagelist is the image number that system generates, 1 for apple, 2 for banana. 
	static private ArrayList<Integer> imagelist = new ArrayList<Integer>() ;
	
	//imagelists is the address of images that user inputs, each indext is one input image.
	static private ArrayList<String> imagelists = new ArrayList<String>() ;
	
	//imgAddress contains the path to all the available images
	static private ArrayList<String> imgAddress = new ArrayList<String>() ;	
	
	//iconAddress contains the path to all the available image icons
	static private ArrayList<String> iconAddress = new ArrayList<String>() ;	
	
	//bitmapResult is the identified result from Agent FastBitmap
	static private String bitmapResult = null;
	
	
	
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
	public String getBitmapResult(){
		return BlackBoard.bitmapResult;
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
	public ArrayList<String> getImgAddress() {
		return BlackBoard.imgAddress;
	}	
	public ArrayList<String> getIconAddress() {
		return BlackBoard.iconAddress;
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
	//Used in "MainWindow", "KnowledgeSource"
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
	//Used in "KnowledgeSource", "MainWindow"
	public synchronized void setImagelists(ArrayList<String> imagelists) {
		BlackBoard.imagelists = imagelists;
	}
	
	//imgAddress contains the path to all the available images
	//used in Agent_ImageSource 
	public synchronized void setImgAddress(ArrayList<String> imgAddress) {
		BlackBoard.imgAddress = imgAddress;
	}
	
	//iconAddress contains the path to all the available image icons
	//used in Agent_ImageSource 
	public synchronized void setIconAddress(ArrayList<String> iconAddress) {
		BlackBoard.iconAddress = iconAddress;
	}
	
	//bitmapResult contains the answer from agent FastBitmap
	//used in Agent_FastBitmap
	public void setFastBitMapResult(String FastBitMapResult) {
		// TODO Auto-generated method stub
		BlackBoard.bitmapResult = FastBitMapResult;
		
	}
}
