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
public class KhoDTO {
    int idKho;
    String tenKho;
    String vitri;

    public KhoDTO() {
    }

    public KhoDTO(int idKho, String tenKho, String vitri) {
        this.idKho = idKho;
        this.tenKho = tenKho;
        this.vitri = vitri;
    }

    public int getIdKho() {
        return idKho;
    }

    public void setIdKho(int idKho) {
        this.idKho = idKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }
    
}
