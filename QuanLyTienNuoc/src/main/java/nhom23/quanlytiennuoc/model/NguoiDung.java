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
public class NguoiDung {
    private String MaTK;
    private String TenTaiKhoan;
    private String MatKhau;
    private String QuyenTaiKhoan;
    private String TenHienThi;
    private int MaQuyenTaiKhoan;
    
    public NguoiDung() {
    }
    
    public NguoiDung(String TenTaiKhoan,String MatKhau,String QuyenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.QuyenTaiKhoan = QuyenTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getQuyenTaiKhoan() {
        return QuyenTaiKhoan;
    }

    public void setQuyenTaiKhoan(String QuyenTaiKhoan) {
        this.QuyenTaiKhoan = QuyenTaiKhoan;
    }

    public String getTenHienThi() {
        return TenHienThi;
    }

    public void setTenHienThi(String TenHienThi) {
        this.TenHienThi = TenHienThi;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public int getMaQuyenTaiKhoan() {
        return MaQuyenTaiKhoan;
    }

    public void setMaQuyenTaiKhoan(int MaQuyenTaiKhoan) {
        this.MaQuyenTaiKhoan = MaQuyenTaiKhoan;
    }
    
    @Override
    public String toString() {
        if(getTenHienThi() == null)
            return getTenTaiKhoan();
        return getTenHienThi();
    } 
}
