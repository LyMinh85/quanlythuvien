/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NguoiDocDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NhanVienBUS {
    private ArrayList<NhanVienDTO> listNhanVien;
    private NhanVienDAO nhanvienDAO = new NhanVienDAO();
    
    public NhanVienBUS(){
        listNhanVien =  new ArrayList<>();
    }
    
    public ArrayList<NhanVienDTO> getListNhanVien(){
        return listNhanVien;
    }
    
    public void findALl(){
        listNhanVien = nhanvienDAO.findAll();
    }
    
    public NhanVienDTO findOne(int id){
        return nhanvienDAO.findOne(id);
    }
    
    public void findMany(int id, String timHotenNV, int tinhtrangNV){
        listNhanVien = nhanvienDAO.findMany(id, timHotenNV, tinhtrangNV);
    }
    
    public boolean ThemNhanVien(NhanVienDTO nhanvienDTO){
        if (nhanvienDAO.findOne(nhanvienDTO.getID_NV()) == null) {
            return nhanvienDAO.ThemNhanVien(nhanvienDTO);
        }
        return false;
    }
    
    public boolean updateOne(NhanVienDTO nhanvienDTO) {
        return nhanvienDAO.updateOne(nhanvienDTO);
    }

    public boolean deleteOne(int id) {
        return nhanvienDAO.deleteOne(id);
    }
}
