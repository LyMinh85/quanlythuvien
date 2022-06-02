/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuMuonDTO {
    private int id_pm;
    private int id_ND;
    private Date Ngay_muon;
    private Date Ngay_Tra;
    private int id_nv;
    private ArrayList<CTPhieuMuonDTO> listCTPhieuMuon;
    
    public PhieuMuonDTO() {
        listCTPhieuMuon = new ArrayList<>();
    }

    public PhieuMuonDTO(int id_pm, int id_ND, Date ngay_muon, Date ngay_Tra, int id_nv) {
        this.id_pm = id_pm;
        this.id_ND = id_ND;
        Ngay_muon = ngay_muon;
        Ngay_Tra = ngay_Tra;
        this.id_nv = id_nv;
        listCTPhieuMuon = new ArrayList<>();
    }

    public ArrayList<CTPhieuMuonDTO> getListCTPhieuMuon() {
        return listCTPhieuMuon;
    }

    public void setListCTPhieuMuon(ArrayList<CTPhieuMuonDTO> listCTPhieuMuon) {
        this.listCTPhieuMuon = listCTPhieuMuon;
    }

    public int getId_pm() {
        return id_pm;
    }

    public void setId_pm(int id_pm) {
        this.id_pm = id_pm;
    }

    public int getId_ND() {
        return id_ND;
    }

    public void setId_ND(int id_ND) {
        this.id_ND = id_ND;
    }

    public Date getNgay_muon() {
        return Ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        Ngay_muon = ngay_muon;
    }

    public Date getNgay_Tra() {
        return Ngay_Tra;
    }

    public void setNgay_Tra(Date ngay_Tra) {
        Ngay_Tra = ngay_Tra;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }
}

