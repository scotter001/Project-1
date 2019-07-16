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
public class BanNgoi {
    int MaBan ;
    String SoBan ; //30
    int TrangThai ; //30
    String GhiChu ; //255

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
    }

    public String getSoBan() {
        return SoBan;
    }

    public void setSoBan(String SoBan) {
        this.SoBan = SoBan;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

   

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public BanNgoi() {
    }

    public BanNgoi(int MaBan, int TrangThai) {
        this.MaBan = MaBan;
        this.TrangThai = TrangThai;
    }

    
    
    public BanNgoi(String SoBan, int TrangThai, String GhiChu) {
        this.SoBan = SoBan;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public BanNgoi(int MaBan, String SoBan, int TrangThai, String GhiChu) {
        this.MaBan = MaBan;
        this.SoBan = SoBan;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    
    
}
