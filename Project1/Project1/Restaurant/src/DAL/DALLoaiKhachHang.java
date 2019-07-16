/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.LoaiKhachHang;
import DTO.LoaiSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DALLoaiKhachHang {
    
public static ArrayList<LoaiKhachHang> getAllLoaiKhachHang() {
        ResultSet rs;
        ArrayList<LoaiKhachHang> loaikh = null;
        String sql = "select * from LoaiKhachHang";
        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
        loaikh = new ArrayList<LoaiKhachHang>();
        try {
            while (rs.next()) {
                LoaiKhachHang kh = new LoaiKhachHang(rs.getInt("MaLoaiKH"), rs.getString("TenLoaiKH"), rs.getString("UuDai"));
                loaikh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DALLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaikh; 
}
//1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        String cauTruyVan = "select * from LoaiKhachHang";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaLoaiSP(int MaLoaiKH){
        String cauTruyVan = "select * from LoaiKhachHang where MaLoaiKH = "+MaLoaiKH;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    //3. hàm xóa theo ID
    public static void Xoa(int MaLoaiKH){
        String cauTruyVan = "delete from LoaiKhachHang where MaLoaiKH = "+MaLoaiKH;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
 
    }
     //Tìm Kiếm Theo Từ Khóa   
     public static ResultSet GetByTenLoaiKH(String tuKhoa) {
        String cauTruyVan = "select * from LoaiKhachHang where TenLoaiKH like N'%"+tuKhoa+"%'";             
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);        
    }
         //4. hàm sửa toàn bộ 
    public static void Sua(LoaiKhachHang LKH){
        String cauTruyVan = "update LoaiKhachHang set TenLoaiKH = N'"+LKH.getTenLoaiKH()+"', UuDai = N'"+LKH.getUuDai()+"' where MaLoaiKH = "+LKH.getMaLoaiKH()+"";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }
    // hàm thêm
    public static void Them(LoaiKhachHang LKH){
        String cauTruyVan = "insert into LoaiKhachHang values (N'"+LKH.getTenLoaiKH()+"', N'"+LKH.getUuDai()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    } 
}
