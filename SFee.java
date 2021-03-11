package SIS;
import java.awt.BorderLayout;
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
import java.sql.ResultSet;
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
    public class SFee{
//Search details
    JFrame f = new JFrame("Student Search");
    JPanel jsh;
    int roll;
    static double fee,feep,feed;
    static int sroll;
    byte flag;
    SFee() {
    	 // background
        ImageIcon backi3 = new ImageIcon("Images\\wave4.png");
        Image img3 = backi3.getImage();
        Image temp_img3 =img3.getScaledInstance(450,350,Image.SCALE_SMOOTH);
        backi3 = new ImageIcon(temp_img3);
        JLabel l4= new JLabel("",backi3,JLabel.CENTER);
        l4.setSize(450,350);
     // to Show fee :panel
	    jsh = new JPanel();
		jsh.setBounds(50, 50,350,250);
		jsh.setBackground(new Color(250,250,250,4));
	    jsh.setBorder(BorderFactory.createRaisedBevelBorder());
	    JPanel jsa = new JPanel();
	    jsa.setBorder(BorderFactory.createEmptyBorder(20,55,0,55));
	    jsa.setBackground(new Color(255,255,255,4));
	    JLabel en = new JLabel("Enter the roll to show");
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
	    
	    JButton ad = new JButton("Show");
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
					 sroll= Integer.parseInt(ns.getText());
					 Class.forName("oracle.jdbc.driver.OracleDriver");
					   System.out.println("Driver Loaded");
					   Connection con = DriverManager.getConnection(url,user,pass);
					   System.out.println("Connection Established");
					   if(con!=null) {
							   Statement st = con.createStatement();
							   ResultSet rs = st.executeQuery("Select * from STUDM"+ChooseStan.lst);
					            while ( rs.next() ){
					             int  roll = rs.getInt(1);
					              if(roll == sroll) {
					            	fee = rs.getDouble(10);
					                feep = rs.getDouble(22);
					            	feed = rs.getDouble(23);
					            	new StudFee();
					              }
					             
					          }
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
    
    f.getContentPane().add(l4);
    f.setSize(450,350);
    f.setResizable(false);
    f.setLayout(new BorderLayout());
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Image icon = Toolkit.getDefaultToolkit().getImage("Images\\School-512.png");
    f.setIconImage(icon);
    f.setLocationRelativeTo(null);
    }
}