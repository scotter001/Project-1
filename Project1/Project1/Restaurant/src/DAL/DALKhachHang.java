/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHang;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALKhachHang {
       //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        String cauTruyVan = "select * from KhachHang";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaKH(int MaKH){
        String cauTruyVan = "select * from KhachHang where MaKH = "+MaKH;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    
      //2. hàm lấy theo ID
    public static ResultSet GetbyMaLoaiKH(int MaLoaiKH){
        String cauTruyVan = "select * from KhachHang where MaLoaiKH = "+MaLoaiKH;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    
    //3. hàm xóa theo ID
    public static void Xoa(int MaKH){
        String cauTruyVan = "delete from KhachHang where MaKH ="+MaKH;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        
    }
     //Tìm Kiếm Theo Từ Khóa   
     public static ResultSet GetByTenKH(String tuKhoa) {
        String cauTruyVan = "select * from KhachHang where TenKH like N'%"+tuKhoa+"%'";             
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);        
    }
         //4. hàm sửa toàn bộ 
    public static void Sua(KhachHang KH){
        String cauTruyVan = "update KhachHang set TenKH = N'"+KH.getTenKH()+"', DiaChi = N'"+KH.getDiaChi()+"', GioiTinh = "+KH.getGioiTinh()+", DienThoai ='"+KH.getDienThoai()+"', MaLoaiKH = "+KH.getMaLoaiKH()+", GhiChu = N'"+KH.getGhiChu()+"' where MaKH = "+KH.getMaKH()+"";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }
    // hàm thêm
    public static void Them(KhachHang KH){
        String cauTruyVan = "insert into KhachHang values (N'"+KH.getTenKH()+"', N'"+KH.getDiaChi()+"', "+KH.getGioiTinh()+", '"+KH.getDienThoai()+"', "+KH.getMaLoaiKH()+", N'"+KH.getGhiChu()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    } 
}
