/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.LoaiSanPham;
import DTO.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLLoaiSanPham {

    public static void DoDuLieu(JTable table) {
        
        try {
            ResultSet rs = DAL.DALLoaiSanPham.GetAll();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.setRowCount(0); //Xóa dữ liệu cũ trong Table
            while (rs.next()) {
                Object obj[] = new Object[3];
                obj[0] = tableModel.getRowCount() + 1;
                obj[1] = rs.getString(1);
                obj[2] = rs.getString(2);

                //Thêm obj vào tableModel
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn dữ liệu Sản Phẩm !");
        }
    }   public static LoaiSanPham KiemTraTenLoaiSP(String TenLoaiSP) {
        try {
            ResultSet rs = DAL.DALLoaiSanPham.GetByTenLoaiSP(TenLoaiSP);
            if (rs.next()) {
                LoaiSanPham bn = new LoaiSanPham();
                bn.setMaLoaiSP(rs.getInt("MaLoaiSP"));
                bn.setTenLoaiSP(rs.getString("TenLoaiSP"));

                return bn;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn Lấy mã Bàn !");
        }
        return null;
    }

    //2.Thêm
    public static void InsertInto(LoaiSanPham LSP) {
        DAL.DALLoaiSanPham.Them(LSP);
    }

    //3.Sửa
    public static void Update(LoaiSanPham LSP) {
        DAL.DALLoaiSanPham.Sua(LSP);
    }

    //4.Xóa
    public static void Delete(int MaLoaiSP) {
        DAL.DALLoaiSanPham.Xoa(MaLoaiSP);
    }

   //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String TenLoaiSP_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String daucach = "^\\s+";

    public static boolean KiemTra(String TenLoaiSP) {
        if (TenLoaiSP.length() == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Không Được Để Trống !");
            return false;
        }
        Pattern pattern1 = Pattern.compile(daucach);
        if (pattern1.matcher(TenLoaiSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Không Được Để Khoảng Trắng Hoặc chứa kí tự đặc biệt !");
            return false;
        }
//Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(TenLoaiSP_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenLoaiSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }

        if (TenLoaiSP.length() < 5) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Tối Thiểu 5 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenLoaiSP.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Tối Đa 50 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        //Kiểm Tra Trùng Tên
        LoaiSanPham sp = BLL.BLLLoaiSanPham.KiemTraTenLoaiSP(TenLoaiSP);
        if (sp != null) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Đã Tồn Tại !");
            return false;
        }
        return true;
    }
        public static boolean KiemTraSua(String TenLoaiSP) {
        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(TenLoaiSP_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenLoaiSP).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenLoaiSP.length() == 0) {
              GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Không Được Để Trống !");
              return false;
        }
        if (TenLoaiSP.length() < 5) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Tối Thiểu 5 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenLoaiSP.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Sản Phẩm Tối Đa 50 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        return true;
    }
}
