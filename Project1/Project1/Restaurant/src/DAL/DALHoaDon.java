/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.HoaDon;
import com.sun.java.accessibility.util.GUIInitializedListener;
import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class DALHoaDon {
    //1. hàm lấy tất cả 

    public static ResultSet GetAll() {

        String cauTruyVan = "select * from HoaDon";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    //2.2 Hàm lấy theo MaSP
    public static ResultSet GetByTenHD(String SoHoaDon) {
        String cauTruyVan = "select * from HoaDon where SoHoaDon = '" + SoHoaDon + "'";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    //2.2 Hàm lấy theo MaSP
    public static ResultSet GetByMaHD(int MaHD) {
        String cauTruyVan = "select * from HoaDon where MaHD = " + MaHD;
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet LayHoaDonTheoMaBan(int MaBan) {
        String cauTruyVan = "select * from HoaDon where MaBan = " + MaBan;
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
     public static void SuaTrangThai(HoaDon HD) {
        String cauTruyVan = "update HoaDon set TinhTrang = N'Đã Thanh Toán' where SoHoaDon = '"+HD.getSoHoaDon()+"'";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
       
    }
    

    // hàm thêm
    public static void Them(HoaDon HD) {
        String cauTruyVan = "insert into HoaDon(SoHoaDon,NgayTaoHD,MaNV,MaBan,TinhTrang,TongTien,MaKH) values('" + HD.getSoHoaDon() + "','"+HD.getNgayTaoHD()+"'," + HD.getMaNV() + "," + HD.getMaBan() + ",N'" + HD.getTinhTrang() + "'," + HD.getTongTien() + "," + HD.getMaKH() + ")";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
       
    }
      
     public static void updateTongTienTheoMaBan(HoaDon HD){
        String cauTruyVan = "update HoaDon set TongTien = "+HD.getTongTien()+" where MaBan = '"+HD.getMaBan()+"'";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
    }

    public static void updateTongTien(HoaDon HD){
        String cauTruyVan = "update HoaDon set TongTien = "+HD.getTongTien()+" where SoHoaDon = '"+HD.getSoHoaDon()+"'";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
    }
  public static void updateChuyenBanTheoSoHoaDon(HoaDon HD){
        String cauTruyVan = "update HoaDon set MaBan = "+HD.getMaBan()+" where SoHoaDon = '"+HD.getSoHoaDon()+"'";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
    }


}
