/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ChuyenDoi {
    //Ham doi tu so sang chu co dinh dang
    public static String DinhDangTien(double tien){
          return NumberFormat.getNumberInstance().format(tien);
    }
    
    //ham chuyen tu chu sang so de tinh toan
    
    public static double ChuyenTien(String tien){
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
            GUI.frmMain.ThongBao("Thong Bao", "sai định dạng giá tiền");
        }
        return 0 ;
    }
    
    //ham chuyen kieu chu sang ngay thang
    public static String DinhDangNgay(Date ngay){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        return dateFormat.format(ngay);
    }
    
    //ham chuyen chu sang ngay thang
    public static Date LayNgay(String ngay){
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            return dateFormat.parse(ngay);
        } catch (ParseException ex) {
            GUI.frmMain.ThongBao("Thong Bao", "sai định dạng ngày");
        }
        return null ;
    }
}
