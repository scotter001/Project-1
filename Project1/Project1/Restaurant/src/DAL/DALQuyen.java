/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DALQuyen {
        //1. hàm lấy tất cả 
    public static  ResultSet GetAll(){
        
        String cauTruyVan = "select * from Quyen";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
               
    }
     //2. hàm lấy theo ID
    public static ResultSet GetbyMaQuyen(int MaNV){
        String cauTruyVan = "select * from Quyen where MaQuyen =  "+MaNV;
         return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }
    //3. hàm xóa theo ID
    public static void Xoa(int MaNV){
        String cauTruyVan = "delete from Quyen where MaQuyen = "+MaNV;
        GUI.frmMain.connection.ExcuteQueryUpdateDB(cauTruyVan);
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
 
    }
     //Tìm Kiếm Theo Từ Khóa   
     public static ResultSet GetByTenQuyen(String tuKhoa) {
        String cauTruyVan = "select * from Quyen where TenQuyen like N'%"+tuKhoa+"%'";             
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);        
    }
}
