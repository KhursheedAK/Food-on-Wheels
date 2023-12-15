package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.sun.tools.javac.Main;

import BusinessLogic.Customers;
import BusinessLogic.newRestaurant;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class gui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Restaurant");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Options opt=new Options();
				
			}
		});
		btnNewButton.setBounds(47, 38, 100, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(47, 118, 100, 34);
		frame.getContentPane().add(btnCustomer);
		
		JButton btnNewButton_2 = new JButton("ADMIN");
		btnNewButton_2.setBounds(47, 193, 100, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnRider = new JButton("Rider");
		btnRider.setBounds(262, 38, 100, 34);
		frame.getContentPane().add(btnRider);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(262, 118, 100, 34);
		frame.getContentPane().add(btnExit);
	}

}
