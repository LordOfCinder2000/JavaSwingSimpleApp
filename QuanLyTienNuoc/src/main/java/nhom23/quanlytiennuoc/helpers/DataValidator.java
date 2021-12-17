/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom23.quanlytiennuoc.helpers;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import nhom23.quanlytiennuoc.dao.NguoiDungDao;

/**
 *
 * @author Admin
 */
public class DataValidator {
    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage){
        if(field.getText().equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage){
        String password = new String(field.getPassword());
        if(password.equals("")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateEmpty(JComboBox comboBox, StringBuilder sb, String errorMessage){
        if(comboBox.getSelectedItem()==null){
            sb.append(errorMessage).append("\n");
            comboBox.setBackground(Color.red);
            comboBox.requestFocus();
        }else{
            comboBox.setBackground(Color.white);
        }
    }
    
    public static void validateConfirmPassword(JPasswordField field1, JPasswordField field2,StringBuilder sb, String errorMessage){
        String password = new String(field1.getPassword());
        String passwordConfirm = new String(field2.getPassword());
        if(password.equals(passwordConfirm)==false){
            sb.append(errorMessage).append("\n");
            field2.setBackground(Color.red);
            field2.requestFocus();
        }else{
            field2.setBackground(Color.white);
        }
    }
    
    public static void validatePassword(JPasswordField field,StringBuilder sb, String errorMessage){
        String password = new String(field.getPassword());
        if(password.contains(" ")){
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateUnique(JTextField field, StringBuilder sb, String errorMessage){
        NguoiDungDao dao = new NguoiDungDao();
        if(dao.findByID(field.getText()) != null)
        {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
        else{
            field.setBackground(Color.white);
        }
    }
    
    public static void validateDateTime(JTextField field, StringBuilder sb, String errorMessage){
        String value = field.getText();
        String dateRegEx="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        if(Pattern.matches(dateRegEx, value))
        {
            Date date = new Date();
            String rs = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                date = sdf.parse(value);
                rs = sdf.format(date);
                field.setBackground(Color.white);
            } catch (Exception ex) {
                sb.append(errorMessage).append("\n");
                field.setBackground(Color.red);
                field.requestFocus();
            }
        }
        else
        {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
    }
    
    public static String setCurentDate()
    {
        String rs = null;
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            rs = sdf.format(date); 
            return rs;
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static String setCurentDateWithHour()
    {
        String rs = null;
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            rs = sdf.format(date); 
            return rs;
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static String formatDate(String value){
        Date date = new Date();
        String rs = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
            rs = sdf2.format(sdf1.parse(value));
            return rs;
        } catch (Exception ex) {
        }
        return null;
    }
    
    public static String formatDateForTable(String value){
        Date date = new Date();
        String rs = null;
        try {
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            rs = sdf2.format(sdf1.parse(value));
            return rs;
        } catch (Exception ex) {
        }
        return null;
    }
    
    public static void validatePhoneNumber(JTextField field, StringBuilder sb){
        String str = field.getText();
        if(str.contains(" "))
        {
            sb.append("Số điện thoại không được có khoảng trắng").append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
        else
        {
            String RegEx="^(?!\\s*$)[0-9\\s]{10}$";
            if(Pattern.matches(RegEx, str))
            {
                field.setBackground(Color.white);
            }
            else
            {
                sb.append("Số điện thoại có 10 số và không được có ký tự đặc biệt").append("\n");
                field.setBackground(Color.red);
                field.requestFocus();
            }
        }
    }
    
    public static void validateNumber(JTextField field, StringBuilder sb){
        String str = field.getText();
        if(str.contains(" "))
        {
            sb.append("Chỉ số nước không được có khoản trắng").append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }
        else
        {
            String regex = "\\d+";
            if(Pattern.matches(regex, str))
            {
                field.setBackground(Color.white);
            }
            else
            {
                sb.append("Chỉ số nước không được có ký tự đặc biệt").append("\n");
                field.setBackground(Color.red);
                field.requestFocus();
            }
        }
    }
}
