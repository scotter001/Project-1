/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DALChiTietHoaDon;
import DAL.DALHoaDon;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.MyCombobox;
import DTO.SanPham;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLHoaDon {

    public static void themHoaDon(HoaDon HD) {
        DAL.DALHoaDon.Them(HD);
    }

    public static void DoDuLieuThucDonChoHD(JTable table) {

        try {
            ResultSet rs = DAL.DALSanPham.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[4];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("Gia"));
//                obj[3] = rs.getString(4);             
                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn đổ dữ liệu thực đơn !");
        }
    }

    //2. tim san theo tu khoa
    public static void TimSanPhamTheoTuKhoaSP(JTable table, String tuKhoa) {

        try {
            ResultSet rs = DAL.DALSanPham.GetByTenSP(tuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[4];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = NumberFormat.getNumberInstance().format(rs.getDouble("Gia"));

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu.tìm Sản Phẩm !");
        }
    }
    // 2. Hàm thêm  

    public static void Them(HoaDon HD) {
        DAL.DALHoaDon.Them(HD);
    }

    public static void ThemChiTietHoaDon(DTO.ChiTietHoaDon cthd) {
        DAL.DALChiTietHoaDon.Them(cthd);
    }

    public static void ChuyenBan(HoaDon HD) {
        DAL.DALHoaDon.updateChuyenBanTheoSoHoaDon(HD);
    }

    public static void updateSoLuongChoSP(SanPham sp) {
        DAL.DALSanPham.updateSoluong(sp);
    }

    public static void CongTienChuyenBan(HoaDon HD) {
        DAL.DALHoaDon.updateTongTienTheoMaBan(HD);
    }

    public static void updateSoLuongMoi(ChiTietHoaDon ct) {
        DAL.DALChiTietHoaDon.updateSoLuongMoi(ct);
    }

//     public static ResultSet getChiTietThucDonBySoHoaDon(int MaHD){
//        ResultSet rs;
//        rs = DALChiTietHoaDon.getChiTietHoaDonBySoHoaDon(MaHD);
//        return rs;
//    }
    public static void Delete(int MaCTHD) {
        DAL.DALChiTietHoaDon.Xoa(MaCTHD);
    }

    public static int LayMaHoaDonString(String TenHD) {
        try {
            ResultSet rs = DALHoaDon.GetByTenHD(TenHD);

            if (rs.next()) {
                return rs.getInt("MaHD");
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi Lấy Mã Hóa Đơn !");
        }
        return 0;
    }

    //ham lay ma hoa don dua vao so hoa don
    public static int LayMaHoaDon(int MaHD) {
        try {
            ResultSet rs = DALHoaDon.GetByMaHD(MaHD);

            if (rs.next()) {
                return rs.getInt("MaHD");
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thong Bao", "Loi Lay ma hoa don !");
        }
        return 0;
    }

    public static void KiemTraSoHoaDon(String SoHoaDon) {
        ResultSet rs;
        rs = DALHoaDon.GetByTenHD(SoHoaDon);

    }

    // 3 Tao so hoa don HD180814015820222
    public static String taoSoHoaDon() {
        String soHoaDon;

        DateFormat dateFormat = new SimpleDateFormat("YYMMDDhhmmss");

        Date d = new Date();

        soHoaDon = "HD" + dateFormat.format(d);

        return soHoaDon;
    }

//     public static String LayNgayHienTai(){
//        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date d = new Date();
//        return dateFormat.format(d);
//     }
    //2. tim san theo tu khoa
    public static void TimSanPhamTheoTuKhoa(JTable table, String tuKhoa) {

        try {
            ResultSet rs = DAL.DALSanPham.GetByTenSP(tuKhoa);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[4];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = NumberFormat.getNumberInstance().format(rs.getDouble("Gia"));

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu.tìm Sản Phẩm !");
        }
    }

    public static void DoDuLieuVaoCBBNhanVien(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALNhanVien.GetAll();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenNV"), rs.getInt("MaNV"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    public static void SetCBBNhanVien(JComboBox cbb, int MaNV) {
        try {
            ResultSet rs = DAL.DALNhanVien.GetbyMaNV(MaNV);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenNV"),
                        rs.getInt("MaNV"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

    public static HoaDon LayHDDuaVaoMaBan(int MaBan) {
        try {
            ResultSet rs = DAL.DALHoaDon.LayHoaDonTheoMaBan(MaBan);
            if (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setSoHoaDon(rs.getString("SoHoaDon"));
                hd.setNgayTaoHD(rs.getString("NgayTaoHD"));
                hd.setMaNV(rs.getInt("MaNV"));
                hd.setTinhTrang(rs.getString("TinhTrang"));
                hd.setTongTien(rs.getDouble("TongTien"));
                hd.setMaBan(rs.getInt("MaBan"));
                hd.setMaKH(rs.getInt("MaKH"));

                return hd;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn hóa đơn !");
        }
        return null;
    }

    public static void DoDuLieuVaoCBBKhachHang(JComboBox cbb) {
        try {
            ResultSet rs = DAL.DALKhachHang.GetAll();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenKH"), rs.getInt("MaKH"));
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông báo", "Lỗi truy vấn dữ liệu !");
        }
    }

    public static void SetCBBKhachHang(JComboBox cbb, int MaKH) {
        try {
            ResultSet rs = DAL.DALKhachHang.GetbyMaKH(MaKH);
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("TenKH"),
                        rs.getInt("MaKH"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu !");
        }
    }

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

            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu mã Bàn cho cbbBanNgoi !");
        }
    }

//     public static void DoDuLieuVaoJTableChiTietHoaDon(ResultSet rs, JTable tableTam){
//        Object []objs = new Object[]{"STT","Mã Món","Tên Món", "Số Lượng","Giá", "Tổng Giá","Ghi CHú"};
//        DefaultTableModel tableModel = new DefaultTableModel(objs, 0);
//        tableTam.setModel(tableModel);
//        tableTam.getColumnModel().getColumn(1).setMinWidth(0);
//        tableTam.getColumnModel().getColumn(1).setMaxWidth(0);
//        tableTam.getColumnModel().getColumn(2).setMinWidth(0);
//        tableTam.getColumnModel().getColumn(2).setMaxWidth(0);
//        tableTam.getColumnModel().getColumn(6).setMinWidth(0);
//        tableTam.getColumnModel().getColumn(6).setMaxWidth(0);
//        try {
//            while(rs.next()){
//                Object[] item = new Object[7];
//                
//         objs[0] = tableModel.getRowCount() + 1 ;
//         objs[1] = rs.getInt("MaSP");
//         objs[2] = rs.getString("TenSP");        
//         objs[3] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("Gia"));
//         objs[4] = rs.getInt("SoLuong");
//         double thanhTien = (rs.getDouble("Gia")) * rs.getInt("SoLuong") ;
//         objs[5] = BLL.ChuyenDoi.DinhDangTien(thanhTien);   
//         objs[6] = rs.getString("GhiChu");
//         
//         
//         tableModel.addRow(objs);
//         
////         double tongTien = 0 ;
////         for (int i = 0; i < tableModel.getRowCount(); i++) {
////             
////                 double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 5).toString());
////                 
////                 tongTien = tongTien + tien ;
////             
////         }
////         
////         return tongTien;
//
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        
//    }
//      
    //ham nhap thong tin san pham can mua vao Bang ChiTietHoaDon
    public static double NhapSanPhamVaoChiTietHoaDon(JTable tb, SanPham sp, int SoLuong, String GhiChu) {
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();

//        if (tb.getRowCount() == 0) {
            Object obj[] = new Object[7];
            obj[0] = tableModel.getRowCount() + 1;
            obj[1] = sp.getMaSP();
            obj[2] = sp.getTenSP();
            obj[3] = BLL.ChuyenDoi.DinhDangTien(sp.getGia());
            obj[4] = SoLuong;
            double thanhTien = (sp.getGia()) * SoLuong;
            obj[5] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
            obj[6] = GhiChu;

            tableModel.addRow(obj);

            double tongTien = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {

                double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 5).toString());

                tongTien = tongTien + tien;

            }

            return tongTien;

//        } else {
//
//            for (int i = 0; i < tb.getRowCount(); i++) {
//                if (tb.getValueAt(i, 1).toString().equals(sp.getMaSP() + "")) {
//
//                    int slmoi = Integer.parseInt(tb.getValueAt(i, 4).toString()) + SoLuong;
//                    tb.setValueAt(slmoi, i, 4);
//                    double thanhTienmoi = (sp.getGia()) * slmoi;
//
//                    tb.setValueAt(BLL.ChuyenDoi.DinhDangTien(thanhTienmoi), i, 5);
//                    double tongTien = 0;
//                    for (int k = 0; k < tableModel.getRowCount(); k++) {
//
//                        double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(k, 5).toString());
//
//                        tongTien = tongTien + tien;
//
//                    }
//
//                    return tongTien;
//                } else {
//                    Object obj[] = new Object[7];
//                    obj[0] = tableModel.getRowCount() + 1;
//                    obj[1] = sp.getMaSP();
//                    obj[2] = sp.getTenSP();
//                    obj[3] = BLL.ChuyenDoi.DinhDangTien(sp.getGia());
//                    obj[4] = SoLuong;
//                    double thanhTien = (sp.getGia()) * SoLuong;
//                    obj[5] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
//                    obj[6] = GhiChu;
//
//                    tableModel.addRow(obj);
//                    double tongTien = 0;
//                    for (int k = 0; k < tableModel.getRowCount(); k++) {
//
//                        double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(k, 5).toString());
//
//                        tongTien = tongTien + tien;
//
//                    }
//
//                    return tongTien;
//                }
//            }
//        }

//        double tongTien = 0;
//        for (int i = 0; i < tableModel.getRowCount(); i++) {
//
//            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 5).toString());
//
//            tongTien = tongTien + tien;
//
//        }
//
//        return tongTien;
    }

    public static void updateTongTienTheoSoHoaDon(HoaDon HD) {
        DAL.DALHoaDon.updateTongTien(HD);
    }
 public static void updateTongTienTheoMaBan(HoaDon HD) {
        DAL.DALHoaDon.updateTongTienTheoMaBan(HD);
    }

    public static ResultSet getChiTietThucDonBySoHoaDon(int MaHD) {
        ResultSet rs;
        rs = DALChiTietHoaDon.getChiTietHoaDonByMaHD(MaHD);
        return rs;
    }

    public static ResultSet getChiTietThucDonByMaSP(int MaSP) {
        ResultSet rs;
        rs = DAL.DALChiTietHoaDon.getChiTietHoaDonByMaSP(MaSP);
        return rs;
    }

    public static ResultSet getTrangThaiCuaBan(int MaBan) {
        ResultSet rs;
        rs = DAL.DALBanNgoi.GetByTrangThai(MaBan);
        return rs;
    }

    public static void DoDuLieuLaiChoCTHD(JTable table, int MaBan) {

        try {
            ResultSet rs = DAL.DALChiTietHoaDon.LayCTHDTheoMaBan(MaBan);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getInt("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("Gia"));
                obj[4] = rs.getInt("SoLuong");
                obj[5] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[6] = rs.getString("GhiChu");
                obj[7] = rs.getInt("MaCTHD");
                tableModel.addRow(obj);

            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu lại cho chi tiết hóa đơn !");
        }
    }
//-------------------------------------------------------------------------------------------------------
//        public static void SetCBBBanNgoi(JComboBox cbb, int MaBan){
//        try {
//            ResultSet rs = DAL.DALBanNgoi.GetbyMaBan(MaBan);
//            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbb.getModel();
//            if(rs.next()){
//                MyCombobox mb = new MyCombobox(rs.getString("SoBan"), 
//                                            rs.getInt("MaBan"));
//                
//                cbbModel.setSelectedItem(mb);
//            }
//        } catch (SQLException ex) {
//            
//            GUI.frmMain.ThongBao("Thông báo", "Lỗi truy vấn đổ dữ liệu cbb bàn");
//        }
//    }

    public static void DoDuLieuLoaiSPChoHD(JTable table, int MaLoaiSP) {

        try {
            ResultSet rs = DAL.DALSanPham.GetbyMaLoaiSP(MaLoaiSP);
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[8];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("Gia"));

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu Sản Phẩm !");
        }
    }
}
