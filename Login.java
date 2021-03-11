package SIS;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int flag =0;
	static String lid;
	Login() {
		// header
       Font font = new Font("Segoe UI Light",Font.BOLD,25);
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(240, 230, 230, 40));

		heading.setBounds(0, 0, 600, 100);
		JLabel name;
		name = new JLabel("Login Please");
		name.setForeground(Color.RED);
		name.setFont(new Font("Stencil", Font.BOLD, 50));
		heading.add(name);
		JPanel login = new JPanel();
		login.setLayout(null);
		login.setBackground(new Color(200, 200, 200, 25));
		login.setBounds(100, 125, 400, 450);
		JLabel un = new JLabel("Username");
		un.setFont(font);
		un.setBounds(50, 50, 300, 50);
		login.add(un);
		JTextField username = new JTextField("");
		username.setBounds(50, 110, 300, 50);
		username.setFont(font);
		username.setBackground(new Color(230, 240, 230));
		login.add(username);
		JLabel ps = new JLabel("Password");
		ps.setBounds(50, 170, 300, 50);
		login.add(ps);
		ps.setFont(font);
		JPasswordField password = new JPasswordField("");
		password.setBounds(50, 230, 300, 50);
		password.setBackground(new Color(230, 240, 230));
		password.setFont(font);
		login.add(password);

		JButton signup = new JButton("Sign Up");
		signup.setBounds(50, 290, 100, 50);
		signup.setBackground(new Color(160, 182, 45));
		signup.setFocusable(false);
		signup.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		signup.setFont(new Font("Segoe UI Light",Font.BOLD,19));
		signup.setForeground(Color.WHITE);
		login.add(signup);

		JButton login_button = new JButton("Login");
		login_button.setBounds(250, 290, 100, 50);
		login_button.setBackground(new Color(160, 182, 45));
		login_button.setFocusable(false);
		login_button.setFont(new Font("Segoe UI Light",Font.BOLD,19));
		login_button.setForeground(Color.WHITE);
		login_button.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lov = username.getText();
				String pass = new String(password.getPassword());
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
						   if(!rs.next()) {
							   flag =1;
						   }
						   else {
							ResultSet rs2 = st.executeQuery("Select * from STUDLOG");
				            while ( rs2.next() ){
				              String l = rs2.getString(1);				            				            		  
				              String p = rs2.getString(3);
				              if(l.equals(lov) && p.equals(pass)) {
				            	 flag=0;
				            	 break;
				              }
				              else {
				            	  flag=1;
				              }
				            }
						   }
						   con.close();
						}
				}
						catch(ClassNotFoundException ec) {
							System.out.println("Driver Not Loaded");
						}
						catch(SQLException ec ) {
							System.out.println("Connection Not Established");
						}
				 if(flag ==1) {
					JOptionPane.showMessageDialog(null, "Wrong username or password");
				}
				 else {
					 lid=lov;
					new ChooseStan();
				 }
			}
		});
		login.add(login_button);

		// frame
		setSize(600, 650);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// backgrounds
		ImageIcon background_image = new ImageIcon("Images\\logpic.png");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(600, 650, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		background.add(login);
		background.add(heading);
		background.setSize(600, 650);
		add(background);

		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		 Image icon = Toolkit.getDefaultToolkit().getImage("Images\\School-512.png");
		    setIconImage(icon);
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Registration();
			}

		});
	}
}