/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LENOVO
 */
public class SanPham {
    int MaSP ;
    String TenSP ; //50
    int SoLuong ; 
    String DonViTinh ; //20
    double Gia ;
    int MaLoaiSP ;
    String GhiChu ; //50

    public int getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(int MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public SanPham() {
    }

    public SanPham(int MaSP, int SoLuong) {
        this.MaSP = MaSP;
        this.SoLuong = SoLuong;
    }

    public SanPham(String TenSP, int SoLuong, String DonViTinh, double Gia, int MaLoaiSP, String GhiChu) {
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.Gia = Gia;
        this.MaLoaiSP = MaLoaiSP;
        this.GhiChu = GhiChu;
    }

    public SanPham(int MaSP, String TenSP, int SoLuong, String DonViTinh, double Gia, int MaLoaiSP, String GhiChu) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonViTinh = DonViTinh;
        this.Gia = Gia;
        this.MaLoaiSP = MaLoaiSP;
        this.GhiChu = GhiChu;
    }

  
    
}