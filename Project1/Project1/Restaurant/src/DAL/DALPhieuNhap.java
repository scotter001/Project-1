/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.PhieuNhap;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class DALPhieuNhap {
       //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        String cauTruyVan = "select * from PhieuNhap";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaPhieuNhapKho(int MaPhieuNhapKho){
        String cauTruyVan = "select * from PhieuNhap where MaPhieuNhapKho ="+MaPhieuNhapKho;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    //3. hàm xóa theo ID
    public static void Xoa(int MaPhieuNhapKho){
        String cauTruyVan = "delete from PhieuNhap where MaPhieuNhapKho = "+MaPhieuNhapKho;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
 
    }
     //Tìm Kiếm Theo Từ Khóa   
   
     //4. hàm sửa toàn bộ 
    public static void Sua(PhieuNhap PN){
        String cauTruyVan = "update PhieuNhap set MaNCC = "+PN.getMaNCC()+",MaNV = "+PN.getMaNV()+" ,SoLuong = "+PN.getSoLuong()+",GiaTien = "+PN.getGiaTien()+",NgayNhap = '"+PN.getNgayNhap()+"',MaSP = "+PN.getMaSP()+" , DonViTinh = N'"+PN.getDonViTinh()+"' , GhiChu = N'"+PN.getGhiChu()+"' where MaPhieuNhapKho = "+PN.getMaPhieuNhapKho()+"";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }
    // hàm thêm
    public static void Them(PhieuNhap PN){
        String cauTruyVan = "insert into PhieuNhap values("+PN.getMaNCC()+","+PN.getMaNV()+","+PN.getSoLuong()+","+PN.getGiaTien()+",'"+PN.getNgayNhap()+"',"+PN.getMaSP()+",N'"+PN.getDonViTinh()+"',N'"+PN.getGhiChu()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    } 
}
