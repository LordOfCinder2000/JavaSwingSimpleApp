/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom23.quanlytiennuoc.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import nhom23.quanlytiennuoc.helpers.DataBaseHelper;
import nhom23.quanlytiennuoc.model.KhachHang;

/**
 *
 * @author Admin
 */
public class KhachHangDao {
    public static List<KhachHang> getTable()
    {
        String sql = "SELECT * FROM khachhang";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while(rs.next())
            {
                KhachHang kh = createKhachhang(rs);
                list.add(kh);
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }

    private static KhachHang createKhachhang(ResultSet rs) throws SQLException {
        KhachHang kh = new KhachHang();
        kh.setMaCT(rs.getString(1));
        kh.setHoTen(rs.getString(2));
        kh.setSoNha(rs.getString(3));
        kh.setSoDienThoai(rs.getString(4));
        return kh;
    }
    
    public static KhachHang findByID(String id)
    {
        String sql = "SELECT * FROM khachhang" + " WHERE MaCT = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                KhachHang kh = createKhachhang(rs);           
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Boolean Insert(KhachHang kh)
    {
        String sql = "INSERT INTO KhachHang (MaCT,HoTen,SoNha,SoDienThoai)" + "VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, kh.getMaCT());
            pstmt.setString(2, kh.getHoTen());
            pstmt.setString(3, kh.getSoNha());
            pstmt.setString(4, kh.getSoDienThoai());
            
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static Boolean Update(KhachHang kh)
    {
        String sql = "UPDATE khachhang" + " SET HoTen = ?, SoNha = ?, SoDienThoai = ?" + " WHERE MaCT = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(4, kh.getMaCT());
            pstmt.setString(1, kh.getHoTen());
            pstmt.setString(2, kh.getSoNha());
            pstmt.setString(3, kh.getSoDienThoai());
            
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static Boolean Delete(String MaCT)
    {
        String sql = "DELETE FROM khachhang" + " WHERE MaCT = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, MaCT);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
}
