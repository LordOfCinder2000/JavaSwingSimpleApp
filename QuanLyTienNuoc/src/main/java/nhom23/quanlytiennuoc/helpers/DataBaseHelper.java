/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom23.quanlytiennuoc.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class DataBaseHelper {
    private static String DB_URL = "jdbc:mysql://localhost:3306/QuanLyTienNuoc";
    private static String USER_NAME = "root";
    private static String PASSWORD = "123456";

    public static Connection openConnection()
    {
    	Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
    	return conn;
    }


    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("\nconnect successfully!");
        } catch (Exception ex) {
            System.out.println("\nconnect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
