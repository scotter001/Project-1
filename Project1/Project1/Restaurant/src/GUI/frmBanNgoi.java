/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.BanNgoi;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Admin
 */
public class frmBanNgoi extends javax.swing.JFrame {

    /**
     * Creates new form frmBanNgoi
     */
    public frmBanNgoi() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBanNgoi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(85, 78, 59));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 0, 4), null, null));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(212, 216, 225));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Cocktail_30px_1.png"))); // NOI18N
        jLabel5.setText("Phần Mềm Quản Lý Nhà Hàng");

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Quản Lý Bàn Ngồi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        jPanel3.setBackground(new java.awt.Color(85, 78, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        btnThem.setBackground(new java.awt.Color(255, 153, 0));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 0, 153));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Add-icon (1).png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 153, 0));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(0, 0, 153));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/edit-tomboy-icon (1).png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 153, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(0, 0, 153));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Delete-icon (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(255, 153, 0));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(0, 0, 153));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Close-icon (1).png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnThoat)
                .addGap(36, 36, 36)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        tblBanNgoi.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblBanNgoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Bàn ", "Số Bàn ", "Trạng Thái", "Ghi Chú"
            }
        ));
        jScrollPane1.setViewportView(tblBanNgoi);
        if (tblBanNgoi.getColumnModel().getColumnCount() > 0) {
            tblBanNgoi.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblBanNgoi.getColumnModel().getColumn(1).setMinWidth(0);
            tblBanNgoi.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblBanNgoi.getColumnModel().getColumn(1).setMaxWidth(0);
            tblBanNgoi.getColumnModel().getColumn(3).setMinWidth(0);
            tblBanNgoi.getColumnModel().getColumn(3).setPreferredWidth(0);
            tblBanNgoi.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

    }//GEN-LAST:event_jPanel1MousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        new JDLThemBanNgoi(this, true).setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(), 
               "Bạn Có Chắc Chắn Thoát ?", //thông báo 
               "Thông Báo !",  //tiêu đề 
               JOptionPane.YES_NO_OPTION , //lựa chọn 
               JOptionPane.ERROR_MESSAGE); // icon 
        
       if(ketquasaukhibam == JOptionPane.YES_OPTION) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //đóng chính form đang đứng 
        }else {this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);}
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BLL.BLLBanNgoi.DoDuLieu(tblBanNgoi);
    }//GEN-LAST:event_formWindowOpened

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       int dongduocchon = tblBanNgoi.getSelectedRow();
        if(dongduocchon < 0){
            GUI.frmMain.ThongBao("Thông Báo !", "Bạn Chưa Chọn Sản Phẩm !");
            return ;
        }
        int MaBan = Integer.parseInt(tblBanNgoi.getValueAt(dongduocchon, 1).toString());

        BanNgoi BN = BLL.BLLBanNgoi.LayDuaVaoMa(MaBan);

        int dongduocchon1 = tblBanNgoi.getSelectedRow();
        int MaSp = Integer.parseInt(tblBanNgoi.getValueAt(dongduocchon1,1).toString()) ;
        String SoBan = tblBanNgoi.getValueAt(dongduocchon1,2).toString() ;
//        String TrangThai = tblBanNgoi.getValueAt(dongduocchon1, 3).toString();
        String GhiChu = tblBanNgoi.getValueAt(dongduocchon1,4).toString() ;
        //truoc khi do vao
        new JDLThemBanNgoi(MaBan, SoBan, GhiChu).setVisible(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        //Lấy các dòng đc chọn
        int cacdongduocchon[] = tblBanNgoi.getSelectedRows();
        if (cacdongduocchon.length < 1) {
            GUI.frmMain.ThongBao("Thông Báo !", "Chưa Chọn Dòng Để Xóa !");
            return;//Thoát
        }
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(), 
               "Bạn Có Muốn Xóa Không ?", //thông báo 
               "Thông Báo !",  //tiêu đề 
               JOptionPane.YES_NO_OPTION , //lựa chọn 
               JOptionPane.ERROR_MESSAGE); // icon 
        
       if(ketquasaukhibam == JOptionPane.YES_OPTION) {
     
        //dùng vòng lặp
        for (int i = 0; i < cacdongduocchon.length; i++) {
            int dong = cacdongduocchon[i];
            int macanxoa = Integer.parseInt(tblBanNgoi.getValueAt(dong, 1).toString());
            BLL.BLLBanNgoi.Delete(macanxoa);
        }
        //sau khi xóa đổ lại dữ liệu
         BLL.BLLBanNgoi.DoDuLieu(tblBanNgoi);
       }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
         int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(), 
               "Bạn Có Muốn Thoát Không ?", //thông báo 
               "Thông Báo !",  //tiêu đề 
               JOptionPane.YES_NO_OPTION , //lựa chọn 
               JOptionPane.ERROR_MESSAGE); // icon 
        
       if(ketquasaukhibam == JOptionPane.YES_OPTION) {
        this.setVisible(false); //đóng chính form đang đứng 
       }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        BLL.BLLBanNgoi.TimBanNgoiTheoTuKhoa(tblBanNgoi, txtTimKiem.getText().trim());
    }//GEN-LAST:event_txtTimKiemKeyReleased

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
            java.util.logging.Logger.getLogger(frmBanNgoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBanNgoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBanNgoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBanNgoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBanNgoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblBanNgoi;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}