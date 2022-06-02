package DTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PhieuTraDTO {
    private int id;
    private int idNguoiDoc;
    private LocalDate ngayTraThatSu;
    private int tienPhat;
    private ArrayList<CTPhieuTraDTO> listCTPhieuTra;

    public PhieuTraDTO(int id, int idNguoiDoc, LocalDate ngayTraThatSu, int tienPhat) {
        this.id = id;
        this.idNguoiDoc = idNguoiDoc;
        this.ngayTraThatSu = ngayTraThatSu;
        this.tienPhat = tienPhat;
        listCTPhieuTra = new ArrayList<>();
    }

    public String toString() {
        return String.format("%d,%d,%s,%d", id, idNguoiDoc, ngayTraThatSu, tienPhat);
    }

    public ArrayList<CTPhieuTraDTO> getListCTPhieuTra() {
        return listCTPhieuTra;
    }

    public void setListCTPhieuTra(ArrayList<CTPhieuTraDTO> listCTPhieuTra) {
        this.listCTPhieuTra = listCTPhieuTra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNguoiDoc() {
        return idNguoiDoc;
    }

    public void setIdNguoiDoc(int idNguoiDoc) {
        this.idNguoiDoc = idNguoiDoc;
    }

    public LocalDate getNgayTraThatSu() {
        return ngayTraThatSu;
    }

    public void setNgayTraThatSu(LocalDate ngayTraThatSu) {
        this.ngayTraThatSu = ngayTraThatSu;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }
}
