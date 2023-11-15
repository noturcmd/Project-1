/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpustakaan;

import java.awt.Color;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class UbahBiodataAnggota extends javax.swing.JFrame {
    private KoneksiDatabase koneksi;
    Statement st = null;
    ResultSet rs = null;
    ButtonGroup buttonJK = new ButtonGroup();
    
    public UbahBiodataAnggota(){
        koneksi = KoneksiDatabase.getInstance();
        initComponents();
        getContentPane().setBackground(new Color(189, 173, 138));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.buttonJK.add(ubahJKPria);
        this.buttonJK.add(ubahJKWanita);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        new UbahBiodataAnggota().show();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputNamaAnggota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputAkunAnggota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputPasswordAnggota = new javax.swing.JPasswordField();
        tombolSimpan = new javax.swing.JButton();
        inputAlamatAnggota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tombolKembali = new javax.swing.JButton();
        nimAnggota = new javax.swing.JLabel();
        ubahJKPria = new javax.swing.JRadioButton();
        ubahJKWanita = new javax.swing.JRadioButton();
        inputJK = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pendaftaran Anggota");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setText("Ubah Data Anggota");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setText("Nama                  :");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setText("NIM                     : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setText("Alamat                : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setText("Akun                   :");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel6.setText("Password           : ");

        tombolSimpan.setBackground(new java.awt.Color(255, 204, 0));
        tombolSimpan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        inputAlamatAnggota.setText(" ");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel7.setText("Jenis Kelamin    :");

        tombolKembali.setBackground(new java.awt.Color(194, 190, 70));
        tombolKembali.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tombolKembali.setText("Kembali");
        tombolKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKembaliActionPerformed(evt);
            }
        });

        ubahJKPria.setText("Pria");
        ubahJKPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahJKPriaActionPerformed(evt);
            }
        });

        ubahJKWanita.setText("Wanita");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(inputNamaAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                        .addComponent(nimAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(25, 25, 25)
                                            .addComponent(ubahJKPria)
                                            .addGap(18, 18, 18)
                                            .addComponent(ubahJKWanita))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(inputJK, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inputPasswordAnggota)
                                            .addComponent(inputAlamatAnggota)
                                            .addComponent(inputAkunAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(258, 258, 258)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tombolKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34))))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(140, 140, 140))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(inputNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nimAnggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputJK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubahJKPria)
                    .addComponent(ubahJKWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputAlamatAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputAkunAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputPasswordAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolKembali)
                    .addComponent(tombolSimpan))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        try{
                if(this.inputAkunAnggota.getText().isBlank() || this.inputNamaAnggota.getText().isBlank() || this.inputAlamatAnggota.getText().isBlank() || this.nimAnggota.getText().isBlank() || this.inputPasswordAnggota.getText().isBlank()){
                    JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan Data");
                }else{
                    if(!this.ubahJKPria.isSelected() && !this.ubahJKWanita.isSelected()){
                        JOptionPane.showMessageDialog(this, "Mohon memilih jenis kelamin!");
                    }else{
                        if(this.ubahJKPria.isSelected()){
                                if(!this.inputAkunAnggota.getText().contains("@gmail.com")){
    //                        System.out.println("tidak mengandung @gmail.com");
                                this.st = this.koneksi.getConnection().createStatement();
                                String cekAkun = this.inputAkunAnggota.getText() + "@gmail.com";
                                String query = String.format("select email from data_anggota where email = \"%s\" and nim != \"%s\";", cekAkun, this.nimAnggota.getText());
                                this.rs = this.st.executeQuery(query);
                                if(this.rs.next()){
                                     JOptionPane.showMessageDialog(this, "Email sudah digunakan, silahkan input email yang lain!");
                                }else{
                                    if(this.inputJK.getText().equals("pria") && this.inputJK.getText().equals("wanita")){
                                        JOptionPane.showMessageDialog(this, "Mohon input jenis kelamin Pria/Wanita");
                                    }else{
                                        this.st = this.koneksi.getConnection().createStatement();
                                        String query2 = String.format("update data_anggota set nama = \"%s\", alamat = \"%s\", jenis_kelamin = \"%s\", email = \"%s\", password = \"%s\" where nim = \"%s\"", this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), this.ubahJKPria.getText(), this.inputAkunAnggota.getText(), this.inputPasswordAnggota.getText(), this.nimAnggota.getText());
                                        this.st.executeUpdate(query2);
                                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                                        String getJK = String.format("select * from data_anggota where nim = \"%s\"", this.nimAnggota.getText());
                                        ResultSet rs2 = this.st.executeQuery(getJK);
                                        System.out.println("JK adalah :");
                                        if(rs2.next()){
                                            System.out.println("Apa yaaaa");
                                            this.inputNamaAnggota.setText(rs2.getString("nama"));
                                            this.nimAnggota.setText(rs2.getString("nim"));
                                            this.inputJK.setText(rs2.getString("jenis_kelamin"));
                                            this.inputAlamatAnggota.setText(rs2.getString("alamat"));
                                            this.inputAkunAnggota.setText(rs2.getString("email"));
                                            this.inputPasswordAnggota.setText(rs2.getString("password"));
                                        }
                                    } 
                                }
                            }else if(this.inputAkunAnggota.getText().contains("@gmail.com")){
        //                        System.out.println("mengandung @gmail.com");
                                this.st = this.koneksi.getConnection().createStatement();
                                String query10 = String.format("select email from data_anggota where email = \"%s\" and nim != \"%s\";", this.inputAkunAnggota.getText(), this.nimAnggota.getText());
        //                        System.out.println(this.nimAnggota.getText());
                                this.rs = this.st.executeQuery(query10);
                                if(rs.next()){
                                     JOptionPane.showMessageDialog(this, "Email sudah digunakan, silahkan input email yang lain!");
                                }else{
                                    if(this.inputJK.getText().equals("pria") && this.inputJK.getText().equals("wanita")){
                                        JOptionPane.showMessageDialog(this, "Mohon input jenis kelamin Pria/Wanita");
                                    }else{
                                        this.st = this.koneksi.getConnection().createStatement();
                                        String query2 = String.format("update data_anggota set nama = \"%s\", alamat = \"%s\", jenis_kelamin = \"%s\", email = \"%s\", password = \"%s\" where nim = \"%s\"", this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), this.ubahJKPria.getText(), this.inputAkunAnggota.getText(), this.inputPasswordAnggota.getText(), this.nimAnggota.getText());
                                        this.st.executeUpdate(query2);
                                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                                        String getJK = String.format("select * from data_anggota where nim = \"%s\"", this.nimAnggota.getText());
                                        ResultSet rs2 = this.st.executeQuery(getJK);
                                        System.out.println("JK adalah :");
                                        if(rs2.next()){
                                            System.out.println("Apa yaaaa");
                                            this.inputNamaAnggota.setText(rs2.getString("nama"));
                                            this.nimAnggota.setText(rs2.getString("nim"));
                                            this.inputJK.setText(rs2.getString("jenis_kelamin"));
                                            this.inputAlamatAnggota.setText(rs2.getString("alamat"));
                                            this.inputAkunAnggota.setText(rs2.getString("email"));
                                            this.inputPasswordAnggota.setText(rs2.getString("password"));
                                        }
                                    } 
                                } 
                            }else{
                                JOptionPane.showMessageDialog(this, "Mohon input akun dengan format \"@gmail.com\"");
                            }
                        }else if(this.ubahJKWanita.isSelected()){
                            if(!this.inputAkunAnggota.getText().contains("@gmail.com")){
    //                        System.out.println("tidak mengandung @gmail.com");
                                this.st = this.koneksi.getConnection().createStatement();
                                String cekAkun = this.inputAkunAnggota.getText() + "@gmail.com";
                                String query = String.format("select email from data_anggota where email = \"%s\" and nim != \"%s\";", cekAkun, this.nimAnggota.getText());
                                this.rs = this.st.executeQuery(query);
                                if(this.rs.next()){
                                     JOptionPane.showMessageDialog(this, "Email sudah digunakan, silahkan input email yang lain!");
                                }else{
                                    if(this.inputJK.getText().equals("pria") && this.inputJK.getText().equals("wanita")){
                                        JOptionPane.showMessageDialog(this, "Mohon input jenis kelamin Pria/Wanita");
                                    }else{
                                        this.st = this.koneksi.getConnection().createStatement();
                                        String query2 = String.format("update data_anggota set nama = \"%s\", alamat = \"%s\", jenis_kelamin = \"%s\", email = \"%s\", password = \"%s\" where nim = \"%s\"", this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), this.ubahJKWanita.getText(), this.inputAkunAnggota.getText(), this.inputPasswordAnggota.getText(), this.nimAnggota.getText());
                                        this.st.executeUpdate(query2);
                                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                                        String getJK = String.format("select * from data_anggota where nim = \"%s\"", this.nimAnggota.getText());
                                        ResultSet rs2 = this.st.executeQuery(getJK);
                                        System.out.println("JK adalah :");
                                        if(rs2.next()){
                                            System.out.println("Apa yaaaa");
                                            this.inputNamaAnggota.setText(rs2.getString("nama"));
                                            this.nimAnggota.setText(rs2.getString("nim"));
                                            this.inputJK.setText(rs2.getString("jenis_kelamin"));
                                            this.inputAlamatAnggota.setText(rs2.getString("alamat"));
                                            this.inputAkunAnggota.setText(rs2.getString("email"));
                                            this.inputPasswordAnggota.setText(rs2.getString("password"));
                                        }
                                    } 
                                }
                            }else if(this.inputAkunAnggota.getText().contains("@gmail.com")){
        //                        System.out.println("mengandung @gmail.com");
                                this.st = this.koneksi.getConnection().createStatement();
                                String query10 = String.format("select email from data_anggota where email = \"%s\" and nim != \"%s\";", this.inputAkunAnggota.getText(), this.nimAnggota.getText());
        //                        System.out.println(this.nimAnggota.getText());
                                this.rs = this.st.executeQuery(query10);
                                if(rs.next()){
                                     JOptionPane.showMessageDialog(this, "Email sudah digunakan, silahkan input email yang lain!");
                                }else{
                                    if(this.inputJK.getText().equals("pria") && this.inputJK.getText().equals("wanita")){
                                        JOptionPane.showMessageDialog(this, "Mohon input jenis kelamin Pria/Wanita");
                                    }else{
                                        this.st = this.koneksi.getConnection().createStatement();
                                        String query2 = String.format("update data_anggota set nama = \"%s\", alamat = \"%s\", jenis_kelamin = \"%s\", email = \"%s\", password = \"%s\" where nim = \"%s\"", this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), this.ubahJKWanita.getText(), this.inputAkunAnggota.getText(), this.inputPasswordAnggota.getText(), this.nimAnggota.getText());
                                        this.st.executeUpdate(query2);
                                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                                        String getJK = String.format("select * from data_anggota where nim = \"%s\"", this.nimAnggota.getText());
                                        ResultSet rs2 = this.st.executeQuery(getJK);
                                        System.out.println("JK adalah :");
                                        if(rs2.next()){
                                            System.out.println("Apa yaaaa");
                                            this.inputNamaAnggota.setText(rs2.getString("nama"));
                                            this.nimAnggota.setText(rs2.getString("nim"));
                                            this.inputJK.setText(rs2.getString("jenis_kelamin"));
                                            this.inputAlamatAnggota.setText(rs2.getString("alamat"));
                                            this.inputAkunAnggota.setText(rs2.getString("email"));
                                            this.inputPasswordAnggota.setText(rs2.getString("password"));
                                        }
                                    } 
                                } 
                            }else{
                                JOptionPane.showMessageDialog(this, "Mohon input akun dengan format \"@gmail.com\"");
                            }
                        }
                    }
                }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKembaliActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_tombolKembaliActionPerformed

    private void ubahJKPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahJKPriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahJKPriaActionPerformed

    void biodata(String nama, String nim, String jenisKelamin, String alamat, String email, String password){
        this.inputNamaAnggota.setText(nama);
        this.nimAnggota.setText(nim);
        this.inputJK.setText(jenisKelamin);
        this.inputAlamatAnggota.setText(alamat);
        this.inputAkunAnggota.setText(email);
        this.inputPasswordAnggota.setText(password);
        System.out.println(jenisKelamin);
        if(jenisKelamin.equals("Pria")){
            this.ubahJKPria.setSelected(true);
        }else{
            this.ubahJKWanita.setSelected(true);
        }
        
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputAkunAnggota;
    private javax.swing.JTextField inputAlamatAnggota;
    private javax.swing.JLabel inputJK;
    private javax.swing.JTextField inputNamaAnggota;
    private javax.swing.JPasswordField inputPasswordAnggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel nimAnggota;
    private javax.swing.JButton tombolKembali;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JRadioButton ubahJKPria;
    private javax.swing.JRadioButton ubahJKWanita;
    // End of variables declaration//GEN-END:variables
}
