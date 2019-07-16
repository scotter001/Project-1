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
public class NhaCungCap {
    int MaNCC ;
    String TenNCC ; //50
    String DiaChi ; //50
    String DienThoai ; //10 
    String GhiChu ; // 255
    int MaLoaiNCC ; 

    public int getMaLoaiNCC() {
        return MaLoaiNCC;
    }

    public void setMaLoaiNCC(int MaLoaiNCC) {
        this.MaLoaiNCC = MaLoaiNCC;
    }

    public int getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(int MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public NhaCungCap() {
    }

    public NhaCungCap(String TenNCC, String DiaChi, String DienThoai, String GhiChu, int MaLoaiNCC) {
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
        this.MaLoaiNCC = MaLoaiNCC;
    }

    public NhaCungCap(int MaNCC, String TenNCC, String DiaChi, String DienThoai, String GhiChu, int MaLoaiNCC) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.GhiChu = GhiChu;
        this.MaLoaiNCC = MaLoaiNCC;
    }

   
    
}
