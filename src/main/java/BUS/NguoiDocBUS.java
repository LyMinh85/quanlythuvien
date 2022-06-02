/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NguoiDocDAO;
import DTO.NguoiDocDTO;

import java.util.ArrayList;

/**
 * @author pc
 */
public class NguoiDocBUS {
    private ArrayList<NguoiDocDTO> listNguoiDoc;
    private NguoiDocDAO nguoiDocDAO = new NguoiDocDAO();

    public NguoiDocBUS() {
        listNguoiDoc = new ArrayList<>();
    }

    public ArrayList<NguoiDocDTO> getListNguoiDoc() {
        return listNguoiDoc;
    }

    public void findAll() {
        listNguoiDoc = nguoiDocDAO.findAll();
    }

    public NguoiDocDTO findOne(int id) {
        return nguoiDocDAO.findOne(id);
    }

    public void findMany(String hoTenTimKiem, boolean quaHanSuDung, int trangThai) {
        listNguoiDoc = nguoiDocDAO.findMany(hoTenTimKiem, quaHanSuDung, trangThai);
    }

    public boolean insertOne(NguoiDocDTO nguoiDocDTO) {
        return nguoiDocDAO.insertOne(nguoiDocDTO);
    }

    public int insertMany(ArrayList<NguoiDocDTO> listNguoiDoc) {
        return nguoiDocDAO.insertMany(listNguoiDoc);
    }

    public boolean updateOne(NguoiDocDTO nguoiDocDTO) {
        return nguoiDocDAO.updateOne(nguoiDocDTO);
    }

    public boolean deleteOne(int id) {
        return nguoiDocDAO.deleteOne(id);
    }

    public int deleteMany(ArrayList<Integer> arrayId) {
        return nguoiDocDAO.deleteMany(arrayId);
    }
}
