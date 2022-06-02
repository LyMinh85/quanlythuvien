package BUS;

import DAO.CTPhieuTraDAO;
import DTO.CTPhieuTraDTO;
import DTO.SachDTO;

import java.util.ArrayList;
import java.util.Map;

public class CTPhieuTraBUS {
    ArrayList<CTPhieuTraDTO> listCTPhieuTra;
    public CTPhieuTraBUS() {
        listCTPhieuTra = new ArrayList<>();
    }

    public boolean insertOne(CTPhieuTraDTO ctPhieuTraDTO) {
        try {
            return CTPhieuTraDAO.insertOne(ctPhieuTraDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<CTPhieuTraDTO> findAll() {
        try {
            return CTPhieuTraDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CTPhieuTraDTO> findMany(int idPhieuTra) {
        try {
            return CTPhieuTraDAO.findMany(idPhieuTra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<CTPhieuTraDTO, SachDTO> findManyJoinSach(int idPhieuTra) {
        try {
            return CTPhieuTraDAO.findManyJoinSach(idPhieuTra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CTPhieuTraDTO findOne(int idSach, int idPhieuTra) {
        try {
            return CTPhieuTraDAO.findOne(idSach, idPhieuTra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOne(CTPhieuTraDTO ctPhieuTraDTO) {
        try {
            return CTPhieuTraDAO.updateOne(ctPhieuTraDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int idSach, int idPhieuTra) {
        try {
            return CTPhieuTraDAO.deleteOne(idSach, idPhieuTra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int deleteMany(int idPhieuTra) {
        try {
            return CTPhieuTraDAO.deleteMany(idPhieuTra);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
