/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.BanNgoi;
import DTO.MyCombobox;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLBanNgoi {

    public static void DoDuLieu(JTable table) {

        try {
            ResultSet rs = DAL.DALBanNgoi.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //XÃ³a dá»¯ liá»‡u cÅ© trong Table
            while (rs.next()) {
                Object obj[] = new Object[5];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);

                //ThÃªm obj vÃ o tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Lá»—i truy váº¥n dá»¯ liá»‡u BÃ n Ngá»“i !");
        }
    }
      //2. tim san theo tu khoa
     public static String TimBanNgoiTheoTuKhoa(JTable table , String tuKhoa){
        
        try {
            ResultSet rs = DAL.DALBanNgoi.GetBySoBan(tuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            tableModel.setRowCount(0); //XÃ³a dá»¯ liá»‡u cÅ© trong Table
            while(rs.next()){
                Object obj[] = new Object[5];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);                         
  
                //ThÃªm obj vÃ o tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Lá»—i truy váº¥n dá»¯ liá»‡u tÃ¬m Sáº£n Pháº©m !");
        }
        return tuKhoa;
    }
    //2.ThÃªm

    public static void InsertInto(BanNgoi BN) {
        DAL.DALBanNgoi.Them(BN);
    }

    //3.Sá»­a
    public static void Update(BanNgoi BN) {
        DAL.DALBanNgoi.Sua(BN);
    }

    //3.Sá»­a
    public static void UpdateTrangThaiDaCoNguoi(BanNgoi BN) {
        DAL.DALBanNgoi.SuaTrangThaiBanDaCoNguoiNgoi(BN);
    }

    public static void UpdateTrangThaiBanTrong(BanNgoi BN) {
        DAL.DALBanNgoi.SuaTrangThaiBanTrong(BN);
    }

    //4.XÃ³a
    public static void Delete(int MaBan) {
        DAL.DALBanNgoi.Xoa(MaBan);
    }

    public static BanNgoi LayDuaVaoMa(int MaBan) {
        try {
            ResultSet rs = DAL.DALBanNgoi.GetbyMaBan(MaBan);
            if (rs.next()) {
                BanNgoi bn = new BanNgoi();
                bn.setMaBan(rs.getInt("MaBan"));
                bn.setSoBan(rs.getString("SoBan"));
                bn.setTrangThai(rs.getInt("TrangThai"));
                bn.setGhiChu(rs.getString("GhiChu"));
                return bn;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Lá»—i truy váº¥n Láº¥y mÃ£ BÃ n !");
        }
        return null;
    }

    public static BanNgoi LayDuaVaoSo(String SoBan) {
        try {
            ResultSet rs = DAL.DALBanNgoi.GetBySoBan(SoBan);
            if (rs.next()) {
                BanNgoi bn = new BanNgoi();
                bn.setMaBan(rs.getInt("MaBan"));
                bn.setSoBan(rs.getString("SoBan"));
                bn.setTrangThai(rs.getInt("TrangThai"));
                bn.setGhiChu(rs.getString("GhiChu"));

                return bn;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Lá»—i truy váº¥n Láº¥y Sá»‘ BÃ n !");
        }
        return null;
    }

    //3. HÃ m Ä‘á»• dá»¯ liá»‡u vÃ o Combobox 
    public static void DoDuLieuVaoCBBBanNgoi(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALBanNgoi.GetAll();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("SoBan"),
                        rs.getInt("MaBan"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Lá»—i truy váº¥n dá»¯ liá»‡u !");
        }
    }

    //4. HÃ m gÃ¡n dá»¯ liá»‡u cho combobox 
    public static void SetCBBBanNgoi(JComboBox cbb, int MaBan) {
        try {
            ResultSet rs = DAL.DALBanNgoi.GetbyMaBan(MaBan);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("SoBan"),
                        rs.getInt("MaBan"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Lá»—i truy váº¥n dá»¯ liá»‡u !");
        }
    }
    
    //HÃ m Kiá»ƒm Tra BÃ n Ngá»“i
    public static boolean KiemTra(int MaBan, String SoBan, int TrangThai, String GhiChu) {

        //Kiá»ƒm Tra Sá»‘ BÃ n
        BanNgoi bn = BLL.BLLBanNgoi.LayDuaVaoSo(SoBan);
        if (bn != null) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Sá»‘ BÃ n NÃ y Ä�Ã£ Tá»“n Táº¡i !");
            return false;
        }
        if (SoBan.length() == 0) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Sá»‘ BÃ n KhÃ´ng Ä�Æ°á»£c Bá»� Trá»‘ng !");
            return false;
        }
        if (SoBan.length() < 3) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Sá»‘ BÃ n Tá»‘i Thiá»ƒu 3 KÃ­ Tá»± !");
            return false;
        }
        if (SoBan.length() > 30) {
            GUI.frmMain.ThongBao("ThÃ´ng BÃ¡o !", "Sá»‘ BÃ n Tá»‘i Ä�a 30 KÃ­ Tá»± !");
            return false;
        }
        return true;
    }
}
