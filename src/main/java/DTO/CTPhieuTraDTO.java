package DTO;

public class CTPhieuTraDTO {
    private int idSach;
    private int idPhieuTra;
    private int soLuong;
    private int trangThaiSach;

    public CTPhieuTraDTO(int idSach, int idPhieuTra, int soLuong, int trangThaiSach) {
        this.idSach = idSach;
        this.idPhieuTra = idPhieuTra;
        this.soLuong = soLuong;
        this.trangThaiSach = trangThaiSach;
    }

    public String toString() {
        return String.format("%d,%d,%d,%d", idSach, idPhieuTra, soLuong, trangThaiSach);
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdPhieuTra() {
        return idPhieuTra;
    }

    public void setIdPhieuTra(int idPhieuTra) {
        this.idPhieuTra = idPhieuTra;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThaiSach() {
        return trangThaiSach;
    }

    public void setTrangThaiSach(int trangThaiSach) {
        this.trangThaiSach = trangThaiSach;
    }
}
