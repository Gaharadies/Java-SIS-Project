package SIS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StudHome {
	JFrame f =new JFrame("Student Home Page");
	JPanel jp1,jp3,jpins,jpup,jpdel,jpfee,jstud,jpshow,jpad;
    JLabel l2,l3,l4,l5;
	StudHome() {
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
    home.setFocusable(false);
    home.setFocusPainted(false);
    home.setBorderPainted(false);
	home.setCursor(new Cursor(12));
    home.setBackground(Color.white);
    home.setIcon(backi);
    home.setBorder(BorderFactory.createEmptyBorder());
    home.setMargin(new Insets(10, 10, 10, 10));
    home.setBounds(0,0,200,200);
	home.setToolTipText("GoTo Main Home Page");
    jp1.add(home);
    ImageIcon backi2 = new ImageIcon("Images\\school3.jpg");
    Image img2 = backi2.getImage();
    Image temp_img2 =img2.getScaledInstance(800,200,Image.SCALE_SMOOTH);
    backi2 = new ImageIcon(temp_img2);
    l2= new JLabel("",backi2,JLabel.CENTER);
    l2.setBounds(200,0,800,200);
    jp1.add(l2);
    String str = "<html><p><u> School Information <br><center> System <center></u></p></html>\n";
	JLabel l3= new JLabel(str,JLabel.CENTER);
	l3.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	l3.setForeground(new Color(70,176,250));
    jp1.add(l3);
    jp1.setLayout(new BorderLayout());
    jp1.setBackground(new Color(250,250,250));
    jp1.setBounds(0,0,1000,200);
    f.getContentPane().add(jp1);
    
    // Title
    jp3= new JPanel();
	l5 = new JLabel("Students Information",JLabel.CENTER);
	l5.setFont(new Font("Goudy Stout", Font.BOLD, 35));
	l5.setForeground(Color.white);
	jp3.add(l5);
	jp3.setBorder(BorderFactory.createRaisedBevelBorder());
	jp3.setLayout(new GridLayout(1,1,5,10));
    jp3.setBackground(new Color(40,146,254));
    jp3.setBounds(0,200,1000,50);
	f.getContentPane().add(jp3);
	
	// Insert Details
	jpins = new JPanel();
	jpins.setBackground(Color.white);
	jpins.setBounds(450,265,550,50); 
    JButton ins = new JButton("Insert Details");
	ins.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	ins.setBackground(new Color(40,146,250));
	ins.setForeground(Color.white);
	ins.setCursor(new Cursor(12));
	ins.setBorder(BorderFactory.createRaisedBevelBorder());
	ins.setBorderPainted(true);
    ins.setFocusable(false);
	ins.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new StudPersonalData();
		}
	});
	jpins.add(ins);
	jpins.setLayout(new GridLayout(1,1,0,0));
	f.getContentPane().add(jpins);
	
	// Show Details
		jpshow = new JPanel();
		jpshow.setBackground(Color.white);
		jpshow.setBounds(450,330,550,50); 
	    JButton show = new JButton("Show Details");
		show.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
		show.setBackground(new Color(40,146,250));
		show.setForeground(Color.white);
		show.setCursor(new Cursor(12));
		show.setBorder(BorderFactory.createRaisedBevelBorder());
		show.setBorderPainted(true);
	    show.setFocusable(false);
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudShow();
			}
		});
		jpshow.add(show);
		jpshow.setLayout(new GridLayout(1,1,0,0));
		f.getContentPane().add(jpshow);
	
	// Update Details
	jpup = new JPanel();
	jpup.setBackground(Color.white);
	jpup.setBounds(450,395,550,50);    
    JButton up = new JButton("Update Details");
	up.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	up.setBackground(new Color(40,146,250));
	up.setCursor(new Cursor(12));
	up.setForeground(Color.white);
	up.setBorderPainted(true);
    up.setFocusable(false);
	up.setBorder(BorderFactory.createRaisedBevelBorder());
	up.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new StudSearch();
		}
	});
	jpup.add(up);
	jpup.setLayout(new GridLayout(1,1,0,0));
	f.getContentPane().add(jpup);
	
	// Delete Details
	jpdel = new JPanel();
	jpdel.setBackground(Color.white);
	jpdel.setBounds(450,460,550,50); 
    JButton del = new JButton("Delete Details");
	del.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	del.setBackground(new Color(40,146,250));
	del.setCursor(new Cursor(12));
	del.setForeground(Color.white);
	del.setBorderPainted(true);
    del.setFocusable(false);
	del.setBorder(BorderFactory.createRaisedBevelBorder());
	del.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new StudDel();
		}
	});
	jpdel.add(del);
	jpdel.setLayout(new GridLayout(1,1,0,0));
	f.getContentPane().add(jpdel);
	
	// Fee Details
	jpfee = new JPanel();
	jpfee.setBackground(Color.white);
	jpfee.setBounds(450,525,550,50); 
    JButton fee = new JButton("Fee Details");
	fee.setFont(new Font("Showcard Gothic", Font.BOLD, 35));
	fee.setBackground(new Color(40,146,250));
	fee.setCursor(new Cursor(12));
	fee.setForeground(Color.white);
    fee.setFocusable(false);
	fee.setBorder(BorderFactory.createRaisedBevelBorder());
	fee.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new SFee();
		}
	});
	jpfee.add(fee);
	jpfee.setLayout(new GridLayout(1,1,0,0));
	f.getContentPane().add(jpfee);
	
	//Bottom Borders
	jstud = new JPanel();
	jstud.setBackground(new Color(72,38,100));
	jstud.setBounds(0,675,1000,50); 
	jstud.setLayout(new GridLayout(1,1,0,0));
	f.getContentPane().add(jstud);
	
    f.getContentPane().add(l4);
    f.setSize(1000,750);
    f.setResizable(false);
    f.getContentPane().setLayout(new BorderLayout());
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    Image icon = Toolkit.getDefaultToolkit().getImage("Images\\School-512.png");
    f.setIconImage(icon);
  }
} 