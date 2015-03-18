package CAS703.Blackboard.FruitRecongnition;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class DrawFruit {
	private BufferedImage bi;
	
	public DrawFruit(String img){
		File file =new File(img);
		try{
			  bi =ImageIO.read(file);
		  }catch(IOException e){
			  e.printStackTrace();
		  }
	}
	public void paint(Graphics g){
	  String basePath = new File("").getAbsolutePath();
	  String imgApple = basePath + "/res/apple.jpg";
		ImageIcon i = new ImageIcon(imgApple);
		Image image = i.getImage();
		g.drawImage(image, 320, 160, bi.getWidth(), bi.getHeight(), null);
	}
}
