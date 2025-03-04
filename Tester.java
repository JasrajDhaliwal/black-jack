package termProject;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

import week11.Test1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tester {

	private JFrame frame;
	Game g1;
	DeckImage d1;
	int comp; int play;
	
	JLabel t1;
	JLabel t2;
	JButton s1;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	
	JButton b1; JButton b2; JButton b3; JButton b4; JButton b5;
	JButton [] arrayUser = {b1, b2, b3, b4, b5};
	int count = 0;
	JLabel currentLabel = l1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tester window = new Tester();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Tester() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		g1 = new Game();
		frame = new JFrame();
		frame.setBounds(100, 100, 1045, 707);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		t1 = new JLabel("New label");
		t1.setBounds(524, 280, 177, 16);
		frame.getContentPane().add(t1);
		
		t2 = new JLabel("New label");
		t2.setBounds(524, 352, 177, 16);
		frame.getContentPane().add(t2);

		l1 = new JLabel();
		g1.dealCardToComputer(l1, t1);
		l1.setBounds(6, 6, 196, 262);
		frame.getContentPane().add(l1);
		
		l2 = new JLabel();
		l2.setBounds(212, 6, 196, 262);
		frame.getContentPane().add(l2);
		
		l3 = new JLabel();
		l3.setBounds(425, 6, 196, 262);
		frame.getContentPane().add(l3);
		
		l4 = new JLabel();
		l4.setBounds(633, 6, 196, 262);
		frame.getContentPane().add(l4);
		
		l5 = new JLabel();
		l5.setBounds(841, 6, 196, 262);
		frame.getContentPane().add(l5);
		
		JLabel [] arrayComp = {l1, l2, l3, l4, l5};
		currentLabel = l2;
		
		b1 = new JButton("Press Me");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.dealCardToUser(b1, t2);
				checkIfOverUser();
				g1.dealCardToComputer(currentLabel, t1);
				checkCompLabel();
				checkIfOverComputer();
				currentLabel = l3;
				count++;
				}
			
		});
		b1.setBounds(6, 384, 196, 262);
		frame.getContentPane().add(b1);
		
		
		b2 = new JButton("Press Me");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.dealCardToUser(b2, t2);
				checkIfOverUser();
				g1.dealCardToComputer(currentLabel,t1);
				checkCompLabel();
				checkIfOverComputer();
				currentLabel = l4;
				count++;
			}
			
		});
		b2.setBounds(212, 384, 196, 262);
		frame.getContentPane().add(b2);
		
		b3 = new JButton("Press Me");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.dealCardToUser(b3, t2);
				checkIfOverUser();
				g1.dealCardToComputer(currentLabel, t1);
				checkCompLabel();
				checkIfOverComputer();
				currentLabel = l5;
				count++;
			}
			
		});
		b3.setBounds(425, 384, 196, 262);
		frame.getContentPane().add(b3);
		
		b4 = new JButton("Press Me");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.dealCardToUser(b4, t2);
				checkIfOverUser();
				g1.dealCardToComputer(currentLabel, t1);
				checkCompLabel();
				checkIfOverComputer();
				count++;
			}
		});
		b4.setBounds(633, 384, 196, 262);
		frame.getContentPane().add(b4);
		
		JButton b5 = new JButton("Press Me");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.dealCardToUser(b5, t2);
				checkIfOverUser();
				count++;
				checkWin();
			}
		});
		b5.setBounds(841, 384, 196, 262);
		frame.getContentPane().add(b5);
		
		JButton [] arrayUser = {b1, b2, b3, b4, b5};
		
		s1 = new JButton("Skip");
		s1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e){
		    	
		        
		       if (count >= 1 && count <= 5) {
		        	
		            switch (count) {
		                case 1:
		                	b2.setEnabled(false);
		                	g1.dealCardToComputer(currentLabel, t1);
		                	checkCompLabel();
		                	currentLabel = l4;
		                	count++;
		                    break;
		                case 2:
		                	b3.setEnabled(false);
		                	g1.dealCardToComputer(currentLabel, t1);
		                	checkCompLabel();
		                	currentLabel = l5;
		                	count++;
		                    break;
		                case 3:	   
		                	b4.setEnabled(false);
		                	g1.dealCardToComputer(currentLabel, t1);
		                	checkCompLabel();
		                	//currentLabel = l5;
		                	count++;
		                    break;
		                case 4:		   
		                	b5.setEnabled(false);
		                	g1.dealCardToComputer(currentLabel, t1);
		                	checkWin();
		                	count++;
		                	break;
		            } 
		            	
			        }
		            
		           
		        	
		        }
		       

		       
		    
		});
		s1.setBounds(504, 644, 117, 29);			// set text according to count and use if else to choose what label to do it with
		frame.getContentPane().add(s1);

		
		
	}
	public void checkIfOverUser() {
		if(g1.checkIfOver(g1.getPlayer())) {
			frame.setVisible(false);
			//frame.dispose();
			Tester newTester = new Tester();
			newTester.frame.setVisible(true);
		}
	}
	public void checkIfOverComputer() {
		if(g1.checkIfOver(g1.getComputer())) {
			frame.setVisible(false);
			//frame.dispose();
			Tester newTester = new Tester();
			newTester.frame.setVisible(true);
		}
	}

	public void checkWin () {
		if (g1.checkWin()) {
			frame.setVisible(false);
			//frame.dispose();
			Tester newTester = new Tester();
			newTester.frame.setVisible(true);
		}
	}
	
	public void checkCompLabel () {
		if (currentLabel == l5) {
			checkWin();
		}
	}
	

}
