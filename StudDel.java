package SIS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudDel {
	JFrame f =new JFrame("Student Home Page");
	JPanel jp1,jp3,jstud,jpdel1,jpdel2,jsh;
    JLabel l2,l4,l5;
	StudDel() {
		 // background
	    ImageIcon backi3 = new ImageIcon("Images\\wave3.png");
	    Image img3 = backi3.getImage();
	    Image temp_img3 =img3.getScaledInstance(1000,750,Image.SCALE_SMOOTH);
	    backi3 = new ImageIcon(temp_img3);
	    l4= new JLabel("",backi3,JLabel.CENTER);
	    l4.setSize(1000,750);
	    
	    // for top
	    jp1= new JPanel();
	    ImageIcon backi = new ImageIcon("Images\\schooli.png");
	    Image img = backi.getImage();
	    Image temp_img =img.getScaledInstance(180,180,Image.SCALE_SMOOTH);
	    backi = new ImageIcon(temp_img);
	    JButton home = new JButton();
		home.setCursor(new Cursor(12));
	    home.setBackground(Color.white);
	    home.setIcon(backi);
	    home.setBorderPainted(false);
	    home.setFocusable(false);
	    home.setBorder(BorderFactory.createEmptyBorder());
	    home.setMargin(new Insets(10, 10, 10, 10));
	    home.setBounds(0,0,200,200);
		home.setToolTipText("GoTo Main Home Page");
		home.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new StudHome();
	    	}
	    });
	    jp1.add(home);
	    ImageIcon backi2 = new ImageIcon("Images\\school3.jpg");
	    Image img2 = backi2.getImage();
	    Image temp_img2 =img2.getScaledInstance(800,200,Image.SCALE_SMOOTH);
	    backi2 = new ImageIcon(temp_img2);
	    l2= new JLabel("",backi2,JLabel.CENTER);
	    l2.setBounds(200,0,800,200);
	    jp1.add(l2);
	    jp1.setLayout(new BorderLayout());
	    jp1.setBackground(new Color(250,250,250));
	    jp1.setBounds(0,0,1000,200);
	    f.getContentPane().add(jp1);
	    
	    // Title
	    jp3= new JPanel();
		l5 = new JLabel("Delete Student Records",JLabel.CENTER);
		l5.setFont(new Font("Goudy Stout", Font.BOLD, 35));
		l5.setForeground(Color.white);
		jp3.add(l5);
		jp3.setBorder(BorderFactory.createRaisedBevelBorder());
		jp3.setLayout(new GridLayout(1,1,5,10));
	    jp3.setBackground(new Color(40,146,254));
	    jp3.setBounds(0,200,1000,50);
		f.getContentPane().add(jp3);
		
		// Delete at desired  location
		jpdel1 = new JPanel();
		jpdel1.setBackground(Color.white);
		jpdel1.setBounds(450,345,550,50);    
	    JButton up = new JButton("Delete Desired Records");
		up.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
		up.setBackground(new Color(40,146,250));
		up.setCursor(new Cursor(12));
		up.setForeground(Color.white);
		up.setBorderPainted(true);
	    up.setFocusable(false);
		up.setBorder(BorderFactory.createRaisedBevelBorder());
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   // Stud Search
				jpdel1.setVisible(false);
				jpdel2.setVisible(false);
				jsh.setVisible(true);
		
			}
		});
		jpdel1.add(up);
		jpdel1.setLayout(new GridLayout(1,1,0,0));
		f.getContentPane().add(jpdel1);
		
		// Delete  All Details
		jpdel2 = new JPanel();
		jpdel2.setBackground(Color.white);
		jpdel2.setBounds(450,475,550,50); 
	    JButton del = new JButton("Delete All Records");
		del.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
		del.setBackground(new Color(40,146,250));
		del.setCursor(new Cursor(12));
		del.setForeground(Color.white);
		del.setBorderPainted(true);
	    del.setFocusable(false);
		del.setBorder(BorderFactory.createRaisedBevelBorder());
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent de) {
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "SYSTEM";
				String pass = "hari";
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					   System.out.println("Driver Loaded");
					   Connection con = DriverManager.getConnection(url,user,pass);
					   System.out.println("Connection Established");
						   if(con != null) {
		 		   Statement st = con.createStatement();
		 		   st.executeUpdate("TRUNCATE TABLE STUDM"+ChooseStan.lst);
		 		   JOptionPane.showMessageDialog(null,"All records is deleted");
		 		   st.close();
		 		   }
		 		   con.close();
		 		}
		 		catch(ClassNotFoundException e) {
		 			System.out.println("Driver Not Loaded");
		 		}
		 		catch(SQLException e ) {
		 			System.out.println("Connection Not Established");
		 		} 
			}
		});
		jpdel2.add(del);
		jpdel2.setLayout(new GridLayout(1,1,0,0));
		f.getContentPane().add(jpdel2);
		
		// to delete :panel
		    jsh = new JPanel();
		    jsh.setVisible(false);
			jsh.setBounds(350, 300,350,250);
			jsh.setBackground(new Color(250,250,250,4));
		    jsh.setBorder(BorderFactory.createRaisedBevelBorder());
		    JPanel jsa = new JPanel();
		    jsa.setBorder(BorderFactory.createEmptyBorder(20,55,0,55));
		    jsa.setBackground(new Color(255,255,255,4));
		    JLabel en = new JLabel("Enter the roll to delete");
		    en.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		    jsa.add(en);
		    jsh.add(jsa);
		    
		    JPanel jsa2 = new JPanel();
		    jsa2.setBorder(BorderFactory.createEmptyBorder(0,55,0,55));
		    jsa2.setBackground(new Color(255,255,255,4));
		    JTextField ns = new JTextField("",0);
		    ns.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(50,50,250)));
		    ns.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
			ns.setToolTipText("Fill the name of student");
			ns.setBackground(new Color(250,250,255));
		    jsa2.add(ns);
		    jsa2.setLayout(new GridLayout(1,1,20,10));
		    jsh.add(jsa2);
		    
		    JButton ad = new JButton("Delete");
			ad.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
			ad.setBackground(new Color(40,146,250));
			ad.setForeground(Color.white);
			ad.setCursor(new Cursor(12));
			ad.setSize(200,50);
			ad.setBorderPainted(true);
		    ad.setFocusable(false);
			ad.setBorder(BorderFactory.createRaisedBevelBorder());
			ad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ed) {
					 String url = "jdbc:oracle:thin:@localhost:1521:XE";
						String user = "SYSTEM";
						String pass = "hari";
					 try {
						 int sroll= Integer.parseInt(ns.getText());
						 Class.forName("oracle.jdbc.driver.OracleDriver");
						   System.out.println("Driver Loaded");
						   Connection con = DriverManager.getConnection(url,user,pass);
						   System.out.println("Connection Established");
							   if(con != null) {
								   PreparedStatement ps=con.prepareStatement("Delete from STUDM"+ChooseStan.lst+" Where REG_ID =?");
								   ps.setInt(1,sroll);
								   int i = ps.executeUpdate();
								   JOptionPane.showMessageDialog(null,i+" Record is deleted");
							   }
							   con.close();
							}
							catch(ClassNotFoundException ec) {
								System.out.println("Driver Not Loaded");
							}
							catch(SQLException ec ) {
								System.out.println("Connection Not Established");
							}
					        catch(NumberFormatException ne) {
					        	JOptionPane.showMessageDialog(null,"Enter the number");				        	
					        }
				
				}
			});
			jsh.add(ad);
			jsh.setLayout(new GridLayout(3,1,20,10));
		    f.getContentPane().add(jsh);
		
		//Bottom Borders
		jstud = new JPanel();
		jstud.setBackground(new Color(72,38,100));
		jstud.setBounds(0,675,1000,50); 
		jstud.setLayout(new GridLayout(1,1,0,0));
		f.getContentPane().add(jstud);
		f.setLocationRelativeTo(null);
	    f.getContentPane().add(l4);
	    f.setSize(1000,750);
	    f.setResizable(false);
	    f.setLayout(new BorderLayout());
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Image icon = Toolkit.getDefaultToolkit().getImage("Images\\School-512.png");
	    f.setIconImage(icon);
	}
}