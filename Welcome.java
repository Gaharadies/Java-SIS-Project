package SIS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Welcome extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Welcome() {
	    JPanel jp1= new JPanel();
	    jp1.setBackground(Color.WHITE);
	    ImageIcon backi = new ImageIcon("Images\\schooli.png");
	    Image img = backi.getImage();
	    Image temp_img =img.getScaledInstance(180,180,Image.SCALE_SMOOTH);
	    backi = new ImageIcon(temp_img);
	    JLabel home = new JLabel("",backi,JLabel.CENTER);
	    home.setBackground(Color.white);
	    jp1.add(home);
	    String str = "<html><p><u> Student Information <br><center> System <center></u></p></html>\n";
		JLabel l3= new JLabel(str,JLabel.CENTER);
		l3.setFont(new Font("Showcard Gothic", Font.BOLD, 65));
		l3.setForeground(new Color(70,176,250));
	    jp1.add(l3);
	    jp1.setLayout(new GridLayout(2,1,0,0));
	    jp1.setBounds(0,0,1000,400);
	    getContentPane().add(jp1);
	
	JButton b2;
	b2=new JButton("WELCOME");
	b2.setForeground(Color.WHITE);
	b2.setFont(new Font("Segoe UI",Font.BOLD,40));
	b2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
	b2.setFocusable(false);
	b2.setBackground(new Color(250,50,178));
	b2.setBounds(375,400,250,60);
	add(b2);
	
	   //frame
	   setSize(1000,730);
	   setLayout(null);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   //backgrounds
	    ImageIcon backi3 = new ImageIcon("Images\\wave2.png");
	    Image img3 = backi3.getImage();
	    Image temp_img3 =img3.getScaledInstance(1000,340,Image.SCALE_SMOOTH);
	    backi3 = new ImageIcon(temp_img3);
		 JLabel background=new JLabel("",backi3,JLabel.CENTER);
		   background.setBounds(0,360,1000,340);	   
	   add(background);
	   Image icon = Toolkit.getDefaultToolkit().getImage("Images\\School-512.png");
	    setIconImage(icon);
   
	   setLocationRelativeTo(null);
   setLayout(null);
   setVisible(true);
    setResizable(false);  
   b2.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent e) {
		   new Login();
		   
	   }
   
	});
	}

	public static void main(String[] args) {
		new Welcome();
	}
}
