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
public class DTOLoaiNCC {
   int MaLoaiNCC ;
   String TenLoaiNCC ; //50

    public int getMaLoaiNCC() {
        return MaLoaiNCC;
    }

    public void setMaLoaiNCC(int MaLoaiNCC) {
        this.MaLoaiNCC = MaLoaiNCC;
    }

    public String getTenLoaiNCC() {
        return TenLoaiNCC;
    }

    public void setTenLoaiNCC(String TenLoaiNCC) {
        this.TenLoaiNCC = TenLoaiNCC;
    }

    public DTOLoaiNCC() {
    }

    public DTOLoaiNCC(String TenLoaiNCC) {
        this.TenLoaiNCC = TenLoaiNCC;
    }

    public DTOLoaiNCC(int MaLoaiNCC, String TenLoaiNCC) {
        this.MaLoaiNCC = MaLoaiNCC;
        this.TenLoaiNCC = TenLoaiNCC;
    }
   
}
