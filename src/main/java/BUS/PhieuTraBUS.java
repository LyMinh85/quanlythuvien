package BUS;

import DAO.PhieuTraDAO;
import DTO.PhieuTraDTO;

import java.sql.Date;
import java.util.ArrayList;

public class PhieuTraBUS {
    ArrayList<PhieuTraDTO> listPhieuTra;
    public PhieuTraBUS() {
        listPhieuTra = new ArrayList<>();
    }

    public ArrayList<PhieuTraDTO> getListPhieuTra() {
        return listPhieuTra;
    }

    public boolean insertOne(PhieuTraDTO phieuTraDTO) {
        try {
            return PhieuTraDAO.insertOne(phieuTraDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<PhieuTraDTO> findAll() {
        try {
            return PhieuTraDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PhieuTraDTO> findMany(int id, int idNguoiDoc, java.util.Date ngayTraFrom, java.util.Date ngayTraTo, int tienPhatFrom, int tienPhatTo) {
        try {
            return PhieuTraDAO.findMany(id, idNguoiDoc, ngayTraFrom, ngayTraTo, tienPhatFrom, tienPhatTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PhieuTraDTO findOne(int id) {
        try {
            return PhieuTraDAO.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOne(PhieuTraDTO phieuTraDTO) {
        try {
            return PhieuTraDAO.updateOne(phieuTraDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int id) {
        try {
            return PhieuTraDAO.deleteOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
