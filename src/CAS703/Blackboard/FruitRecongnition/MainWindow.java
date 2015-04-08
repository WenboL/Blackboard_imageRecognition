/**
 * Created by Wenbo Liu.
 * For class CAS 703 term project, McMaster University
 * Project name: Fruit Recognition with Blackboard Architecture
 * File: MainWindow.java
 * In this file, creates the main UI window, after user click the icon, 
 * it will update imagelists and update the FruitNumber to Blackboard
 */
package CAS703.Blackboard.FruitRecongnition;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.awt.Font;

public class MainWindow {
	BlackBoard blackBoard =new BlackBoard();
//	List<KnowledgeSource> sourceList =new LinkedList<KnowledgeSource>();
	KnowledgeSource knowledgeSource;
	Output output;
	Agent_ImageSource imageSource;
	

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FirstWindow window = new FirstWindow();
//					window.frame.setVisible(true);
//					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//		blackBoard.getImgAddress();
//		blackBoard.getIconAddress();
		imageSource = new Agent_ImageSource();
		imageSource.run(blackBoard);
		
		URL AppleIcon = ClassLoader.getSystemResource( "appleIcon.png" );
		URL BananaIcon = ClassLoader.getSystemResource( "bananaIcon.png" );
		URL PepperIcon = ClassLoader.getSystemResource( "pepperIcon.png" );
		String imgApple = "apple.jpg";
		String imgBanana = "banana.jpg";
		String imgPepper = "pepper.jpg";
//		String basePath = new File("").getAbsolutePath();
//		String AppleIcon =  basePath + "/res/appleIcon.png";
//		String BananaIcon = basePath + "/res/bananaIcon.png";
//		String imgApple =  basePath + "/res/apple.jpg";
//		String imgBanana = basePath + "/res/banana.jpg";
//		String imgPepper = basePath + "/res/pepper.jpg";
//		String PepperIcon = basePath + "/res/pepperIcon.png";
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblIntro = new JLabel("Please select the fruit for system to recognize:");
		lblIntro.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblIntro.setBounds(22, 6, 450, 16);
		frame.getContentPane().add(lblIntro);
		
		
		JButton btnApple = new JButton("Apple");
		btnApple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("apple button pressed!");
				  //send back to blackboard the current img add to the input image list
				  ArrayList<String> imagelists = blackBoard.getImagelists();
				  imagelists.add(imgApple);
				  blackBoard.setImagelists(imagelists);
				  blackBoard.setFruitNumber();
//				  Integer fruitNumber = blackBoard.getFruitNumber();
//				  System.out.println(fruitNumber);
			}
		});
		
		btnApple.setIcon(new ImageIcon(AppleIcon));
		btnApple.setBounds(6, 62, 143, 139);
		frame.getContentPane().add(btnApple);
		
		JButton btnBanana = new JButton("Banana");
		btnBanana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Banana button pressed!");
				  //send back to blackboard the current img add to the input image list
				  ArrayList<String> imagelists = blackBoard.getImagelists();
				  imagelists.add(imgBanana);
				  blackBoard.setImagelists(imagelists);
				  blackBoard.setFruitNumber();
//				  Integer fruitNumber = blackBoard.getFruitNumber();
//				  System.out.println(fruitNumber);
				
			}
		});
		
		
		btnBanana.setIcon(new ImageIcon(BananaIcon));
		btnBanana.setBounds(301, 62, 143, 137);
		frame.getContentPane().add(btnBanana);
		
		JButton btnPepper = new JButton("Pepper");
		btnPepper.setIcon(new ImageIcon(PepperIcon));
		btnPepper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pepper button pressed!");
				  //send back to blackboard the current img add to the input image list
				  ArrayList<String> imagelists = blackBoard.getImagelists();
				  imagelists.add(imgPepper);
				  blackBoard.setImagelists(imagelists);
				  blackBoard.setFruitNumber();
//				  Integer fruitNumber = blackBoard.getFruitNumber();
//				  System.out.println(fruitNumber);
			}
		});
		btnPepper.setBounds(156, 63, 139, 136);
		frame.getContentPane().add(btnPepper);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				knowledgeSource = new KnowledgeSource();
				output = new Output();
				knowledgeSource.run(blackBoard);
				output.run(blackBoard);
			}
		});
		

		
		
		
		btnNext.setBounds(307, 216, 117, 29);
		frame.getContentPane().add(btnNext);
		
		JTextArea txtrSelectAsMany = new JTextArea();
		txtrSelectAsMany.setEditable(false);
		txtrSelectAsMany.setBackground(UIManager.getColor("Button.background"));
		txtrSelectAsMany.setText("Select as many fruits as you want, then click Next.");
		txtrSelectAsMany.setBounds(22, 34, 323, 16);
		frame.getContentPane().add(txtrSelectAsMany);
		
		
		
	}
	public void run() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
