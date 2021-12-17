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
public class QuyenTaiKhoan {
    private int MaQTK;
    private  String TenQuyen;

    public QuyenTaiKhoan() {
    }

    public QuyenTaiKhoan(int MaQTK, String TenQuyen) {
        this.MaQTK = MaQTK;
        this.TenQuyen = TenQuyen;
    }

    public int getMaQTK() {
        return MaQTK;
    }

    public void setMaQTK(int MaQTK) {
        this.MaQTK = MaQTK;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }
    
    @Override
    public String toString() {
        return getTenQuyen();
    } 
}
