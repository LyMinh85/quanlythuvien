package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

public class TaiKhoanBUS {
    public TaiKhoanBUS() {
    }
    public boolean themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        return TaiKhoanDAO.themTaiKhoan(taiKhoanDTO);
    }
    public boolean checkTaiKhoan(int id, String matKhau) {
        return TaiKhoanDAO.checkTaiKhoan(id, matKhau);
    }
}
