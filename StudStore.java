package SIS;

import java.sql.*;
import javax.swing.JOptionPane;
public class StudStore{
	static int r;
	StudStore (String sname, 
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
		   if(con!=null) {
			   Statement s = con.createStatement();
			   ResultSet rs  = s.executeQuery(StudPersonalData.qry);
			   int r=0;
			   while(rs.next()) {
				   r=rs.getInt(1);
				   System.out.println(r);
				   if(r==0) {
					   System.out.println("2s");
					   break;
				   }
				   else {
					   
					   r=r+1;
					   System.out.println(r);
				   }
				   
			   }
			   if(r==0) {
				   System.out.println("4s");
				 r = 1; 
			   }
				System.out.println(r);   
				   PreparedStatement ps=con.prepareStatement("insert into STUDM"+ChooseStan.lst+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
				  
				   ps.setInt(1, r);
				   ps.setString(2,sname);
			  	    ps.setString(3, sgen);
					ps.setString(4, sfn);
					ps.setString(5, smn);
					ps.setString(6, sfo);
					ps.setString(7, sdob);
					ps.setString(8, sess);
					ps.setString(9, sstand);
					ps.setDouble(10, sfee);
					ps.setString(11,scont);
					ps.setString(12,slin1);
					ps.setString(13, stown);
					ps.setString(14, scity);
					ps.setString(15,sstate);
					ps.setLong(16, spin);
					ps.setString(17, slin2);
					ps.setString(18, stown2);
					ps.setString(19, scity2);
					ps.setString(20, sstate2);
					ps.setLong(21, spin2);
					ps.setDouble(22, 0.0);
					ps.setDouble(23, 0.0);
					ps.setString(24, Login.lid);
					int i = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, i+ "Record inserted Table");
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
}