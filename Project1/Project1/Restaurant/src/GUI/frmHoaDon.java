/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLHoaDon;
import DAL.DBConection;
import DTO.BanNgoi;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.LoaiSanPham;
import DTO.MyCombobox;
import DTO.SanPham;
import static GUI.JDLChiTietHD.spnSoLuong;
import static GUI.JDLChiTietHD.txtGhiChu;
import static GUI.JDLChuyenBan.cbbBanChuyen;
import static GUI.frmSanPham.tblSanPham;
import com.itextpdf.text.pdf.codec.Base64;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Admin
 */
public class frmHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form frmHoaDon
     */
    public frmHoaDon() {
        initComponents();
        FillBan();
        NgayGio();
        FillMon();
    }

    public void NgayGio() {
        Thread clock;
        clock = new Thread() {
            @Override
            public void run() {
                while (true) {
                    SimpleDateFormat formattime = new SimpleDateFormat("hh:mm:ss");
                    SimpleDateFormat formatday = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar cal = new GregorianCalendar();
                    String time, day;
                    time = formattime.format(cal.getTime());
                    day = formatday.format(cal.getTime());

//                    String soHoaDon;        
//                     
//                       
//                    soHoaDon = "HD" + formattime.format(time);
//                    TxtTenHoaDon.setText("HD00" + time);
                    LblGioChay.setText(time);
                    TxtNgayTaoHD.setText(day);
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        };
        clock.start();
    }

    private void FillBan() {
//        selectBan = 0;
//        trangThaiBan = 0;
//        tenBan = "";
//        soHoaDon = "";
//        idChiTietHoaDon = 0;
//        idThucDon = 0;
//        soLuong = 0;
        pnlBanNgoi.removeAll();

//        DefaultTableModel dtm = (DefaultTableModel) tblThucDonHD.getModel();
//        dtm.setRowCount(0);
        ArrayList<BanNgoi> ban = DAL.DALBanNgoi.getAllBan();
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
            switch (ban.get(i).getTrangThai()) {
                case 1:
                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px_3.png"))); // NOI18N
                    break;
                case 2:
                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px.png"))); // NOI18N
                    break;
                case 3:
                    lblImgBan[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Restaurant Table_60px_2.png"))); // NOI18N
                    break;
                default:
                    break;
            }
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(ban.get(i).getSoBan());

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        DefaultTableModel dtm = (DefaultTableModel) TblChiTietHoaDon.getModel();
                        dtm.setRowCount(0);
                    } else {
                        checkclick.set(j, true);
                        //BanNgoi BN = BLL.BLLBanNgoi.LayDuaVaoMa(ban.get(j).getMaBan());
                        BLL.BLLBanNgoi.SetCBBBanNgoi(cbbBanNgoi, ban.get(j).getMaBan());

                        DefaultTableModel dtm = (DefaultTableModel) TblChiTietHoaDon.getModel();
                        switch (ban.get(j).getTrangThai()) {
                            case 1:

                                dtm.setRowCount(0);
                                TxtTongTien.setText("0");
                                TxtTienDu.setText("0");
                                TxtTienKhachTra.setText("0");
                                TxtTenHoaDon.setText("");
                                BtnDatMon.setVisible(true);
                                GUI.frmMain.ThongBao("Thông báo !", "bạn chưa đặt món");
//                                btnChuyenBan.setVisible(false);
                                break;
                            case 2:

                                BLLHoaDon.DoDuLieuLaiChoCTHD(TblChiTietHoaDon, ban.get(j).getMaBan());

                                HoaDon hd = BLL.BLLHoaDon.LayHDDuaVaoMaBan(ban.get(j).getMaBan());

                                TxtTenHoaDon.setText(hd.getSoHoaDon());
                                BtnDatMon.setVisible(true);
//                                btnChuyenBan.setVisible(true);
//                                TxtNgayTaoHD.setText("NgayTaoHD");
//                                BLL.BLLHoaDon.SetCBBNhanVien(CbbNhanVienBanHang, hd.getMaNV());
//                                CbbTrangThai.setSelectedItem(hd.getTinhTrang());
                                if (TxtTongTien.getText().trim().equals("")) {
                                    GUI.frmMain.ThongBao("Thông báo !", "chưa có Tổng Tiền");
                                } else {
                                    TxtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(hd.getTongTien()));
                                }

//                                BLL.BLLHoaDon.SetCBBKhachHang(cbbKhachHang, hd.getMaKH());
//                                ResultSet rsGetChiTietThucDonBySoHoaDon = BLLHoaDon.getChiTietThucDonBySoHoaDon(MaHD);
                                break;
//                            case 3:
//                                dtm.setRowCount(0);
//                                TxtTongTien.setText("0");
//                                TxtTienDu.setText("0");
//                                TxtTienKhachTra.setText("0");
//                                TxtTenHoaDon.setText("");
//                                BtnDatMon.setVisible(true);
//                                GUI.frmMain.ThongBao("Thông báo !", "bạn chưa đặt món");
////                                btnChuyenBan.setVisible(false);
//                                //ResultSet rsGetAllThucDon = ThucDonBLL.getAllThucDon();
//                                //ThucDonBLL.doDuLieuVaoBang(rsGetAllThucDon, tblGoiMon);
//                                break;
                            default:
                                break;
                        }

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

                @Override
                public void mouseReleased(MouseEvent e) {
                    MyCombobox bb = (MyCombobox) cbbBanNgoi.getSelectedItem();
                    // Lấy mã phần tử được chọn mb.Value 
                    int MaBann = Integer.parseInt(bb.Value.toString());
//                  ResultSet rs = DAL.DALBanNgoi.GetByTrangThai(MaBann);
                    ResultSet rss = BLL.BLLHoaDon.getTrangThaiCuaBan(MaBann);
                    try {
                        while (rss.next()) {
                            if (rss.getInt("TrangThai") == 2) {
                                if (e.isPopupTrigger() && e.getComponent() instanceof JPanel) {
                                    pmnChuyenBan.show(e.getComponent(), e.getX(), e.getY());
                                }
                                HoaDon hd = BLL.BLLHoaDon.LayHDDuaVaoMaBan(ban.get(j).getMaBan());
                                TxtTenHoaDon.setText(hd.getSoHoaDon());
                                BLLHoaDon.DoDuLieuLaiChoCTHD(TblChiTietHoaDon, ban.get(j).getMaBan());
                                TxtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(hd.getTongTien()));
                            }
                        }
                    } catch (SQLException ex) {
//             GUI.frmMain.ThongBao("Thông báo", "Bàn này đã có người ngồi");

                    }

                }

            });
            pnlBanNgoi.add(pnlBan[i]);
        }
        pnlBanNgoi.updateUI();
    }

    private void FillMon() {

        pnlLoaiSP.removeAll();

        DefaultTableModel dtm = (DefaultTableModel) tblThucDonHD.getModel();
        dtm.setRowCount(0);

        ArrayList<LoaiSanPham> ban = DAL.DALLoaiSanPham.getAllLoaiSanPham();
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
            lblTenBan[i].setText(ban.get(i).getTenLoaiSP());

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(15, Short.MAX_VALUE))
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
                    } else {
                        checkclick.set(j, true);
                        //BanNgoi BN = BLL.BLLBanNgoi.LayDuaVaoMa(ban.get(j).getMaBan());
//                          BLL.BLLBanNgoi.SetCBBBanNgoi(cbbBanNgoi, ban.get(j).getMaBan());
                        BLL.BLLHoaDon.DoDuLieuLoaiSPChoHD(tblThucDonHD, ban.get(j).getMaLoaiSP());
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
            pnlLoaiSP.add(pnlBan[i]);
        }
        pnlLoaiSP.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pmnChonMon = new javax.swing.JPopupMenu();
        mniChon = new javax.swing.JMenuItem();
        pmnHuyMon = new javax.swing.JPopupMenu();
        mniXoaMon = new javax.swing.JMenuItem();
        pmnChuyenBan = new javax.swing.JPopupMenu();
        mniChuyenBan = new javax.swing.JMenuItem();
        jPanel11 = new javax.swing.JPanel();
        pnlBanNgoi = new javax.swing.JPanel();
        PnlTTSanPham = new javax.swing.JPanel();
        LblTimKiemTTSP = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThucDonHD = new javax.swing.JTable();
        btnTatCa = new javax.swing.JButton();
        pnlLoaiSP = new javax.swing.JPanel();
        LblGioChay = new javax.swing.JLabel();
        PnlTTHoaDon = new javax.swing.JPanel();
        PnlTTHoaDon1 = new javax.swing.JPanel();
        LblSoHoaDon = new javax.swing.JLabel();
        TxtTenHoaDon = new javax.swing.JTextField();
        LblNgayTaoHoaDon = new javax.swing.JLabel();
        LblNVBanHang = new javax.swing.JLabel();
        TxtNgayTaoHD = new javax.swing.JTextField();
        CbbNhanVienBanHang = new javax.swing.JComboBox<Object>();
        PnlTongTienHD = new javax.swing.JPanel();
        LblTongTien = new javax.swing.JLabel();
        TxtTongTien = new javax.swing.JTextField();
        LblTienKhachTra = new javax.swing.JLabel();
        TxtTienKhachTra = new javax.swing.JTextField();
        LblTienDu = new javax.swing.JLabel();
        TxtTienDu = new javax.swing.JTextField();
        PnlTTKhachHang = new javax.swing.JPanel();
        lblTenBan = new javax.swing.JLabel();
        cbbBanNgoi = new javax.swing.JComboBox<Object>();
        lblTenBan1 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<String>();
        PnlTongTienHD1 = new javax.swing.JPanel();
        BtnDatMon = new javax.swing.JButton();
        BtnThanhToan = new javax.swing.JButton();
        PnlChiTietHoaDon = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblChiTietHoaDon = new javax.swing.JTable();

        mniChon.setText("Chọn");
        mniChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mniChonMouseClicked(evt);
            }
        });
        mniChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChonActionPerformed(evt);
            }
        });
        pmnChonMon.add(mniChon);

        mniXoaMon.setText("Hủy ");
        mniXoaMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaMonActionPerformed(evt);
            }
        });
        pmnHuyMon.add(mniXoaMon);

        mniChuyenBan.setText("Chuyển Bàn");
        mniChuyenBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mniChuyenBanMousePressed(evt);
            }
        });
        pmnChuyenBan.add(mniChuyenBan);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bán Hàng");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        pnlBanNgoi.setBackground(new java.awt.Color(85, 78, 56));
        pnlBanNgoi.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)), "Quản Lý Bàn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        PnlTTSanPham.setBackground(new java.awt.Color(85, 78, 56));
        PnlTTSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0)), "Menu", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        LblTimKiemTTSP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblTimKiemTTSP.setForeground(new java.awt.Color(255, 255, 0));
        LblTimKiemTTSP.setText("Tìm Nhanh");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        tblThucDonHD.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblThucDonHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Món", "Tên Món", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pmnChonMon, org.jdesktop.beansbinding.ObjectProperty.create(), tblThucDonHD, org.jdesktop.beansbinding.BeanProperty.create("componentPopupMenu"));
        bindingGroup.addBinding(binding);

        tblThucDonHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThucDonHDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblThucDonHD);
        if (tblThucDonHD.getColumnModel().getColumnCount() > 0) {
            tblThucDonHD.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblThucDonHD.getColumnModel().getColumn(1).setMinWidth(0);
            tblThucDonHD.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblThucDonHD.getColumnModel().getColumn(1).setMaxWidth(0);
            tblThucDonHD.getColumnModel().getColumn(2).setPreferredWidth(120);
        }

        btnTatCa.setBackground(new java.awt.Color(255, 102, 0));
        btnTatCa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTatCa.setForeground(new java.awt.Color(204, 0, 0));
        btnTatCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/Button-Add-icon (1).png"))); // NOI18N
        btnTatCa.setText("Tất Cả");
        btnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCaActionPerformed(evt);
            }
        });

        pnlLoaiSP.setBackground(new java.awt.Color(85, 78, 56));
        pnlLoaiSP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0)), "Nhóm Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 0))); // NOI18N

        LblGioChay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblGioChay.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PnlTTSanPhamLayout = new javax.swing.GroupLayout(PnlTTSanPham);
        PnlTTSanPham.setLayout(PnlTTSanPhamLayout);
        PnlTTSanPhamLayout.setHorizontalGroup(
            PnlTTSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTTSanPhamLayout.createSequentialGroup()
                .addGroup(PnlTTSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlTTSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PnlTTSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblGioChay, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PnlTTSanPhamLayout.createSequentialGroup()
                                .addComponent(LblTimKiemTTSP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(btnTatCa)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(PnlTTSanPhamLayout.createSequentialGroup()
                        .addComponent(pnlLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlTTSanPhamLayout.setVerticalGroup(
            PnlTTSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlTTSanPhamLayout.createSequentialGroup()
                .addComponent(LblGioChay, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlTTSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTimKiemTTSP)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(PnlTTSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(pnlLoaiSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        PnlTTHoaDon.setBackground(new java.awt.Color(85, 78, 56));
        PnlTTHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)), "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        PnlTTHoaDon1.setBackground(new java.awt.Color(255, 255, 0));
        PnlTTHoaDon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        LblSoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblSoHoaDon.setForeground(new java.awt.Color(204, 0, 0));
        LblSoHoaDon.setText("Số Hóa Đơn");

        TxtTenHoaDon.setEnabled(false);

        LblNgayTaoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblNgayTaoHoaDon.setForeground(new java.awt.Color(204, 0, 0));
        LblNgayTaoHoaDon.setText("Ngày Tạo Hóa Đơn");

        LblNVBanHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblNVBanHang.setForeground(new java.awt.Color(204, 0, 0));
        LblNVBanHang.setText("Nhân Viên Bán Hàng");

        TxtNgayTaoHD.setEnabled(false);

        javax.swing.GroupLayout PnlTTHoaDon1Layout = new javax.swing.GroupLayout(PnlTTHoaDon1);
        PnlTTHoaDon1.setLayout(PnlTTHoaDon1Layout);
        PnlTTHoaDon1Layout.setHorizontalGroup(
            PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTTHoaDon1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblNVBanHang)
                    .addComponent(LblNgayTaoHoaDon)
                    .addComponent(LblSoHoaDon))
                .addGap(18, 18, 18)
                .addGroup(PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtTenHoaDon)
                    .addComponent(TxtNgayTaoHD)
                    .addComponent(CbbNhanVienBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlTTHoaDon1Layout.setVerticalGroup(
            PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTTHoaDon1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTenHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblSoHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNgayTaoHoaDon)
                    .addComponent(TxtNgayTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlTTHoaDon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblNVBanHang)
                    .addComponent(CbbNhanVienBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlTongTienHD.setBackground(new java.awt.Color(255, 255, 0));
        PnlTongTienHD.setBorder(new javax.swing.border.MatteBorder(null));

        LblTongTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblTongTien.setForeground(new java.awt.Color(204, 0, 0));
        LblTongTien.setText("Tổng Tiền");

        TxtTongTien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtTongTien.setForeground(new java.awt.Color(255, 0, 0));
        TxtTongTien.setText("0");
        TxtTongTien.setBorder(null);
        TxtTongTien.setEnabled(false);

        LblTienKhachTra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblTienKhachTra.setForeground(new java.awt.Color(204, 0, 0));
        LblTienKhachTra.setText("Tiền Khách Trả");

        TxtTienKhachTra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtTienKhachTra.setForeground(new java.awt.Color(204, 0, 0));
        TxtTienKhachTra.setText("0");
        TxtTienKhachTra.setBorder(null);
        TxtTienKhachTra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtTienKhachTraFocusGained(evt);
            }
        });
        TxtTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtTienKhachTraKeyReleased(evt);
            }
        });

        LblTienDu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LblTienDu.setForeground(new java.awt.Color(204, 0, 0));
        LblTienDu.setText("Tiền Dư");

        TxtTienDu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtTienDu.setForeground(new java.awt.Color(204, 0, 0));
        TxtTienDu.setText("0");
        TxtTienDu.setBorder(null);

        javax.swing.GroupLayout PnlTongTienHDLayout = new javax.swing.GroupLayout(PnlTongTienHD);
        PnlTongTienHD.setLayout(PnlTongTienHDLayout);
        PnlTongTienHDLayout.setHorizontalGroup(
            PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTongTienHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblTongTien)
                    .addComponent(LblTienKhachTra)
                    .addComponent(LblTienDu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TxtTienKhachTra, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTongTien, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTienDu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );
        PnlTongTienHDLayout.setVerticalGroup(
            PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTongTienHDLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTongTien)
                    .addComponent(TxtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTienKhachTra)
                    .addComponent(TxtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PnlTongTienHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTienDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblTienDu))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        PnlTTKhachHang.setBackground(new java.awt.Color(255, 255, 0));
        PnlTTKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        lblTenBan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTenBan.setForeground(new java.awt.Color(204, 0, 0));
        lblTenBan.setText("Khách Hàng");

        cbbBanNgoi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbBanNgoiItemStateChanged(evt);
            }
        });

        lblTenBan1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTenBan1.setForeground(new java.awt.Color(204, 0, 0));
        lblTenBan1.setText("Tên Bàn");

        javax.swing.GroupLayout PnlTTKhachHangLayout = new javax.swing.GroupLayout(PnlTTKhachHang);
        PnlTTKhachHang.setLayout(PnlTTKhachHangLayout);
        PnlTTKhachHangLayout.setHorizontalGroup(
            PnlTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenBan)
                    .addComponent(lblTenBan1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbBanNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        PnlTTKhachHangLayout.setVerticalGroup(
            PnlTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTTKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenBan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlTTKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbBanNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenBan1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlTongTienHD1.setBackground(new java.awt.Color(85, 78, 56));
        PnlTongTienHD1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        BtnDatMon.setBackground(new java.awt.Color(255, 102, 0));
        BtnDatMon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnDatMon.setForeground(new java.awt.Color(204, 0, 0));
        BtnDatMon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/edit-tomboy-icon.png"))); // NOI18N
        BtnDatMon.setText("Đặt Món");
        BtnDatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDatMonActionPerformed(evt);
            }
        });

        BtnThanhToan.setBackground(new java.awt.Color(255, 102, 0));
        BtnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnThanhToan.setForeground(new java.awt.Color(204, 0, 0));
        BtnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/images/coin-us-dollar-icon (1).png"))); // NOI18N
        BtnThanhToan.setText("Thanh Toán");
        BtnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlTongTienHD1Layout = new javax.swing.GroupLayout(PnlTongTienHD1);
        PnlTongTienHD1.setLayout(PnlTongTienHD1Layout);
        PnlTongTienHD1Layout.setHorizontalGroup(
            PnlTongTienHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTongTienHD1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(BtnDatMon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(BtnThanhToan)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        PnlTongTienHD1Layout.setVerticalGroup(
            PnlTongTienHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlTongTienHD1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlTongTienHD1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDatMon, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout PnlTTHoaDonLayout = new javax.swing.GroupLayout(PnlTTHoaDon);
        PnlTTHoaDon.setLayout(PnlTTHoaDonLayout);
        PnlTTHoaDonLayout.setHorizontalGroup(
            PnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlTTKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlTongTienHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlTTHoaDon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlTongTienHD1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlTTHoaDonLayout.setVerticalGroup(
            PnlTTHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlTTHoaDonLayout.createSequentialGroup()
                .addComponent(PnlTTHoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlTTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PnlTongTienHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        PnlChiTietHoaDon.setBackground(new java.awt.Color(85, 78, 56));
        PnlChiTietHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)), "Danh Sách Đã Gọi", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        TblChiTietHoaDon.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        TblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Món", "Tên Món", "Đơn Giá", "SL", "Thành Tiền", "Ghi Chú", "MaCTHD"
            }
        ));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pmnHuyMon, org.jdesktop.beansbinding.ObjectProperty.create(), TblChiTietHoaDon, org.jdesktop.beansbinding.BeanProperty.create("componentPopupMenu"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(TblChiTietHoaDon);
        if (TblChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            TblChiTietHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
            TblChiTietHoaDon.getColumnModel().getColumn(1).setMinWidth(0);
            TblChiTietHoaDon.getColumnModel().getColumn(1).setPreferredWidth(0);
            TblChiTietHoaDon.getColumnModel().getColumn(1).setMaxWidth(0);
            TblChiTietHoaDon.getColumnModel().getColumn(2).setPreferredWidth(120);
            TblChiTietHoaDon.getColumnModel().getColumn(4).setPreferredWidth(25);
            TblChiTietHoaDon.getColumnModel().getColumn(6).setPreferredWidth(50);
            TblChiTietHoaDon.getColumnModel().getColumn(7).setMinWidth(0);
            TblChiTietHoaDon.getColumnModel().getColumn(7).setPreferredWidth(0);
            TblChiTietHoaDon.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        javax.swing.GroupLayout PnlChiTietHoaDonLayout = new javax.swing.GroupLayout(PnlChiTietHoaDon);
        PnlChiTietHoaDon.setLayout(PnlChiTietHoaDonLayout);
        PnlChiTietHoaDonLayout.setHorizontalGroup(
            PnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        PnlChiTietHoaDonLayout.setVerticalGroup(
            PnlChiTietHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(pnlBanNgoi, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlTTSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlTTHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(PnlTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnlChiTietHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PnlTTSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBanNgoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        BLL.BLLHoaDon.DoDuLieuThucDonChoHD(tblThucDonHD);

//        TxtNgayTaoHD.setText(BLL.BLLHoaDon.LayNgayHienTai());
        BLL.BLLHoaDon.DoDuLieuVaoCBBNhanVien(CbbNhanVienBanHang);
        BLL.BLLHoaDon.DoDuLieuVaoCBBKhachHang(cbbKhachHang);
    }//GEN-LAST:event_formWindowOpened

    private void mniChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChonActionPerformed

//        ThemChiTietHoaDon();
        new JDLChiTietHD(this, true).setVisible(true);

    }//GEN-LAST:event_mniChonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Chắc Chắn Thoát ?", //thông báo 
                "Thông Báo !", //tiêu đề 
                JOptionPane.YES_NO_OPTION, //lựa chọn 
                JOptionPane.ERROR_MESSAGE); // icon 

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //đóng chính form đang đứng 
        } else {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void tblThucDonHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThucDonHDMouseClicked
        //    Kiểm tra xem người dùng click mấy lần
        if (evt.getClickCount() == 2) {
//            ThemChiTietHoaDon();
            new JDLChiTietHD(this, true).setVisible(true);
        }
    }//GEN-LAST:event_tblThucDonHDMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        BLL.BLLSanPham.TimSanPhamTheoTuKhoaSP(tblThucDonHD, txtTimKiem.getText().trim());
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void BtnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnThanhToanActionPerformed
        if (TxtTienKhachTra.getText().trim().equals("0") || BLL.ChuyenDoi.ChuyenTien(TxtTienKhachTra.getText()) < BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText())) {
            GUI.frmMain.ThongBao("Thông Báo !", "Khách chưa trả đủ tiền !");
            return;
        }
        //----------------- chuyển trạng thái bàn sau khi thanh toán
        MyCombobox bb = (MyCombobox) cbbBanNgoi.getSelectedItem();
        // Lấy mã phần tử được chọn mb.Value 
        int MaBann = Integer.parseInt(bb.Value.toString());
        int TrangThai = 1;
        BanNgoi BN = new BanNgoi(MaBann, TrangThai);
        BLL.BLLBanNgoi.UpdateTrangThaiBanTrong(BN);
        FillBan();

        String SoHoaDon = TxtTenHoaDon.getText();
//        String Sodu = TxtTienDu.getText();
        String TinhTrang = "Đã Thanh Toán";
        HoaDon HD = new HoaDon(SoHoaDon, TinhTrang);
        DAL.DALHoaDon.SuaTrangThai(HD);
        DefaultTableModel dtm = (DefaultTableModel) TblChiTietHoaDon.getModel();
        dtm.setRowCount(0);
        BLL.BLLHoaDon.DoDuLieuThucDonChoHD(tblThucDonHD);
        //Xuất thông báo có in hóa đơn không => nếu có thì in ngược lại thì không
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Muốn In Hóa Đơn Không ?", //thông báo 
                "Thông Báo !", //tiêu đề 
                JOptionPane.YES_NO_OPTION, //lựa chọn 
                JOptionPane.ERROR_MESSAGE); // icon 

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {
            try {
                //String sohd = JOptionPane.showInputDialog(null, "Nhập số hóa đơn");
                JasperReport report = JasperCompileManager.compileReport("src/report/ListHD.jrxml");
                InputStream is = new FileInputStream("src/report/ListHD.jasper");
                Hashtable map = new Hashtable();
                map.put("ID", SoHoaDon);
                // map.put("DaThanh", DaThanh);
                map.put("duongdan", new File("").getCanonicalPath() + "\\");
                JasperPrint print = JasperFillManager.fillReport(is, map, DBConection.conn);
                //Đổi font chữ in hóa đơn
                // JRStyle[] styles = print.getStyles();
                //for (int i = 0; i < styles.length; i++) {
                //styles[i].setPdfFontName("C:/Windows/Fonts/Arial.ttf");
                //}
                //tạo ra bản in
                JasperViewer jv = new JasperViewer(print, false);
                //jv.setAlwaysOnTop(true);
                //xuất bản in
                jv.setVisible(true);
                //xét lại ban đầu cho các text tổng tiền và tiền khách trả
                TxtTongTien.setText("");
                TxtTienKhachTra.setText("");
                TxtTienDu.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_BtnThanhToanActionPerformed

    private void cbbBanNgoiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbBanNgoiItemStateChanged

    }//GEN-LAST:event_cbbBanNgoiItemStateChanged

    private void TxtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtTienKhachTraKeyReleased
        double tienKhachTra, tongTien, tienDu;

        tongTien = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());
        tienKhachTra = BLL.ChuyenDoi.ChuyenTien(TxtTienKhachTra.getText());

        TxtTienKhachTra.setText(BLL.ChuyenDoi.DinhDangTien(tienKhachTra));

        tienDu = tienKhachTra - tongTien;

      TxtTienDu.setText(BLL.ChuyenDoi.DinhDangTien(tienDu));
        if (tienKhachTra < tongTien) {
            TxtTienDu.setText("0");
        }
    }//GEN-LAST:event_TxtTienKhachTraKeyReleased

    private void TxtTienKhachTraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtTienKhachTraFocusGained
        TxtTienKhachTra.setText("");
    }//GEN-LAST:event_TxtTienKhachTraFocusGained

    private void mniChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniChonMouseClicked

    }//GEN-LAST:event_mniChonMouseClicked

    private void btnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCaActionPerformed
        BLL.BLLHoaDon.DoDuLieuThucDonChoHD(tblThucDonHD);
    }//GEN-LAST:event_btnTatCaActionPerformed

