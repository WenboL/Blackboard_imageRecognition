package CAS703.Blackboard.FruitRecongnition;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class FirstWindow {
	BlackBoard blackBoard =new BlackBoard();
//	List<KnowledgeSource> sourceList =new LinkedList<KnowledgeSource>();
	KnowledgeSource knowledgeSource;
	Agent_output output;
	
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
	public FirstWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String basePath = new File("").getAbsolutePath();
		String AppleIcon =  basePath + "/res/appleIcon.png";
		String BananaIcon = basePath + "/res/bananaIcon.png";
		String imgApple =  basePath + "/res/apple.jpg";
		String imgBanana = basePath + "/res/banana.jpg";
		
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblIntro = new JLabel("Please select the fruit for system to recognize:");
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
		btnApple.setBounds(33, 73, 159, 128);
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
		btnBanana.setBounds(265, 77, 159, 121);
		frame.getContentPane().add(btnBanana);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				knowledgeSource = new KnowledgeSource();
				output = new Agent_output();
				
				knowledgeSource.run(blackBoard);
				output.run(blackBoard);
			}
		});
		btnNext.setBounds(307, 216, 117, 29);
		frame.getContentPane().add(btnNext);
		
		JTextArea txtrSelectAsMany = new JTextArea();
		txtrSelectAsMany.setBackground(UIManager.getColor("Button.background"));
		txtrSelectAsMany.setText("Select as many fruit as you want, then click Next");
		txtrSelectAsMany.setBounds(22, 34, 323, 16);
		frame.getContentPane().add(txtrSelectAsMany);
	}
	public void run() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstWindow window = new FirstWindow();
					window.frame.setVisible(true);
					window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
}
