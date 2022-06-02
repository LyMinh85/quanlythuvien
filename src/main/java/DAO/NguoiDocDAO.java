/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NguoiDocDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pc
 */
public class NguoiDocDAO {
    private NguoiDocDTO resultSetToNguoiDocDTO(ResultSet rs) {
        NguoiDocDTO nguoiDocDTO = null;
        try {
            nguoiDocDTO = new NguoiDocDTO(
                    rs.getInt("id"),
                    rs.getString("sdt"),
                    rs.getDate("ngaySinh").toLocalDate(),
                    rs.getString("diaChi"),
                    rs.getString("hoTen"),
                    rs.getString("cmnd"),
                    rs.getDate("hanSuDung").toLocalDate(),
                    rs.getInt("soLuongMuonChoPhep"),
                    rs.getInt("trangThaiViPham")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiDocDTO;
    }

    public boolean insertOne(NguoiDocDTO nguoiDoc) {
        Connection con = null;
        try {
            con = MyConnection.getConnection();
            String queryInsert = "INSERT INTO NGUOI_DOC VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Date ngaySinh = Date.valueOf(nguoiDoc.getNgaySinh());
            Date hanSuDung = Date.valueOf(nguoiDoc.getHanSuDung());

            PreparedStatement prest = con.prepareStatement(queryInsert);
            prest.setInt(1, nguoiDoc.getId());
            prest.setString(2, nguoiDoc.getSdt());
            prest.setDate(3, ngaySinh);
            prest.setString(4, nguoiDoc.getDiaChi());
            prest.setString(5, nguoiDoc.getHoTen());
            prest.setString(6, nguoiDoc.getCmnd());
            prest.setDate(7, hanSuDung);
            prest.setInt(8, nguoiDoc.getSoLuongMuonChoPhep());
            prest.setInt(9, nguoiDoc.getTrangThaiViPham());
            int count = prest.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int insertMany(ArrayList<NguoiDocDTO> listNguoiDoc) {
        try {
            Connection con = MyConnection.getConnection();
            String queryInsert = "INSERT INTO NGUOI_DOC VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prest = con.prepareStatement(queryInsert);
            AtomicInteger idNguoiDoc = new AtomicInteger(MyConnection.getLastRecordId("NGUOI_DOC") + 1);
            listNguoiDoc.forEach(nguoiDocDTO -> {
                Date ngaySinh = Date.valueOf(nguoiDocDTO.getNgaySinh());
                Date hanSuDung = Date.valueOf(nguoiDocDTO.getHanSuDung());
                try {
                    prest.setInt(1, idNguoiDoc.getAndIncrement());
                    prest.setString(2, nguoiDocDTO.getSdt());
                    prest.setDate(3, ngaySinh);
                    prest.setString(4, nguoiDocDTO.getDiaChi());
                    prest.setString(5, nguoiDocDTO.getHoTen());
                    prest.setString(6, nguoiDocDTO.getCmnd());
                    prest.setDate(7, hanSuDung);
                    prest.setInt(8, nguoiDocDTO.getSoLuongMuonChoPhep());
                    prest.setInt(9, nguoiDocDTO.getTrangThaiViPham());
                    prest.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            int[] arr = prest.executeBatch();
            con.close();
            int count = 0;
            for (int i : arr) {
                count += i;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<NguoiDocDTO> findAll() {
        ArrayList<NguoiDocDTO> listNguoiDoc = new ArrayList();
        try {
            Connection con = MyConnection.getConnection();
            Statement st = con.createStatement();
            String queryFindAll = "SELECT * FROM NGUOI_DOC";
            ResultSet rs = st.executeQuery(queryFindAll);
            while (rs.next()) {
                NguoiDocDTO nguoiDocDTO = new NguoiDocDTO(
                        rs.getInt("id"),
                        rs.getString("sdt"),
                        rs.getDate("ngaySinh").toLocalDate(),
                        rs.getString("diaChi"),
                        rs.getString("hoTen"),
                        rs.getString("cmnd"),
                        rs.getDate("hanSuDung").toLocalDate(),
                        rs.getInt("soLuongMuonChoPhep"),
                        rs.getInt("trangThaiViPham")
                );
                listNguoiDoc.add(nguoiDocDTO);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDoc;
    }

    public NguoiDocDTO findOne(int id) {
        NguoiDocDTO nguoiDocDTO = null;
        try {
            Connection con = MyConnection.getConnection();

            String queryFindOne = "SELECT * FROM NGUOI_DOC WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryFindOne);
            prest.setInt(1, id);
            ResultSet rs = prest.executeQuery();
            if (rs.next()) {
                nguoiDocDTO = resultSetToNguoiDocDTO(rs);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nguoiDocDTO;
    }

    public ArrayList<NguoiDocDTO> findMany(String hoTenTimKiem, boolean quaHanSuDung, int trangThai) {
        ArrayList<NguoiDocDTO> listResult = null;
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = "" +
                    "SELECT * " +
                    "FROM NGUOI_DOC " +
                    "WHERE ";
            ArrayList<String> queries = new ArrayList<>();
            if (!hoTenTimKiem.equalsIgnoreCase("")) {
                queries.add(String.format("hoTen LIKE '%%%s%%'\n", hoTenTimKiem));
            }
            if (quaHanSuDung) {
                queries.add("hanSuDung <= CAST( GETDATE() AS Date )\n");
            }
            if (trangThai != -1) {
                queries.add(String.format("trangThaiViPham = %d\n", trangThai));
            }
            for (int i = 0; i < queries.size(); i++) {
                if (i + 1 < queries.size()) {
                    queryFind += queries.get(i) + "AND ";
                } else {
                    queryFind += queries.get(i);
                }
            }
            System.out.println(queryFind);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryFind);
            listResult = new ArrayList<>();
            while (rs.next()) {
                NguoiDocDTO nguoiDocDTO = resultSetToNguoiDocDTO(rs);
                listResult.add(nguoiDocDTO);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResult;
    }

    public boolean updateOne(NguoiDocDTO nguoiDocDTO) {
        try {
            Connection con = MyConnection.getConnection();
            String queryUpdateOne =
                    "UPDATE NGUOI_DOC" +
                            " SET sdt=?, ngaySinh=?, diaChi=?, hoTen=?, cmnd=?, hanSuDung=?," +
                            " soLuongMuonChoPhep=?, trangThaiViPham=?" +
                            " WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryUpdateOne);
            Date ngaySinh = Date.valueOf(nguoiDocDTO.getNgaySinh());
            Date hanSuDung = Date.valueOf(nguoiDocDTO.getHanSuDung());
            prest.setString(1, nguoiDocDTO.getSdt());
            prest.setDate(2, ngaySinh);
            prest.setString(3, nguoiDocDTO.getDiaChi());
            prest.setString(4, nguoiDocDTO.getHoTen());
            prest.setString(5, nguoiDocDTO.getCmnd());
            prest.setDate(6, hanSuDung);
            prest.setInt(7, nguoiDocDTO.getSoLuongMuonChoPhep());
            prest.setInt(8, nguoiDocDTO.getTrangThaiViPham());
            prest.setInt(9, nguoiDocDTO.getId());
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
            String queryDeleteOne = "DELETE FROM NGUOI_DOC WHERE id = ?";
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

    public int deleteMany(ArrayList<Integer> arrayId) {
        Connection con = null;
        try {
            con = MyConnection.getConnection();
            String listValues = arrayId.
                    toString().
                    replaceAll("\\[", "(").
                    replaceAll("\\]", ")");
            String queryDeleteone = "DELETE FROM NGUOI_DOC\n" +
                                    "WHERE id IN " + listValues;
            try {
                PreparedStatement prest = con.prepareStatement(queryDeleteone);
                int count = prest.executeUpdate();
                return count;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        NguoiDocDAO nguoiDocDAO = new NguoiDocDAO();
        System.out.println(MyConnection.getLastRecordId("NGUOI_DOC"));
    }
}
