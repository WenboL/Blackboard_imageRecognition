package CAS703.Blackboard.FruitRecongnition;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
 
public class Agent_RGB extends Component {
 
  private String compareImage(BufferedImage image) {
    int w = image.getWidth();
    int h = image.getHeight();
    int RGB = image.getRGB(w/2, h*2/3);
	int[] RGBValue = new int[3]; 
	String fruit="";
	RGBValue[0] = (RGB >> 16) & 0xff;
	RGBValue[1] = (RGB >> 8) & 0xff;
	RGBValue[2] = (RGB) & 0xff;
	
//    System.out.println("argb: " + RGBValue[0] + ", " + RGBValue[1] + ", " + RGBValue[2]);
	if (RGBValue[0]==243 && RGBValue[1]==231 && RGBValue[2]==129){
    	fruit="banana";

    }else if (RGBValue[0]==158 && RGBValue[1]==13 && RGBValue[2]==42){
    	fruit="apple";
    }
	System.out.println("RGB_Value detection: "+fruit);
	
    return fruit;
    
//    for (int i = 0; i < h; i++) {
//      for (int j = 0; j < w; j++) {
//        System.out.println("x,y: " + j + ", " + i);
//        int pixel = image.getRGB(j, i);
//        IdentifyRGB(pixel);
//        System.out.println("");
//      }
//    }
  }
 
  public void run(BlackBoard blackboard) {
	String img = blackboard.getImg();
    try {
        // get the BufferedImage, using the ImageIO class
    	File file = new File(img);
        BufferedImage image = ImageIO.read(file);
        
        blackboard.setRGBResult(compareImage(image));
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }

//	identifiedFruits.add(fruit);
//	blackboard.setIdentifiedFruits(identifiedFruits);
  }
 
}