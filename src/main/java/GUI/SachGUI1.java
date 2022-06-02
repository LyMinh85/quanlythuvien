/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.SachBUS;
import DAO.MyConnection;
import DTO.LoaiSachDTO;
import DTO.SachDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class SachGUI1 extends javax.swing.JPanel {

    /**
     * Creates new form SachGUI1
     */
    private DefaultTableModel sachmd;
    private ArrayList<LoaiSachDTO> listLoaiSach;
    
    public SachGUI1() {
        initComponents();
        LoadDB();
        setTableItemList();
        SachBUS sachBUS = new SachBUS();
        listLoaiSach = sachBUS.findAllLoaiSach();
    }
    public void LoadDB(){
        String sql= "select * from dbo.LOAI_SACH";
        Connection conn=null;
        try{
            conn= MyConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               this.dbLS.addItem(rs.getString("tenLoai"));
               this.txtLS.addItem(rs.getString("tenLoai"));
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Thông báo lỗi", 1);
        }
    }
    
    public void setTableItemList(){
        sachmd = (DefaultTableModel) jTableSach.getModel();
        sachmd.setRowCount(0);
        SachBUS sachBUS = new SachBUS();
        sachBUS.findAll();
        ArrayList<SachDTO> listSach = sachBUS.getListSach();
        listSach.forEach(ele ->{
            sachmd.addRow(new Object[]{
                ele.getId(),
                ele.getTenSach(),
                ele.getGiaSach(),
                ele.getSoluong(),
                ele.getTrangthai(),
                ele.getIdTacGia(),
                ele.getIdNhaXuatBan(),
                ele.getIdLoaiSach(),
                ele.getIdKho()
            });
        });
    }
    
    public void setTableItemList(SachBUS sachBUS){
        sachmd = (DefaultTableModel) jTableSach.getModel();
        sachmd.setRowCount(0);
        ArrayList<SachDTO> listSach = sachBUS.getListSach();
        listSach.forEach(ele ->{
            sachmd.addRow(new Object[]{
                ele.getId(),
                ele.getTenSach(),
                ele.getGiaSach(),
                ele.getSoluong(),
                ele.getTrangthai(),
                ele.getIdTacGia(),
                ele.getIdNhaXuatBan(),
                ele.getIdLoaiSach(),
                ele.getIdKho()
            });
        });
    }
    
    public void clearAllTextField(){
        txtTenSach.setText("");
        txtGia.setText("");
        txtTG.setText("");
        txtNXB.setText("");
        txtSoLuong.setText("");
        txtTrangThai.setText("");
        txtKho.setText("");
        dbLS.setSelectedItem("");
    }
    
    public boolean isEmptyString(String str) {
        return str.equalsIgnoreCase("");
    }
    
    public boolean checkTextField(String option) {
        String ts= txtTenSach.getText();
        String g= txtGia.getText();
        String tg= txtTG.getText();
        String nxb= txtNXB.getText();
        String sl= txtSoLuong.getText();
        String tt= txtTrangThai.getText();
        String k= txtKho.getText();
        String ls= (String) dbLS.getSelectedItem();
        if (option.equalsIgnoreCase("Sua")) {
            ts= txtTenSach.getText();
            g= txtGia.getText();
            tg= txtTG.getText();
            nxb= txtNXB.getText();
            sl= txtSoLuong.getText();
            tt= txtTrangThai.getText();
            k= txtKho.getText();
            ls= (String) dbLS.getSelectedItem();
        }
        if (isEmptyString(ts)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách");
            return false;
        }
        if (isEmptyString(g)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá");
            return false;
        }
        if (isEmptyString(tg)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tác giả");
            return false;
        }
        if (isEmptyString(nxb)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập nhà xuất bản");
            return false;
        }
        if (!sl.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Số lượng chi duoc nhap so");
            return false;
        }
        if (isEmptyString(tt)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập trạng thái");
            return false;
        }
        if (isEmptyString(k)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập kho");
            return false;
        }
        if (isEmptyString(ls)) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại sách");
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

        jDialogTimKiem = new javax.swing.JDialog();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTS2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnXacNhanTIm = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtID2 = new javax.swing.JTextField();
        txtLS2 = new javax.swing.JTextField();
        jDialogSua = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtG = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTGia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNXB1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtK = new javax.swing.JTextField();
        btnXacNhanSua = new javax.swing.JButton();
        txtLS = new javax.swing.JComboBox<>();
        txtID = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTrangThai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTG = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNXB = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtKho = new javax.swing.JTextField();
        btnTK = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnHuyTK = new javax.swing.JButton();
        dbLS = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSach = new javax.swing.JTable();

        jDialogTimKiem.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Tìm Kiếm Sách");

        jLabel20.setText("Tên Sách");

        jLabel21.setText("Loại Sách");

        btnXacNhanTIm.setText("Tìm Kiếm");
        btnXacNhanTIm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanTImActionPerformed(evt);
            }
        });

        jLabel22.setText("ID");

        javax.swing.GroupLayout jDialogTimKiemLayout = new javax.swing.GroupLayout(jDialogTimKiem.getContentPane());
        jDialogTimKiem.getContentPane().setLayout(jDialogTimKiemLayout);
        jDialogTimKiemLayout.setHorizontalGroup(
            jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addComponent(txtTS2)
                    .addComponent(btnXacNhanTIm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID2)
                    .addComponent(txtLS2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jDialogTimKiemLayout.setVerticalGroup(
            jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addGap(30, 30, 30)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtLS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnXacNhanTIm)
                .addGap(29, 29, 29))
        );

        jDialogSua.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel10.setText("ID");

        jLabel11.setText("Tên Sách");

        jLabel12.setText("Giá");

        jLabel13.setText("Tác giá");

        jLabel14.setText("NXB");

        jLabel15.setText("Số lượng");

        jLabel16.setText("Loại sách");

        jLabel17.setText("Trạng thái");

        jLabel18.setText("Kho");

        btnXacNhanSua.setText("Sửa");
        btnXacNhanSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanSuaActionPerformed(evt);
            }
        });

        txtID.setEnabled(false);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSuaLayout = new javax.swing.GroupLayout(jDialogSua.getContentPane());
        jDialogSua.getContentPane().setLayout(jDialogSuaLayout);
        jDialogSuaLayout.setHorizontalGroup(
            jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSuaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogSuaLayout.createSequentialGroup()
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTS, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtID)))
                    .addComponent(txtTGia, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogSuaLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(txtG, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNXB1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                        .addComponent(txtSL, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(txtLS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogSuaLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialogSuaLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnXacNhanSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTT)
                                .addComponent(txtK, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jDialogSuaLayout.setVerticalGroup(
            jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSuaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtID))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNXB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXacNhanSua)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Danh sách Sách");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Tên Sách:");

        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá:");

        jLabel4.setText("Số lượng:");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel5.setText("Trạng thái:");

        jLabel6.setText("Tác Giả:");

        jLabel7.setText("NXB:");

        jLabel8.setText("Loại Sách");

        jLabel9.setText("Kho");

        btnTK.setText("Tìm kiếm");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnHuyTK.setText("Tải lại");
        btnHuyTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTKActionPerformed(evt);
            }
        });

        dbLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbLSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNXB, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTG))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .addComponent(txtTenSach))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dbLS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnHuyTK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKho, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(dbLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTK)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnHuyTK))
                .addGap(55, 55, 55))
        );

        jTableSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Sách", "Giá", "Tác Giả", "NXB", "Số lượng", "Loại Sách", "Trạng thái", "Kho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSach);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:
        jDialogTimKiem.setVisible(true);
        jDialogTimKiem.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTKActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!checkTextField("them")) {
            return;
        }
        int id = MyConnection.getLastRecordId("SACH") + 1;
        String ts= txtTenSach.getText();
        Float g= Float.valueOf(txtGia.getText());
        int tg= Integer.parseInt(txtTG.getText());
        int nxb= Integer.parseInt(txtNXB.getText());
        int sl= Integer.parseInt(txtSoLuong.getText());
        int tt= Integer.parseInt(txtTrangThai.getText());
        int k= Integer.parseInt(txtKho.getText());
        System.out.println(dbLS.getSelectedItem());
        int ls = 0;
        for (int i = 0; i < listLoaiSach.size(); i++) {
            if (listLoaiSach.get(i).getTenLoai().equalsIgnoreCase(String.valueOf(dbLS.getSelectedItem()))) {
                ls = i + 1;
            }
        }
        System.out.println(ls);
        SachDTO sachDTO = new SachDTO(id,ts, g, sl, tt, tg, nxb, ls, k);
        SachBUS sachBUS = new SachBUS();
        sachBUS.insertone(sachDTO);
        setTableItemList();
        clearAllTextField();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
            return;
        }
        Object obj = jTableSach.getValueAt(selectedRow, 0);
        int id = Integer.parseInt(obj.toString());
        SachBUS sbus = new SachBUS();
        if (sbus.delete(id)) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xoá thất bại");
        }
        setTableItemList();
        clearAllTextField();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }

        JTextField textFields[] = {txtID, txtTS, txtG, txtTGia, txtNXB1, txtSL,null, txtTT, txtK};

        for (int col = 0; col < 9; col++) {
            Object obj = jTableSach.getValueAt(selectedRow, col);
            if (col == 6) {
                txtLS.setSelectedItem("");
            } else {
                textFields[col].setText(obj.toString());
            }
        }
        jDialogSua.setVisible(true);
        jDialogSua.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnHuyTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTKActionPerformed
        // TODO add your handling code here:
        setTableItemList();
    }//GEN-LAST:event_btnHuyTKActionPerformed

    private void btnXacNhanTImActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanTImActionPerformed
        // TODO add your handling code here:
        try {
            boolean itNhat1DieuKien = false;
            int id;
            String tensach = "";
            String loaisach="";
            if (!txtID2.getText().isEmpty()) {
                id = Integer.parseInt(txtID2.getText());
                itNhat1DieuKien = true;
            } else {
                id = -1;
            }
            if (!txtTS2.getText().isEmpty()) {
                tensach = txtTS2.getText();
                itNhat1DieuKien = true;
            }
            if (txtLS2.getText().isEmpty()) {
                loaisach = txtLS2.getText();
                itNhat1DieuKien = true;
            }
            if (!itNhat1DieuKien) {
                return;
            }
            SachBUS sachBUS = new SachBUS();
            sachBUS.findMany(id, tensach, loaisach);
            setTableItemList(sachBUS);
            jDialogTimKiem.setVisible(false);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jDialogTimKiem, "id chỉ được nhập chữ số");
        }
    }//GEN-LAST:event_btnXacNhanTImActionPerformed

    private void btnXacNhanSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanSuaActionPerformed
        // TODO add your handling code here:
        if (!checkTextField("Sua")) {
            return;
        }
        // Get value in text field
        int id = Integer.parseInt(txtID.getText());
        String ts= txtTS.getText();
        Float g= Float.valueOf(txtGia.getText());
        int tg= Integer.parseInt(txtTG.getText());
        int nxb= Integer.parseInt(txtNXB.getText());
        int sl= Integer.parseInt(txtSoLuong.getText());
        int tt= Integer.parseInt(txtTrangThai.getText());
        int k= Integer.parseInt(txtKho.getText());
        int ls= (int) dbLS.getSelectedItem();
        SachBUS sachBUS = new SachBUS();
        //Get a record with id
        SachDTO sachDTO = sachBUS.findone(id);
        //Change the record columns value
        sachDTO.setTenSach(ts);
        sachDTO.setGiaSach(g);
        sachDTO.setIdTacGia(tg);
        sachDTO.setIdNhaXuatBan(nxb);
        sachDTO.setSoluong(sl);
        sachDTO.setIdLoaiSach(ls);
        sachDTO.setTrangthai(tt);
        sachDTO.setIdKho(k);
        //Update record to database
        if (sachBUS.update(sachDTO)) {
            System.out.println("Sua thanh cong");
        } else {
            System.out.println("Sua that bai");
        }
        setTableItemList();
        clearAllTextField();
        jDialogSua.setVisible(false);
    }//GEN-LAST:event_btnXacNhanSuaActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void dbLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbLSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbLSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyTK;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhanSua;
    private javax.swing.JButton btnXacNhanTIm;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> dbLS;
    private javax.swing.JDialog jDialogSua;
    private javax.swing.JDialog jDialogTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSach;
    private javax.swing.JTextField txtG;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtK;
    private javax.swing.JTextField txtKho;
    private javax.swing.JComboBox<String> txtLS;
    private javax.swing.JTextField txtLS2;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtNXB1;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTG;
    private javax.swing.JTextField txtTGia;
    private javax.swing.JTextField txtTS;
    private javax.swing.JTextField txtTS2;
    private javax.swing.JTextField txtTT;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
