/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class LoaiSachDTO {
    int idLoaiSach;
    String tenLoai;

    public LoaiSachDTO() {
    }

    public LoaiSachDTO(int idLoaiSach, String tenLoai) {
        this.idLoaiSach = idLoaiSach;
        this.tenLoai = tenLoai;
    }

    public int getIdLoaiSach() {
        return idLoaiSach;
    }

    public void setIdLoaiSach(int idLoaiSach) {
        this.idLoaiSach = idLoaiSach;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}
