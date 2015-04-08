/**
 * Created by Wenbo Liu on 05-03-20.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: Agent_ImageSource.java
 * In this file, it will set all the available images from local
 * Used blackboard value: 
 */

package CAS703.Blackboard.FruitRecongnition;

import java.util.ArrayList;

public class Agent_ImageSource {
	public void run(BlackBoard blackboard){

		String AppleIcon =  "appleIcon.png";
		String BananaIcon = "bananaIcon.png";
		String PepperIcon = "pepperIcon.png";
		String UndefinedIcon = "undefinedIcon.png";
		String imgApple =  "apple.jpg";
		String imgBanana = "banana.jpg";
		String imgPepper = "pepper.jpg";
		String imgUndefined = "undefined.jpg";
		
		ArrayList<String> imgAddress=blackboard.getImgAddress();
		ArrayList<String> iconAddress=blackboard.getIconAddress();
		imgAddress.add(imgApple);
		imgAddress.add(imgBanana);
		imgAddress.add(imgPepper);
		imgAddress.add(imgUndefined);
		
		iconAddress.add(AppleIcon);
		iconAddress.add(BananaIcon);
		iconAddress.add(PepperIcon);
		iconAddress.add(UndefinedIcon);
		
		blackboard.setImgAddress(imgAddress);
		blackboard.setIconAddress(iconAddress);
	}


}
