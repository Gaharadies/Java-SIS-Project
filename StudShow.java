package SIS;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudShow{
	JFrame f =new JFrame("Student Details");
	JPanel jp1,jp3,jp2,jstud;
    JLabel l2,l3,l4,l5;
    StudShow () {
   	 // background
        ImageIcon backi3 = new ImageIcon("Images\\wave4.png");
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
    	l5 = new JLabel("Students Details",JLabel.CENTER);
    	l5.setFont(new Font("Goudy Stout", Font.BOLD, 35));
    	l5.setForeground(Color.white);
    	jp3.add(l5);
    	jp3.setBorder(BorderFactory.createRaisedBevelBorder());
    	jp3.setLayout(new GridLayout(1,1,5,10));
        jp3.setBackground(new Color(40,146,254));
        jp3.setBounds(0,200,1000,50);
    	f.getContentPane().add(jp3);
    	
    	// Shows Table
    	jp2 = new JPanel();
    	jp2.setBackground(new Color(255,255,255,5));
    	String data[][] = new String[1][21];
    	String column[] = {"Roll","Name","Gender","Father","Mother","Father Occupation",
    			"Date Of Birth","Session","Standard","Fee","Contact",
    			"Present Address","Permanent Address"};
    	String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "SYSTEM";
		String pass = "hari";
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
 		   System.out.println("Driver Loaded");
 		   Connection con = DriverManager.getConnection(url,user,pass);
 		   System.out.println("Connection Established");
 		   if(con!=null) {
 			   Statement st = con.createStatement();
 			   ResultSet rs  = st.executeQuery("Select *From STUDM"+ChooseStan.lst);
 		   int c =0;
 		   while (rs.next()) {
 			   c= c+1;
 		   }
 		  data = new String[c][13];
 		 c--;
 		  int i=0;
 		  System.out.println(c);
 		 ResultSet rs2 = st.executeQuery("Select * from STUDM"+ChooseStan.lst);
 		     while(rs2.next()) {
 		    	int j=0;
 		    	data[i][11]="";
 		    	data[i][12]="";
                while ( j<21 ){	
                  if(j < 11) {
                      data[i][j]=rs2.getString(j+1);
                  }
                	
                  if(j>=11  && j<=15) {
                	 data[i][11] = data[i][11]+rs2.getString(j+1)+", ";
                  }
                  if(j>=16  && j<=20) {
                 	 data[i][12] = data[i][12]+rs2.getString(j+1)+", ";
                   }
                  j++;
                }
                i++;
 		     }
 		   }
 		   con.close();
 		}
 		catch(ClassNotFoundException e) {
 			System.out.println("Driver Not Loaded");
 		}
 		catch(SQLException e ) {
 			System.out.println("Connection Not Established");
 		} 

    	JTable jt = new JTable(data,column);
    	JTableHeader Theader = jt.getTableHeader() ;
    	Theader.setBackground(new Color(40,146,254));
    	Theader.setForeground(Color.WHITE);
    	Theader.setFont(new Font("Tahome",Font.BOLD,16));
    	Theader.setBorder(BorderFactory.createRaisedBevelBorder());
    	jt.setFont(new Font("Segoe UI Historic", Font.PLAIN, 14));
    	JScrollPane sp = new JScrollPane(jt);
    	jt.setFillsViewportHeight(true);
    	sp.setBackground(new Color(255,255,255,5));
    	sp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    	 TableColumn col = null;
    	    for (int i = 0; i < 13; i++) {
    	        col = jt.getColumnModel().getColumn(i);
    	        if (i == 0) {
    	            col.setPreferredWidth(100); //sport column is bigger
    	        }
    	        else if(i==1){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==2){
    	            col.setPreferredWidth(50);
    	        }
    	        else if(i==3){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==4){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==5){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==6){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==7){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==8){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==9){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==10){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==11){
    	            col.setPreferredWidth(200);
    	        }
    	        else if(i==12){
    	            col.setPreferredWidth(200);
    	        }
    	    }    
    	    
    	jp2.add(sp);
    	jp2.setBounds(150,300,800,350);
    	jp2.setLayout(new GridLayout(1,1,0,0));
    	f.getContentPane().add(jp2);
    
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