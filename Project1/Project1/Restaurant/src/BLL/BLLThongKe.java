/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

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
public class BLLThongKe {

    public static void DoDuLieu(JTable table) {

        try {
            ResultSet rs = DAL.DALThongKe.ThongKe();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[7] = rs.getString(7);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông báo lỗi", "Lỗi truy vấn dữ liệu Bàn Ngồi");
        }
    }

    public static void DoDuLieuNgay(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALThongKe.TimKiemTheoNgay();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();

            while (rs.next()) {
                cbbModel.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo", "Lỗi truy vấn dữ liệu");
        }
    }

    public static void DoDuLieuThang(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALThongKe.TimKiemTheoThang();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();

            while (rs.next()) {
                cbbModel.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo", "Lỗi truy vấn dữ liệu");
        }
    }

    public static void DoDuLieuNam(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALThongKe.TimKiemTheoNam();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();

            while (rs.next()) {
                cbbModel.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo", "Lỗi truy vấn dữ liệu");
        }
    }

    public static void TimKiemHoaDonTheoNgay(JTable table, String TuKhoa) {

        try {
            ResultSet rs = DAL.DALThongKe.TimKiemHoaDonTheoNgay(TuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[7] = rs.getString(7);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);

            }

        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông báo lỗi", "Lỗi truy vấn dữ liệu Bàn Ngồi");

        }

    }

    public static void TimKiemHoaDonTheoThang(JTable table, String TuKhoa) {

        try {
            ResultSet rs = DAL.DALThongKe.TimKiemHoaDonTheoThang(TuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[7] = rs.getString(7);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông báo lỗi", "Lỗi truy vấn dữ liệu Bàn Ngồi");
        }
    }

    public static void TimKiemHoaDonTheoNam(JTable table, String TuKhoa) {

        try {
            ResultSet rs = DAL.DALThongKe.TimKiemHoaDonTheoNam(TuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);
                obj[3] = rs.getString(3);
                obj[4] = rs.getString(4);
                obj[5] = rs.getString(5);
                obj[6] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[7] = rs.getString(7);
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông báo lỗi", "Lỗi truy vấn dữ liệu Bàn Ngồi");
        }
    }

    public static double DoTongTien(JTable tb, double thanhTien) {
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
//        if (tb.getRowCount() == 0) {
        Object obj[] = new Object[7];
        obj[6] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
        tableModel.addRow(obj);
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 6).toString());
            tongTien = tongTien + tien;
        }
        return tongTien;
    }
}
