/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom23.quanlytiennuoc.model;

/**
 *
 * @author Admin
 */
public class BienLai {
    String MaBL;
    String MaCT;
    String MaTK;
    int ChiSoMoi;
    int ChiSoCu;
    int TongTien;
    String NgayLap;

    public BienLai() {
    }

    public BienLai(String MaBL, String MaCT, String MaTK, int ChiSoMoi, int ChiSoCu, int TongTien, String NgayLap) {
        this.MaBL = MaBL;
        this.MaCT = MaCT;
        this.MaTK = MaTK;
        this.ChiSoMoi = ChiSoMoi;
        this.ChiSoCu = ChiSoCu;
        this.TongTien = TongTien;
        this.NgayLap = NgayLap;
    }

    public String getMaBL() {
        return MaBL;
    }

    public void setMaBL(String MaBL) {
        this.MaBL = MaBL;
    }

    public String getMaCT() {
        return MaCT;
    }

    public void setMaCT(String MaCT) {
        this.MaCT = MaCT;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public int getChiSoMoi() {
        return ChiSoMoi;
    }

    public void setChiSoMoi(int ChiSoMoi) {
        this.ChiSoMoi = ChiSoMoi;
    }

    public int getChiSoCu() {
        return ChiSoCu;
    }

    public void setChiSoCu(int ChiSoCu) {
        this.ChiSoCu = ChiSoCu;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }
    
    
    
}
