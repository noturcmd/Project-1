/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpustakaan;

import java.awt.Color;
import java.sql.*;
import java.util.concurrent.TimeUnit;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;



public class PendaftaranAnggota extends javax.swing.JFrame {
    private KoneksiDatabase koneksi;
    Login log = new Login();
    Statement st = null;
    ResultSet rs = null;
    ButtonGroup buttonJK = new ButtonGroup();
    
    public PendaftaranAnggota() {
        koneksi = KoneksiDatabase.getInstance();
        initComponents();
        this.buttonJK.add(jkPria);
        this.buttonJK.add(jkWanita);
        getContentPane().setBackground(new Color(189, 173, 138));
        setLocationRelativeTo(null);
    }
    
//    public static void main(String[] args) {
//        new PendaftaranAnggota().show();
//    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tombolDaftar = new javax.swing.JButton();
        tombolKembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jkWanita = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        inputNamaAnggota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputNIMAnggota = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputAkunAnggota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inputPasswordAnggota = new javax.swing.JPasswordField();
        inputAlamatAnggota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jkPria = new javax.swing.JRadioButton();
        outputDaftar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pendaftaran Anggota");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 240, 206));
        jLabel1.setText("Pendaftaran Anggota");

        tombolDaftar.setBackground(new java.awt.Color(153, 176, 128));
        tombolDaftar.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        tombolDaftar.setText("Daftar");
        tombolDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolDaftarActionPerformed(evt);
            }
        });

        tombolKembali.setBackground(new java.awt.Color(255, 196, 54));
        tombolKembali.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        tombolKembali.setForeground(new java.awt.Color(255, 255, 255));
        tombolKembali.setText("Kembali");
        tombolKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKembaliActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 0));

        jkWanita.setBackground(new java.awt.Color(51, 51, 0));
        jkWanita.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jkWanita.setForeground(new java.awt.Color(153, 153, 0));
        jkWanita.setText("Wanita");
        jkWanita.setToolTipText("Jenis Kelamin Wanita");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 116, 190));
        jLabel2.setText("Nama                 :");

        inputNamaAnggota.setBackground(new java.awt.Color(51, 51, 0));
        inputNamaAnggota.setForeground(new java.awt.Color(255, 255, 0));
        inputNamaAnggota.setToolTipText("Input Nama");
        inputNamaAnggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));
        inputNamaAnggota.setCaretColor(new java.awt.Color(255, 255, 0));
        inputNamaAnggota.setSelectedTextColor(new java.awt.Color(255, 51, 0));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 116, 190));
        jLabel3.setText("NIM                    : ");

        inputNIMAnggota.setBackground(new java.awt.Color(51, 51, 0));
        inputNIMAnggota.setForeground(new java.awt.Color(255, 255, 0));
        inputNIMAnggota.setToolTipText("Input NIM");
        inputNIMAnggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));
        inputNIMAnggota.setCaretColor(new java.awt.Color(255, 255, 0));
        inputNIMAnggota.setSelectedTextColor(new java.awt.Color(255, 51, 0));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 116, 190));
        jLabel4.setText("Alamat               : ");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 116, 190));
        jLabel5.setText("Akun                  :");

        inputAkunAnggota.setBackground(new java.awt.Color(51, 51, 0));
        inputAkunAnggota.setForeground(new java.awt.Color(255, 255, 0));
        inputAkunAnggota.setToolTipText("Input Akun");
        inputAkunAnggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));
        inputAkunAnggota.setCaretColor(new java.awt.Color(255, 255, 0));
        inputAkunAnggota.setSelectedTextColor(new java.awt.Color(255, 51, 0));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 116, 190));
        jLabel6.setText("Password           : ");

        inputPasswordAnggota.setBackground(new java.awt.Color(51, 51, 0));
        inputPasswordAnggota.setForeground(new java.awt.Color(255, 255, 0));
        inputPasswordAnggota.setToolTipText("Input Password");
        inputPasswordAnggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));
        inputPasswordAnggota.setCaretColor(new java.awt.Color(255, 255, 0));
        inputPasswordAnggota.setSelectedTextColor(new java.awt.Color(255, 51, 0));

        inputAlamatAnggota.setBackground(new java.awt.Color(51, 51, 0));
        inputAlamatAnggota.setForeground(new java.awt.Color(255, 255, 0));
        inputAlamatAnggota.setText(" ");
        inputAlamatAnggota.setToolTipText("Input Alamat");
        inputAlamatAnggota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0), 3));
        inputAlamatAnggota.setCaretColor(new java.awt.Color(255, 255, 0));
        inputAlamatAnggota.setSelectedTextColor(new java.awt.Color(255, 51, 0));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 116, 190));
        jLabel7.setText("Jenis Kelamin     :");

        jkPria.setBackground(new java.awt.Color(51, 51, 0));
        jkPria.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jkPria.setForeground(new java.awt.Color(153, 153, 0));
        jkPria.setText("Pria");
        jkPria.setToolTipText("Jenis Kelamin Pria");
        jkPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkPriaActionPerformed(evt);
            }
        });

        outputDaftar.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        outputDaftar.setForeground(new java.awt.Color(255, 0, 0));
        outputDaftar.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(jkPria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jkWanita)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNIMAnggota)
                            .addComponent(inputNamaAnggota)))
                    .addComponent(outputDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputAlamatAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(inputAkunAnggota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputPasswordAnggota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(inputNamaAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(inputNIMAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jkPria)
                    .addComponent(jkWanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputAlamatAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputAkunAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputPasswordAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(tombolKembali)
                        .addGap(204, 204, 204)
                        .addComponent(tombolDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombolKembali)
                    .addComponent(tombolDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolDaftarActionPerformed
        // TODO add your handling code here:
        JOptionPane jop = new JOptionPane();
                int jawab = jop.showConfirmDialog(this, "Ingin meminjam buku tersebut?");
                switch(jawab){
                    case JOptionPane.YES_OPTION: 
                        try{
                            if(this.inputAkunAnggota.getText().isBlank() || this.inputNamaAnggota.getText().isBlank() || this.inputAlamatAnggota.getText().isBlank() || this.inputNIMAnggota.getText().isBlank() || this.inputPasswordAnggota.getText().isBlank()){
                                this.outputDaftar.setText("Mohon untuk tidak mengosongkan data!");
                            }else{
                                this.st = this.koneksi.getConnection().createStatement();
                                String query = String.format("select nim from data_anggota where nim = \"%s\"",this.inputNIMAnggota.getText());
                                this.rs = this.st.executeQuery(query);
                                if(this.rs.next()){
                                    this.outputDaftar.setText("NIM tersebut telah terdaftar!");
                                }else{
                                    if(jkPria.isSelected() || jkWanita.isSelected()){
                                        if(this.inputAkunAnggota.getText().contains("@admin.ac.id")){
                                                this.outputDaftar.setText("Mohon Input dengan format \"@gmail.com\"");
                                        }else if(!this.inputAkunAnggota.getText().contains("@gmail.com") || !this.inputAkunAnggota.getText().contains("@")){
                                                String deteksiAkun = this.inputAkunAnggota.getText() + "@gmail.com";
                                                this.st = this.koneksi.getConnection().createStatement();
                                                String query2 = String.format("select email from data_anggota where email = \"%s\";", deteksiAkun);
                                                this.rs = this.st.executeQuery(query2);
                                                if(this.rs.next() == true){
                                                    this.outputDaftar.setText("Akun tersebut sudah ada, mohon mendaftar dengan akun lain");
                                                }else{
                                                    if(this.jkPria.isSelected()){
                                                        this.st = this.koneksi.getConnection().createStatement();
                                                        String query4 = String.format("insert into data_anggota (nim, nama, alamat, email, password, jenis_kelamin) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.inputNIMAnggota.getText(), this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), (this.inputAkunAnggota.getText() + "@gmail.com"), this.inputPasswordAnggota.getText(), this.jkPria.getText());
                                                        this.st.executeUpdate(query4);
                                                    }else{
                                                        this.st = this.koneksi.getConnection().createStatement();
                                                        String query4 = String.format("insert into data_anggota (nim, nama, alamat, email, password, jenis_kelamin) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.inputNIMAnggota.getText(), this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), (this.inputAkunAnggota.getText() + "@gmail.com"), this.inputPasswordAnggota.getText(), this.jkWanita.getText());
                                                        this.st.executeUpdate(query4);
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                                                    dispose();
                                                    try{
                                                        TimeUnit.SECONDS.sleep(2);
                                                    }catch(InterruptedException a){
                                                        a.printStackTrace();
                                                    }
                                                    this.log.setVisible(true);
                                                }
                                        }else if(this.inputAkunAnggota.getText().contains("@gmail.com")){
                                                this.st = this.koneksi.getConnection().createStatement();
                                                String query3 = String.format("select email from data_anggota where email = \"%s\";", this.inputAkunAnggota.getText());
                                                this.rs = this.st.executeQuery(query3);
                                                if(this.rs.next() == true){
                                                    this.outputDaftar.setText("Akun tersebut sudah ada, mohon mendaftar dengan akun lain");
                                                }else{
                                                    if(this.jkPria.isSelected()){
                                                        this.st = this.koneksi.getConnection().createStatement();
                                                        String query4 = String.format("insert into data_anggota (nim, nama, alamat, email, password, jenis_kelamin) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.inputNIMAnggota.getText(), this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), this.inputAkunAnggota.getText(), this.inputPasswordAnggota.getText(), this.jkPria.getText());
                                                        this.st.executeUpdate(query4);
                                                    }else{
                                                        this.st = this.koneksi.getConnection().createStatement();
                                                        String query4 = String.format("insert into data_anggota (nim, nama, alamat, email, password, jenis_kelamin) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.inputNIMAnggota.getText(), this.inputNamaAnggota.getText(), this.inputAlamatAnggota.getText(), this.inputAkunAnggota.getText(), this.inputPasswordAnggota.getText(), this.jkWanita.getText());
                                                        this.st.executeUpdate(query4);
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                                                    dispose();;
                                                    try{
                                                        TimeUnit.SECONDS.sleep(2);
                                                    }catch(InterruptedException a){
                                                        a.printStackTrace();
                                                    }
                                                    this.log.setVisible(true);
                                                }
                                            }
                                        }else{
                                            this.outputDaftar.setText("Mohon memilih jenis kelamin!");
                                        }

                                }

                            }
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(this, "Berhasil Mendaftar");
                        break;
                    case JOptionPane.NO_OPTION:
                        JOptionPane.showMessageDialog(this, "Mohon mengecek kembali data input Anda!");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(this, "Membatalkan pendaftaran");
                }
    }//GEN-LAST:event_tombolDaftarActionPerformed

    private void jkPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkPriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jkPriaActionPerformed

    private void tombolKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKembaliActionPerformed
        // TODO add your handling code here:
        dispose();
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException a){
            a.printStackTrace();
        }
        this.log.setVisible(true);
    }//GEN-LAST:event_tombolKembaliActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputAkunAnggota;
    private javax.swing.JTextField inputAlamatAnggota;
    private javax.swing.JTextField inputNIMAnggota;
    private javax.swing.JTextField inputNamaAnggota;
    private javax.swing.JPasswordField inputPasswordAnggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jkPria;
    private javax.swing.JRadioButton jkWanita;
    private javax.swing.JLabel outputDaftar;
    private javax.swing.JButton tombolDaftar;
    private javax.swing.JButton tombolKembali;
    // End of variables declaration//GEN-END:variables
}
