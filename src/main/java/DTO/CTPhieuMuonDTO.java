package DTO;

public class CTPhieuMuonDTO {
    private int idSach;
    private int idPhieuMuon;
    private int soLuong;

    public CTPhieuMuonDTO(int idSach, int idPhieuMuon, int soLuong) {
        this.idSach = idSach;
        this.idPhieuMuon = idPhieuMuon;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d", idSach, idPhieuMuon, soLuong);
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(int idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
