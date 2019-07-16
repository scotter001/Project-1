/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.SanPham;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class DALSanPham {
       //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        
        String cauTruyVan = "select * from SanPham";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaSP(int MaSP){
        String cauTruyVan = "select * from SanPham where MaSP = "+MaSP;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    
      //2. hàm lấy theo ID
    public static ResultSet GetbyMaLoaiSP(int MaLoaiSP){
        String cauTruyVan = "select * from SanPham where MaLoaiSP = "+MaLoaiSP;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    
    //3. hàm xóa theo ID
    public static void Xoa(int MaSP){
        String cauTruyVan = "delete from SanPham where MaSP ="+MaSP;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
 
    }
     //Tìm Kiếm Theo Từ Khóa   
     public static ResultSet GetByTenSP(String tuKhoa) {
        String cauTruyVan = "select * from SanPham where TenSP like N'%"+tuKhoa+"%'";             
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);        
    }
     
    public static void updateSoluong(SanPham sp){
        String cauTruyVan = "update SanPham set SoLuong = "+sp.getSoLuong()+" where MaSP = "+sp.getMaSP()+"";
         GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
    }
     
         //4. hàm sửa toàn bộ 
    public static void Sua(SanPham SP){
        String cauTruyVan = "update SanPham set TenSP = N'"+SP.getTenSP()+"' ,SoLuong = "+SP.getSoLuong()+", DonViTinh = N'"+SP.getDonViTinh()+"' ,Gia = "+SP.getGia()+",MaLoaiSP = "+SP.getMaLoaiSP()+" , GhiChu = N'"+SP.getGhiChu()+"' where MaSP = "+SP.getMaSP()+"";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }
    // hàm thêm
    public static void Them(SanPham SP){
        String cauTruyVan = "insert into SanPham values(N'"+SP.getTenSP()+"',"+SP.getSoLuong()+",N'"+SP.getDonViTinh()+"',"+SP.getGia()+","+SP.getMaLoaiSP()+",N'"+SP.getGhiChu()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    } 
}
