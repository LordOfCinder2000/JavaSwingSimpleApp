/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom23.quanlytiennuoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nhom23.quanlytiennuoc.helpers.DataBaseHelper;
import nhom23.quanlytiennuoc.model.NguoiDung;
import nhom23.quanlytiennuoc.model.QuyenTaiKhoan;

/**
 *
 * @author Admin
 */
public class QuyenTaiKhoanDao {
    public static QuyenTaiKhoan findByID(int id)
    {
        String sql = "SELECT * FROm quyentaikhoan" + " WHERE MaQTK = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            QuyenTaiKhoan qtk = null;
            if(rs.next())
            {
                qtk = new QuyenTaiKhoan();
                qtk.setMaQTK(rs.getInt(1));
                qtk.setTenQuyen(rs.getString(2));
            }
            return qtk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<QuyenTaiKhoan> getTable()
    {
        String sql = "SELECT * FROM quyentaikhoan";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<QuyenTaiKhoan> list = new ArrayList<>();
            while(rs.next())
            {
                QuyenTaiKhoan qtk = new QuyenTaiKhoan();
                qtk.setMaQTK(rs.getInt(1));
                qtk.setTenQuyen(rs.getString(2));
                list.add(qtk);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
