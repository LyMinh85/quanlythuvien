/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class TaiKhoanDAO {
    public static boolean themTaiKhoan(TaiKhoanDTO taiKhoan) {
        try {
            Connection con = MyConnection.getConnection();
            String queryInsert = "INSERT INTO TAI_KHOAN VALUES (?, ?)";
            try {
              PreparedStatement prest = con.prepareStatement(queryInsert);
              prest.setInt(1, taiKhoan.getId());
              prest.setString(2, taiKhoan.getMatKhau());
              prest.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
            con.close();
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean checkTaiKhoan(int id, String matKhau) {
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = "SELECT * FROM TAI_KHOAN\n" +
                                "WHERE id = ? AND matKhau = ?";
            PreparedStatement prest = con.prepareStatement(queryFind);
            prest.setInt(1, id);
            prest.setString(2, matKhau);
            ResultSet rs = prest.executeQuery();
            boolean result = rs.next();
            con.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
