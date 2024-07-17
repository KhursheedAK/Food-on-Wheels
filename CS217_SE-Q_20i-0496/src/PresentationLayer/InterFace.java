package PresentationLayer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class InterFace 
{

	public void myGUI()
	{
		JFrame frame = new JFrame();
		ImageIcon image2 = new ImageIcon("4.jpg");
		Border border = BorderFactory.createLineBorder(Color.green, 3);
		
		JLabel label = new JLabel("<html>Welcome to Khursheed and Abdullah's Restaurant<br/><br>Made with Love by two beloved brothers<br/><t>Khursheed Alam Khan: 20i-0496<br/> Muhammad Abdullah: 20i-2311</html>", SwingConstants.CENTER); 
		label.setIcon(image2);//
		label.setVerticalTextPosition(JLabel.TOP);//
		label.setHorizontalTextPosition(JLabel.CENTER);//
		
	
		frame.setTitle("Food on Wheels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
		frame.setResizable(false);
		frame.setSize(1495,390);//
		frame.setVisible(true);//
		label.setFont(new Font("MV Boli", Font.CENTER_BASELINE,20));//
		label.setForeground(Color.green);//
		label.setIconTextGap(50);//
		label.setBackground(Color.black);//
		label.setOpaque(true);//
		label.setBorder(border);//
		label.setVerticalAlignment(JLabel.TOP);//
		label.setHorizontalAlignment(JLabel.CENTER);//
		label.setBounds(0,0, 1480, 350);
		
		ImageIcon image = new ImageIcon("blue.jpg");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(155,180,120));
		frame.add(label);//
		frame.setLayout(null);
		
	}	
		
		
	

}
