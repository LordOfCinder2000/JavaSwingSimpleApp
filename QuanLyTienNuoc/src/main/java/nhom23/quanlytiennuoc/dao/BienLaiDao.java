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
import nhom23.quanlytiennuoc.model.BienLai;
/**
 *
 * @author Admin
 */
public class BienLaiDao {
    public static List<BienLai> getTable()
    {
        String sql = "SELECT * FROM bienlai";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<BienLai> list = new ArrayList<>();
            while(rs.next())
            {
                BienLai bl = createBienLai(rs);
                list.add(bl);
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }

    private static BienLai createBienLai(ResultSet rs) throws SQLException {
        BienLai bl = new BienLai();
        bl.setMaBL(rs.getString(1));
        bl.setMaCT(rs.getString(2));
        bl.setMaTK(rs.getString(3));
        bl.setChiSoMoi(rs.getInt(4));
        bl.setChiSoCu(rs.getInt(5));
        bl.setTongTien(rs.getInt(6));
        bl.setNgayLap(rs.getString(7));
        return bl;
    }
    
    public static BienLai findByID(String id)
    {
        String sql = "SELECT * FROM bienlai" + " WHERE MaBL = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                BienLai bl = createBienLai(rs);           
                return bl;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static Boolean Insert(BienLai bl)
    {
        String sql = "INSERT INTO bienlai (MaBL,MaCT,MaTK,ChiSoMoi,ChiSoCu,TongTien,NgayLap)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, bl.getMaBL());
            pstmt.setString(2, bl.getMaCT());
            pstmt.setString(3, bl.getMaTK());
            pstmt.setInt(4, bl.getChiSoMoi());
            pstmt.setInt(5, bl.getChiSoCu());
            pstmt.setInt(6, bl.getTongTien());
            pstmt.setString(7, bl.getNgayLap());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static Boolean Update(BienLai bl)
    {
        String sql = "UPDATE bienlai" + " SET MaCT = ?, MaTK = ?, ChiSoMoi = ?, ChiSoCu = ?, TongTien = ?, NgayLap = ?" + " WHERE MaBL = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(7, bl.getMaBL());
            pstmt.setString(1, bl.getMaCT());
            pstmt.setString(2, bl.getMaTK());
            pstmt.setInt(3, bl.getChiSoMoi());
            pstmt.setInt(4, bl.getChiSoCu());
            pstmt.setInt(5, bl.getTongTien());
            pstmt.setString(6, bl.getNgayLap());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Boolean Delete(String MaBL)
    {
        String sql = "DELETE FROM bienlai" + " WHERE MaBL = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, MaBL);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
}
