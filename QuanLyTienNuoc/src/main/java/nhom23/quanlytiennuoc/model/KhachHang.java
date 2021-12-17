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
public class KhachHang {
    private String MaCT;
    private String HoTen;
    private String SoNha;
    private String SoDienThoai;

    public KhachHang() {
    }

    public KhachHang(String MaCT, String HoTen, String SoNha, String SoDienThoai) {
        this.MaCT = MaCT;
        this.HoTen = HoTen;
        this.SoNha = SoNha;
        this.SoDienThoai = SoDienThoai;
    }

    public String getMaCT() {
        return MaCT;
    }

    public void setMaCT(String MaCT) {
        this.MaCT = MaCT;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSoNha() {
        return SoNha;
    }

    public void setSoNha(String SoNha) {
        this.SoNha = SoNha;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    
    @Override
    public String toString() {
        return getMaCT();
    } 
}
