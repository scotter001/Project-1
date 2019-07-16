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
public class HoaDon {
    int MaHD ;
    String SoHoaDon ; //20
    String NgayTaoHD ; 
    int MaNV ;
    int MaBan ;
    String TinhTrang ; 
    double TongTien ;
    int MaKH ;

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public String getNgayTaoHD() {
        return NgayTaoHD;
    }

    public void setNgayTaoHD(String NgayTaoHD) {
        this.NgayTaoHD = NgayTaoHD;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public HoaDon() {
    }

    public HoaDon(int MaHD) {
        this.MaHD = MaHD;
    }

    public HoaDon(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public HoaDon(String SoHoaDon, double TongTien) {
        this.SoHoaDon = SoHoaDon;
        this.TongTien = TongTien;
    }

    public HoaDon(String SoHoaDon, String TinhTrang) {
        this.SoHoaDon = SoHoaDon;
        this.TinhTrang = TinhTrang;
    }

    public HoaDon(String SoHoaDon, int MaBan) {
        this.SoHoaDon = SoHoaDon;
        this.MaBan = MaBan;
    }

    public HoaDon(int MaBan, double TongTien) {
        this.MaBan = MaBan;
        this.TongTien = TongTien;
    }

    
    
    public HoaDon(String SoHoaDon, int MaNV, int MaBan, String TinhTrang, double TongTien, int MaKH) {
        this.SoHoaDon = SoHoaDon;
        this.MaNV = MaNV;
        this.MaBan = MaBan;
        this.TinhTrang = TinhTrang;
        this.TongTien = TongTien;
        this.MaKH = MaKH;
    }

    public HoaDon(String SoHoaDon, String NgayTaoHD, int MaNV, int MaBan, String TinhTrang, double TongTien, int MaKH) {
        this.SoHoaDon = SoHoaDon;
        this.NgayTaoHD = NgayTaoHD;
        this.MaNV = MaNV;
        this.MaBan = MaBan;
        this.TinhTrang = TinhTrang;
        this.TongTien = TongTien;
        this.MaKH = MaKH;
    }
    
    

   
    
}
