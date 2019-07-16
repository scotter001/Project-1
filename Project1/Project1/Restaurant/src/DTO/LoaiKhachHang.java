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
public class LoaiKhachHang {
    int MaLoaiKH;
    String TenLoaiKH;
    String UuDai;

    public int getMaLoaiKH() {
        return MaLoaiKH;
    }

    public void setMaLoaiKH(int MaLoaiKH) {
        this.MaLoaiKH = MaLoaiKH;
    }

    public String getTenLoaiKH() {
        return TenLoaiKH;
    }

    public void setTenLoaiKH(String TenLoaiKH) {
        this.TenLoaiKH = TenLoaiKH;
    }

    public String getUuDai() {
        return UuDai;
    }

    public void setUuDai(String UuDai) {
        this.UuDai = UuDai;
    }

    public LoaiKhachHang() {
    }

    public LoaiKhachHang(String TenLoaiKH, String UuDai) {
        this.TenLoaiKH = TenLoaiKH;
        this.UuDai = UuDai;
    }

    public LoaiKhachHang(int MaLoaiKH, String TenLoaiKH, String UuDai) {
        this.MaLoaiKH = MaLoaiKH;
        this.TenLoaiKH = TenLoaiKH;
        this.UuDai = UuDai;
    }
    
}
