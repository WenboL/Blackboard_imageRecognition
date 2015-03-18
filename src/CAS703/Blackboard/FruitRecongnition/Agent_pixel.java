package CAS703.Blackboard.FruitRecongnition;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Agent_pixel {
	
		public static String[][] getPX(String args) {
			int[] rgb = new int[3];

			File file = new File(args);
			BufferedImage bi = null;
			try {
				bi = ImageIO.read(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

			int width = bi.getWidth();
			int height = bi.getHeight();
			int minx = bi.getMinX();
			int miny = bi.getMinY();
			String[][] list = new String[width][height];
			for (int i = minx; i < width; i++) {
				for (int j = miny; j < height; j++) {
					int pixel = bi.getRGB(i, j);
					rgb[0] = (pixel & 0xff0000) >> 16;
					rgb[1] = (pixel & 0xff00) >> 8;
					rgb[2] = (pixel & 0xff);
					list[i][j] = rgb[0] + "," + rgb[1] + "," + rgb[2];

				}
			}
			return list;

		}
		
		public String comparing(String[][] list1, String[][] list2){

			int Match = 0;
			int NotMatch = 0;
			int i = 0, j = 0;
			for (String[] strings : list1) {
				if ((i + 1) == list1.length) {
					continue;
				}
				for (int m=0; m<strings.length; m++) {
					try {
						String[] value1 = list1[i][j].toString().split(",");
						String[] value2 = list2[i][j].toString().split(",");
						int k = 0;
						for (int n=0; n<value2.length; n++) {
							if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
								Match++;
							} else {
								NotMatch++;
							}
						}
					} catch (RuntimeException e) {
						continue;
					}
					j++;
				}
				i++;
			}
			
			i = 0;
			j = 0;
			for (String[] strings : list2) {
				if ((i + 1) == list2.length) {
					continue;
				}
				for (int m=0; m<strings.length; m++) {
					try {
						String[] value1 = list2[i][j].toString().split(",");
						String[] value2 = list1[i][j].toString().split(",");
						int k = 0;
						for (int n=0; n<value2.length; n++) {
							if (Math.abs(Integer.parseInt(value1[k]) - Integer.parseInt(value2[k])) < 5) {
								Match++;
							} else {
								NotMatch++;
							}
						}
					} catch (RuntimeException e) {
						continue;
					}
					j++;
				}
				i++;
			}
			String Percent;
			try {
				Percent = ((Double.parseDouble(Match + "") / Double.parseDouble((NotMatch + Match) + "")) + "");
			} catch (Exception e) {
				Percent = "0";
			}
			return Percent;
			
		}
		public String compareImage(String imgPath1){
			String basePath = new File("").getAbsolutePath();
			String imgApple =  basePath + "/res/apple.jpg";
			String imgBanana = basePath + "/res/banana.jpg";
			String[] images = {imgPath1, imgApple, imgBanana};
			if (images.length == 0) {
				System.out.println("No imagefile selected");
				System.exit(0);
			}

			
			String[][] list1 = getPX(images[0]);
			String[][] listApple = getPX(images[1]);
			String[][] listBanana = getPX(images[2]);
			String percentage1 = comparing(list1,listApple);
			String percentage2 = comparing(list1,listBanana);
			double value1 = Double.parseDouble(percentage1);
			double value2 = Double.parseDouble(percentage2);
//			System.out.println("value1: "+value1+". value2: "+value2);
			String ThisFruit;
			if (value1 > value2){
				ThisFruit = "apple";
			}else ThisFruit = "banana";

			System.out.println("PixelValue detection: "+ThisFruit);
			return ThisFruit;
		}
		
	public void run(BlackBoard blackboard) {
		String img = blackboard.getImg();
		blackboard.setPixelResult(compareImage(img));	
//		ArrayList<String> identifiedFruits = blackboard.getIdentifiedFruits();
//		identifiedFruits.add(compareImage(img));
//		blackboard.setIdentifiedFruits(identifiedFruits);
		
	}

}



