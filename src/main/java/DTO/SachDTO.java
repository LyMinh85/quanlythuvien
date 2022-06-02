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
public class SachDTO {
    int id;
    String tenSach;
    float giaSach;
    int soluong;
    int trangthai;
    int idTacGia;
    int idNhaXuatBan;
    int idLoaiSach;
    int idKho;

    public SachDTO() {
    }

    public SachDTO(int id, String tenSach, float giaSach, int soluong, int trangthai, int idTacGia, int idNhaXuatBan, int idLoaiSach, int idKho) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaSach = giaSach;
        this.soluong = soluong;
        this.trangthai = trangthai;
        this.idTacGia = idTacGia;
        this.idNhaXuatBan = idNhaXuatBan;
        this.idLoaiSach = idLoaiSach;
        this.idKho = idKho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public float getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(float giaSach) {
        this.giaSach = giaSach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }

    public int getIdNhaXuatBan() {
        return idNhaXuatBan;
    }

    public void setIdNhaXuatBan(int idNhaXuatBan) {
        this.idNhaXuatBan = idNhaXuatBan;
    }

    public int getIdLoaiSach() {
        return idLoaiSach;
    }

    public void setIdLoaiSach(int idLoaiSach) {
        this.idLoaiSach = idLoaiSach;
    }

    public int getIdKho() {
        return idKho;
    }

    public void setIdKho(int idKho) {
        this.idKho = idKho;
    }
    
}
