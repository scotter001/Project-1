/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.BanNgoi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DALBanNgoi {

    public static ArrayList<BanNgoi> getAllBan() {
        ResultSet rs;
        ArrayList<BanNgoi> ban = null;
        String sql = "select * from BanNgoi";
        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
        ban = new ArrayList<BanNgoi>();
        try {
            while (rs.next()) {
                BanNgoi bn = new BanNgoi(rs.getInt("MaBan"), rs.getString("SoBan"), rs.getInt("TrangThai"), rs.getString("GhiChu"));
                ban.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DALBanNgoi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ban;
    }

    //1. hàm lấy tất cả 
    public static ResultSet GetAll() {

        String cauTruyVan = "select * from BanNgoi";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);

    }
    //2. hàm lấy theo ID

    public static ResultSet GetbyMaBan(int MaBan) {
        String cauTruyVan = "select * from BanNgoi where MaBan = " + MaBan;
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet getBySoBanTrung(String SoBan) {
        String cauTruyVan = "select * from BanNgoi where SoBan = " + SoBan;
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    //3. hàm xóa theo ID
    public static void Xoa(int MaBan) {
        String cauTruyVan = "delete from BanNgoi where MaBan = " + MaBan;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");

    }
    //Tìm Kiếm Theo Từ Khóa   
public static ResultSet GetByTrangThai(int MaBan) {     
        String cauTruyVan = "select * from BanNgoi where MaBan = "+MaBan+"";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);       
    }

    public static ResultSet GetBySoBan(String tuKhoa) {
        String cauTruyVan = "select * from BanNgoi where SoBan like N'%" + tuKhoa + "%'";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static void SuaTrangThaiBanDaCoNguoiNgoi(BanNgoi BN) {
        String cauTruyVan = "update BanNgoi set TrangThai = 2 where MaBan = " + BN.getMaBan() + "";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
    }

    public static void SuaTrangThaiBanTrong(BanNgoi BN) {
        String cauTruyVan = "update BanNgoi set TrangThai = 1 where MaBan = " + BN.getMaBan() + "";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
    }

    //4. hàm sửa toàn bộ 
    public static void Sua(BanNgoi BN) {
        String cauTruyVan = "update BanNgoi set SoBan = N'" + BN.getSoBan() + "' ,TrangThai = N'" + BN.getTrangThai() + "' , GhiChu = N'" + BN.getGhiChu() + "' where MaBan = " + BN.getMaBan() + "";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }

    // hàm thêm
    public static void Them(BanNgoi BN) {
        String cauTruyVan = "insert into BanNgoi values(N'" + BN.getSoBan() + "',N'" + BN.getTrangThai() + "',N'" + BN.getGhiChu() + "')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    }
}
