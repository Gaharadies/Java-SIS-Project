package SIS;

import java.sql.*;
import javax.swing.JOptionPane;
public class StudUp{
	static int r;
	StudUp (String sname, 
			String sgen, String sfn, String smn, String sfo, String sdob, String sess,
			String sstand, double sfee, String scont,
			String slin1, String stown, String scity, String sstate, long spin,
			String slin2, String stown2, String scity2, String sstate2, long spin2) {	    
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "SYSTEM";
		String pass = "hari";
	   try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   System.out.println("Driver Loaded");
		   Connection con = DriverManager.getConnection(url,user,pass);
		   System.out.println("Connection Established");
			   if(con != null) {
				            	  PreparedStatement ps=con.prepareStatement("update STUDM"+ChooseStan.lst+" set  SNAME=? , SGEN= ? ,"
				            	  		+ " SFATN=? , SMATN=? ,SFOCC=? , SDOB=? , SSESS=? , SSTAND=? , SFEE=? ,"
				            	  		+ " SCONT=? ,  SLIN1=? , STOWN=? , SCITY=? ,"
				            	  		+ " SSTATE=? , SPIN=? , SLIN2=? , STOWN2=? , SCITY2=? , " 
				            	  		+ " SSTATE2=? , SPIN2=? where REG_ID=?"); 
				            	  
				  				    ps.setString(1,sname);
				  			  	    ps.setString(2, sgen);
				  					ps.setString(3, sfn);
				  				    ps.setString(4, smn);
				  					ps.setString(5, sfo);
				  					ps.setString(6, sdob);
				  					ps.setString(7, sess);
				  					ps.setString(8, sstand);
				  					ps.setDouble(9, sfee);
				  					ps.setString(10,scont);
				  					ps.setString(11,slin1);
				  					ps.setString(12, stown);
				  					ps.setString(13, scity);
				  					ps.setString(14,sstate);
				  				    ps.setLong(15, spin);  					
				  					ps.setString(16, slin2);
				  					ps.setString(17, stown2);
				  					ps.setString(18, scity2);
				  					ps.setString(19, sstate2);				  					
				  					ps.setLong(20, spin2); 				  					
				  					ps.setInt(21, StudSearch.sroll);
				  					
				  					int i= ps.executeUpdate();
				            	 JOptionPane.showMessageDialog(null, i+" Record updated");
						   }
						   con.close();
						}
						catch(ClassNotFoundException ec) {
							System.out.println("Driver Not Loaded");
						}
						catch(SQLException ec ) {
							System.out.println("Connection Not Established");
						}
			   
			   }
	}