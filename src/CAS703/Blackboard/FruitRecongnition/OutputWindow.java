/**
 * Created by Wenbo Liu on 05-03-20.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: OutputWindow.java
 * In this file, it will create a window for output the result.
 * Used blackboard value: getIdentifiedFruits
 */
package CAS703.Blackboard.FruitRecongnition;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class OutputWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage bi1, bi2, bi3;
	private ArrayList<String> inputs;
	private String cost;
	//Loading image files.
	public OutputWindow(String title, int width, int height, BlackBoard blackboard, double money){
			setTitle(title);
			setSize(width, height);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			setLocationRelativeTo(null);
			setVisible(true);
			cost = String.valueOf(money);
			inputs = blackboard.getIdentifiedFruits();
//			  String basePath = new File("").getAbsolutePath();
//			  String imgApple = basePath + "/res/apple.jpg";
//			  String imgBanana = basePath + "/res/banana.jpg";
//			  String imgUndefined = basePath + "/res/undefined.jpg";
//			  File file1 =new File(imgApple);
//			  File file2 =new File(imgBanana);
//			  File file3 =new File(imgUndefined);
			  URL file1 = ClassLoader.getSystemResource("apple.jpg");
			  URL file2 = ClassLoader.getSystemResource("banana.jpg");
			  URL file3 = ClassLoader.getSystemResource("undefined.jpg");
			  
				try{
					  bi1 =ImageIO.read(file1);
				  }catch(IOException e){
				  }
				try{
					  bi2 =ImageIO.read(file2);
				  }catch(IOException e){
				  }
				try{
					  bi3 =ImageIO.read(file3);
				  }catch(IOException e){
				  }
				//repaint();
			
	}
	//paint identified fruit's image to UI window
	public void paint(Graphics g){
		g.setFont(new Font("Arial",Font.PLAIN,18));
		g.drawString("These are the fruits system recongnized: ", 10, 80);
		g.drawString(""+inputs, 10, 110);
		g.drawString("Apple - $0.5/each, Banana - $0.7/each, Total cost: $"+ cost, 10, 300);
		for (int i=0; i<inputs.size(); i++){
			if (inputs.get(i) == "apple"){
				g.drawImage(bi1, 10+(i* bi1.getHeight()/3), 120, bi1.getWidth()/3, bi1.getHeight()/3, null);
			}else if (inputs.get(i) == "banana"){
				g.drawImage(bi2, 10+(i* bi2.getHeight()/3), 120, bi2.getWidth()/3, bi2.getHeight()/3, null);
			}else if (inputs.get(i) == "Unidentified"){
				g.drawImage(bi3, 10+(i* bi3.getHeight()/3), 120, bi3.getWidth()/3, bi3.getHeight()/3, null);
			}
		}
		repaint();
	}
		
		
}
