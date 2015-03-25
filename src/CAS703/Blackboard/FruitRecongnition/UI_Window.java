package CAS703.Blackboard.FruitRecongnition;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class UI_Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage bi1, bi2;
	private ArrayList<String> inputs;
	private String cost;
	public UI_Window(String title, int width, int height, BlackBoard blackboard, double money){
		
			setTitle(title);
			setSize(width, height);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setLocationRelativeTo(null);

			cost = String.valueOf(money);
			inputs = blackboard.getIdentifiedFruits();
			  String basePath = new File("").getAbsolutePath();
			  String imgApple = basePath + "/res/apple.jpg";
			  String imgBanana = basePath + "/res/banana.jpg";
			  File file1 =new File(imgApple);
			  File file2 =new File(imgBanana);
				try{
					  bi1 =ImageIO.read(file1);
				  }catch(IOException e){
				  }
				try{
					  bi2 =ImageIO.read(file2);
				  }catch(IOException e){
				  }
				repaint();
	}

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
			}
		}

		
	}
		
		
}
