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
public class NhanVien {

    int MaNV;
    String TenNV; //50 
    String NgaySinh;
    String NgayVaoLam;
    String GioiTinh;
    double Luong;
    String SoCMND; //9 
    String DiaChi; // 50
    String DienThoai; //10
    int MaQuyen;
    String TenDangNhap; //50
    String MatKhau; // 50 

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String SoCMND) {
        this.SoCMND = SoCMND;
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

    public int getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(int MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public NhanVien(int MaNV, String TenDangNhap, String MatKhau) {
        this.MaNV = MaNV;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public NhanVien(String TenNV, String TenDangNhap, String MatKhau) {
        this.TenNV = TenNV;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public NhanVien() {
    }

    public NhanVien(String TenNV, String NgaySinh, String NgayVaoLam, String GioiTinh, double Luong, String SoCMND, String DiaChi, String DienThoai, int MaQuyen, String TenDangNhap, String MatKhau) {
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.GioiTinh = GioiTinh;
        this.Luong = Luong;
        this.SoCMND = SoCMND;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.MaQuyen = MaQuyen;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }

    public NhanVien(int MaNV, String TenNV, String NgaySinh, String NgayVaoLam, String GioiTinh, double Luong, String SoCMND, String DiaChi, String DienThoai, int MaQuyen, String TenDangNhap, String MatKhau) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.GioiTinh = GioiTinh;
        this.Luong = Luong;
        this.SoCMND = SoCMND;
        this.DiaChi = DiaChi;
        this.DienThoai = DienThoai;
        this.MaQuyen = MaQuyen;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
    }


}
