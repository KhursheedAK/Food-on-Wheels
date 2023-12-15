package PresentationLayer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.sun.tools.javac.Main;

import BusinessLogic.Customers;
import BusinessLogic.newRestaurant;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class GraphicUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GraphicUI window = new GraphicUI();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraphicUI() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnNewButton = new JButton("Restaurant");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Options opt=new Options();
				
			}
		});
		btnNewButton.setBounds(47, 38, 100, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(47, 118, 100, 34);
		frame.getContentPane().add(btnCustomer);
		frame.setResizable(false);
		
		JButton btnNewButton_2 = new JButton("ADMIN");
		btnNewButton_2.setBounds(47, 193, 100, 34);
		frame.getContentPane().add(btnNewButton_2);
		frame.setResizable(false);
		
		JButton btnRider = new JButton("Rider");
		btnRider.setBounds(262, 38, 100, 34);
		frame.getContentPane().add(btnRider);
		frame.setResizable(false);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(262, 118, 100, 34);
		frame.getContentPane().add(btnExit);
		frame.setResizable(false);
		
	}

}
