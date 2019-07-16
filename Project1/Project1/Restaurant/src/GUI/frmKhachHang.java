/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.KhachHang;
import DTO.LoaiKhachHang;
import DTO.LoaiSanPham;
import static GUI.frmSanPham.tblSanPham;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class frmKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form frmKhachHang
     */
    public frmKhachHang() {
        initComponents();
        FillBan();
    }
    private void FillBan() {
//        selectBan = 0;
//        trangThaiBan = 0;
//        tenBan = "";
//        soHoaDon = "";
//        idChiTietHoaDon = 0;
//        idThucDon = 0;
//        soLuong = 0;
        pnlLoaiKH.removeAll();
        
        DefaultTableModel dtm = (DefaultTableModel) tblKhachHang.getModel();
        dtm.setRowCount(0);

        ArrayList<LoaiKhachHang> ban = DAL.DALLoaiKhachHang.getAllLoaiKhachHang();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[ban.size()];
        JLabel[] lblImgBan = new JLabel[ban.size()];
        JLabel[] lblTenBan = new JLabel[ban.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < ban.size(); i++) {
            checkclick.add(i, false);
            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
//            switch (ban.get(i).getMaLoaiSP()) {
//                case 1:
//                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px.png"))); // NOI18N
//                    break;
//                case 2:
//                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px_2.png"))); // NOI18N
//                    break;
//                case 3:
//                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px_3.png"))); // NOI18N
//                    break;
//                default:
//                    break;
//            }
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(ban.get(i).getTenLoaiKH());

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(21, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImgBan[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTenBan[i])
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            int j = i;
            pnlBan[j].addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    if (checkclick.get(j)) {
                         checkclick.set(j, false);                                               
                            
                            
                           e.getComponent().setBackground(Color.yellow);
                    }else{
                         checkclick.set(j, true); 
                          //BanNgoi BN = BLL.BLLBanNgoi.LayDuaVaoMa(ban.get(j).getMaBan());
//                          BLL.BLLBanNgoi.SetCBBBanNgoi(cbbBanNgoi, ban.get(j).getMaBan());
                           BLL.BLLKhachHang.DoDuLieuLoaiKH(tblKhachHang, ban.get(j).getMaLoaiKH());
                            for (int k = 0; k < ban.size(); k++) {
                            if (k != j) {
                                checkclick.set(k, false);
                                pnlBan[k].setBackground(new java.awt.Color(240, 240, 240));
                            }
                        }
                         }
                }
                //hover
                  @Override
                public void mouseEntered(MouseEvent e) {
                    e.getComponent().setBackground(Color.yellow);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        e.getComponent().setBackground(Color.yellow);
                    } else {

                        e.getComponent().setBackground(new java.awt.Color(240, 240, 240));
                    }
                }
            });
             pnlLoaiKH.add(pnlBan[i]);
        }
        pnlLoaiKH.updateUI();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlLoaiKH = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnLoaiNCC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(85, 78, 59));
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(63, 0, 4), null, null));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
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
        jLabel2.setText("Quản Lý Thực Đơn");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(36, 36, 36))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 429, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        pnlLoaiKH.setBackground(new java.awt.Color(85, 78, 56));
        pnlLoaiKH.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)), "Nhóm Loại Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(85, 78, 59));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
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
                        .addComponent(btnSua)
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );

        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã KH", "Tên KH", "Địa Chỉ", "Giới Tính", "Điện Thoại", "Mã Loại KH", "Ghi Chú"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblKhachHang.getColumnModel().getColumn(1).setMinWidth(0);
            tblKhachHang.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblKhachHang.getColumnModel().getColumn(1).setMaxWidth(0);
            tblKhachHang.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblKhachHang.getColumnModel().getColumn(4).setMinWidth(0);
            tblKhachHang.getColumnModel().getColumn(4).setPreferredWidth(0);
            tblKhachHang.getColumnModel().getColumn(4).setMaxWidth(0);
            tblKhachHang.getColumnModel().getColumn(6).setMinWidth(0);
            tblKhachHang.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblKhachHang.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        btnLoaiNCC.setBackground(new java.awt.Color(255, 153, 0));
        btnLoaiNCC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLoaiNCC.setForeground(new java.awt.Color(0, 0, 153));
        btnLoaiNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Cherry_30px.png"))); // NOI18N
        btnLoaiNCC.setText("Thêm Loại KH");
        btnLoaiNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLoaiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoaiNCC)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged

    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed

    }//GEN-LAST:event_jPanel4MousePressed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int dongduocchon = tblKhachHang.getSelectedRow();
        if(dongduocchon < 0){
            GUI.frmMain.ThongBao("Thông Báo !", "Bạn Chưa Chọn Sản Phẩm !");
            return ;
        }
        int MaKH = Integer.parseInt(tblKhachHang.getValueAt(dongduocchon, 1).toString());

        KhachHang SP = BLL.BLLKhachHang.LayDuaVaoMaKH(MaKH);

        int dongduocchon1 = tblKhachHang.getSelectedRow();
        int MaKh = Integer.parseInt(tblKhachHang.getValueAt(dongduocchon1,1).toString()) ;
        String TenKH = tblKhachHang.getValueAt(dongduocchon1,2).toString() ;
        String DiaChi = tblKhachHang.getValueAt(dongduocchon1,3).toString() ;
        
        String DienThoai = tblKhachHang.getValueAt(dongduocchon1, 5).toString();
        String GhiChu = tblKhachHang.getValueAt(dongduocchon1, 7).toString();
        //truoc khi do vao
        new JDLThemKhachHang(MaKh, TenKH, DiaChi, DienThoai, GhiChu).setVisible(true);
    
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        //Lấy các dòng đc chọn
      
        int cacdongduocchon[] = tblKhachHang.getSelectedRows();
        if (cacdongduocchon.length < 1) {
            GUI.frmMain.ThongBao("Thông báo !", "Chưa Chọn Dòng Để Xóa !");
            return;//Thoát
        }
        GUI.frmMain.ThongBao("Thông báo !", "thông tin của khách hàng này liên quan đến hóa đơn , có thể không xóa được !");
        //dùng vòng lặp
        for (int i = 0; i < cacdongduocchon.length; i++) {
            int dong = cacdongduocchon[i];
            int macanxoa = Integer.parseInt(tblKhachHang.getValueAt(dong, 1).toString());
            BLL.BLLKhachHang.Delete(macanxoa);
        }
        GUI.frmMain.ThongBao("Thông báo", "Xóa Thành Công");
        //sau khi xóa đổ lại dữ liệu
        BLL.BLLKhachHang.DoDuLieu(tblKhachHang);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        new JDLThemKhachHang(this,true).setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        //        int dongduocchon = tblSanPham.getSelectedRow();
        //        if(dongduocchon < 0){
            //            GUI.frmMain.ThongBao("Thông Báo", "Bạn Chưa Chọn Sản Phẩm");
            //            return ;
            //        }
        //        int MaSP = Integer.parseInt(tblSanPham.getValueAt(dongduocchon, 1).toString());
        //
        //        ThucDon TD = BLL.BLLThucDon.LayDuaVaoMaMon(MaMon);
        //
        //        int dongduocchon1 = tblThucDon.getSelectedRow();
        //        int maMon = Integer.parseInt(tblThucDon.getValueAt(dongduocchon1,0).toString()) ;
        //        String TenMon = tblThucDon.getValueAt(dongduocchon1,2).toString() ;
        //        double GiaTien = Double.parseDouble(tblThucDon.getValueAt(dongduocchon1,3).toString()) ;
        //        String GhiChu = tblThucDon.getValueAt(dongduocchon1,3).toString() ;
        //        //truoc khi do vao
        //        new JDLThemMon(maMon, TenMon, GiaTien, GhiChu).setVisible(true);
        //        int ketqua = JOptionPane.showConfirmDialog(this, pnl , "nhập số lượng , ghi chú", JOptionPane.OK_CANCEL_OPTION);
        //
        //        if(ketqua == JOptionPane.YES_OPTION){
            //
            //                        int SoLuong = (int) pnl.spnSoLuong.getValue();
            //                        String GhiChu = pnl.txtGhiChu.getText();
            //
            //                        if(SoLuong < 1){
                //                                GUI.frmMain.ThongBao("Loi", "So Luong Phai Lon Hon 1");
                //                                return ;
                //                            }
            //
            //                       double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDon(TblChiTietHoaDon, sp , SoLuong , GhiChu);
            //
            //                       TxtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));
            //        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BLL.BLLKhachHang.DoDuLieu(tblKhachHang);
    }//GEN-LAST:event_formWindowOpened

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
        BLL.BLLKhachHang.TimKhachHangTheoTuKhoa(tblKhachHang, txtTimKiem.getText().trim());
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnLoaiNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiNCCActionPerformed
        new JDLLoaiKH(this, true).setVisible(true);
        FillBan();
        BLL.BLLKhachHang.DoDuLieu(tblKhachHang);
    }//GEN-LAST:event_btnLoaiNCCActionPerformed

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
            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoaiNCC;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlLoaiKH;
    public static javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
