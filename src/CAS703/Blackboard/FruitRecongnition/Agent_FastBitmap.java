package CAS703.Blackboard.FruitRecongnition;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Concurrent.Filters.Grayscale;
import Catalano.Imaging.Tools.ObjectiveFidelity;

import javax.imageio.ImageIO;

public class Agent_FastBitmap {
	
	
	public ArrayList<Double> fastbitmap(BufferedImage bufferedImage1, BufferedImage bufferedImage2){

	FastBitmap original = new FastBitmap(bufferedImage1);
	FastBitmap reconstructed = new FastBitmap(bufferedImage2);
	original.toARGB();
	original.toGrayscale();
	reconstructed.toARGB();
	reconstructed.toGrayscale();
	

	ObjectiveFidelity o = new ObjectiveFidelity(original, reconstructed);
	ArrayList<Double> result=new ArrayList<Double>();
	// Error total
	int error = o.getTotalError();

	//Mean Square Error
	double mse = o.getMSE();

	//Signal Noise Ratio
	double snr = o.getSNR();

	//Peak Signal Noise Ratio
	double psnr = o.getPSNR();
	System.out.println("FastBitmap answer mse: "+mse + ". snr: " +snr+". psnr: "+psnr);
	
	result.add(mse);
	result.add(snr);
	result.add(psnr);
	//System.out.println(result);
	return result;
	}
	
	public String compare(String path){
		URL appleFile = ClassLoader.getSystemResource("apple.jpg");
		URL bananaFile = ClassLoader.getSystemResource("banana.jpg");
		URL file = ClassLoader.getSystemResource(path);
		BufferedImage b1 = null, bApple = null, bBanana = null;
		
		try {
			b1 = ImageIO.read(file);
			bApple = ImageIO.read(appleFile);
			bBanana = ImageIO.read(bananaFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//convert image to grayscale
		try{
        int width = b1.getWidth();
        int height = b1.getHeight();
        
        for(int i=0; i<height; i++){        
           for(int j=0; j<width; j++){           
              Color c = new Color(b1.getRGB(j, i));
              int red = (int)(c.getRed() * 0.299);
              int green = (int)(c.getGreen() * 0.587);
              int blue = (int)(c.getBlue() *0.114);
              Color newColor = new Color(red+green+blue,
              
              red+green+blue,red+green+blue);
              
              b1.setRGB(j,i,newColor.getRGB());
           }
        }
        
//        File ouptut = new File("grayscale.jpg");
//        ImageIO.write(b1, "jpg", ouptut);
		} catch (Exception e) {}
		int isApple=0;
		int isBanana=0;
		ArrayList<Double> appleResult = fastbitmap(b1, bApple);
		ArrayList<Double> bananaResult = fastbitmap(b1, bBanana);
		
		if(appleResult.get(0)<bananaResult.get(0)){
			isApple++;
			
		}else{isBanana++;}
		if(appleResult.get(1)>bananaResult.get(1)){
			isApple++;
		}else{isBanana++;}
		if(appleResult.get(0)>bananaResult.get(0)){
			isApple++;
		}else{isBanana++;}

		String result;
		if(isApple>isBanana){
			result="apple";
		}else{result="banana";}
		System.out.println("FastBitmap detection: "+result+". isApple: "+isApple+". isBanana: "+isBanana);
		
		return result;
	}
//	public void toGrayscale(){
//        new Grayscale().applyInPlace();
//    }
	
	public void run(BlackBoard blackboard){
		String path = blackboard.getImg();
		blackboard.setFastBitMapResult(compare(path));	
	}
	
	
}
