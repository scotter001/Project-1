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
public class DALThongKe {

    public static ResultSet ThongKe() {

        String cauTruyVan = "SELECT        dbo.HoaDon.SoHoaDon, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoaiSP, dbo.HoaDon.NgayTaoHD, dbo.ChiTietHoaDon.SoLuong, dbo.ChiTietHoaDon.ThanhTien, dbo.ChiTietHoaDon.GhiChu\n"
                + "FROM            dbo.ChiTietHoaDon INNER JOIN\n"
                + "                         dbo.SanPham ON dbo.ChiTietHoaDon.MaSP = dbo.SanPham.MaSP INNER JOIN\n"
                + "                         dbo.LoaiSanPham ON dbo.SanPham.MaLoaiSP = dbo.LoaiSanPham.MaLoaiSP INNER JOIN\n"
                + "                         dbo.HoaDon ON dbo.ChiTietHoaDon.MaHD = dbo.HoaDon.MaHD";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);

    }

    public static ResultSet TimKiemTheoNgay() {

        String cauTruyVan = " select distinct DAY(NgayTaoHD) from HoaDon ";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet TimKiemTheoThang() {

        String cauTruyVan = " select distinct Month(NgayTaoHD) from HoaDon ";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet TimKiemTheoNam() {

        String cauTruyVan = " select distinct Year(NgayTaoHD) from HoaDon ";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet TimKiemHoaDonTheoNgay(String TuKhoa) {

        String cauTruyVan = "SELECT distinct dbo.HoaDon.SoHoaDon, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoaiSP, dbo.HoaDon.NgayTaoHD, dbo.ChiTietHoaDon.SoLuong, dbo.ChiTietHoaDon.ThanhTien, dbo.ChiTietHoaDon.GhiChu FROM  dbo.SanPham INNER JOIN dbo.LoaiSanPham ON dbo.SanPham.MaLoaiSP = dbo.LoaiSanPham.MaLoaiSP INNER JOIN dbo.ChiTietHoaDon ON dbo.SanPham.MaSP = dbo.ChiTietHoaDon.MaSP INNER JOIN dbo.HoaDon ON dbo.ChiTietHoaDon.MaHD = dbo.HoaDon.MaHD where DAY(NgayTaoHD) =" + TuKhoa + "";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet TimKiemHoaDonTheoThang(String TuKhoa) {

        String cauTruyVan = "SELECT distinct dbo.HoaDon.SoHoaDon, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoaiSP, dbo.HoaDon.NgayTaoHD, dbo.ChiTietHoaDon.SoLuong, dbo.ChiTietHoaDon.ThanhTien, dbo.ChiTietHoaDon.GhiChu FROM  dbo.SanPham INNER JOIN dbo.LoaiSanPham ON dbo.SanPham.MaLoaiSP = dbo.LoaiSanPham.MaLoaiSP INNER JOIN dbo.ChiTietHoaDon ON dbo.SanPham.MaSP = dbo.ChiTietHoaDon.MaSP INNER JOIN dbo.HoaDon ON dbo.ChiTietHoaDon.MaHD = dbo.HoaDon.MaHD where Month(NgayTaoHD) =" + TuKhoa + "";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

    public static ResultSet TimKiemHoaDonTheoNam(String TuKhoa) {

        String cauTruyVan = "SELECT distinct dbo.HoaDon.SoHoaDon, dbo.SanPham.TenSP, dbo.LoaiSanPham.TenLoaiSP, dbo.HoaDon.NgayTaoHD, dbo.ChiTietHoaDon.SoLuong, dbo.ChiTietHoaDon.ThanhTien, dbo.ChiTietHoaDon.GhiChu FROM  dbo.SanPham INNER JOIN dbo.LoaiSanPham ON dbo.SanPham.MaLoaiSP = dbo.LoaiSanPham.MaLoaiSP INNER JOIN dbo.ChiTietHoaDon ON dbo.SanPham.MaSP = dbo.ChiTietHoaDon.MaSP INNER JOIN dbo.HoaDon ON dbo.ChiTietHoaDon.MaHD = dbo.HoaDon.MaHD where Year(NgayTaoHD) =" + TuKhoa + "";
        return GUI.frmMain.connection.ExcuteQueryGetTable(cauTruyVan);
    }

}