//    private void TaoOrder() {
//        // đoạn này check lại order , chưa có món vẫn order dc :v
//
//        if (TxtTenHoaDon.getText().equals("")) {
//
//            TxtTenHoaDon.setText(BLL.BLLHoaDon.taoSoHoaDon());
//            String SoHoaDon;
//            int MaNV;
//            int MaKH;
//            int MaBan;
//
//            String TinhTrang;
//            double TongTien;
//
////        ResultSet rs = DAL.DALHoaDon.GetByTenHD(SoHoaDon);
////        if(rs.next() == true ){
////            
////        }else{
////            
////        }
//            SoHoaDon = TxtTenHoaDon.getText();
//            String NgayTaoHD = TxtNgayTaoHD.getText();
//            MyCombobox cbbNV = (MyCombobox) CbbNhanVienBanHang.getSelectedItem();
//            MaNV = (int) cbbNV.Value;
//
//            MyCombobox cbbBan = (MyCombobox) cbbBanNgoi.getSelectedItem();
//            MaBan = (int) cbbBan.Value;
//
//            TinhTrang = "Chưa Thanh Toán";
//            TongTien = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());
//
//            MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
//            MaKH = (int) cbbKH.Value;
//
//            HoaDon HD = new HoaDon(SoHoaDon, NgayTaoHD, MaNV, MaBan, TinhTrang, TongTien, MaKH);
//
//            BLL.BLLHoaDon.Them(HD);
//
//            GUI.frmMain.ThongBao("Thông Báo !", "Order thành công !");
//
//        }
//
//        //B2 : Lay ma hoa don vua tao
//        String SoHoaDon = TxtTenHoaDon.getText();
//
//        int MaHD = BLL.BLLHoaDon.LayMaHoaDonString(SoHoaDon);
//
//        // B3 : them cac ma chi tiet hoa don
//        for (int i = 0; i < TblChiTietHoaDon.getRowCount(); i++) {
//
//            int MaSP = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 1).toString());
//
//            int SoLuong = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 4).toString());
//
//            double ThanhTien = BLL.ChuyenDoi.ChuyenTien(TblChiTietHoaDon.getValueAt(i, 5).toString());
//
//            String GhiChu = TblChiTietHoaDon.getValueAt(i, 6).toString();
//
//            DTO.ChiTietHoaDon cthd = new DTO.ChiTietHoaDon(MaHD, MaSP, SoLuong, ThanhTien, GhiChu);
//
//            BLL.BLLHoaDon.ThemChiTietHoaDon(cthd);
//        }
//    }

    private void BtnDatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDatMonActionPerformed

        int dongDuocChon = TblChiTietHoaDon.getRowCount();
        if (dongDuocChon == 0) {
            GUI.frmMain.ThongBao("Thông Báo !", "Bàn chưa có sản phẩm ,không thể Order !");
            return;
        }

        // dự theo trạng thái chia chức năng thêm món 
        MyCombobox bb = (MyCombobox) cbbBanNgoi.getSelectedItem();
        // Lấy mã phần tử được chọn mb.Value 
        int MaBann = Integer.parseInt(bb.Value.toString());
