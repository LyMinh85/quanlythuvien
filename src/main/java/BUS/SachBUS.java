/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.SachDAO;
import DTO.LoaiSachDTO;
import DTO.SachDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SachBUS {
    private ArrayList<SachDTO> listSach;
    private SachDAO sachDAO = new SachDAO();
    
    public SachBUS()
    {
        SachDAO sachDAO = new SachDAO();
        listSach = new ArrayList<>();
    }
    
    public ArrayList<SachDTO> getListSach(){
        return listSach;
    }
    
    public void findAll(){
        listSach = sachDAO.findAll();
    }
    
    public SachDTO findone(int id){
        return sachDAO.findone(id);
    }
    
    public boolean insertone(SachDTO sach){
        return sachDAO.insertone(sach);
    }
    
    public boolean update (SachDTO sach){
        return sachDAO.update(sach);
    }
    
    public boolean delete(int id){
        return sachDAO.delete(id);
    }
    
    public void findMany (int id, String timTenSach, String timLoaiSach){
        listSach = sachDAO.findMany(id, timTenSach, timLoaiSach);
    }

    public ArrayList<LoaiSachDTO> findAllLoaiSach() {
        return sachDAO.findAllLoaiSach();
    }

}
