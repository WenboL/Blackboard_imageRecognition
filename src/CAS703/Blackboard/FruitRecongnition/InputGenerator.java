/**
 * Created by Wenbo Liu.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: InputGenerator.java
 * In this file, it will randomly generate the inpput image for user
 * Used blackboard value: getImagelist, setImagelist, setImg
 */
package CAS703.Blackboard.FruitRecongnition;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;


public class InputGenerator{
	//random the image number then select image as a new input
	public void run(BlackBoard blackboard) {
		  String basePath = new File("").getAbsolutePath();
		  String imgApple = basePath + "/res/apple.jpg";
		  String imgBanana = basePath + "/res/banana.jpg";
		  String img = null;
		  Random rand = new Random();
		  int  n = rand.nextInt(2) + 1;
		  if (n == 1) {
			  img=imgApple;

		  } else if (n==2){
			  img=imgBanana;

		  }
		  //send back to blackboard the current img add to the input image list
		  blackboard.setImg(img);
		  ArrayList<Integer> imagelist = blackboard.getImagelist();
		  imagelist.add(n);
		  blackboard.setImagelist(imagelist);
	 }
	

}