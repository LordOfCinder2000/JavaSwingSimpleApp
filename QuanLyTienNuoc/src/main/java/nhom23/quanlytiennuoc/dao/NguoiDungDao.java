/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom23.quanlytiennuoc.dao;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import nhom23.quanlytiennuoc.helpers.DataBaseHelper;
import nhom23.quanlytiennuoc.model.NguoiDung;

/**
 *
 * @author Admin
 */
public class NguoiDungDao {
    public static List<NguoiDung> getTable()
    {
        String sql = "SELECT MaTK,TenTaiKhoan,MatKhau,TenHienThi,TenQuyen,quyentaikhoan.MaQTK FROM taikhoan , quyentaikhoan WHERE taikhoan.MaQTK = quyentaikhoan.MaQTK";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<NguoiDung> list = new ArrayList<>();
            while(rs.next())
            {
                NguoiDung nd = createNguoiDung(rs);
                list.add(nd);
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static NguoiDung findByID(String id)
    {
        String sql = "SELECT MaTK,TenTaiKhoan,MatKhau,TenHienThi,MaQTK FROM taikhoan" + " WHERE MaTK = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                NguoiDung nd = new NguoiDung();
                nd.setMaTK(rs.getString(1));
                nd.setTenTaiKhoan(rs.getString(2));
                nd.setMatKhau(rs.getString(3));
                nd.setTenHienThi(rs.getString(4));
                nd.setMaQuyenTaiKhoan(rs.getInt(5));
                //System.out.println("nhom23.quanlytiennuoc.dao.NguoiDungDao.findByID()");
                return nd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static NguoiDung findByTK(String id)
    {
        String sql = "SELECT * FROM taikhoan" + " WHERE TenTaiKhoan = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                NguoiDung nd = new NguoiDung();
                nd.setMaTK(rs.getString(1));
                nd.setTenTaiKhoan(rs.getString(4));
                nd.setMatKhau(rs.getString(5));
                nd.setTenHienThi(rs.getString(3));
                nd.setMaQuyenTaiKhoan(rs.getInt(2));
                //System.out.println("nhom23.quanlytiennuoc.dao.NguoiDungDao.findByID()");
                return nd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private static NguoiDung createNguoiDung(ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
        nd.setMaTK(rs.getString(1));
        nd.setTenTaiKhoan(rs.getString(2));
        nd.setMatKhau(rs.getString(3));
        nd.setTenHienThi(rs.getString(4));
        nd.setQuyenTaiKhoan(rs.getString(5));
        nd.setMaQuyenTaiKhoan(rs.getInt(6));
        return nd;
    }
    
    public static NguoiDung checkLogin(String TenTaiKhoan, String MatKhau)
    {
        NguoiDung nd = new NguoiDung();
        String sql = "select TenTaiKhoan, MatKhau, MaQTK, TenHienThi from taikhoan";
        Connection conn = DataBaseHelper.openConnection();
        ResultSet rs = null;
    	try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);     
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}	
        MatKhau = Encode(MatKhau);
        try {
                while(rs.next())
                {
                        if(rs.getString(1).equals(TenTaiKhoan) && rs.getString(2).equals(MatKhau))
                        {
                                nd.setTenTaiKhoan(TenTaiKhoan);
                                nd.setTenHienThi(rs.getString(4));
                                nd.setMatKhau(MatKhau);
                                if(rs.getInt(3) == 1)
                                {
                                    nd.setQuyenTaiKhoan("Quản trị");
                                }
                                else
                                {
                                    nd.setQuyenTaiKhoan("Người sử dụng");
                                }
                                conn.close();
                                return nd;
                        }
                }
        } catch (SQLException e) {
                e.printStackTrace();
        }
        return null;
    }
    
    public static Boolean Insert(NguoiDung nd)
    {
        String sql = "INSERT INTO taikhoan (MaTK,MaQTK,TenHienThi,TenTaiKhoan,MatKhau)" + "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, nd.getMaTK());
            pstmt.setInt(2, nd.getMaQuyenTaiKhoan());
            pstmt.setString(3, nd.getTenHienThi());
            pstmt.setString(4, nd.getTenTaiKhoan());
            pstmt.setString(5, nd.getMatKhau());
            //System.out.println(nd.getMaQuyenTaiKhoan());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static Boolean Update(NguoiDung nd)
    {
        String sql = "UPDATE taikhoan" + " SET MaQTK = ?, TenHienThi = ?, TenTaiKhoan = ?, MatKhau = ?"+ " WHERE MaTK = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(5, nd.getMaTK());
            pstmt.setInt(1, nd.getMaQuyenTaiKhoan());
            pstmt.setString(2, nd.getTenHienThi());
            pstmt.setString(3, nd.getTenTaiKhoan());
            pstmt.setString(4, nd.getMatKhau());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Boolean Delete(String MaTK)
    {
        String sql = "DELETE FROM taikhoan" + " WHERE MaTK = ?";
        try {
            Connection conn = DataBaseHelper.openConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, MaTK);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public static String Encode(String str)
    {
        String hashtext = null;
        try {
            Base64.Encoder enc = Base64.getEncoder();
            String encoded = enc.encodeToString(str.getBytes());

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(encoded.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
        } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return hashtext;
    }
}
