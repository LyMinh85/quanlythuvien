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
public class TacGiaDTO {
    int idTacGia;
    String hoTen;
    String ngaysinh;
    String diachi;

    public TacGiaDTO() {
    }

    public TacGiaDTO(int idTacGia, String hoTen, String ngaysinh, String diachi) {
        this.idTacGia = idTacGia;
        this.hoTen = hoTen;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
}