//            ResultSet rs = DAL.DALBanNgoi.GetByTrangThai(MaBann);
        ResultSet rss = BLL.BLLHoaDon.getTrangThaiCuaBan(MaBann);
        try {
            while (rss.next()) {
                // nếu trạng thái bằng 2 thực hiện thêm món mới 
                if (rss.getInt("TrangThai") == 2) {

//                    for (int i = 0; i < TblChiTietHoaDon.getRowCount(); i++) {
//                        int MaSPdaco = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 1).toString());
//                        if (TblChiTietHoaDon.getValueAt(i, 1).toString().equals(MaSPdaco + "")) {
//                            // cập nhập số lượng và thành tiền , sau khi thêm mới số lượng  
//                            int SoLuongmoi = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 4).toString());
//                            int MaSP = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 1).toString());
//                            double ThanhTienmoi = BLL.ChuyenDoi.ChuyenTien(TblChiTietHoaDon.getValueAt(i, 5).toString());
//                            ChiTietHoaDon ct = new ChiTietHoaDon(MaSP, SoLuongmoi, ThanhTienmoi);
//                            BLL.BLLHoaDon.updateSoLuongMoi(ct);
//                            // cập nhập tổng tiền , sau khi thêm mới số lượng  
//                            MyCombobox bbco = (MyCombobox) cbbBanNgoi.getSelectedItem();
//                            // Lấy mã phần tử được chọn mb.Value 
//                            int MaBannco = Integer.parseInt(bbco.Value.toString());
//                            double TongTienmoi = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());
//                            HoaDon hdmoi = new HoaDon(MaBann, TongTienmoi);
//                            BLL.BLLHoaDon.updateTongTienTheoMaBan(hdmoi);
//                            GUI.frmMain.ThongBao("Thông báo", "Cập nhập số lượng món thành công");
//                        } else {
                    String SoHoaDon = TxtTenHoaDon.getText();
                    double TongTien = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());
                    HoaDon HD = new HoaDon(SoHoaDon, TongTien);
                    BLL.BLLHoaDon.updateTongTienTheoSoHoaDon(HD);

                    DefaultTableModel dtm = (DefaultTableModel) TblChiTietHoaDon.getModel();
                    dtm.setRowCount(0);

//                    ThemChiTietHoaDon();
                    int dongDuocChon1 = tblThucDonHD.getSelectedRow();
                    if (dongDuocChon1 < 0) {
                        GUI.frmMain.ThongBao("Thông báo", "Bạn chưa chọn sản phẩm cần bán.");
                        return;
                    }

                    int MaSP = Integer.parseInt(tblThucDonHD.getValueAt(dongDuocChon1, 1).toString());

                    SanPham sp = BLL.BLLSanPham.LayDuaVaoMaSP(MaSP);

                    boolean kiemTra = false;
                    int soLuong = 0;

                    soLuong = (int) spnSoLuong.getValue();
                    if (soLuong < 1) {
                        GUI.frmMain.ThongBao("Lỗi dữ liệu", "Số lượng mua phải lớn hơn 0");
                        kiemTra = false;
                        return;
                    } else if (soLuong > sp.getSoLuong()) {
                        GUI.frmMain.ThongBao("Lỗi dữ liệu", "Số lượng hàng không đủ");
                        kiemTra = false;
                        return;
                    } else {
                        kiemTra = true;
                    }

                    String ghiChu = txtGhiChu.getText();
                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDon(TblChiTietHoaDon, sp, soLuong, ghiChu);

                    TxtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

                    int MaHD = BLL.BLLHoaDon.LayMaHoaDonString(SoHoaDon);
//         pnlThongTinChiTietHoaDon pnl = new pnlThongTinChiTietHoaDon();
//         pnl.setVisible(false);
                    // B3 : them cac ma chi tiet hoa don
//                    for (int i = 0; i < TblChiTietHoaDon.getRowCount(); i++) {
//                        if (!TblChiTietHoaDon.getValueAt(i, 1).toString().equals(sp.getMaSP() + "")) {
                    for (int j = 0; j < TblChiTietHoaDon.getRowCount(); j++) {

                        int MaSP1 = Integer.parseInt(TblChiTietHoaDon.getValueAt(j, 1).toString());

                        int SoLuong = Integer.parseInt(TblChiTietHoaDon.getValueAt(j, 4).toString());

                        double ThanhTien = BLL.ChuyenDoi.ChuyenTien(TblChiTietHoaDon.getValueAt(j, 5).toString());

                        String GhiChu = TblChiTietHoaDon.getValueAt(j, 6).toString();

                        DTO.ChiTietHoaDon cthd = new DTO.ChiTietHoaDon(MaHD, MaSP1, SoLuong, ThanhTien, GhiChu);

                        BLL.BLLHoaDon.ThemChiTietHoaDon(cthd);

                    }
                    MyCombobox bbco = (MyCombobox) cbbBanNgoi.getSelectedItem();
                    // Lấy mã phần tử được chọn mb.Value 
                    int MaBannco = Integer.parseInt(bbco.Value.toString());
                    BLLHoaDon.DoDuLieuLaiChoCTHD(TblChiTietHoaDon, MaBannco);
                    TxtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(HD.getTongTien()));
                    GUI.frmMain.ThongBao("Thông báo", "đặt món mới thành công");

//                        }//
//                        } else {
//                            int SoLuong = Integer.parseInt(spnSoLuong.getValue().toString());
//                            int MaSP2 = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 1).toString());
//                            slmoi = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 4).toString()) + SoLuong;
//                            ChiTietHoaDon ct = new ChiTietHoaDon(MaSP2, slmoi);
//                            BLL.BLLHoaDon.updateSoLuongMoi(ct);
//                            
//                        }
//                    }
//                  ChiTietHoaDon ct = (ChiTietHoaDon) BLL.BLLHoaDon.getChiTietThucDonByMaSP(MaSP);
//                  if(ct.getMaMon()==0){
//                        int SoLuong = Integer.parseInt(spnSoLuong.getValue().toString());
//                  }
//                    ResultSet cthdde = BLL.BLLHoaDon.getChiTietThucDonByMaSP(MaSP);
//                    try {
//                        while (cthdde.next()) {
//                            if () {
//
//                            }
//                        }
//                    } catch (SQLException ex) {
////             GUI.frmMain.ThongBao("Thông báo", "Bàn này đã có người ngồi");
//
//                    }
                    // nếu trạng thái bằng 1 thực hiện thêm mới hóa đơn
                }

            }
        } catch (SQLException ex) {
//             GUI.frmMain.ThongBao("Thông báo", "Bàn này đã có người ngồi");
        }

        ResultSet vss = BLL.BLLHoaDon.getTrangThaiCuaBan(MaBann);
        try {
            while (vss.next()) {
                if (vss.getInt("TrangThai") == 1) {

                    if (TxtTenHoaDon.getText().equals("")) {

                        TxtTenHoaDon.setText(BLL.BLLHoaDon.taoSoHoaDon());
                        String SoHoaDon;
                        int MaNV;
                        int MaKH;
                        int MaBan;

                        String TinhTrang;
                        double TongTien;

//        ResultSet rs = DAL.DALHoaDon.GetByTenHD(SoHoaDon);
//        if(rs.next() == true ){
//            
//        }else{
//            
//        }
                        SoHoaDon = TxtTenHoaDon.getText();
                        String NgayTaoHD = TxtNgayTaoHD.getText();
                        MyCombobox cbbNV = (MyCombobox) CbbNhanVienBanHang.getSelectedItem();
                        MaNV = (int) cbbNV.Value;

                        MyCombobox cbbBan = (MyCombobox) cbbBanNgoi.getSelectedItem();
                        MaBan = (int) cbbBan.Value;

                        TinhTrang = "Chưa Thanh Toán";
                        TongTien = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());

                        MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
                        MaKH = (int) cbbKH.Value;

                        HoaDon HD = new HoaDon(SoHoaDon, NgayTaoHD, MaNV, MaBan, TinhTrang, TongTien, MaKH);

                        BLL.BLLHoaDon.Them(HD);

                        GUI.frmMain.ThongBao("Thông Báo !", "đặt món thành công !");

                    }

                    //B2 : Lay ma hoa don vua tao
                    String SoHoaDon = TxtTenHoaDon.getText();

                    int MaHD = BLL.BLLHoaDon.LayMaHoaDonString(SoHoaDon);

                    // B3 : them cac ma chi tiet hoa don
                    for (int i = 0; i < TblChiTietHoaDon.getRowCount(); i++) {

                        int MaSP = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 1).toString());

                        int SoLuong = Integer.parseInt(TblChiTietHoaDon.getValueAt(i, 4).toString());

                        double ThanhTien = BLL.ChuyenDoi.ChuyenTien(TblChiTietHoaDon.getValueAt(i, 5).toString());

                        String GhiChu = TblChiTietHoaDon.getValueAt(i, 6).toString();

                        DTO.ChiTietHoaDon cthd = new DTO.ChiTietHoaDon(MaHD, MaSP, SoLuong, ThanhTien, GhiChu);

                        BLL.BLLHoaDon.ThemChiTietHoaDon(cthd);
                    }

                    MyCombobox bbhd = (MyCombobox) cbbBanNgoi.getSelectedItem();
                    // Lấy mã phần tử được chọn mb.Value 
                    int MaBannhd = Integer.parseInt(bbhd.Value.toString());
                    int TrangThai = 2;
                    BanNgoi BN = new BanNgoi(MaBannhd, TrangThai);
                    BLL.BLLBanNgoi.UpdateTrangThaiDaCoNguoi(BN);
                    FillBan();

                }
            }
        } catch (SQLException ex) {
//             GUI.frmMain.ThongBao("Thông báo", "Bàn này đã có người ngồi");

        }


    }//GEN-LAST:event_BtnDatMonActionPerformed

    private void mniXoaMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaMonActionPerformed
        int dongDuocChon = TblChiTietHoaDon.getSelectedRow();
        //tính lại tổng tiền
        double ThanhTien = BLL.ChuyenDoi.ChuyenTien(TblChiTietHoaDon.getValueAt(dongDuocChon, 5).toString());
        double TongTien = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());

        TongTien = TongTien - ThanhTien;

        TxtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(TongTien));

        String SoHoaDon = TxtTenHoaDon.getText();
        double TongTienAgain = BLL.ChuyenDoi.ChuyenTien(TxtTongTien.getText());
        HoaDon HD = new HoaDon(SoHoaDon, TongTienAgain);
        BLL.BLLHoaDon.updateTongTienTheoSoHoaDon(HD);
        // sau đó thực hiện xóa món đó đi 🙂 
        int MaCTHD = Integer.parseInt(TblChiTietHoaDon.getValueAt(dongDuocChon, 7).toString());
        BLL.BLLHoaDon.Delete(MaCTHD);
        // xóa xong đổ lại 
        MyCombobox bb = (MyCombobox) cbbBanNgoi.getSelectedItem();
        // Lấy mã phần tử được chọn mb.Value 
        int MaBann = Integer.parseInt(bb.Value.toString());
        BLL.BLLHoaDon.DoDuLieuLaiChoCTHD(TblChiTietHoaDon, MaBann);
    }//GEN-LAST:event_mniXoaMonActionPerformed

    private void mniChuyenBanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mniChuyenBanMousePressed
        JDLChuyenBan JDL = new JDLChuyenBan(this, true);
        JDL.setVisible(true);
        FillBan();
    }//GEN-LAST:event_mniChuyenBanMousePressed

