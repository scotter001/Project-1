/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.LoaiSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DALLoaiSanPham {
    
     public static ArrayList<LoaiSanPham> getAllLoaiSanPham() {
        ResultSet rs;
        ArrayList<LoaiSanPham> loaisp = null;
        String sql = "select * from LoaiSanPham";
        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
        loaisp = new ArrayList<LoaiSanPham>();
        try {
            while (rs.next()) {
                LoaiSanPham bn = new LoaiSanPham(rs.getInt("MaLoaiSP"), rs.getString("TenLoaiSP"));
                loaisp.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DALLoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaisp;
    }
    
       //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        
        String cauTruyVan = "select * from LoaiSanPham";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaLoaiSP(int MaLoaiSP){
        String cauTruyVan = "select * from LoaiSanPham where MaLoaiSP = "+MaLoaiSP;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    //3. hàm xóa theo ID
    public static void Xoa(int MaLoaiSP){
        String cauTruyVan = "delete from LoaiSanPham where MaLoaiSP = "+MaLoaiSP;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
 
    }
     //Tìm Kiếm Theo Từ Khóa   
     public static ResultSet GetByTenLoaiSP(String tuKhoa) {
        String cauTruyVan = "select * from LoaiSanPham where TenLoaiSP like N'%"+tuKhoa+"%'";             
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);        
    }
         //4. hàm sửa toàn bộ 
    public static void Sua(LoaiSanPham LSP){
        String cauTruyVan = "update LoaiSanPham set TenLoaiSP = N'"+LSP.getTenLoaiSP()+"' where MaLoaiSP = "+LSP.getMaLoaiSP()+"";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }
    // hàm thêm
    public static void Them(LoaiSanPham LSP){
        String cauTruyVan = "insert into LoaiSanPham values(N'"+LSP.getTenLoaiSP()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    } 
}
