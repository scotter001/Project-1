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
public class PhieuNhap {
    int MaPhieuNhapKho ;
    int MaNCC ;
    int MaNV ;
    int SoLuong ;
    double GiaTien ;
    String NgayNhap ;
    int MaSP ;
    String DonViTinh ; //20
    String GhiChu ; // 50

    public int getMaPhieuNhapKho() {
        return MaPhieuNhapKho;
    }

    public void setMaPhieuNhapKho(int MaPhieuNhapKho) {
        this.MaPhieuNhapKho = MaPhieuNhapKho;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double GiaTien) {
        this.GiaTien = GiaTien;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public PhieuNhap() {
    }

    public PhieuNhap(int MaNCC, int MaNV, int SoLuong, double GiaTien, String NgayNhap, int MaSP, String DonViTinh, String GhiChu) {
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.NgayNhap = NgayNhap;
        this.MaSP = MaSP;
        this.DonViTinh = DonViTinh;
        this.GhiChu = GhiChu;
    }

    public PhieuNhap(int MaPhieuNhapKho, int MaNCC, int MaNV, int SoLuong, double GiaTien, String NgayNhap, int MaSP, String DonViTinh, String GhiChu) {
        this.MaPhieuNhapKho = MaPhieuNhapKho;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.NgayNhap = NgayNhap;
        this.MaSP = MaSP;
        this.DonViTinh = DonViTinh;
        this.GhiChu = GhiChu;
    }
    
}
