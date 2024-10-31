/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

/**
 *
 * @author admin
 */
import data.ConnectToSQLServer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.DAOtk;
public class dangky extends javax.swing.JInternalFrame {
    private DAOtk dao;
    /**
     * Creates new form dangky
     */
    
    public dangky() {
        initComponents();
        dao = new DAOtk();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtdn = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttondk = new javax.swing.JButton();
        buttonthoat = new javax.swing.JButton();
        txtmk2 = new javax.swing.JPasswordField();
        txtmk = new javax.swing.JPasswordField();
        txtsdt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("Tên Đăng Nhập");

        jLabel2.setText("Mật Khẩu");

        jLabel3.setText("Xác Nhận Mật Khẩu");

        jLabel4.setText("Email");

        buttondk.setText("Đăng Ký");
        buttondk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttondkActionPerformed(evt);
            }
        });

        buttonthoat.setText("Thoát");
        buttonthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonthoatActionPerformed(evt);
            }
        });

        jLabel5.setText("Số Điện Thoại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtsdt)
                    .addComponent(buttonthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttondk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdn)
                    .addComponent(txtemail)
                    .addComponent(txtmk2)
                    .addComponent(txtmk, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(buttondk)
                .addGap(18, 18, 18)
                .addComponent(buttonthoat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonthoatActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonthoatActionPerformed

    private void buttondkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondkActionPerformed
        

        String tenDangNhap = txtdn.getText();
        String matKhau = new String(txtmk.getPassword());
        String xacNhanMatKhau = new String(txtmk2.getPassword());
        String email = txtemail.getText();
        String sdt = txtsdt.getText();

        // Kiểm tra thông tin đăng ký
        if (tenDangNhap.isEmpty() || matKhau.isEmpty() || xacNhanMatKhau.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin.");
        } else if (!matKhau.equals(xacNhanMatKhau)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp.");
        } else {
            if (dao.kiemTraTonTai(tenDangNhap, email,sdt)) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc email đã tồn tại hoặc sđt đã tồn tại.");
            } else {
                if (dao.themNguoiDung(tenDangNhap, matKhau, email,sdt)) {
                    JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Đăng ký không thành công. Vui lòng thử lại.");
                }
            }
        }
    

    

        // TODO add your handling code here:
    }//GEN-LAST:event_buttondkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttondk;
    private javax.swing.JButton buttonthoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtdn;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtmk;
    private javax.swing.JPasswordField txtmk2;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables

    
}