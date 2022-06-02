/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAO.MyConnection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author pc
 */
public class NguoiDocDTO {

    private int id;
    private String sdt;
    private LocalDate ngaySinh;
    private String diaChi;
    private String hoTen;
    private String cmnd;
    private LocalDate hanSuDung;
    private int soLuongMuonChoPhep;
    private int trangThaiViPham;

    public NguoiDocDTO() {};

    public NguoiDocDTO(int id, String sdt, LocalDate ngaySinh, String diaChi, String hoTen, String cmnd, LocalDate hanSuDung, int soLuongMuonChoPhep, int trangThaiViPham) {
        this.id = id;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.hanSuDung = hanSuDung;
        this.soLuongMuonChoPhep = soLuongMuonChoPhep;
        this.trangThaiViPham = trangThaiViPham;
    }

    @Override
    public String toString() {
        return String.format(
                "%d,%s,%s,%s,%s,%s,%s,%d,%d",
                this.id, this.hoTen, this.sdt, this.ngaySinh, this.diaChi,
                this.cmnd, this.hanSuDung, this.soLuongMuonChoPhep, this.trangThaiViPham
        );
    }

    public boolean create(String []list) {
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            setId(Integer.parseInt(list[0]));
            setHoTen(list[1]);
            setSdt(list[2]);
            setNgaySinh(LocalDate.parse(list[3], dtf));
            setDiaChi(list[4]);
            setCmnd(list[5]);
            setHanSuDung(LocalDate.parse(list[6], dtf));
            setSoLuongMuonChoPhep(Integer.parseInt(list[7]));
            setTrangThaiViPham(Integer.parseInt(list[8]));
            return true;
        } catch (IndexOutOfBoundsException ignored) {}
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public int getSoLuongMuonChoPhep() {
        return soLuongMuonChoPhep;
    }

    public void setSoLuongMuonChoPhep(int soLuongMuonChoPhep) {
        this.soLuongMuonChoPhep = soLuongMuonChoPhep;
    }

    public int getTrangThaiViPham() {
        return trangThaiViPham;
    }

    public void setTrangThaiViPham(int trangThaiViPham) {
        this.trangThaiViPham = trangThaiViPham;
    }

}
