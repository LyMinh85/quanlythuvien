/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS
 */
public class Connect {
    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QuanLyThuVien;"
                + "encrypt=true; trustServerCertificate=true;";
        String username = "minh";
        String password = "85659712";
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        return con;
    }
}
