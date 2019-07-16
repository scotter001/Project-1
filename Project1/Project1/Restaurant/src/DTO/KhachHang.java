/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class KhachHang {
    int MaKH;
    String TenKH;
    String DiaChi;
    String GioiTinh;
    String DienThoai;
    int MaLoaiKH;
    String GhiChu;

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public int getMaLoaiKH() {
        return MaLoaiKH;
    }

    public void setMaLoaiKH(int MaLoaiKH) {
        this.MaLoaiKH = MaLoaiKH;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public KhachHang() {
    }

    public KhachHang(String TenKH, String DiaChi, String GioiTinh, String DienThoai, int MaLoaiKH, String GhiChu) {
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
        this.MaLoaiKH = MaLoaiKH;
        this.GhiChu = GhiChu;
    }

    public KhachHang(int MaKH, String TenKH, String DiaChi, String GioiTinh, String DienThoai, int MaLoaiKH, String GhiChu) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.DienThoai = DienThoai;
        this.MaLoaiKH = MaLoaiKH;
        this.GhiChu = GhiChu;
    }
    
    
}