// sửa lại số lượng , khi thêm 1 món giống 
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
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDatMon;
    private javax.swing.JButton BtnThanhToan;
    public static javax.swing.JComboBox<Object> CbbNhanVienBanHang;
    private javax.swing.JLabel LblGioChay;
    private javax.swing.JLabel LblNVBanHang;
    private javax.swing.JLabel LblNgayTaoHoaDon;
    private javax.swing.JLabel LblSoHoaDon;
    private javax.swing.JLabel LblTienDu;
    private javax.swing.JLabel LblTienKhachTra;
    private javax.swing.JLabel LblTimKiemTTSP;
    private javax.swing.JLabel LblTongTien;
    private javax.swing.JPanel PnlChiTietHoaDon;
    private javax.swing.JPanel PnlTTHoaDon;
    private javax.swing.JPanel PnlTTHoaDon1;
    private javax.swing.JPanel PnlTTKhachHang;
    private javax.swing.JPanel PnlTTSanPham;
    private javax.swing.JPanel PnlTongTienHD;
    private javax.swing.JPanel PnlTongTienHD1;
    public static javax.swing.JTable TblChiTietHoaDon;
    private javax.swing.JTextField TxtNgayTaoHD;
    public static javax.swing.JTextField TxtTenHoaDon;
    private javax.swing.JTextField TxtTienDu;
    private javax.swing.JTextField TxtTienKhachTra;
    public static javax.swing.JTextField TxtTongTien;
    private javax.swing.JButton btnTatCa;
    public static javax.swing.JComboBox<Object> cbbBanNgoi;
    public static javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblTenBan;
    private javax.swing.JLabel lblTenBan1;
    private javax.swing.JMenuItem mniChon;
    private javax.swing.JMenuItem mniChuyenBan;
    private javax.swing.JMenuItem mniXoaMon;
    private javax.swing.JPopupMenu pmnChonMon;
    private javax.swing.JPopupMenu pmnChuyenBan;
    private javax.swing.JPopupMenu pmnHuyMon;
    private javax.swing.JPanel pnlBanNgoi;
    private javax.swing.JPanel pnlLoaiSP;
    public static javax.swing.JTable tblThucDonHD;
    private javax.swing.JTextField txtTimKiem;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
