package CAS703.Blackboard.FruitRecongnition;

import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Tools.ImageStatistics;
import Catalano.Statistics.Histogram;
import javax.swing.JOptionPane;

public class Agent_FastBitmap {
	public void run() {

	FastBitmap original = new FastBitmap(bufferedImage1);
	FastBitmap reconstructed = new FastBitmap(bufferedImage2);

	ObjectiveFidelity o = new ObjectiveFidelity(original, reconstructed);

	// Error total
	int error = o.getTotalError();

	//Mean Square Error
	double mse = o.getMSE();

	//Signal Noise Ratio
	double snr = o.getSNR();

	//Peak Signal Noise Ratio
	double psnr = o.getPSNR();
	
	}
}
