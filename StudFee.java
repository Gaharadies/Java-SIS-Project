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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudFee {
	JFrame f =new JFrame("Student Fee Update");
	JPanel jp1,jp3,jstud,jsh,jpfee;
    JLabel l2,l4,l5,l6,l7,l8,lp;
    JTextField tf,tf2,tf3,tf4;
    byte flag =0;
	StudFee() {
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
	    home.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new StudHome();
	    	}
	    });
		home.setToolTipText("GoTo Main Home Page");
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
		l5 = new JLabel("Show Fee Details",JLabel.CENTER);
		l5.setFont(new Font("Goudy Stout", Font.BOLD, 35));
		l5.setForeground(Color.white);
		jp3.add(l5);
		jp3.setBorder(BorderFactory.createRaisedBevelBorder());
		jp3.setLayout(new GridLayout(1,1,5,10));
	    jp3.setBackground(new Color(40,146,254));
	    jp3.setBounds(0,200,1000,50);
		f.getContentPane().add(jp3);
		
		
		
	    // Fee Panel:
	    jpfee = new  JPanel();
	    jpfee.setBounds(225,350,725,100);
	    jpfee.setBackground(new Color(255,255,255,44));
	    jpfee.setBorder(BorderFactory.createRaisedBevelBorder());
	    JPanel jplt = new JPanel();
	    jplt.setBackground(new Color(40,146,254));
		l6 = new JLabel("Total Fee",JLabel.CENTER);
		l6.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		l6.setForeground(Color.white);
		jplt.add(l6);
		l7 = new JLabel("Fee Paid",JLabel.CENTER);
		l7.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		l7.setForeground(Color.white);
		jplt.add(l7);
		lp = new JLabel("Fee Paying",JLabel.CENTER);
		lp.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		lp.setForeground(Color.white);
		jplt.add(lp);
		l8 = new JLabel("Fee Dues",JLabel.CENTER);
		l8.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 25));
		l8.setForeground(Color.white);
		jplt.add(l8);
		jplt.setBorder(BorderFactory.createRaisedBevelBorder());
		jplt.setLayout(new GridLayout(1,4,0,0));
		jpfee.add(jplt);
		JPanel jptf = new JPanel();
	    jptf.setBackground(new Color(255,255,255,4));
	    JPanel jst1 = new JPanel();
	    jst1.setBorder(BorderFactory.createEmptyBorder(0,55,0,55));
	    jst1.setBackground(new Color(255,255,255,4));
	    tf = new JTextField(Double.toString(SFee.fee),0);
	    tf.setEditable(false);
	    tf.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(40,146,254)));
	    tf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		tf.setToolTipText("Total fee of student");
		tf.setBackground(new Color(255,255,255));
	    jst1.add(tf);
	    jst1.setLayout(new GridLayout(1,1,20,10));
	    jst1.setBorder(BorderFactory.createRaisedBevelBorder());
	    jptf.add(jst1);
	    
	    JPanel jst2 = new JPanel();
	    jst2.setBorder(BorderFactory.createEmptyBorder(0,55,0,55));
	    jst2.setBackground(new Color(255,255,255,4));
	    tf2 = new JTextField(Double.toString(SFee.feep),0);
	    tf2.setEditable(false);
	    tf2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(40,146,254)));
	    tf2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		tf2.setToolTipText("Fee paid by student");
		tf2.setBackground(new Color(255,255,255));
	    jst2.add(tf2);
	    jst2.setLayout(new GridLayout(1,1,20,10));
	    jst2.setBorder(BorderFactory.createRaisedBevelBorder());
	    jptf.add(jst2);
	    
	    JPanel jst3 = new JPanel();
	    jst3.setBorder(BorderFactory.createEmptyBorder(0,55,0,55));
	    jst3.setBackground(new Color(255,255,255,4));
	    tf3 = new JTextField("",0);
	    tf3.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(40,146,254)));
	    tf3.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		tf3.setToolTipText("Fee paying by student");
		tf3.setBackground(new Color(255,255,255));
		tf3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double feepay = Double.parseDouble(tf3.getText());
				SFee.feep=SFee.feep+feepay;
				tf2.setText(Double.toString(SFee.feep));
				SFee.feed = SFee.fee-SFee.feep;
				tf4.setText(Double.toString(SFee.feed));
				String url = "jdbc:oracle:thin:@localhost:1521:XE";
				String user = "SYSTEM";
				String pass = "hari";
				 try {
					 Class.forName("oracle.jdbc.driver.OracleDriver");
					   System.out.println("Driver Loaded");
					   Connection con = DriverManager.getConnection(url,user,pass);
					   System.out.println("Connection Established");
					   if(con!=null) {
							   PreparedStatement ps=con.prepareStatement("update STUDM"+ChooseStan.lst+" set  SFPAID=? , SFDUE= ? "
				            	  		+" where REG_ID=?");           	   
				  				    ps.setDouble(1,SFee.feep);
				  			  	    ps.setDouble(2, SFee.feed);
				  					ps.setInt(3, SFee.sroll);
							   int i = ps.executeUpdate();
							   JOptionPane.showMessageDialog(null, i+" Records Updated");
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
		});
	    jst3.add(tf3);
	    jst3.setLayout(new GridLayout(1,1,20,10));
	    jst3.setBorder(BorderFactory.createRaisedBevelBorder());
	    jptf.add(jst3);
	    
	    JPanel jst4 = new JPanel();
	    jst4.setBorder(BorderFactory.createEmptyBorder(0,55,0,55));
	    jst4.setBackground(new Color(255,255,255,4));
	    tf4 = new JTextField(Double.toString(SFee.feed),0);
	    tf4.setEditable(false);
	    tf4.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(40,146,254)));
	    tf4.setFont(new Font("Segoe UI Historic", Font.PLAIN, 15));
		tf4.setToolTipText("Fee dues of student");
		tf4.setBackground(new Color(255,255,255));
	    jst4.add(tf4);
	    jst4.setLayout(new GridLayout(1,1,20,10));
	    jst4.setBorder(BorderFactory.createRaisedBevelBorder());
	    jptf.add(jst4);
	    jptf.setLayout(new GridLayout(1,4,5,5));
		jpfee.add(jptf);
		jpfee.setLayout(new GridLayout(2,1,10,10));
		f.getContentPane().add(jpfee);
		
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