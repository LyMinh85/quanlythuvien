/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoaiSachDTO;
import DTO.SachDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SachDAO {
    private SachDTO resutlSetSachDTO (ResultSet rs){
      SachDTO sachDTO = null;
      try{
          sachDTO =new SachDTO(
                rs.getInt("id"),
                rs.getString("tenSach"),
                rs.getFloat("giaSach"),
                rs.getInt("soluong"),
                rs.getInt("trangthai"),
                rs.getInt("idTacGia"),
                rs.getInt("idNhaXuatBan"),
                rs.getInt("idLoaiSach"),
                rs.getInt("idKho")
          );
          
      } catch (SQLException e) {
            e.printStackTrace();}
        return sachDTO;  
    }
    
    public boolean insertone (SachDTO sach)
    {
        Connection con = null;
        try{
            con = MyConnection.getConnection();
            String queryInsert = "INSERT INTO SACH VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(queryInsert);
            ps.setInt(1, sach.getId());
            ps.setString(2, sach.getTenSach());
            ps.setFloat(3, sach.getGiaSach());
            ps.setInt(4, sach.getSoluong());
            ps.setInt(5, sach.getTrangthai());
            ps.setInt(6, sach.getIdTacGia());
            ps.setInt(7, sach.getIdNhaXuatBan());
            ps.setInt(8, sach.getIdLoaiSach());
            ps.setInt(9, sach.getIdKho());
            int c = ps.executeUpdate();
            con.close();
            return c !=0;
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<SachDTO> findAll(){
        ArrayList<SachDTO> listSach = new ArrayList();
        try{
            Connection con = MyConnection.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM SACH";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                SachDTO sach = new SachDTO(
                    rs.getInt("id"),
                    rs.getString("tenSach"),
                    rs.getFloat("giaSach"),
                    rs.getInt("soluong"),
                    rs.getInt("trangthai"),
                    rs.getInt("idTacGia"),
                    rs.getInt("idNhaXuatBan"),
                    rs.getInt("idLoaiSach"),
                    rs.getInt("idKho")
                );
                listSach.add(sach);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }
    
    public SachDTO findone(int id){
        SachDTO sachDTO = null;
        try{
             Connection con = MyConnection.getConnection();
             String query = "SELECT * FROM SACH WHERE id=?";
             PreparedStatement ps= con.prepareStatement(query);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             if(rs.next())
             {
                 sachDTO = resutlSetSachDTO(rs);
             }
             con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sachDTO;
    }

    
    public boolean update (SachDTO sach)
    {
        try{
            Connection con = MyConnection.getConnection();
            String queryUpdate = "UPDATE SACH" + "SET tenSach=?, giaSach=?, soluong=?, trangthai=?, idTacGia=?, idNhaXuatBan=?, idLoaiSach=?, idKho=? ";
            PreparedStatement ps = con.prepareStatement(queryUpdate);
           ps.setInt(1, sach.getId());
            ps.setString(2, sach.getTenSach());
            ps.setFloat(3, sach.getGiaSach());
            ps.setInt(4, sach.getSoluong());
            ps.setInt(5, sach.getTrangthai());
            ps.setInt(6, sach.getIdTacGia());
            ps.setInt(7, sach.getIdNhaXuatBan());
            ps.setInt(8, sach.getIdLoaiSach());
            ps.setInt(9, sach.getIdKho());
            int count= ps.executeUpdate();
            con.close();
            return count != 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int id) {
        try {
            Connection con = MyConnection.getConnection();
            String queryDelete = "DELETE FROM SACH WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(queryDelete);
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<SachDTO> findMany(int id, String timTenSach, String timLoaiSach) {
        ArrayList<SachDTO> listResult = null;
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = ""
                    + " SELECT * "
                    + " FROM SACH "
                    + " WHERE ";
            ArrayList<String> queries = new ArrayList<>();
            if (id != -1) {
                queries.add(String.format("id = %d \n", id));
            }
            if (!timTenSach.equalsIgnoreCase("")) {
                queries.add(String.format("tenSach LIKE '%%%s%%'\n", timTenSach));
            }
            if (!timLoaiSach.equalsIgnoreCase("")) {
                queries.add(String.format("tinhTrang = %d\n", timLoaiSach));
            }
            for (int i = 0; i < queries.size(); i++) {
                if (i + 1 < queries.size()) {
                    queryFind += queries.get(i) + "AND";
                } else {
                    queryFind += queries.get(i);
                }
            }
            System.out.println(queryFind);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryFind);
            listResult = new ArrayList<>();
            while (rs.next()) {
                SachDTO sachDTO = resutlSetSachDTO(rs);
                listResult.add(sachDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResult;
    }

    public ArrayList<LoaiSachDTO> findAllLoaiSach() {
        ArrayList<LoaiSachDTO> listResult = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String queryFindAllLoaiSach = "" +
                    "SELECT * \n" +
                    "FROM LOAI_SACH \n";
            PreparedStatement prest = con.prepareStatement(queryFindAllLoaiSach);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                listResult.add(new LoaiSachDTO(
                        rs.getInt("id"),
                        rs.getString("tenLoai")
                ));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResult;
    }
}
