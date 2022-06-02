/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.CTPhieuTraBUS;
import BUS.NhanVienBUS;
import BUS.PhieuTraBUS;
import BUS.TaiKhoanBUS;
import DAO.MyConnection;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class NhanVienGUI extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienGUI
     */
    
    private DefaultTableModel nhanvienModel;
    public NhanVienGUI() {
        initComponents();
        setTableItemList();
    }
    public void setTableItemList() {
        nhanvienModel = (DefaultTableModel) jTableNhanVien.getModel();
        nhanvienModel.setRowCount(0);
        NhanVienBUS nhanvienBUS = new NhanVienBUS();
        nhanvienBUS.findALl();
        ArrayList<NhanVienDTO> listNhanVien = nhanvienBUS.getListNhanVien();
        System.out.println(listNhanVien);
        listNhanVien.forEach(ele -> {
            nhanvienModel.addRow(new Object[]{
                    ele.getID_NV(),
                    ele.getHoTen_NV(),
                    ele.getngaysinh_NV().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    ele.getDiaChi_NV(),
                    ele.getCmnd_NV(),
                    ele.getTinhTrang_NV()
                   
            });
        });
    }
    
    public void setTableItemList(NhanVienBUS nhanvienBUS) {
        nhanvienModel = (DefaultTableModel) jTableNhanVien.getModel();
        nhanvienModel.setRowCount(0);
        ArrayList<NhanVienDTO> listNhanVien = nhanvienBUS.getListNhanVien();
        listNhanVien.forEach(ele -> {
            nhanvienModel.addRow(new Object[]{
                    ele.getID_NV(),
                    ele.getHoTen_NV(),
                    ele.getngaysinh_NV().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    ele.getDiaChi_NV(),
                    ele.getCmnd_NV(),
                    ele.getTinhTrang_NV()
            });
        });
    }
    public void clearAllTextField() {
        // Them
        jTxtID.setText("");
        jTxtHoten.setText("");
        jTxtNgaysinh.setText("");
        jTxtDiachi.setText("");
        jTxtCmnd.setText("");
        jTxtTinhtrang.setText("");
        // Sua
        jTxtIDSua.setText("");
        jTxtHotenSua.setText("");
        jTxtNgaysinhSua.setText("");
        jTxtDiachiSua.setText("");
        jTxtCmndSua.setText("");
        jTxtTinhtrangSua.setText("");
        // Tim Kiem
        jTxtIDTimKiem.setText("");
        jTxtHotenTimKiem.setText("");
        jTxtTinhtrangTimKiem.setText("");
    }
    
     public boolean checkTextField(String option) {
        String id = jTxtID.getText();
        String hoten = jTxtHoten.getText();
        String ngaysinh = jTxtNgaysinh.getText();
        String diachi = jTxtDiachi.getText();
        String cmnd = jTxtCmnd.getText();
        String tinhtrang = jTxtTinhtrang.getText();

        if (option.equals("Sua")) {
            id = jTxtIDSua.getText();
            hoten = jTxtHotenSua.getText();
            ngaysinh = jTxtNgaysinhSua.getText();
            diachi = jTxtDiachiSua.getText();
            cmnd = jTxtCmndSua.getText();
            tinhtrang = jTxtTinhtrangSua.getText();
        }
        
       if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID");
            return false;
        }
        
        if (hoten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên");
            return false;
        }
        if (ngaysinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh");
            return false;
        }
    
        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
            return false;
        }
        if (cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập CMND");
            return false;
        }
        if (tinhtrang.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số CMND");
            return false;
        }
        if (!id.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập chữ số trong id");
            return false;
        }
         if (!cmnd.matches("[0-9]+")) {
             JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập chữ số trong cmnd");
             return false;
         }
         if (!tinhtrang.matches("[0-9]+")) {
             JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập chữ số trong tinhTrang");
             return false;
         }
        return true;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDialogThem = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtID = new javax.swing.JTextField();
        jTxtNgaysinh = new javax.swing.JTextField();
        jTxtDiachi = new javax.swing.JTextField();
        jTxtHoten = new javax.swing.JTextField();
        jTxtCmnd = new javax.swing.JTextField();
        jTxtTinhtrang = new javax.swing.JTextField();
        jBtnXacNhanThem = new javax.swing.JButton();
        JDialogSua = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTxtIDSua = new javax.swing.JTextField();
        jTxtNgaysinhSua = new javax.swing.JTextField();
        jTxtDiachiSua = new javax.swing.JTextField();
        jTxtHotenSua = new javax.swing.JTextField();
        jTxtCmndSua = new javax.swing.JTextField();
        jTxtTinhtrangSua = new javax.swing.JTextField();
        jBtnXacNhanSua = new javax.swing.JButton();
        JDialogTimKiem = new javax.swing.JDialog();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTxtIDTimKiem = new javax.swing.JTextField();
        jTxtHotenTimKiem = new javax.swing.JTextField();
        jTxtTinhtrangTimKiem = new javax.swing.JTextField();
        jBtnXacNhanTimKiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnHuyTimKiem = new javax.swing.JButton();
        jBtnThem = new javax.swing.JButton();
        jBtnTimkiem = new javax.swing.JButton();
        jBtnXoa = new javax.swing.JButton();
        jBtnSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNhanVien = new javax.swing.JTable();

        JDialogThem.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel3.setFont(new java.awt.Font("Tiffany-u-Heavy", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("THÊM NHÂN VIÊN");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setText("ID Nhân Viên:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Ngày sinh:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("Số CMND:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Tình trạng làm việc:");

        jTxtID.setText("nhập id");
        jTxtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtIDActionPerformed(evt);
            }
        });

        jTxtNgaysinh.setText("nhập ngày sinh");

        jTxtDiachi.setText("nhập địa chỉ");

        jTxtHoten.setText("nhập họ tên");
        jTxtHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHotenActionPerformed(evt);
            }
        });

        jTxtCmnd.setText("nhập số cmnd");

        jTxtTinhtrang.setText("nhập tình trạng làm việc");

        jBtnXacNhanThem.setBackground(new java.awt.Color(102, 255, 51));
        jBtnXacNhanThem.setText("THÊM");
        jBtnXacNhanThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JDialogThemLayout = new javax.swing.GroupLayout(JDialogThem.getContentPane());
        JDialogThem.getContentPane().setLayout(JDialogThemLayout);
        JDialogThemLayout.setHorizontalGroup(
            JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogThemLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JDialogThemLayout.createSequentialGroup()
                        .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JDialogThemLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtTinhtrang))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDialogThemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnXacNhanThem)
                .addGap(60, 60, 60))
        );
        JDialogThemLayout.setVerticalGroup(
            JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogThemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtTinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jBtnXacNhanThem)
                .addContainerGap())
        );

        JDialogSua.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel9.setFont(new java.awt.Font("Tiffany-u-Heavy", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("SỬA NHÂN VIÊN");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("ID Nhân Viên:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Họ và tên:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Ngày sinh:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Địa chỉ:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Số CMND:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Tình trạng làm việc:");

        jTxtIDSua.setEnabled(false);

        jTxtHotenSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHotenSuaActionPerformed(evt);
            }
        });

        jBtnXacNhanSua.setBackground(new java.awt.Color(102, 255, 51));
        jBtnXacNhanSua.setText("Sửa");
        jBtnXacNhanSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JDialogSuaLayout = new javax.swing.GroupLayout(JDialogSua.getContentPane());
        JDialogSua.getContentPane().setLayout(JDialogSuaLayout);
        JDialogSuaLayout.setHorizontalGroup(
            JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogSuaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JDialogSuaLayout.createSequentialGroup()
                        .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtIDSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNgaysinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtDiachiSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtHotenSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCmndSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JDialogSuaLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtTinhtrangSua))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDialogSuaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnXacNhanSua)
                .addGap(60, 60, 60))
        );
        JDialogSuaLayout.setVerticalGroup(
            JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogSuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTxtIDSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTxtHotenSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTxtNgaysinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTxtDiachiSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTxtCmndSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTxtTinhtrangSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jBtnXacNhanSua)
                .addContainerGap())
        );

        JDialogTimKiem.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel23.setFont(new java.awt.Font("Tiffany-u-Heavy", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 0));
        jLabel23.setText("TÌM KIẾM NHÂN VIÊN");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel24.setText("ID Nhân Viên:");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel25.setText("Họ và tên:");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel29.setText("Tình trạng làm việc:");

        jTxtHotenTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHotenTimKiemActionPerformed(evt);
            }
        });

        jBtnXacNhanTimKiem.setBackground(new java.awt.Color(102, 255, 51));
        jBtnXacNhanTimKiem.setText("Tìm kiếm");
        jBtnXacNhanTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JDialogTimKiemLayout = new javax.swing.GroupLayout(JDialogTimKiem.getContentPane());
        JDialogTimKiem.getContentPane().setLayout(JDialogTimKiemLayout);
        JDialogTimKiemLayout.setHorizontalGroup(
            JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addGap(18, 18, 18)
                            .addComponent(jTxtTinhtrangTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                            .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtIDTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtHotenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnXacNhanTimKiem)
                .addGap(60, 60, 60))
        );
        JDialogTimKiemLayout.setVerticalGroup(
            JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTxtIDTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTxtHotenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtTinhtrangTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(147, 147, 147)
                .addComponent(jBtnXacNhanTimKiem)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jBtnHuyTimKiem.setText("HỦY TÌM KIẾM");
        jBtnHuyTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyTimKiemActionPerformed(evt);
            }
        });

        jBtnThem.setText("THÊM");
        jBtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemActionPerformed(evt);
            }
        });

        jBtnTimkiem.setText("TÌM KIẾM");
        jBtnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTimkiemActionPerformed(evt);
            }
        });

        jBtnXoa.setText("XÓA");
        jBtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXoaActionPerformed(evt);
            }
        });

        jBtnSua.setText("SỬA");
        jBtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnHuyTimKiem)
                .addGap(34, 34, 34)
                .addComponent(jBtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jBtnTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jBtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jBtnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnHuyTimKiem)
                    .addComponent(jBtnThem)
                    .addComponent(jBtnTimkiem)
                    .addComponent(jBtnXoa)
                    .addComponent(jBtnSua))
                .addGap(40, 40, 40))
        );

        jTableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID NHÂN VIÊN", "HỌ TÊN NHÂN VIÊN", "NGÀY SINH NHÂN VIÊN", "ĐỊA CHỈ", "CHỨNG MINH NHÂN DÂN", "TÌNH TRẠNG LÀM VIỆC"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableNhanVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnHuyTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyTimKiemActionPerformed
        setTableItemList();
    }//GEN-LAST:event_jBtnHuyTimKiemActionPerformed

    private void jBtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXoaActionPerformed
        // Get selected rows
        int[] selectedRows = jTableNhanVien.getSelectedRows();
        if (selectedRows == null || selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
            return;
        }
        // Get id
        ArrayList<Integer> arrayIdNhanVien = new ArrayList<>();
        for (int row : selectedRows) {
            Object id = jTableNhanVien.getValueAt(row, 0);
            arrayIdNhanVien.add((Integer) id);
        }
        int result = JOptionPane.showConfirmDialog(this, "Xác nhận xóa id = " + arrayIdNhanVien.toString());
        if (result == JOptionPane.YES_OPTION) {
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            arrayIdNhanVien.forEach(idNhanvien -> {
                nhanVienBUS.deleteOne(idNhanvien);
            });
        }

        setTableItemList();
    }//GEN-LAST:event_jBtnXoaActionPerformed

    private void jBtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemActionPerformed
        // TODO add your handling code here:
        clearAllTextField();
        JDialogThem.setVisible(true);
        JDialogThem.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnThemActionPerformed

    private void jBtnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimkiemActionPerformed
        clearAllTextField();
        JDialogTimKiem.setVisible(true);
        JDialogTimKiem.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnTimkiemActionPerformed

    private void jBtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaActionPerformed
        clearAllTextField();
        int selectedRow = jTableNhanVien.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        int id = (int) jTableNhanVien.getValueAt(selectedRow, 0);
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVienDTO nhanVienDTO = nhanVienBUS.findOne(id);
        jTxtIDSua.setText(String.valueOf(nhanVienDTO.getID_NV()));
        jTxtHotenSua.setText(nhanVienDTO.getHoTen_NV());
        DateTimeFormatter fmr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        jTxtNgaysinhSua.setText(nhanVienDTO.getngaysinh_NV().format(fmr));
        jTxtDiachiSua.setText(nhanVienDTO.getDiaChi_NV());
        jTxtCmndSua.setText(nhanVienDTO.getCmnd_NV());
        jTxtTinhtrangSua.setText(String.valueOf(nhanVienDTO.getTinhTrang_NV()));
        JDialogSua.setVisible(true);
        JDialogSua.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnSuaActionPerformed

    private void jTxtHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHotenActionPerformed

    private void jTxtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtIDActionPerformed

    private void jBtnXacNhanThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXacNhanThemActionPerformed
        // TODO add your handling code here:
        if (!checkTextField("them")) {
            return;
        }
        int id = Integer.parseInt(jTxtID.getText());
        DateTimeFormatter fmr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaysinh = null;
        try {
            ngaysinh = LocalDate.parse(jTxtNgaysinh.getText(), fmr);
        } catch (java.time.format.DateTimeParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(JDialogThem, "Vui lòng nhập ngày sinh theo dd/MM/yyyy. VD: 22/10/2022");
            return;
        }
        String diachi = jTxtDiachi.getText();
        String hoten = jTxtHoten.getText();
        String cmnd = jTxtCmnd.getText();
        int tinhtrang = Integer.parseInt(jTxtTinhtrang.getText());
      
        NhanVienDTO nhanvienDTO = new NhanVienDTO(id, hoten, ngaysinh, diachi, cmnd, tinhtrang);
        NhanVienBUS nhanvienBUS = new NhanVienBUS();
        TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
        boolean result = nhanvienBUS.ThemNhanVien(nhanvienDTO);
        if (!result) {
            JOptionPane.showMessageDialog(JDialogThem, "Trùng ID nhân viên");
            return;
        }
        taiKhoanBUS.themTaiKhoan(new TaiKhoanDTO(nhanvienDTO.getID_NV(), "123456"));
        setTableItemList();
        clearAllTextField();
        JDialogThem.setVisible(false);
    }//GEN-LAST:event_jBtnXacNhanThemActionPerformed

    private void jTxtHotenSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHotenSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHotenSuaActionPerformed

    private void jBtnXacNhanSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXacNhanSuaActionPerformed
        if (!checkTextField("Sua")) {
            return;
        }
        int id = Integer.parseInt(jTxtIDSua.getText());
        String hoTen = jTxtHotenSua.getText();
        DateTimeFormatter fmr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaysinh = null;
        try {
            ngaysinh = LocalDate.parse(jTxtNgaysinhSua.getText(), fmr);
        } catch (java.time.format.DateTimeParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(JDialogThem, "Vui lòng nhập ngày sinh theo dd/MM/yyyy. VD: 02/10/2022");
            return;
        }
        String diaChi = jTxtDiachiSua.getText();
        String cmnd = jTxtCmndSua.getText();
        int tinhTrang = Integer.parseInt(jTxtTinhtrangSua.getText());
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVienDTO newNhanVien = new NhanVienDTO(id, hoTen, ngaysinh, diaChi, cmnd, tinhTrang);
        nhanVienBUS.updateOne(newNhanVien);
        setTableItemList();
        JDialogSua.setVisible(false);
    }//GEN-LAST:event_jBtnXacNhanSuaActionPerformed

    private void jTxtHotenTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHotenTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHotenTimKiemActionPerformed

    private void jBtnXacNhanTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXacNhanTimKiemActionPerformed
        try {
            boolean itNhat1DieuKien = false;
            int id, tinhTrang;
            String hoTen = "";
            if (!jTxtIDTimKiem.getText().isEmpty()) {
                id = Integer.parseInt(jTxtIDTimKiem.getText());
                itNhat1DieuKien = true;
            } else {
                id = -1;
            }
            if (!jTxtHotenTimKiem.getText().isEmpty()) {
                hoTen = jTxtHotenTimKiem.getText();
                itNhat1DieuKien = true;
            }
            if (!jTxtTinhtrangTimKiem.getText().isEmpty()) {
                tinhTrang = Integer.parseInt(jTxtTinhtrangTimKiem.getText());
                itNhat1DieuKien = true;
            } else {
                tinhTrang = -1;
            }
            if (!itNhat1DieuKien) {
                return;
            }
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            nhanVienBUS.findMany(id, hoTen, tinhTrang);
            setTableItemList(nhanVienBUS);
            JDialogTimKiem.setVisible(false);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(JDialogTimKiem, "id và tình trạng chỉ được nhập chữ số");
        }

    }//GEN-LAST:event_jBtnXacNhanTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JDialogSua;
    private javax.swing.JDialog JDialogThem;
    private javax.swing.JDialog JDialogTimKiem;
    private javax.swing.JButton jBtnHuyTimKiem;
    private javax.swing.JButton jBtnSua;
    private javax.swing.JButton jBtnThem;
    private javax.swing.JButton jBtnTimkiem;
    private javax.swing.JButton jBtnXacNhanSua;
    private javax.swing.JButton jBtnXacNhanThem;
    private javax.swing.JButton jBtnXacNhanTimKiem;
    private javax.swing.JButton jBtnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNhanVien;
    private javax.swing.JTextField jTxtCmnd;
    private javax.swing.JTextField jTxtCmndSua;
    private javax.swing.JTextField jTxtDiachi;
    private javax.swing.JTextField jTxtDiachiSua;
    private javax.swing.JTextField jTxtHoten;
    private javax.swing.JTextField jTxtHotenSua;
    private javax.swing.JTextField jTxtHotenTimKiem;
    private javax.swing.JTextField jTxtID;
    private javax.swing.JTextField jTxtIDSua;
    private javax.swing.JTextField jTxtIDTimKiem;
    private javax.swing.JTextField jTxtNgaysinh;
    private javax.swing.JTextField jTxtNgaysinhSua;
    private javax.swing.JTextField jTxtTinhtrang;
    private javax.swing.JTextField jTxtTinhtrangSua;
    private javax.swing.JTextField jTxtTinhtrangTimKiem;
    // End of variables declaration//GEN-END:variables
}
