package DAO;

import BUS.CTPhieuTraBUS;
import BUS.PhieuTraBUS;
import DTO.CTPhieuMuonDTO;
import DTO.CTPhieuTraDTO;
import DTO.PhieuTraDTO;
import DTO.SachDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CTPhieuTraDAO {
    final public static String TABLE_NAME = "CT_PHIEU_TRA";

    public static CTPhieuTraDTO resultSetToCTPhieuTraDTO(ResultSet rs) throws SQLException {
        CTPhieuTraDTO ctPhieuTraDTO = new CTPhieuTraDTO(
                rs.getInt("idSach"),
                rs.getInt("idPhieuTra"),
                rs.getInt("soLuong"),
                rs.getInt("trangThaiSach")
        );
        return ctPhieuTraDTO;
    }

    public static boolean insertOne(CTPhieuTraDTO ctPhieuTraDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryInsertOne = "" +
                "INSERT INTO " + TABLE_NAME + "\n" +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement prest = con.prepareStatement(queryInsertOne);
        prest.setInt(1, ctPhieuTraDTO.getIdSach());
        prest.setInt(2, ctPhieuTraDTO.getIdPhieuTra());
        prest.setInt(3, ctPhieuTraDTO.getSoLuong());
        prest.setInt(4, ctPhieuTraDTO.getTrangThaiSach());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static ArrayList<CTPhieuTraDTO> findAll() throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "SELECT * FROM " + TABLE_NAME;
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        ResultSet rs = prest.executeQuery();
        ArrayList<CTPhieuTraDTO> listCTPhieuTra = new ArrayList<>();
        while(rs.next()) {
            CTPhieuTraDTO ctPhieuTraDTO = resultSetToCTPhieuTraDTO(rs);
            listCTPhieuTra.add(ctPhieuTraDTO);
        }
        rs.close();
        con.close();
        return listCTPhieuTra;
    }

    public static ArrayList<CTPhieuTraDTO> findMany(int idPhieuTra) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "" +
                "SELECT * FROM " + TABLE_NAME + "\n" +
                "WHERE idPhieuTra = ?";
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        prest.setInt(1, idPhieuTra);
        ResultSet rs = prest.executeQuery();
        ArrayList<CTPhieuTraDTO> listCTPhieuTra = new ArrayList<>();
        while(rs.next()) {
            CTPhieuTraDTO ctPhieuTraDTO = resultSetToCTPhieuTraDTO(rs);
            listCTPhieuTra.add(ctPhieuTraDTO);
        }
        rs.close();
        con.close();
        return listCTPhieuTra;
    }

    public static Map<CTPhieuTraDTO, SachDTO> findManyJoinSach(int idPhieuTra) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "" +
                "SELECT idSach, idPhieuTra, CT_PHIEU_TRA.soLuong as soLuongTra, trangThaiSach, id, tenSach, giaSach, S.soLuong as soLuongSach, trangThai, idTacGia, idNhaXuatBan, idLoaiSach, idKho \n" +
                "FROM " + TABLE_NAME + "\n" +
                "INNER JOIN SACH S on CT_PHIEU_TRA.idSach = S.id \n" +
                "WHERE idPhieuTra = ?";
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        prest.setInt(1, idPhieuTra);
        ResultSet rs = prest.executeQuery();
        Map<CTPhieuTraDTO, SachDTO> listCTPhieuTraVaSach = new HashMap<>();
        while(rs.next()) {
            CTPhieuTraDTO ctPhieuTraDTO = new CTPhieuTraDTO(
                    rs.getInt("idSach"),
                    rs.getInt("idPhieuTra"),
                    rs.getInt(  "soLuongTra"),
                    rs.getInt("trangThaiSach")
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
            listCTPhieuTraVaSach.put(ctPhieuTraDTO, sachDTO);
        }
        rs.close();
        con.close();
        return listCTPhieuTraVaSach;
    }

    public static CTPhieuTraDTO findOne(int idSach, int idPhieuTra) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindOne = "" +
                "SELECT * FROM " + TABLE_NAME + "\n" +
                "WHERE idSach = ? and idPhieuTra = ?";
        PreparedStatement prest = con.prepareStatement(queryFindOne);
        prest.setInt(1, idSach);
        prest.setInt(2, idPhieuTra);
        ResultSet rs = prest.executeQuery();
        CTPhieuTraDTO ctPhieuTraDTO = null;
        if (rs.next()) {
            ctPhieuTraDTO = resultSetToCTPhieuTraDTO(rs);
        }
        rs.close();
        con.close();
        return ctPhieuTraDTO;
    }

    public static boolean updateOne(CTPhieuTraDTO ctPhieuTraDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryUpdate = "" +
                "UPDATE " + TABLE_NAME + "\n" +
                "SET soLuong = ?, trangThaiSach = ?\n" +
                "WHERE idSach = ? and idPhieuTra = ?";
        PreparedStatement prest = con.prepareStatement(queryUpdate);
        prest.setInt(1, ctPhieuTraDTO.getSoLuong());
        prest.setInt(2, ctPhieuTraDTO.getTrangThaiSach());
        prest.setInt(3, ctPhieuTraDTO.getIdSach());
        prest.setInt(4, ctPhieuTraDTO.getIdPhieuTra());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static boolean deleteOne(int idSach, int idPhieuTra) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryDeleteOne = "" +
                "DELETE FROM " + TABLE_NAME + "\n" +
                "WHERE idSach = ? and idPhieuTra = ?";
        PreparedStatement prest = con.prepareStatement(queryDeleteOne);
        prest.setInt(1, idSach);
        prest.setInt(2, idPhieuTra);
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }


    public static int deleteMany(int idPhieuTra) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryDeleteOne = "" +
                "DELETE FROM " + TABLE_NAME + "\n" +
                "WHERE idPhieuTra = ?";
        PreparedStatement prest = con.prepareStatement(queryDeleteOne);
        prest.setInt(1, idPhieuTra);
        int count = prest.executeUpdate();
        con.close();
        return count;
    }
}
