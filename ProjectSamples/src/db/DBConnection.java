package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static void initConnection() {
	
	try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loading Success");
     } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
}
public static Connection getConnection() {
    Connection conn = null;
    System.out.println("now null");
    try {
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mbbh0506");
       System.out.println("MySQL Connection Success!!");
    } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
    }
    return conn;
    
 }

}
