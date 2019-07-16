/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DBConection {
    //Tạo chuỗi kết nối
    String connnectionString = "jdbc:sqlserver://localhost:1433;databaseName=Restauran;"
            + "user=sa;password=123456;" ;
    //Tạo biến kết nối CSDL
    public static  Connection conn;
    public DBConection() {
        try {
            //Đăng ký JDBC Driver
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //Lấy kết nối dựa vào chuỗi kết nối
            conn = DriverManager.getConnection(connnectionString);
            //Kiểm tra kết nối
            if(conn!=null){
                System.out.println("Kết nối CSDL thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi đăng ký JDBC." + ex.getMessage());
        }

    }
    
    //Hàm xử lý câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable (String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Lỗi truy vấn. " + ex.getMessage());
        }
        return null;
    }
    //Hàm xử lý câu lệnh INSERT, UPDATE, DELETE
    public void ExcuteQueryUpdateDB (String cauTruyVanSQL){       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {           
            System.out.println("Lỗi truy vấn. "+ ex.getMessage());
        }
    }
}
