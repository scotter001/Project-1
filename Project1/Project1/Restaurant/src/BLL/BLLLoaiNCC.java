/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOLoaiNCC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLLoaiNCC {
      public static void DoDuLieu(JTable table) {
        
        try {
            ResultSet rs = DAL.DALLoaiNCC.GetAll();
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
    }   public static DTOLoaiNCC KiemTraTenLoaiSP(String TenLoaiNCC) {
        try {
            ResultSet rs = DAL.DALLoaiNCC.GetByTenLoaiSP(TenLoaiNCC);
            if (rs.next()) {
                DTOLoaiNCC bn = new DTOLoaiNCC();
                bn.setMaLoaiNCC(rs.getInt("MaLoaiNCC"));
                bn.setTenLoaiNCC(rs.getString("TenLoaiNCC"));

                return bn;
            }
        } catch (SQLException ex) {
            GUI.frmMain.ThongBao("Thông Báo !", "Lỗi truy vấn Lấy mã Bàn !");
        }
        return null;
    }

    //2.Thêm
    public static void InsertInto(DTOLoaiNCC lncc) {
        DAL.DALLoaiNCC.Them(lncc);
    }

    //3.Sửa
    public static void Update(DTOLoaiNCC lncc) {
        DAL.DALLoaiNCC.Sua(lncc);
    }

    //4.Xóa
    public static void Delete(int MaLoaiNCC) {
        DAL.DALLoaiNCC.Xoa(MaLoaiNCC);
    }

    //Khai Báo Biến Toàn Cục (Hàm Kiểm Tra Kí Tự Đặc Biệt)
    static String TenLoaiSP_Pattern = "^[a-zÃ-ỸA-Z\\s_]{3,50}$$";
    static String TenLoaiSP_Pattern1 = "^\\s+";
    public static boolean KiemTra(String TenLoaiNCC) {
        //Hàm Khởi Tạo Kiểm Tra Sản Phẩm
        Pattern pattern = Pattern.compile(TenLoaiSP_Pattern);
        //Hàm Kiểm Tra Kí Tự Đăc Biệt
        if (!pattern.matcher(TenLoaiNCC).matches()) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Nhà Cung Cấp Không Hợp Lệ !");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenLoaiNCC.length() == 0) {
              GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Nhà Cung Cấp Không Được Để Trống !");
              return false;
        }
        if (TenLoaiNCC.length() < 3) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại nhà Cung Cấp Tối Thiểu 3 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        if (TenLoaiNCC.length() > 50) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Nhà Cung Cấp Tối Đa 50 Kí Tự");
            return false; // Lệnh thoát khỏi hàm nếu bị lỗi 
        }
        //Kiểm Tra Trùng Tên
        DTOLoaiNCC sp = BLL.BLLLoaiNCC.KiemTraTenLoaiSP(TenLoaiNCC);
        if (sp!=null) {
            GUI.frmMain.ThongBao("Thông Báo !", "Tên Loại Nhà Cung Cấp Đã Tồn Tại !");
              return false;
        }
        return true;
    }
}
