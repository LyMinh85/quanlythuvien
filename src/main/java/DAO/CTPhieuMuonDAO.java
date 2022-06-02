package DAO;

import DTO.CTPhieuMuonDTO;
import DTO.CTPhieuTraDTO;
import DTO.SachDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CTPhieuMuonDAO {
    final public static String TABLE_NAME = "CT_PHIEU_MUON";
    final public static String TABLE_COLUMNS = "idSach, idPhieuMuon, soLuong";

    public static CTPhieuMuonDTO resultSetToCTPhieuMuonDTO(ResultSet rs) throws SQLException {
        CTPhieuMuonDTO ctPhieuMuonDTO = new CTPhieuMuonDTO(
                rs.getInt("idSach"),
                rs.getInt("idPhieuMuon"),
                rs.getInt("soLuong")
        );
        return ctPhieuMuonDTO;
    }

    public static boolean insertOne(CTPhieuMuonDTO ctPhieuMuonDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryInsertOne = "" +
                "INSERT INTO " + TABLE_NAME + "\n" +
                "VALUES (?, ?, ?)";
        PreparedStatement prest = con.prepareStatement(queryInsertOne);
        prest.setInt(1, ctPhieuMuonDTO.getIdSach());
        prest.setInt(2, ctPhieuMuonDTO.getIdPhieuMuon());
        prest.setInt(3, ctPhieuMuonDTO.getSoLuong());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static ArrayList<CTPhieuMuonDTO> findAll() throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "SELECT * FROM " + TABLE_NAME;
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        ResultSet rs = prest.executeQuery();
        ArrayList<CTPhieuMuonDTO> listCTPhieuMuon = new ArrayList<>();
        while(rs.next()) {
            CTPhieuMuonDTO ctPhieuMuonDTO = resultSetToCTPhieuMuonDTO(rs);
            listCTPhieuMuon.add(ctPhieuMuonDTO);
        }
        rs.close();
        con.close();
        return listCTPhieuMuon;
    }

    public static ArrayList<CTPhieuMuonDTO> findMany(int idPhieuMuon) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "" +
                "SELECT * FROM " + TABLE_NAME + "\n" +
                "WHERE idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        prest.setInt(1, idPhieuMuon);
        ResultSet rs = prest.executeQuery();
        ArrayList<CTPhieuMuonDTO> listCTPhieuMuon = new ArrayList<>();
        while(rs.next()) {
            CTPhieuMuonDTO ctPhieuMuonDTO = resultSetToCTPhieuMuonDTO(rs);
            listCTPhieuMuon.add(ctPhieuMuonDTO);
        }
        rs.close();
        con.close();
        return listCTPhieuMuon;
    }

    public static Map<CTPhieuMuonDTO, SachDTO> findManyJoinSach(int idPhieuMuon) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "" +
                "SELECT idSach, idPhieuMuon, CT_PHIEU_MUON.soLuong as soLuongMuon, id, tenSach, giaSach, S.soLuong as soLuongSach, trangThai, idTacGia, idNhaXuatBan, idLoaiSach, idKho \n" +
                "FROM " + TABLE_NAME + "\n" +
                "INNER JOIN SACH S on CT_PHIEU_MUON.idSach = S.id \n" +
                "WHERE idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        prest.setInt(1, idPhieuMuon);
        ResultSet rs = prest.executeQuery();
        Map<CTPhieuMuonDTO, SachDTO> listCTPhieuMuonVaSach = new HashMap<>();
        while(rs.next()) {
            CTPhieuMuonDTO ctPhieuMuonDTO = new CTPhieuMuonDTO(
                    rs.getInt("idSach"),
                    rs.getInt("idPhieuMuon"),
                    rs.getInt(  "soLuongMuon")
            );
            SachDTO sachDTO = new SachDTO(
                    rs.getInt("id"),
                    rs.getString("tenSach"),
                    rs.getInt("giaSach"),
                    rs.getInt("soLuongSach"),
                    rs.getInt("trangThai"),
                    rs.getInt("idTacGia"),
                    rs.getInt("idNhaXuatBan"),
                    rs.getInt("idLoaiSach"),
                    rs.getInt("idKho")
            );
            listCTPhieuMuonVaSach.put(ctPhieuMuonDTO, sachDTO);
        }
        rs.close();
        con.close();
        return listCTPhieuMuonVaSach;
    }

    public static CTPhieuMuonDTO findOne(int idSach, int idPhieuMuon) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindOne = "" +
                "SELECT * FROM " + TABLE_NAME + "\n" +
                "WHERE idSach = ? and idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryFindOne);
        prest.setInt(1, idSach);
        prest.setInt(2, idPhieuMuon);
        ResultSet rs = prest.executeQuery();
        CTPhieuMuonDTO ctPhieuMuonDTOt = null;
        if (rs.next()) {
            ctPhieuMuonDTOt = resultSetToCTPhieuMuonDTO(rs);
        }
        rs.close();
        con.close();
        return ctPhieuMuonDTOt;
    }

    public static boolean updateOne(CTPhieuMuonDTO ctPhieuMuonDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryUpdate = "" +
                "UPDATE " + TABLE_NAME + "\n" +
                "SET soLuong = ?\n" +
                "WHERE idSach = ? and idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryUpdate);
        prest.setInt(1, ctPhieuMuonDTO.getSoLuong());
        prest.setInt(2, ctPhieuMuonDTO.getIdSach());
        prest.setInt(3, ctPhieuMuonDTO.getIdPhieuMuon());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static boolean deleteOne(int idSach, int idPhieuMuon) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryDeleteOne = "" +
                "DELETE FROM " + TABLE_NAME + "\n" +
                "WHERE idSach = ? and idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryDeleteOne);
        prest.setInt(1, idSach);
        prest.setInt(2, idPhieuMuon);
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static int deleteMany(int idPhieuMuon) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryDeleteOne = "" +
                "DELETE FROM " + TABLE_NAME + "\n" +
                "WHERE idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryDeleteOne);
        prest.setInt(1, idPhieuMuon);
        int count = prest.executeUpdate();
        con.close();
        return count;
    }
}
