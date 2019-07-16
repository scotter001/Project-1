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
public class ChiTietHoaDon {
    int MaCTHD ;
    int MaHD ; 
    int MaMon ; 
    int SoLuong ;
    double ThanhTien ;
    String GhiChu ; //50

    public int getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(int MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getMaMon() {
        return MaMon;
    }

    public void setMaMon(int MaMon) {
        this.MaMon = MaMon;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public ChiTietHoaDon() {
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public ChiTietHoaDon(int MaMon, int SoLuong, double ThanhTien) {
        this.MaMon = MaMon;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

  
    public ChiTietHoaDon(int MaHD, int MaMon, int SoLuong, double ThanhTien, String GhiChu) {
        this.MaHD = MaHD;
        this.MaMon = MaMon;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    
    
}
