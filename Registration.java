package SIS;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Registration extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4,l5,background;
JTextField t1,t2;
JPasswordField t4,t3;
int flag=0;
Registration()
{
 Font f = new Font("Segoe UI Historic", Font.PLAIN, 20);
 setTitle("Signup Form");
 Border matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
 JPanel login=new JPanel();
	 login.setLayout(new GridLayout(10,1,10,10));
	 login.setBackground(new Color(255,255,255,0));
	 login.setBounds(156,50,280,400);
	 JPanel log=new JPanel();
	 log.setBackground(new Color(240,240,255,80));
	 log.setBounds(86,50,400,50);
	 add(log);
   l1=new JLabel("Sign Up",JLabel.CENTER);
   l1.setFont(new Font("Goudy Stout", Font.BOLD, 25));
   l1.setForeground(Color.BLUE);
   //l1.setFont(f);
       l2=new JLabel("User Name");
	    l2.setFont(f);
	   t1=new JTextField();
	    t1.setBorder(matte);
	    t1.setFont(f);
		t1.setToolTipText("Fill the username");
	    l3=new JLabel("Email Address");
	    l3.setFont(f);
	   t2=new JTextField();
	   t2.setBorder(matte);
	    t2.setFont(f);
		t2.setToolTipText("Fill the email");
	    l4=new JLabel("Password");
	    l4.setFont(f);
	   t3=new JPasswordField();
	   t3.setBorder(matte);
	    t3.setFont(f);
		t3.setToolTipText("Fill the password");
	       l5=new JLabel("ConfirmPassword");
		    l5.setFont(f);
		   t4=new JPasswordField();
		   t4.setBorder(matte);
		    t4.setFont(f);
			t4.setToolTipText("Fill the confirm password");
			JButton ad = new JButton("Signup");
			ad.setFont(new Font("Goudy Stout", Font.BOLD, 20));
			ad.setBackground(new Color(40,146,250));
			ad.setForeground(Color.white);
			ad.setCursor(new Cursor(12));
			ad.setSize(200,50);
			ad.setBorderPainted(true);
		    ad.setFocusable(false);
			ad.setBorder(BorderFactory.createRaisedBevelBorder());
	        ad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String lov = t1.getText();
					String em = t2.getText();
					String pass = new String(t3.getPassword());
					String cpas = new String(t4.getPassword());
					String url = "jdbc:oracle:thin:@localhost:1521:XE";
					String user = "SYSTEM";
					String passw = "hari";
					
					try {
			           Class.forName("oracle.jdbc.driver.OracleDriver");
					   System.out.println("Driver Loaded");
					   Connection con = DriverManager.getConnection(url,user,passw);
					   System.out.println("Connection Established");
					   if(con!=null) {
							   Statement st = con.createStatement();
							   ResultSet rs = st.executeQuery("Select * from STUDLOG");
					            while ( rs.next() ){
					              String l = rs.getString(1);
					              if(l.equals(lov)) {
					            	 flag=1;
					            	 break;
					              }
					              else {
					            	  flag=0;
					              }
					          }
					          rs.close();
							   con.close();
							}
					}
							catch(ClassNotFoundException ec) {
								System.out.println("Driver Not Loaded");
							}
							catch(SQLException ec ) {
								System.out.println("Connection Not Established");
							}
					if(!(pass.equals(cpas))) {
						JOptionPane.showMessageDialog(null," Pass word mismatch");
						
					}
					else if(flag ==1) {
						JOptionPane.showMessageDialog(null, "user is already registerd");
					}
					else {						
						try {
				           Class.forName("oracle.jdbc.driver.OracleDriver");
						   System.out.println("Driver Loaded");
						   Connection con = DriverManager.getConnection(url,user,passw);
						   System.out.println("Connection Established");
						   if(con!=null) {
								   PreparedStatement ps=con.prepareStatement("insert into STUDLOG values(?,?,?)"); 
								   System.out.println("kwh");
					  				    ps.setString(1,lov);
					  			  	    ps.setString(2,em);
					  			        ps.setString(3,pass);
								   int i = ps.executeUpdate();
								   JOptionPane.showMessageDialog(null, i+" Records Inserted");
								   ps.close();
						          }
							
							   con.close();
							}
							catch(ClassNotFoundException ei) {
								System.out.println("Driver Not Loaded");
							}
							catch(SQLException ec ) {
								System.out.println("Connection Not Established");
							}
					}
				}
			});
	 
	 // add
   login.add(l1); 
   login.add(l2);
   login.add(t1);
   login.add(l3);
   login.add(t2);
   login.add(l4);
   login.add(t3);
   login.add(l5);
   login.add(t4);
   login.add(ad);
   add(login); 
   setSize(600,600);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   

	 //background
	ImageIcon background_image = new ImageIcon("Images\\Wave1.png");
	Image img = background_image.getImage();
	Image temp_img = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
	background_image = new ImageIcon(temp_img);
	JLabel background = new JLabel("", background_image, JLabel.CENTER);
	background.setSize(600, 600);
	add(background);
	 
	
   setLayout(null);
   setVisible(true);
   setResizable(false);
	setLocationRelativeTo(null);
	 Image icon = Toolkit.getDefaultToolkit().getImage("Images\\School-512.png");
	    setIconImage(icon);
}
}
