package by.htp.jd2_les01.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
Class.forName("org.gjt.mm.mysql.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jd2-jdbc01?useSSL=false","root", "g145101988Q");

		String sql = "INSERT INTO users(name,surname) VALUES(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, "jjj");
	    ps.setString(2, "llll");

		ps.executeUpdate();

System.out.println("!!!");
		// close
	}

	}


