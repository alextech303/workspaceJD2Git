package by.htp.jd2_les01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
	
    public static void main( String[] args )throws ClassNotFoundException, SQLException {
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	Connection con = null;
		Statement st = null;
		ResultSet rs = null;

//		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jd2-jdbc01?useSSL=false", "root",	"g145101988Q");

			System.out.println("OK");
    	
             st = con.createStatement();
			
			 rs = st.executeQuery("SELECT * FROM users");
			
			String sql = "INSERT INTO users(name,surname) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, "Maslakov");
			ps.setString(2, "Alexey");

			ps.executeUpdate();


			
			 while (rs.next()) {
				 System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)); 
			 }
			
			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			try {
//				if (st != null) {
//					st.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			try {
//				if (con != null) {
//					con.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}

		}
    }


