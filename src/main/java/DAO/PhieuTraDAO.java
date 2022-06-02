package DAO;

import DTO.PhieuTraDTO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PhieuTraDAO {
    final public static String TABLE_NAME = "PHIEU_TRA";
    final public static String TABLE_COLUMNS = "id, idNguoiDoc, ngayTraThatSu, tienPhat";

    public static PhieuTraDTO resultSetToPhieuTraDTO(ResultSet rs) throws SQLException {
        PhieuTraDTO phieuTraDTO = new PhieuTraDTO(
                rs.getInt(1),
                rs.getInt(2),
                rs.getDate(3).toLocalDate(),
                rs.getInt(4)
        );
        return phieuTraDTO;
    }

    public static boolean insertOne(PhieuTraDTO phieuTraDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryInsertOne = "" +
                "INSERT INTO " + TABLE_NAME + "\n" +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement prest = con.prepareStatement(queryInsertOne);
        prest.setInt(1, phieuTraDTO.getId());
        prest.setInt(2, phieuTraDTO.getIdNguoiDoc());
        prest.setDate(3, Date.valueOf(phieuTraDTO.getNgayTraThatSu()));
        prest.setInt(4, phieuTraDTO.getTienPhat());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static ArrayList<PhieuTraDTO> findAll() throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "SELECT * FROM " + TABLE_NAME;
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        ResultSet rs = prest.executeQuery();
        ArrayList<PhieuTraDTO> listPhieuTra = new ArrayList<>();
        while (rs.next()) {
            listPhieuTra.add(resultSetToPhieuTraDTO(rs));
        }
        con.close();
        return listPhieuTra;
    }

    public static ArrayList<PhieuTraDTO> findMany(int id, int idNguoiDoc, java.util.Date ngayTraFrom, java.util.Date ngayTraTo, int tienPhatFrom, int tienPhatTo) throws Exception {
        ArrayList<PhieuTraDTO> listPhieuTra = new ArrayList<>();
        Connection con = MyConnection.getConnection();
        String queryFindMany = "" +
                "SELECT * " +
                "FROM " + TABLE_NAME + "\n" +
                "WHERE ";
        ArrayList<String> queries = new ArrayList<>();
        if (id != -1) {
            queries.add(String.format("id = %d \n", id));
        }
        if (idNguoiDoc != -1) {
            queries.add(String.format("idNguoiDoc = %d \n", idNguoiDoc));
        }
        if (ngayTraFrom != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTraThatSuFrom = sdf.format(ngayTraFrom);
            queries.add(String.format("ngayTraThatSu >= '%s' \n", ngayTraThatSuFrom));
        }
        if (ngayTraTo != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTraThatSuTo = sdf.format(ngayTraTo);
            queries.add(String.format("ngayTraThatSu <= '%s' \n", ngayTraThatSuTo));
        }
        if (tienPhatFrom != -1) {
            queries.add(String.format("tienPhat >= %d \n", tienPhatFrom));
        }

        if (tienPhatTo != -1) {
            queries.add(String.format("tienPhat <= %d \n", tienPhatTo));
        }

        for (int i = 0; i < queries.size(); i++) {
            if (i + 1 < queries.size()) {
                queryFindMany += queries.get(i) + "AND ";
            } else {
                queryFindMany += queries.get(i);
            }
        }
        System.out.println(queryFindMany);
        PreparedStatement prest = con.prepareStatement(queryFindMany);
        ResultSet rs = prest.executeQuery();
        while (rs.next()) {
            listPhieuTra.add(resultSetToPhieuTraDTO(rs));
        }
        return listPhieuTra;
    }

    public static PhieuTraDTO findOne(int id) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindOne = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(queryFindOne);
        prest.setInt(1, id);
        ResultSet rs = prest.executeQuery();
        if (rs.next()) {
            PhieuTraDTO phieuTraDTO = resultSetToPhieuTraDTO(rs);
            return phieuTraDTO;
        }
        rs.close();
        con.close();
        return null;
    }

    public static boolean updateOne(PhieuTraDTO phieuTraDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryUpdateOne = "" +
                "UPDATE " + TABLE_NAME + "\n" +
                "SET idNguoiDoc = ?, ngayTraThatSu = ?, tienPhat = ? \n" +
                "WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(queryUpdateOne);
        prest.setInt(1, phieuTraDTO.getIdNguoiDoc());
        prest.setDate(2, Date.valueOf(phieuTraDTO.getNgayTraThatSu()));
        prest.setInt(3, phieuTraDTO.getTienPhat());
        prest.setInt(4, phieuTraDTO.getId());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static boolean deleteOne(int id) throws Exception {
        Connection con = MyConnection.getConnection();
        String querydeleteOne = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(querydeleteOne);
        prest.setInt(1, id);
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }
}
