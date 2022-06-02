/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class NhanVienDTO {
    private int id_NV;
    private String hoten_NV;
    private LocalDate ngaysinh_NV;
    private String diachi_NV;
    private String cmnd_nv;
    private int tinhtrang_NV;

    public NhanVienDTO(int ID_NV, String HoTen_NV, LocalDate NgaySinh_NV, String DiaChi_NV, String Cmnd_NV, int TinhTrang_NV) {
        this.id_NV = ID_NV;
        this.hoten_NV = HoTen_NV;
        this.ngaysinh_NV = NgaySinh_NV;
        this.diachi_NV = DiaChi_NV;
        this.cmnd_nv = Cmnd_NV;
        this.tinhtrang_NV = TinhTrang_NV;
    }

   
    
    public int getID_NV() {
        return id_NV;
    }

    public void setID_NV(int ID_NV) {
        this.id_NV = ID_NV;
    }

    public String getHoTen_NV() {
        return hoten_NV;
    }

    public void setHoTen_NV(String HoTen_NV) {
        this.hoten_NV = HoTen_NV;
    }

    public LocalDate getngaysinh_NV() {
        return ngaysinh_NV;
    }

    public void setNgaySinh_NV(LocalDate NgaySinh_NV) {
        this.ngaysinh_NV = NgaySinh_NV;
    }

    public String getDiaChi_NV() {
        return diachi_NV;
    }

    public void setDiaChi_NV(String DiaChi_NV) {
        this.diachi_NV = DiaChi_NV;
    }

    public String getCmnd_NV() {
        return cmnd_nv;
    }

    public void setCmnd_NV(String Cmnd_NV) {
        this.cmnd_nv = Cmnd_NV;
    }

    public int getTinhTrang_NV() {
        return tinhtrang_NV;
    }

    public void setTinhTrang_NV(int TinhTrang_NV) {
        this.tinhtrang_NV = TinhTrang_NV;
    }
    
}
