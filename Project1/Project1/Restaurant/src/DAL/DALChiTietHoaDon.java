/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChiTietHoaDon;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class DALChiTietHoaDon {
      //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        
        String cauTruyVan = "select * from ChiTietHoaDon";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);              
    }
    
    public static ResultSet LayCTHDTheoMaBan(int MaBan){
        String cauTruyVan = "select ChiTietHoaDon.MaCTHD ,SanPham.MaSP, SanPham.TenSP, ChiTietHoaDon.SoLuong, SanPham.Gia, ChiTietHoaDon.ThanhTien, ChiTietHoaDon.GhiChu from HoaDon, ChiTietHoaDon, SanPham  where HoaDon.MaHD = ChiTietHoaDon.MaHD and ChiTietHoaDon.MaSP = SanPham.MaSP and HoaDon.TinhTrang like N'%Chưa Thanh Toán%' and HoaDon.MaBan =" + MaBan;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    
      public static ResultSet getChiTietHoaDonByMaHD(int MaHD) {
        ResultSet rs;

        String sql = "select * from  ChiTietHoaDon where MaHD = "+MaHD;
        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
        
        return rs;
    }
        public static ResultSet getChiTietHoaDonByMaSP(int MaSP) {
        ResultSet rs;

        String sql = "select * from  ChiTietHoaDon where MaSP = "+MaSP;
        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
        
        return rs;
    }
      
//      public static ResultSet getChiTietHoaDonBySoHoaDon(int MaHD) {
//        ResultSet rs;
//
//        String sql = "select * from  ChiTietHoaDon where MaHD = "+MaHD;
//        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
//        
//        return rs;
//    }
        public static void updateSoLuongMoi(ChiTietHoaDon ct){
            String cauTruyVan = "update ChiTietHoaDon set SoLuong = "+ct.getSoLuong()+" , ThanhTien = "+ct.getThanhTien()+" where MaSP = "+ct.getMaMon()+"";
            GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        }
       
      
      public static void Xoa(int MaCTHD){
          String cauTruyVan = "delete from ChiTietHoaDon where MaCTHD = "+MaCTHD;
          GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
          GUI.frmMain.ThongBao("Thông báo", "Hủy món thành công");
      }
    
    // hàm thêm
    public static void Them(ChiTietHoaDon CTHD){
        String cauTruyVan = "insert into ChiTietHoaDon values("+CTHD.getMaHD()+","+CTHD.getMaMon()+","+CTHD.getSoLuong()+","+CTHD.getThanhTien()+",N'"+CTHD.getGhiChu()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
//        GUI.frmMain.ThongBao("Thông báo", "Order Thành Công");
    } 
}
