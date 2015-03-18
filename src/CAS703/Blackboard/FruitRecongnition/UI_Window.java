package CAS703.Blackboard.FruitRecongnition;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
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
	private ArrayList<Integer> inputs;
	public UI_Window(String title, int width, int height, BlackBoard blackboard){
		
			setTitle(title);
			setSize(width, height);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setLocationRelativeTo(null);
			
			inputs = blackboard.getImagelists();
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
		g.setFont(new Font("Arial",Font.BOLD,34));
		g.drawString("These are the fruits in your basket: ", 10, 80);
		g.drawString("These are the fruits system recongnized: ", 10, 240);
		for (int i =0; i<=inputs.size(); i++){
			if (inputs.get(i)== 1){
				g.drawImage(bi1, 0+(i*160), 160, bi1.getWidth()/2, bi1.getHeight()/2, null);
			}else if (inputs.get(i) == 2){
				g.drawImage(bi2, 0+(i*160), 160, bi2.getWidth()/2, bi2.getHeight()/2, null);
			}
			
		}

		
	}
		
		
}
