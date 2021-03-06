/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Admin
 */
public class frmThongKe extends javax.swing.JFrame {

    /**
     * Creates new form frmChiTietHoaDon
     */
    public frmThongKe() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        TblThongKe = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        cbbChonNgay = new javax.swing.JComboBox<String>();
        lblTimKiem1 = new javax.swing.JLabel();
        cbbChonThang = new javax.swing.JComboBox<String>();
        lblTimKiem2 = new javax.swing.JLabel();
        cbbChonNam = new javax.swing.JComboBox<String>();
        txttongcong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TblThongKe.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        TblThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "SoHoaDon", "TenSP", "TenLoaiSP", "Ngày Tạo HD", "Số Lượng", "Thành Tiền", "Ghi Chú"
            }
        ));
        TblThongKe.setShowHorizontalLines(false);
        jScrollPane4.setViewportView(TblThongKe);
        if (TblThongKe.getColumnModel().getColumnCount() > 0) {
            TblThongKe.getColumnModel().getColumn(0).setPreferredWidth(20);
            TblThongKe.getColumnModel().getColumn(2).setPreferredWidth(125);
            TblThongKe.getColumnModel().getColumn(4).setPreferredWidth(200);
            TblThongKe.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        jPanel6.setBackground(new java.awt.Color(85, 78, 59));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 0, 4), null, null));

        jLabel9.setBackground(new java.awt.Color(212, 216, 225));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Cocktail_30px_1.png"))); // NOI18N
        jLabel9.setText("Phần Mềm Quản Lý Nhà Hàng");

        jLabel11.setBackground(new java.awt.Color(212, 216, 225));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Thống Kê");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(36, 36, 36))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        lblTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimKiem.setText("Ngày");

        cbbChonNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbChonNgayMouseClicked(evt);
            }
        });
        cbbChonNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChonNgayActionPerformed(evt);
            }
        });

        lblTimKiem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimKiem1.setText("Tháng");

        cbbChonThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbChonThangMouseClicked(evt);
            }
        });
        cbbChonThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChonThangActionPerformed(evt);
            }
        });

        lblTimKiem2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimKiem2.setText("Năm");

        cbbChonNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbChonNamMouseClicked(evt);
            }
        });
        cbbChonNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChonNamActionPerformed(evt);
            }
        });

        txttongcong.setEnabled(false);
        txttongcong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongcongActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tổng Cộng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTimKiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbChonNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimKiem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbChonThang, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimKiem2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbChonNam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttongcong, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTimKiem)
                    .addComponent(cbbChonNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimKiem1)
                    .addComponent(cbbChonThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTimKiem2)
                    .addComponent(cbbChonNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttongcong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Chắc Chắn Thoát?", //thông báo 
                "Thông Báo !", //tiêu đề 
                JOptionPane.YES_NO_OPTION, //lựa chọn 
                JOptionPane.ERROR_MESSAGE); // icon 

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //đóng chính form đang đứng 
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BLL.BLLThongKe.DoDuLieu(TblThongKe);
        BLL.BLLThongKe.DoDuLieuNgay(cbbChonNgay);
        BLL.BLLThongKe.DoDuLieuThang(cbbChonThang);
        BLL.BLLThongKe.DoDuLieuNam(cbbChonNam);
    }//GEN-LAST:event_formWindowOpened

    private void cbbChonNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbChonNgayMouseClicked
      

    }//GEN-LAST:event_cbbChonNgayMouseClicked

    private void cbbChonThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbChonThangMouseClicked
      
    }//GEN-LAST:event_cbbChonThangMouseClicked

    private void cbbChonNamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbChonNamMouseClicked
      
    }//GEN-LAST:event_cbbChonNamMouseClicked

    private void cbbChonNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChonNgayActionPerformed
       String dongDuocchon = (String) cbbChonNgay.getSelectedItem();
        BLL.BLLThongKe.TimKiemHoaDonTheoNgay(TblThongKe, dongDuocchon);
        double Dotong = BLL.BLLThongKe.DoTongTien(TblThongKe, ICONIFIED);
         txttongcong.setText(BLL.ChuyenDoi.DinhDangTien(Dotong));
    }//GEN-LAST:event_cbbChonNgayActionPerformed

    private void cbbChonThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChonThangActionPerformed
          String dongDuocchon = (String) cbbChonThang.getSelectedItem();
        BLL.BLLThongKe.TimKiemHoaDonTheoThang(TblThongKe, dongDuocchon);
        double Dotong = BLL.BLLThongKe.DoTongTien(TblThongKe, ICONIFIED);
         txttongcong.setText(BLL.ChuyenDoi.DinhDangTien(Dotong));
    }//GEN-LAST:event_cbbChonThangActionPerformed

    private void cbbChonNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChonNamActionPerformed
        // TODO add your handling code here:
          String dongDuocchon = (String) cbbChonNam.getSelectedItem();
        BLL.BLLThongKe.TimKiemHoaDonTheoNam(TblThongKe, dongDuocchon);
        double Dotong = BLL.BLLThongKe.DoTongTien(TblThongKe, ICONIFIED);
         txttongcong.setText(BLL.ChuyenDoi.DinhDangTien(Dotong));
    }//GEN-LAST:event_cbbChonNamActionPerformed

    private void txttongcongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongcongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongcongActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblThongKe;
    private javax.swing.JComboBox<String> cbbChonNam;
    private javax.swing.JComboBox<String> cbbChonNgay;
    private javax.swing.JComboBox<String> cbbChonThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JLabel lblTimKiem1;
    private javax.swing.JLabel lblTimKiem2;
    public static javax.swing.JTextField txttongcong;
    // End of variables declaration//GEN-END:variables
}
