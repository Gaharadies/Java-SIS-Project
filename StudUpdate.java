package SIS;

import javax.swing.*;
import java.util.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
public class StudUpdate {
  JFrame f = new JFrame("Student Update Details");
  JPanel jp1,jp3,jpl1,jpl2,jpl3,jsh;
  JLabel l2,l3,l4,r,n,fn,mn,fo,g,d,s,st,fe,c,al1,t1,cd1,s1,p1,al2,t2,cd2,s2,p2;
  JTextField rf,nf,fnf,mnf,fof,sf,stf,fef,cf,al1f,t1f,cd1f,s1f,p1f,al2f,t2f,cd2f,s2f,p2f;
  String name,gen,fname,mname,focc,dateob,ses,stand,cont,adrsl1,town,city,state,adrsl2,town2,city2,state2;
 
  long pin,pin2;
  
  Double fee;
  JCheckBox check;
  JRadioButton male, female;
  byte flag =0;
StudUpdate() {
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
    home.setBackground(Color.white);
    home.setIcon(backi);
	home.setCursor(new Cursor(12));
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
    
    // Buttons
    jp3= new JPanel();
	
    JButton bhome= new JButton("<html><p color=white><b>HOME<b></p></html>");
	bhome.setCursor(new Cursor(12));
    bhome.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    bhome.setBorderPainted(false);
	bhome.setFocusable(false);
    bhome.setBorder(BorderFactory.createRaisedBevelBorder());
    bhome.setBackground(new Color(50,50,250)); 
	bhome.setToolTipText("GoTo Student Homepage");
	bhome.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new StudHome();
		}
	});
    jp3.add(bhome);
	
    JButton bpdetail= new JButton("<html><p color=white><b>PERSONAL DETAILS<b></p></html>");
	bpdetail.setCursor(new Cursor(12));
    bpdetail.setBorderPainted(false);
    bpdetail.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    bpdetail.setBackground(new Color(50,50,250));  
    bpdetail.setFocusable(false);   
    bpdetail.setBorder(BorderFactory.createRaisedBevelBorder());
	bpdetail.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    check.setVisible(false);
			    jpl1.setVisible(true);
				jpl2.setVisible(false);
				jpl3.setVisible(false);
	    }
	});
	bpdetail.setToolTipText("Click to fill the personal\n"+ "details of student");
    jp3.add(bpdetail);
	
    JButton baddr1= new JButton("<html><p color=white><b>PRESENT ADDRESS<b></p></html>");
	baddr1.setCursor(new Cursor(12));
    baddr1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    baddr1.setBorderPainted(false);
	baddr1.setFocusable(false);
	baddr1.setBorder(BorderFactory.createRaisedBevelBorder());
    baddr1.setBackground(new Color(50,50,250)); 
	baddr1.setEnabled(false);
	baddr1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    check.setVisible(false);
			    jpl1.setVisible(false);
			    jpl2.setVisible(true);
				jpl3.setVisible(false);
	    }
	});
	baddr1.setToolTipText("Click to fill the present\n"+ "address of student");
	jp3.add(baddr1);
	
    JButton baddr2= new JButton("<html><p color=white><b>PERMANENT<b></p>\n"+"<html><p color =white><b> ADDRESS</b></p></html>");
	baddr2.setCursor(new Cursor(12));
    baddr2.setBorderPainted(false);
    baddr2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    baddr2.setBackground(new Color(50,50,250));  
    baddr2.setFocusable(false);    
    baddr2.setBorder(BorderFactory.createRaisedBevelBorder()); 
	baddr2.setEnabled(false);
	baddr2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    jpl1.setVisible(false);
			    jpl2.setVisible(false);
				check.setVisible(true);
				jpl3.setVisible(true);
	    }
	});
	baddr2.setToolTipText("Click to fill the permanent\n"+ "address of student");
    jp3.add(baddr2);
	
    jp3.setLayout(new GridLayout(1,4,5,10));
    jp3.setBackground(new Color(150,150,250));
    jp3.setBounds(0,200,1000,50);
    f.getContentPane().add(jp3);
    
	//Students Personal Details Form
    
    jpl1 = new JPanel();  
    jpl1.setBorder(BorderFactory.createRaisedBevelBorder());
    jpl1.setBounds(350,260,450,440);
    jpl1.setBackground(new Color(250,250,250,64));
    r= new JLabel("Roll: ");
    r.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    r.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(r);
    rf = new JTextField(StudSearch.ur[0],0);
    Border empty = BorderFactory.createEmptyBorder(0,0,0,195);
    Border matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    rf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    rf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	rf.setToolTipText("Fill the roll of student");
	rf.setEnabled(false);
    jpl1.add(rf);
	
    n= new JLabel("Name: ");
    n.setBounds(250,325,100,22);   
    n.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    n.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(n);
    nf = new JTextField(StudSearch.ur[1],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,65);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    nf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    nf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	nf.setToolTipText("Fill the name of student");
    jpl1.add(nf);
	
	g= new JLabel("Gender: ");
    g.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    g.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(g);
    JPanel mfr = new JPanel();
	male = new JRadioButton("Male",true);
	female = new JRadioButton("Female",false);
	if(StudSearch.ur[2].equals("M")) {
		male.setSelected(true);
		female.setSelected(false);
	}
	else if(StudSearch.ur[2].equals("F")){
		male.setSelected(false);
		female.setSelected(true);
	}
	male.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	male.setBackground(Color.white);
	male.setBorderPainted(false);
	male.setFocusable(false);
	male.setToolTipText("Set gender to male");
	male.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			female.setSelected(false);
		}
	});
	mfr.add(male);
	female.setBackground(Color.white);
	female.setBorderPainted(false);
	female.setFocusable(false);
	female.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	female.setToolTipText("Set gender to female");
	female.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			male.setSelected(false);
		}
	});
	mfr.setBackground(new Color(250,250,250));
	mfr.add(female);
	mfr.setLayout(new GridLayout(1,2,0,10));
    jpl1.add(mfr);
	
	fn= new JLabel("Father's Name: ");
    fn.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    fn.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(fn);
    fnf = new JTextField(StudSearch.ur[3],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,65);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    fnf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    fnf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	fnf.setToolTipText("Fill the father's name of student");
    jpl1.add(fnf);
	
	mn= new JLabel("Mother's Name: ");
    mn.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    mn.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(mn);
    mnf = new JTextField(StudSearch.ur[4],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,65);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    mnf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    mnf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	mnf.setToolTipText("Fill the Mother's Name of the student");
    jpl1.add(mnf);
	
	fo= new JLabel("Father's Occupation: ");
    fo.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    fo.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(fo);
    fof = new JTextField(StudSearch.ur[5],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    fof.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    fof.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	fof.setToolTipText("Fill the roll of student");
    jpl1.add(fof);
	
    d= new JLabel("Date Of Birth: ");
    d.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    d.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(d);
    SimpleDateFormat dobs = new SimpleDateFormat("dd/MM/yyyy"); 
    JFormattedTextField df = new JFormattedTextField(dobs);
    
    Date dates = null;
	try {
		dates = dobs.parse(StudSearch.ur[6]);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	df.setValue(dates);
   
    empty = BorderFactory.createEmptyBorder(0,0,0,110);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    df.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    df.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	df.setToolTipText("Fill the Date of Birth of the student\n"+"in dd/mm/yyyy format");
    jpl1.add(df);
    s= new JLabel("Session: ");
    s.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    s.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(s);
    sf = new JTextField(StudSearch.ur[7],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,123);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    sf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    sf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	sf.setToolTipText("Fill the session of the student\n"+"in yyyy-yyyy format");
    jpl1.add(sf);
    st= new JLabel("Standard: ");
    st.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    st.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(st);
    stf = new JTextField(StudSearch.ur[8],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,195);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    stf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    stf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	stf.setToolTipText("Fill the standard of the student\n"+"like as for 1 i");
    jpl1.add(stf);
    fe= new JLabel("Fee: ");
    fe.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    fe.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(fe);
    fef = new JTextField(StudSearch.ur[9],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,150);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    fef.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    fef.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	fef.setToolTipText("Fill the fee of the student");
    jpl1.add(fef);
    c= new JLabel("Contact: ");
    c.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    c.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl1.add(c);
    cf = new JTextField(StudSearch.ur[10],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,100);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    cf.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    cf.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	cf.setToolTipText("Fill the contact of student");
    jpl1.add(cf);
    JButton reset= new JButton("<html><h1 color=white>RESET</h1></html>");
	reset.setCursor(new Cursor(12));
    reset.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    reset.setBorderPainted(false);
    Border bevel = BorderFactory.createRaisedBevelBorder();
    empty = BorderFactory.createEmptyBorder(0,50,0,50);
    JButton submit= new JButton("<html><h1 color=white>SUBMIT</h1></html>");
	submit.setCursor(new Cursor(12));
    submit.setBorderPainted(false);
    submit.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    submit.setBackground(new Color(50,50,250));  
    submit.setFocusable(false);
    reset.setFocusable(false);
    submit.setBorder(BorderFactory.createCompoundBorder(empty,bevel));
    reset.setBorder(BorderFactory.createCompoundBorder(empty,bevel));
    reset.setBackground(new Color(50,50,250)); 
	reset.setToolTipText("Reset the details of the student");
	reset.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    jpl1.setVisible(true);
				nf.setText("");
				male.setSelected(true);
				female.setSelected(false);
				fnf.setText("");
				mnf.setText("");
				fof.setText("");
				df.setValue(new Date());
				sf.setText("");
				stf.setText("");
				fef.setText("");
			    cf.setText("");
			    flag =0;
	    }
	});
	submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				name = nf.getText();
				nf.setEnabled(false);
				if(nf.getText().equals("")) {
					nf.setEnabled(true);
					flag =0;
				}
				if(male.isSelected()) {
					gen="M";
				}
				else {
					gen = "F";
				}
				male.setEnabled(false);
				female.setEnabled(false);
				fname = fnf.getText();
				fnf.setEnabled(false);
				if(fnf.getText().equals("")) {
					fnf.setEnabled(true);
					flag =0;
				}
				mname = mnf.getText();
				mnf.setEnabled(false);
				if(mnf.getText().equals("")) {
					mnf.setEnabled(true);
					flag =0;
				}
				focc = fof.getText();
				fof.setEnabled(false);
				if(fof.getText().equals("")) {
					fof.setEnabled(true);
					flag =0;
				}
				dateob = df.getText();
				df.setEnabled(false);
				String dat2= new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				if(dateob.equals(dat2)) {
					df.setEnabled(true);
					flag =0;
				}
				sf.setEnabled(false);
				if(sf.getText().equals("")) {
					sf.setEnabled(true);
					flag =0;
				}
				stf.setEnabled(false);
				if(stf.getText().equals("")) {
					stf.setEnabled(true);
					flag =0;
				}
				fee = Double.parseDouble(fef.getText());
				fef.setEnabled(false);
				cf.setEnabled(false);
				if(cf.getText().equals("")) {
					cf.setText("");
					cf.setEnabled(true);
					flag =0;
				}
			    jpl1.setVisible(false);
				baddr1.setEnabled(true);
			}
			catch (NumberFormatException ex){
				flag =0;
			    JOptionPane.showMessageDialog (null,"Enter Valid Details");
				fef.setText("");
				fef.setEnabled(true);
				jpl1.setVisible(true);
			}
		
				if(!(nf.isEnabled() && fnf.isEnabled() && mnf.isEnabled()
				   && fof.isEnabled() && sf.isEnabled() && stf.isEnabled() 
				   && fef.isEnabled() && cf.isEnabled() && rf.isEnabled()) ) {
					flag =1;
					name = nf.getText();
					fname = fnf.getText();
					mname = mnf.getText();
					focc = fof.getText();
					ses = sf.getText();
					stand = stf.getText();
					fee = Double.parseDouble(fef.getText());
					cont = cf.getText();
				}
	    }
	});
	submit.setToolTipText("If you click on submit you can not change the details");
    jpl1.add(reset);
    jpl1.add(submit);
	jpl1.setLayout(new GridLayout(12,2,2,10));
    f.getContentPane().add(jpl1); 
    
	// Present Address Details Form
	jpl2 = new JPanel(); 
	jpl2.setVisible(false);
    jpl2.setBorder(BorderFactory.createRaisedBevelBorder());
    jpl2.setBounds(350,270,450,350);
    jpl2.setBackground(new Color(250,250,250,64));
    al1= new JLabel("Address Line1: ");
    al1.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    al1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl2.add(al1);
    al1f = new JTextField(StudSearch.ur[11],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    al1f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    al1f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	al1f.setToolTipText("Fill the address line1");
    jpl2.add(al1f);
    t1= new JLabel("Town / village");
    t1.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    t1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl2.add(t1);
    t1f = new JTextField(StudSearch.ur[12],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    t1f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    t1f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	t1f.setToolTipText("Fill the town/village of the student");
    jpl2.add(t1f);
    cd1= new JLabel("City / District");
    cd1.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    cd1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl2.add(cd1);
    cd1f =new JTextField(StudSearch.ur[13]);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    cd1f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    cd1f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	cd1f.setToolTipText("Fill the City / district of the student");
    jpl2.add(cd1f);
    s1= new JLabel("State ");
    s1.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    s1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl2.add(s1);
    s1f = new JTextField(StudSearch.ur[14],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    s1f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    s1f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	s1f.setToolTipText("Fill the state of the student");
    jpl2.add(s1f);
    p1= new JLabel("Pin ");
    p1.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    p1.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl2.add(p1);
    p1f = new JTextField(StudSearch.ur[15],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    p1f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    p1f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	p1f.setToolTipText("Fill the pin code it must be 6 digit chararcter");
    jpl2.add(p1f);
    JButton reset2= new JButton("<html><h1 color=white>RESET</h1></html>");
	reset2.setCursor(new Cursor(12));
    reset2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    reset2.setBorderPainted(false);
    bevel = BorderFactory.createRaisedBevelBorder();
    empty = BorderFactory.createEmptyBorder(0,50,0,50);
	reset2.setToolTipText("Reset the  details");
    JButton submit2= new JButton("<html><h1 color=white>SUBMIT</h1></html>");
	submit2.setCursor(new Cursor(12));
    submit2.setBorderPainted(false);
    submit2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    submit2.setBackground(new Color(50,50,250));
    submit2.setToolTipText("Submit the details, after that you can notchange it");	
    submit2.setFocusable(false);
    reset2.setFocusable(false);
    submit2.setBorder(BorderFactory.createCompoundBorder(empty,bevel));
    reset2.setBorder(BorderFactory.createCompoundBorder(empty,bevel));
    reset2.setBackground(new Color(50,50,250)); 
	reset2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    jpl2.setVisible(true);
				al1f.setText("");
				t1f.setText("");
				cd1f.setText("");
				s1f.setText("");
				p1f.setText("");
	    }
	});
	submit2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {	
				al1f.setEnabled(false);
				if(al1f.getText().equals("")) {
					al1f.setEnabled(true);
					flag =0;
				}
				t1f.setEnabled(false);
				if(t1f.getText().equals("")) {
					t1f.setEnabled(true);
					flag =0;
				}
				cd1f.setEnabled(false);
				if(cd1f.getText().equals("")) {
					cd1f.setEnabled(true);
					flag =0;
				}
				s1f.setEnabled(false);
				if(s1f.getText().equals("")) {
					s1f.setEnabled(true);
					flag=0;
				}
				pin= Long.parseLong(p1f.getText());
				p1f.setEnabled(false);
			    jpl2.setVisible(false);
				baddr2.setEnabled(true);
			}
			catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog (null,"Enter Valid Details");
				p1f.setText("");
				p1f.setEnabled(true);
				jpl2.setVisible(true);
				flag =0;
			}
			
				if(!(al1f.isEnabled() && t1f.isEnabled() && cd1f.isEnabled() && s1f.isEnabled()
						&& p1f.isEnabled())) {
					flag =1;
					adrsl1 = al1f.getText();
					town = t1f.getText();
					city = cd1f.getText();
					state = s1f.getText();
					pin= Long.parseLong(p1f.getText());
				}
				
			
	    }
	});
    jpl2.add(reset2);
    jpl2.add(submit2);
	jpl2.setLayout(new GridLayout(6,2,5,10));
 
	
	check  = new JCheckBox("Is permanent address is same as present address?");
	check.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));	
	check.setBounds(350,250,450,25);
	check.setBackground(new Color(255,255,255));
	check.setVisible(false);
    f.getContentPane().add(check);
	
	// Permanent Address Details Form
	jpl3 = new JPanel(); 
	jpl3.setVisible(false);
    jpl3.setBorder(BorderFactory.createRaisedBevelBorder());
    jpl3.setBounds(350,280,450,350);
    jpl3.setBackground(new Color(250,250,250,64));	
    al2= new JLabel("Address Line1: ");
    al2.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    al2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl3.add(al2);
    al2f = new JTextField(StudSearch.ur[16],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    al2f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    al2f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	al2f.setToolTipText("Fill the address line1");
    jpl3.add(al2f);
    t2= new JLabel("Town / village");
    t2.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    t2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl3.add(t2);
    t2f = new JTextField(StudSearch.ur[17],0);
    t2f.setSize(100,22);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    t2f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    t2f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	t2f.setToolTipText("Fill the town/village of the student");
    jpl3.add(t2f);
    cd2= new JLabel("City / District");
    cd2.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    cd2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl3.add(cd2);
    cd2f =new JTextField(StudSearch.ur[18]);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    cd2f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    cd2f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    cd2f.setToolTipText("Fill the City / district of the student");
    jpl3.add(cd2f);
    s2= new JLabel("State ");
    s2.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    s2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl3.add(s2);
    s2f = new JTextField(StudSearch.ur[19],0);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    s2f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    s2f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	s2f.setToolTipText("Fill the state of the student");
    jpl3.add(s2f);
    p2= new JLabel("Pin ");
    p2.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
    p2.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    jpl3.add(p2);
    p2f = new JTextField(StudSearch.ur[20],0);
    p2f.setSize(100,22);
    empty = BorderFactory.createEmptyBorder(0,0,0,10);
    matte = BorderFactory.createMatteBorder(0,0,2,0,new Color(50,50,250));
    p2f.setBorder(BorderFactory.createCompoundBorder(empty,matte));
    p2f.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
	p2f.setToolTipText("Fill the pin of 6 digit number of the student");
	check.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(check.isSelected()) {
				al2f.setText(adrsl1);
				al2f.setEnabled(false);
				t2f.setText(town);
				t2f.setEnabled(false);
				cd2f.setText(city);
				cd2f.setEnabled(false);
				s2f.setText(state);
				s2f.setEnabled(false);
				p2f.setText(Long.toString(pin));
				p2f.setEnabled(false);
			}
			else if(!(check.isSelected())) {
				al2f.setText("");
				al2f.setEnabled(true);
				t2f.setText("");
				t2f.setEnabled(true);
				cd2f.setText("");
				cd2f.setEnabled(true);
				s2f.setText("");
				s2f.setEnabled(true);
				p2f.setText("");
				p2f.setEnabled(true);
				flag =0;
			}
	    }
	});
	check.setBorderPainted(false);
	check.setFocusable(false);
	f.getContentPane().add(jpl2);
    jpl3.add(p2f);		
    JButton reset3= new JButton("<html><h1 color=white>RESET</h1></html>");
	reset3.setCursor(new Cursor(12));
    reset3.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    reset3.setBorderPainted(false);
    bevel = BorderFactory.createRaisedBevelBorder();
    empty = BorderFactory.createEmptyBorder(0,50,0,50);
    JButton submit3= new JButton("<html><h1 color=white>SUBMIT</h1></html>");
	submit3.setCursor(new Cursor(12));
    submit3.setBorderPainted(false);
    submit3.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
    submit3.setBackground(new Color(50,50,250));  
    submit3.setFocusable(false);
    reset3.setFocusable(false);
    submit3.setBorder(BorderFactory.createCompoundBorder(empty,bevel));
    reset3.setBorder(BorderFactory.createCompoundBorder(empty,bevel));
    reset3.setBackground(new Color(50,50,250)); 
	reset3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			    jpl3.setVisible(true);
				al2f.setText("");
				t2f.setText("");
				cd2f.setText("");
				s2f.setText("");
				p2f.setText("");
				flag =0;
	    }
	});
	submit3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				al2f.setEnabled(false);
				if(al2f.getText().equals("")) {
					al2f.setEnabled(true);
					flag =0;
				}
				t2f.setEnabled(false);
				if(t2f.getText().equals("")) {
					t2f.setEnabled(true);
					flag =0;
				}
				cd2f.setEnabled(false);
				if(cd2f.getText().equals("")) {
					cd2f.setEnabled(true);
					flag =0;
				}
				s2f.setEnabled(false);
				if(s2f.getText().equals("")) {
					s2f.setEnabled(true);
					flag =0;
				}
			try{
				pin2= Long.parseLong(p2f.getText());
				p2f.setEnabled(false);
				check.setVisible(false);
			    jpl3.setVisible(false);
			}
			catch(NumberFormatException ex) {
			    JOptionPane.showMessageDialog (null,"Enter Valid Details");
				p2f.setText("");
				p2f.setEnabled(true);
				jpl3.setVisible(true);
			}
			
				if(!(al2f.isEnabled() && t2f.isEnabled() && cd2f.isEnabled() && s2f.isEnabled()
						&& p2f.isEnabled())) {
					flag =1;
					adrsl2 = al2f.getText();
					town2 = t2f.getText();
					city2 = cd2f.getText();
					state2 = s2f.getText();
					pin2= Long.parseLong(p2f.getText());
				}
			if(flag == 1) {
				
			new StudUp(name,
					gen,fname,mname,focc,dateob,ses,stand,
					fee,
					cont,
					adrsl1,town,city,state,pin,
					adrsl2,town2,city2,state2,pin2);
			}
			else {
				JOptionPane.showMessageDialog(null, "Insert Informations Carefully According To Tooltips");
			}
	}
	});
    jpl3.add(reset3);
    jpl3.add(submit3);
	jpl3.setLayout(new GridLayout(6,2,5,10));
    f.getContentPane().add(jpl3);
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