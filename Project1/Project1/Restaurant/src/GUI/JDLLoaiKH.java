/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.DTOLoaiNCC;
import DTO.LoaiKhachHang;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class JDLLoaiKH extends javax.swing.JDialog {

    /**
     * Creates new form JDLLoaiKH
     */
    public JDLLoaiKH(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        btlLoaiKH = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnThem2 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        btnXoa3 = new javax.swing.JButton();
        btnThoat2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        txtTenLoaiKH = new javax.swing.JTextField();
        lblMaSP1 = new javax.swing.JLabel();
        txtMaLoaiKH = new javax.swing.JTextField();
        lblMaLoaiSP1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        lblMaSP2 = new javax.swing.JLabel();
        txtUuDai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btlLoaiKH.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btlLoaiKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Loại KH", "Tên Loại KH", "Ưu Đãi"
            }
        ));
        btlLoaiKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlLoaiKHMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(btlLoaiKH);

        jPanel10.setBackground(new java.awt.Color(85, 78, 56));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        btnThem2.setBackground(new java.awt.Color(255, 153, 0));
        btnThem2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem2.setForeground(new java.awt.Color(0, 0, 153));
        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Add-icon (1).png"))); // NOI18N
        btnThem2.setText("Thêm");
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnSua2.setBackground(new java.awt.Color(255, 153, 0));
        btnSua2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua2.setForeground(new java.awt.Color(0, 0, 153));
        btnSua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/edit-tomboy-icon (1).png"))); // NOI18N
        btnSua2.setText("Sửa");
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        btnXoa3.setBackground(new java.awt.Color(255, 153, 0));
        btnXoa3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa3.setForeground(new java.awt.Color(0, 0, 153));
        btnXoa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Delete-icon (1).png"))); // NOI18N
        btnXoa3.setText("Xóa");
        btnXoa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa3ActionPerformed(evt);
            }
        });

        btnThoat2.setBackground(new java.awt.Color(255, 153, 0));
        btnThoat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThoat2.setForeground(new java.awt.Color(0, 0, 153));
        btnThoat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Close-icon (1).png"))); // NOI18N
        btnThoat2.setText("Thoát");
        btnThoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem2)
                .addGap(18, 18, 18)
                .addComponent(btnSua2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat2)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat2))
        );

        jPanel8.setBackground(new java.awt.Color(85, 78, 59));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 0, 4), null, null));
        jPanel8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel8MouseDragged(evt);
            }
        });
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(212, 216, 225));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 0));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Cocktail_30px_1.png"))); // NOI18N
        jLabel26.setText("Phần Mềm Quản Lý Nhà Hàng");

        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(36, 36, 36))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27))
        );

        jPanel11.setBackground(new java.awt.Color(85, 78, 56));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)), "Loại SP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N
        jPanel11.setForeground(new java.awt.Color(0, 0, 153));

        lblMaSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaSP1.setForeground(new java.awt.Color(255, 255, 0));
        lblMaSP1.setText("Tên Loại KH");

        txtMaLoaiKH.setEnabled(false);

        lblMaLoaiSP1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaLoaiSP1.setForeground(new java.awt.Color(255, 255, 0));
        lblMaLoaiSP1.setText("Mã Loại KH");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 0));
        jLabel30.setText("Tìm Kiếm");

        lblMaSP2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMaSP2.setForeground(new java.awt.Color(255, 255, 0));
        lblMaSP2.setText("Ưu Đãi");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaLoaiSP1)
                    .addComponent(lblMaSP1)
                    .addComponent(lblMaSP2)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenLoaiKH)
                    .addComponent(txtMaLoaiKH, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(txtUuDai)
                    .addComponent(txtTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaLoaiSP1)
                    .addComponent(txtMaLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSP1)
                    .addComponent(txtTenLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUuDai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSP2))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btlLoaiKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlLoaiKHMouseClicked
        int dongduocchon = btlLoaiKH.getSelectedRow();
        txtMaLoaiKH.setText(btlLoaiKH.getValueAt(dongduocchon, 1).toString());
        txtTenLoaiKH.setText(btlLoaiKH.getValueAt(dongduocchon, 2).toString());
        txtUuDai.setText(btlLoaiKH.getValueAt(dongduocchon, 3).toString());
    }//GEN-LAST:event_btlLoaiKHMouseClicked

    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed
        String TenLoaiNCC = txtTenLoaiKH.getText().trim();
        String uudai = txtUuDai.getText().trim();
        if (TenLoaiNCC.trim().equals("")) { //trim() Cắt Khoảng Trắng Trước Và Sau Chuỗi
            JOptionPane.showMessageDialog(new JFrame(), "Mời Bạn Phải Điền Thông Tin Vào Bảng Trước !");
            return; //Nếu Vào Đây Thì Thoát Khỏi Hàm
        }
        if (BLL.BLLLoaiKH.KiemTra(TenLoaiNCC)) {
            DTO.LoaiKhachHang lncc = new LoaiKhachHang(TenLoaiNCC, uudai);
            BLL.BLLLoaiKH.InsertInto(lncc);
        }
        //Đổ Lại Dữ Liệu Sau Khi Thêm
        BLL.BLLLoaiKH.DoDuLieu(btlLoaiKH);
    }//GEN-LAST:event_btnThem2ActionPerformed

    private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
        String TenLoaiNCC = txtTenLoaiKH.getText().trim();
        String uudai = txtUuDai.getText().trim();
        if (TenLoaiNCC.trim().equals("")) { //trim() Cắt Khoảng Trắng Trước Và Sau Chuỗi
            JOptionPane.showMessageDialog(new JFrame(), "Mời Bạn Phải Điền Thông Tin Vào Bảng Trước !");
            return; //Nếu Vào Đây Thì Thoát Khỏi Hàm
        }
        if (BLL.BLLLoaiKH.KiemTra(TenLoaiNCC)) {
            int MaLoaiKH = Integer.parseInt(txtMaLoaiKH.getText());
            DTO.LoaiKhachHang lncc = new LoaiKhachHang(MaLoaiKH, TenLoaiNCC, uudai);
            BLL.BLLLoaiKH.Update(lncc);
        }
        //Đổ Lại Dữ Liệu Sau Khi Thêm
        BLL.BLLLoaiKH.DoDuLieu(btlLoaiKH);
    }//GEN-LAST:event_btnSua2ActionPerformed

    private void btnXoa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa3ActionPerformed
        //Lấy các dòng đc chọn
        int cacdongduocchon[] = btlLoaiKH.getSelectedRows();

        if (cacdongduocchon.length < 1) {
            GUI.frmMain.ThongBao("Thông Báo !", "Chưa Chọn Dòng Để Xóa !");
            return;//Thoát
        }
        //dùng vòng lặp
        for (int i = 0; i < cacdongduocchon.length; i++) {
            int dong = cacdongduocchon[i];
            int macanxoa = Integer.parseInt(btlLoaiKH.getValueAt(dong, 1).toString());

            BLL.BLLLoaiKH.Delete(macanxoa);
        }
        //sau khi xóa đổ lại dữ liệu
        BLL.BLLLoaiKH.DoDuLieu(btlLoaiKH);
    }//GEN-LAST:event_btnXoa3ActionPerformed

    private void btnThoat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnThoat2ActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jPanel8MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseDragged

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BLL.BLLLoaiKH.DoDuLieu(btlLoaiKH);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(JDLLoaiKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDLLoaiKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDLLoaiKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDLLoaiKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDLLoaiKH dialog = new JDLLoaiKH(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable btlLoaiKH;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnThoat2;
    private javax.swing.JButton btnXoa3;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMaLoaiSP1;
    private javax.swing.JLabel lblMaSP1;
    private javax.swing.JLabel lblMaSP2;
    private javax.swing.JTextField txtMaLoaiKH;
    private javax.swing.JTextField txtTenLoaiKH;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtUuDai;
    // End of variables declaration//GEN-END:variables
}
