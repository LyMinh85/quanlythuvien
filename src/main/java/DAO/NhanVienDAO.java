/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {

    private NhanVienDTO resultSetToNhanVienDTO(ResultSet rs) {
        NhanVienDTO nhanvienDTO = null;
        try {
            nhanvienDTO = new NhanVienDTO(
                    rs.getInt("id"),
                    rs.getString("hoTen"),
                    rs.getDate("ngaySinh").toLocalDate(),
                    rs.getString("diaChi"),
                    rs.getString("cmnd"),
                    rs.getInt("tinhTrang")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvienDTO;
    }

    public boolean ThemNhanVien(NhanVienDTO nhanVien) {
        try {
            Connection con = Connect.getConnection();
            String queryInsert = "INSERT INTO NHAN_VIEN VALUES(?,?,?,?,?,?)";
            try {
                Date ngaySinh = Date.valueOf(nhanVien.getngaysinh_NV());

                PreparedStatement prest = con.prepareStatement(queryInsert);
                prest.setInt(1, nhanVien.getID_NV());
                prest.setString(2, nhanVien.getHoTen_NV());
                prest.setDate(3, ngaySinh);
                prest.setString(4, nhanVien.getDiaChi_NV());
                prest.setString(5, nhanVien.getCmnd_NV());
                prest.setInt(6, nhanVien.getTinhTrang_NV());
                prest.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e);
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            System.out.print(e);

        }
        return false;
    }

    public ArrayList<NhanVienDTO> findAll() {
        ArrayList<NhanVienDTO> listNhanVien = new ArrayList();
        try {
            Connection con = MyConnection.getConnection();
            Statement st = con.createStatement();
            String queryFindAll = "SELECT * FROM NHAN_VIEN";
            ResultSet rs = st.executeQuery(queryFindAll);
            while (rs.next()) {
                NhanVienDTO nhanvienDTO = new NhanVienDTO(
                        rs.getInt("id"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh").toLocalDate(),
                        rs.getString("diaChi"),
                        rs.getString("cmnd"),
                        rs.getInt("tinhTrang")
                );
                listNhanVien.add(nhanvienDTO);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public NhanVienDTO findOne(int id_NV) {
        NhanVienDTO nhanvienDTO = null;
        try {
            Connection con = MyConnection.getConnection();

            String queryFindOne = "SELECT * FROM NHAN_VIEN WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryFindOne);
            prest.setInt(1, id_NV);
            ResultSet rs = prest.executeQuery();
            if (rs.next()) {
                nhanvienDTO = resultSetToNhanVienDTO(rs);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanvienDTO;
    }

    public ArrayList<NhanVienDTO> findMany(int id, String timHotenNV, int tinhtrangNV) {
        ArrayList<NhanVienDTO> listResult = null;
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = ""
                    + " SELECT * "
                    + " FROM NHAN_VIEN "
                    + " WHERE ";
            ArrayList<String> queries = new ArrayList<>();
            if (id != -1) {
                queries.add(String.format("id = %d \n", id));
            }
            if (!timHotenNV.equalsIgnoreCase("")) {
                queries.add(String.format("hoten LIKE '%%%s%%'\n", timHotenNV));
            }
            if (tinhtrangNV != -1) {
                queries.add(String.format("tinhTrang = %d\n", tinhtrangNV));
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
                NhanVienDTO nhanvienDTO = resultSetToNhanVienDTO(rs);
                listResult.add(nhanvienDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResult;
    }

    public boolean updateOne(NhanVienDTO nhanvienDTO) {
        try {
            Connection con = MyConnection.getConnection();
            String queryUpdateOne
                    = " UPDATE NHAN_VIEN"
                    + " SET hoTen=?, ngaySinh=?, diaChi=?, cmnd=?,tinhTrang=?"
                    + " WHERE id=?";
            PreparedStatement prest = con.prepareStatement(queryUpdateOne);
            Date ngaySinh = Date.valueOf(nhanvienDTO.getngaysinh_NV());
            prest.setString(1, nhanvienDTO.getHoTen_NV());
            prest.setDate(2, ngaySinh);
            prest.setString(3, nhanvienDTO.getDiaChi_NV());
            prest.setString(4, nhanvienDTO.getCmnd_NV());
            prest.setInt(5, nhanvienDTO.getTinhTrang_NV());
            prest.setInt(6,nhanvienDTO.getID_NV());
            int count = prest.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int id) {
        try {
            Connection con = MyConnection.getConnection();
            String queryDeleteOne = "DELETE FROM NHAN_VIEN WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryDeleteOne);
            prest.setInt(1, id);
            int count = prest.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        NhanVienDAO dao = new NhanVienDAO();
        NhanVienDTO nv1 = new NhanVienDTO(10, "Ngoc Huynh Nam", LocalDate.of(2002, 12, 16), "Ha noi", "2226666", 1);
//        boolean result = dao.ThemNhanVien(nv1);
//        NhanVienDTO nv2 = new NhanVienDTO(12,"Minh ", LocalDate.of(2002,10,1),"Ho Chi Minh","12226666",1 );
//        result =  dao.ThemNhanVien(nv2);
//        System.out.println(result);
        ArrayList<NhanVienDTO> arr = dao.findAll();
        for (int i = 0; i < arr.size(); i++) {
            String hoTen = arr.get(i).getHoTen_NV();
            System.out.println(hoTen);
        }
//        

//          NhanVienDTO timone = dao.findOne(10);
//          System.out.println(timone.getHoTen_NV()+timone.getID_NV());
//          ArrayList<NhanVienDTO> arr = dao.findMany("Minh", -1);
//          for (int i = 0 ; i < arr.size() ; i++){
//              System.out.println(arr.get(i).getID_NV()+arr.get(i).getHoTen_NV());
//          }
//        boolean thaydoi = dao.updateOne(nv1);
//        
        boolean xoa = dao.deleteOne(10);
        
        System.out.println("\nSau khi sua");
        arr = dao.findAll();
        for (int i = 0; i < arr.size(); i++) {
            String hoTen = arr.get(i).getHoTen_NV();
            System.out.println(hoTen);
        }
        
    }
}
