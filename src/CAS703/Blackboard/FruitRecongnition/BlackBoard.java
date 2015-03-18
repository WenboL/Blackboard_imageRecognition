package CAS703.Blackboard.FruitRecongnition;
import java.util.ArrayList;

public class BlackBoard {
	static private String img = null;
	static private String fruitKind = null;
	static private String pixelResult = null;
	static private String rgbResult = null;
	static private ArrayList<String> identifiedFruits = new ArrayList<String>() ;
	static private ArrayList<Integer> imagelist = new ArrayList<Integer>() ;	
	
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
	public ArrayList<String> getIdentifiedFruits() {
		return BlackBoard.identifiedFruits;
	}
	public ArrayList<Integer> getImagelists() {
		return BlackBoard.imagelist;
	}	
	//All set method are synchronized though no multi-thread in our cases
	public synchronized void setPixelResult(String pixelResult) {
		BlackBoard.pixelResult = pixelResult;
	}
	public synchronized void setRGBResult(String rgbResult) {
		BlackBoard.rgbResult = rgbResult;
	}
	public synchronized void setFruitKind(String fruitKind) {
		BlackBoard.fruitKind = fruitKind;
	}
	public synchronized void setIdentifiedFruits(ArrayList<String> identifiedFruits) {
		BlackBoard.identifiedFruits = identifiedFruits;
	}
	public synchronized void setImg(String img) {
		BlackBoard.img = img;
	}
	public synchronized void setImagelists(ArrayList<Integer> imagelist) {
		BlackBoard.imagelist = imagelist;
	}
}
