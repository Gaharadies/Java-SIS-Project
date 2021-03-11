package SIS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChooseStan {	
		JFrame f =new JFrame("Student Class Selection Page");
		JPanel jp1,jp3,jpins,jpup,jpdel,jpfee,jstud,jpshow,jpad,jsh;
	    JLabel l2,l3,l4,l5;
	    static String lst;
		ChooseStan() {
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

		// to INSERT :panel
	    jsh = new JPanel();
		jsh.setBounds(480, 300,350,250);
		jsh.setBackground(new Color(250,250,250,4));
	    jsh.setBorder(BorderFactory.createRaisedBevelBorder());
	    JPanel jsa = new JPanel();
	    jsa.setBorder(BorderFactory.createEmptyBorder(20,55,0,55));
	    jsa.setBackground(new Color(255,255,255,4));
	    JLabel en = new JLabel("Select standard");
	    en.setForeground(new Color(80,80,80));
	    en.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	    jsa.add(en);
	    jsh.add(jsa);
	    
	    JPanel jsa2 = new JPanel();
	    jsa2.setBorder(BorderFactory.createEmptyBorder(0,55,0,55));
	    jsa2.setBackground(Color.WHITE);
	    String [] list= {"i","ii","iii","iv","v","vi","vii","viii","ix","x","xi","xii"};
	    final JComboBox<Object> ns = new JComboBox<Object>(list);
	    ns.setBorder(BorderFactory.createMatteBorder(2,2,2,2,new Color(50,50,250)));
	    ns.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		ns.setToolTipText("Fill the name of student");
		ns.setBackground(new Color(250,250,255));
	    jsa2.add(ns);
	    jsa2.setLayout(new GridLayout(1,1,20,10));
	    jsh.add(jsa2);
	    
	    JButton ad = new JButton("Insert");
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
					 lst=""+ ns.getItemAt(ns.getSelectedIndex());	
					 new StudHome();
			
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
