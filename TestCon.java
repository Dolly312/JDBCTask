package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCon {
	
	String host = "localhost:3306";
    String database = "electronicdevice";
    String url = "jdbc:mysql://"+ host+"/"+database;

    static Connection con;
    PreparedStatement ps;
   
    public TestCon() throws SQLException, ClassNotFoundException
    {
    	Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,"root","Cloud@123$");
        System.out.println("con "+con);
       
    }

    public static void main(String[] args) {
		try {
			new TestCon();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return con;
	}
}