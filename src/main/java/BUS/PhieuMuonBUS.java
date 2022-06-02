package BUS;

import DAO.PhieuMuonDAO;
import DTO.PhieuMuonDTO;

import java.util.ArrayList;

public class PhieuMuonBUS {
    public boolean insertOne(PhieuMuonDTO phieuMuonDTO) {
        try {
            return PhieuMuonDAO.insertOne(phieuMuonDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<PhieuMuonDTO> findAll() {
        try {
            return PhieuMuonDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PhieuMuonDTO findOne(int id) {
        try {
            return PhieuMuonDAO.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOne(PhieuMuonDTO phieuMuonDTO) {
        try {
            return PhieuMuonDAO.updateOne(phieuMuonDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int id) {
        try {
            return PhieuMuonDAO.deleteOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
