/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import DTO.DTOLoaiNCC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DALLoaiNCC {
            
       public static ArrayList<DTO.DTOLoaiNCC> getAllLoaiNCC() {
        ResultSet rs;
        ArrayList<DTO.DTOLoaiNCC> loaincc = null;
        String sql = "select * from LoaiNCC";
        rs = GUI.frmMain.connection.ExcuteQueryGetTable(sql);
        loaincc = new ArrayList<DTO.DTOLoaiNCC>();
        try {
            while (rs.next()) {
                DTO.DTOLoaiNCC bn = new DTO.DTOLoaiNCC(rs.getInt("MaLoaiNCC"), rs.getString("TenLoaiNCC"));
                loaincc.add(bn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DTO.DTOLoaiNCC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaincc;
    }

    
       //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        
        String cauTruyVan = "select * from LoaiNCC";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaLoaiSP(int MaLoaiNCC){
        String cauTruyVan = "select * from LoaiNCC where MaLoaiNCC = "+MaLoaiNCC;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    //3. hàm xóa theo ID
    public static void Xoa(int MaLoaiNCC){
        String cauTruyVan = "delete from LoaiNCC where MaLoaiNCC = "+MaLoaiNCC;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
 
    }
     //Tìm Kiếm Theo Từ Khóa   
     public static ResultSet GetByTenLoaiSP(String tuKhoa) {
        String cauTruyVan = "select * from LoaiNCC where TenLoaiNCC like N'%"+tuKhoa+"%'";             
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);        
    }
         //4. hàm sửa toàn bộ 
    public static void Sua(DTOLoaiNCC lncc){
        String cauTruyVan = "update LoaiNCC set TenLoaiNCC = N'"+lncc.getTenLoaiNCC()+"' where MaLoaiNCC = "+lncc.getMaLoaiNCC()+"";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Sửa Thành Công");
    }
    // hàm thêm
    public static void Them(DTOLoaiNCC lncc){
        String cauTruyVan = "insert into LoaiNCC values(N'"+lncc.getTenLoaiNCC()+"')";
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Thêm Thành Công");
    } 
}
