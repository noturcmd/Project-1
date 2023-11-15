/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpustakaan;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author acer_
 */
public class HomeAnggota extends javax.swing.JFrame {


    private KoneksiDatabase dbConnection;
    ResultSet rs = null;
    Statement st = null;
    
    boolean isRequestBuku = false;
    private UbahBiodataAnggota ubahData = null;

    ArrayList<String> listJudulBuku = new ArrayList<String>();
    ArrayList<String> listPenulisBuku = new ArrayList<String>();
    ArrayList<String> listDeskripsiSingkat = new ArrayList<String>();
    ArrayList<String> listStokBuku = new ArrayList<String>();

    int curIndex = 0;
    int maxIndex;
    
//    public static void main(String[] args) {
//        new HomeAnggota().showData();
//    }
    public HomeAnggota() {
        dbConnection = KoneksiDatabase.getInstance();
        dataBuku();
        initComponents();
        getContentPane().setBackground(new Color(1,116,190));
        gambarCoverBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/" + this.listJudulBuku.get(curIndex) + ".jpeg")));
        this.titleBuku.setText(this.listJudulBuku.get(curIndex));
        this.penulis.setText(this.listPenulisBuku.get(curIndex));
        this.deskripsiSingkat.setText("<html>" + this.listDeskripsiSingkat.get(curIndex) + "</html>");
        this.stokBuku.setText(this.listStokBuku.get(curIndex));
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.buttonACC.setVisible(false);
        this.tombolBatalkanReq.setVisible(false);
        this.labelSisaWaktu.setVisible(false);
        this.labelSisaWaktu2.setVisible(false);
    }

    private void showData() {
        gambarCoverBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/" + this.listJudulBuku.get(curIndex) + ".jpeg")));
        this.titleBuku.setText(this.listJudulBuku.get(curIndex));
        this.penulis.setText(this.listPenulisBuku.get(curIndex));
        this.deskripsiSingkat.setText("<html>" + this.listDeskripsiSingkat.get(curIndex) + "</html>");
        this.stokBuku.setText(this.listStokBuku.get(curIndex));
    }

    private void dataBuku() {
        try {
            this.st = this.dbConnection.getConnection().createStatement();
            String query1 = String.format("select judul, penulis, deskripsi_singkat, jumlah_tersedia from data_buku;");
            this.rs = st.executeQuery(query1);
            while (rs.next()) {
                this.listJudulBuku.add(rs.getString("judul"));
                this.listPenulisBuku.add(rs.getString("penulis"));
                this.listDeskripsiSingkat.add(rs.getString("deskripsi_singkat"));
                this.listStokBuku.add(rs.getString("jumlah_tersedia"));
            }
            this.maxIndex = this.listJudulBuku.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void statusRequestPeminjamanBuku(){
        try{
            this.st = this.dbConnection.getConnection().createStatement();
            String query2 = String.format("select status_request,judul_buku from request_peminjaman where nim = \"%s\" order by id_request desc;", this.nimAnggotaTerpilih.getText());
            this.rs = st.executeQuery(query2);
            if(rs.next()){
                if(rs.getString("status_request").equals("Diminta")){
                    this.setsetaja.setText("Judul : ");
                    this.statusReq.setText("Status   : Diminta");
                    this.judulBukuReq.setText("<html>" + rs.getString("judul_buku") + "</html>");
                    this.buttonACC.setVisible(false);
                    this.apaAdaYangDipinjam.setText("Request Buku");
                    isRequestBuku = true;
                }else if (rs.getString("status_request").equals("Ditolak")) {
                    this.setsetaja.setText("Judul : ");
                    this.statusReq.setText("Status   : Ditolak");
                    this.statusReq.setForeground(new java.awt.Color(255,0,0));
                    this.judulBukuReq.setText("<html>" + rs.getString("judul_buku") + "</html>");
                    this.buttonACC.setVisible(true);
                    this.apaAdaYangDipinjam.setText("Request Buku");
                    isRequestBuku = false;
                }else{
                    this.setsetaja.setText("Judul : ");
                    this.statusReq.setText("Status   : Buku telah Diterima");
                    this.statusReq.setForeground(new java.awt.Color(255,0,0));
                    this.judulBukuReq.setText("<html>" + rs.getString("judul_buku") + "</html>");
                    this.buttonACC.setVisible(false);
                    this.apaAdaYangDipinjam.setText("Request Buku");
                    isRequestBuku = true;
                    String updateSisaWaktu = "UPDATE data_transaksi SET sisa_waktu = CASE \n" +
                                "WHEN TIMESTAMPDIFF(minute,now(), tanggal_pengembalian) = 0 THEN concat_ws(\" \", convert(timestampdiff(second, now(), tanggal_pengembalian), char), \"detik\")\n" +
                                "WHEN TIMESTAMPDIFF(hour,now(), tanggal_pengembalian) = 0 THEN concat_ws(\" \", convert(timestampdiff(minute, now(), tanggal_pengembalian), char), \"menit\")\n" +
                                "WHEN TIMESTAMPDIFF(day,now(), tanggal_pengembalian) = 0 THEN concat_ws(\" \", convert(timestampdiff(hour, now(), tanggal_pengembalian), char), \"jam\")\n" +
                                "WHEN TIMESTAMPDIFF(day,now(), tanggal_pengembalian) > 0 THEN concat_ws(\" \", convert(timestampdiff(day, now(), tanggal_pengembalian), char), \"hari\")\n" +
                                "ELSE concat_ws(\" \", \"Telat\",convert(timestampdiff(day, tanggal_pengembalian, now()), char), \"hari\")\n" +
                                "END;";
                    st.executeUpdate(updateSisaWaktu);
                    String cekDurasiWaktu = String.format("select sisa_waktu from data_transaksi where nim = \"%s\" order by id_transaksi desc", this.nimAnggotaTerpilih.getText());
                    ResultSet rsCekWaktu = this.st.executeQuery(cekDurasiWaktu);
                    if(rsCekWaktu.next()){
                            System.out.println("Ada sisa waktu dari anggota nim tersebut");
                            this.labelSisaWaktu2.setText(rsCekWaktu.getString("sisa_waktu"));
                            if(labelSisaWaktu2.getText().contains("-")){
                                this.labelSisaWaktu.setText("Telat");
                            }
                            this.labelSisaWaktu.setVisible(true);
                            this.labelSisaWaktu2.setVisible(true);
                    }
                }
            }else{
                this.apaAdaYangDipinjam.setText("Tidak ada buku yang dipinjam");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    void anggotaTerpilih(String nama, String nim, String alamat){
        this.namaAnggotaTerpilih.setText(nama);
        this.nimAnggotaTerpilih.setText(nim);
        this.alamatAnggotaTerpilih.setText(alamat);
        statusRequestPeminjamanBuku();
    }
    private void prev() {
        this.curIndex--;
        if (this.curIndex < 0) {
            this.curIndex = this.maxIndex - 1;
        }

        showData();
    }

    private void next() {
        this.curIndex++;
        if (this.curIndex >= this.maxIndex) {
            this.curIndex = 0;
        }
        showData();
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
        gambarCoverBuku = new javax.swing.JLabel();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        penulis = new javax.swing.JLabel();
        stokBuku = new javax.swing.JLabel();
        titleBuku = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        deskripsiSingkat = new javax.swing.JLabel();
        tombolPinjam = new javax.swing.JButton();
        tombolLogout = new javax.swing.JButton();
        statusRequest = new javax.swing.JPanel();
        statusReq = new javax.swing.JLabel();
        setsetaja = new javax.swing.JLabel();
        apaAdaYangDipinjam = new javax.swing.JLabel();
        judulBukuReq = new javax.swing.JLabel();
        buttonACC = new javax.swing.JButton();
        tombolBatalkanReq = new javax.swing.JButton();
        labelSisaWaktu = new javax.swing.JLabel();
        labelSisaWaktu2 = new javax.swing.JLabel();
        panelTampilBiodata = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nimAnggotaTerpilih = new javax.swing.JLabel();
        namaAnggotaTerpilih = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        alamatAnggotaTerpilih = new javax.swing.JLabel();
        tombolUbahDataDiri = new javax.swing.JButton();
        tombolRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anggota - Home Page");
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        gambarCoverBuku.setBackground(new java.awt.Color(0, 255, 51));
        gambarCoverBuku.setText("jLabel1");
        gambarCoverBuku.setMaximumSize(new java.awt.Dimension(562, 265));
        gambarCoverBuku.setMinimumSize(new java.awt.Dimension(277, 16));
        gambarCoverBuku.setPreferredSize(new java.awt.Dimension(562, 265));
        gambarCoverBuku.setRequestFocusEnabled(false);

        prev.setText("<");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setText("Stok        : ");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setText("penulis                        :");

        penulis.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        penulis.setText("jLabel4");

        stokBuku.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        stokBuku.setText("jLabel4");

        titleBuku.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        titleBuku.setText("jLabel4");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel4.setText("Deskripsi Singkat       :");

        deskripsiSingkat.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        deskripsiSingkat.setText("jLabel5");
        deskripsiSingkat.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        tombolPinjam.setBackground(new java.awt.Color(255, 240, 206));
        tombolPinjam.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tombolPinjam.setForeground(new java.awt.Color(0, 204, 204));
        tombolPinjam.setText("PINJAM");
        tombolPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolPinjamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(gambarCoverBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(prev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(titleBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(penulis, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(deskripsiSingkat, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(next)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tombolPinjam)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stokBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(gambarCoverBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(penulis, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(next))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(deskripsiSingkat, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(prev))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stokBuku))
                .addGap(18, 18, 18)
                .addComponent(tombolPinjam)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tombolLogout.setBackground(new java.awt.Color(255, 240, 206));
        tombolLogout.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        tombolLogout.setForeground(new java.awt.Color(153, 0, 102));
        tombolLogout.setText("Logout");
        tombolLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLogoutActionPerformed(evt);
            }
        });

        statusRequest.setBackground(new java.awt.Color(0, 102, 102));

        statusReq.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusReq.setText(" ");

        setsetaja.setText(" ");

        apaAdaYangDipinjam.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        apaAdaYangDipinjam.setForeground(new java.awt.Color(0, 204, 255));
        apaAdaYangDipinjam.setText(" ");

        judulBukuReq.setText(" ");

        buttonACC.setBackground(new java.awt.Color(153, 153, 0));
        buttonACC.setText("OK");
        buttonACC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonACCActionPerformed(evt);
            }
        });

        tombolBatalkanReq.setBackground(new java.awt.Color(153, 153, 0));
        tombolBatalkanReq.setText("Batalkan");
        tombolBatalkanReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBatalkanReqActionPerformed(evt);
            }
        });

        labelSisaWaktu.setText("Sisa Waktu  :");

        labelSisaWaktu2.setText("jLabel8");

        javax.swing.GroupLayout statusRequestLayout = new javax.swing.GroupLayout(statusRequest);
        statusRequest.setLayout(statusRequestLayout);
        statusRequestLayout.setHorizontalGroup(
            statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusRequestLayout.createSequentialGroup()
                .addGroup(statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusRequestLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusReq, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(statusRequestLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(setsetaja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(judulBukuReq, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(statusRequestLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(apaAdaYangDipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusRequestLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statusRequestLayout.createSequentialGroup()
                                .addComponent(buttonACC)
                                .addGap(30, 30, 30)
                                .addComponent(tombolBatalkanReq))
                            .addGroup(statusRequestLayout.createSequentialGroup()
                                .addComponent(labelSisaWaktu)
                                .addGap(18, 18, 18)
                                .addComponent(labelSisaWaktu2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statusRequestLayout.setVerticalGroup(
            statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusRequestLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(apaAdaYangDipinjam)
                .addGap(18, 18, 18)
                .addComponent(statusReq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(setsetaja)
                    .addComponent(judulBukuReq, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSisaWaktu)
                    .addComponent(labelSisaWaktu2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(statusRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonACC)
                    .addComponent(tombolBatalkanReq))
                .addContainerGap())
        );

        panelTampilBiodata.setBackground(new java.awt.Color(0, 51, 153));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 196, 54));
        jLabel5.setText("Nama        :");

        nimAnggotaTerpilih.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        nimAnggotaTerpilih.setForeground(new java.awt.Color(255, 196, 54));
        nimAnggotaTerpilih.setText("nim");

        namaAnggotaTerpilih.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        namaAnggotaTerpilih.setForeground(new java.awt.Color(255, 196, 54));
        namaAnggotaTerpilih.setText("nama");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 196, 54));
        jLabel6.setText("NIM          :");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 196, 54));
        jLabel7.setText("Alamat      :");

        alamatAnggotaTerpilih.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        alamatAnggotaTerpilih.setForeground(new java.awt.Color(255, 196, 54));
        alamatAnggotaTerpilih.setText("alamat");

        javax.swing.GroupLayout panelTampilBiodataLayout = new javax.swing.GroupLayout(panelTampilBiodata);
        panelTampilBiodata.setLayout(panelTampilBiodataLayout);
        panelTampilBiodataLayout.setHorizontalGroup(
            panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTampilBiodataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTampilBiodataLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaAnggotaTerpilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelTampilBiodataLayout.createSequentialGroup()
                        .addGroup(panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nimAnggotaTerpilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alamatAnggotaTerpilih, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelTampilBiodataLayout.setVerticalGroup(
            panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTampilBiodataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(namaAnggotaTerpilih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nimAnggotaTerpilih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTampilBiodataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(alamatAnggotaTerpilih))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tombolUbahDataDiri.setBackground(new java.awt.Color(194, 190, 70));
        tombolUbahDataDiri.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        tombolUbahDataDiri.setText("Ubah Data");
        tombolUbahDataDiri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahDataDiriActionPerformed(evt);
            }
        });

        tombolRefresh.setBackground(new java.awt.Color(255, 255, 0));
        tombolRefresh.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        tombolRefresh.setText("Refresh");
        tombolRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTampilBiodata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tombolUbahDataDiri)
                                .addGap(7, 7, 7)
                                .addComponent(tombolRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(statusRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(tombolLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTampilBiodata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolUbahDataDiri)
                            .addComponent(tombolRefresh)))
                    .addComponent(statusRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tombolLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_prevActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_nextActionPerformed

    private void tombolLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLogoutActionPerformed
        // TODO add your handling code here:
        dispose();
        Login login = new Login();
        login.setVisible(true);

    }//GEN-LAST:event_tombolLogoutActionPerformed

    private void tombolRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolRefreshActionPerformed
        // TODO add your handling code here:
        try{
            this.st = this.dbConnection.getConnection().createStatement();
            String query1 = String.format("select jumlah_tersedia from data_buku where judul = \"%s\";", this.listJudulBuku.get(curIndex));
            this.rs = st.executeQuery(query1);
            while (rs.next()) {
                this.stokBuku.setText(rs.getString("jumlah_tersedia"));
            }
            
            this.st = this.dbConnection.getConnection().createStatement();
            String query3 = String.format("select nama, nim, alamat from data_anggota where nim = \"%s\";", this.nimAnggotaTerpilih.getText());
            this.rs = st.executeQuery(query3);
            while (rs.next()) {
                this.namaAnggotaTerpilih.setText(rs.getString("nama"));
                this.alamatAnggotaTerpilih.setText(rs.getString("alamat"));
            }
            
            
            if(this.isRequestBuku == true){
                this.st = this.dbConnection.getConnection().createStatement();
                String query2 = String.format("select status_request,judul_buku from request_peminjaman where nim = \"%s\" order by id_request desc;", this.nimAnggotaTerpilih.getText());
                this.rs = st.executeQuery(query2);
                if(rs.next()){
                    isRequestBuku = true;
                    if(rs.getString("status_request").equals("Diminta")){
                        System.out.println("Buku telah diminta");
                        this.setsetaja.setText("Judul : ");
                        this.statusReq.setText("Status   : Diminta");
                        this.judulBukuReq.setText("<html>" + rs.getString("judul_buku") + "</html>");
                        this.buttonACC.setVisible(false);
                        this.tombolBatalkanReq.setVisible(true);
                        this.apaAdaYangDipinjam.setText("Request Buku");
                        isRequestBuku = true;
                    }else if (rs.getString("status_request").equals("Ditolak")) {
                        System.out.println("Buku telah ditolak");
                        this.setsetaja.setText("Judul : ");
                        this.statusReq.setText("Status   : Ditolak");
                        this.statusReq.setForeground(new java.awt.Color(255,0,0));
                        this.judulBukuReq.setText("<html>" + rs.getString("judul_buku") + "</html>");
                        this.buttonACC.setVisible(true);
                        this.apaAdaYangDipinjam.setText("Request Buku");
                        isRequestBuku = false;
                    }else{
                        System.out.println("Buku telah diterima");
                        this.setsetaja.setText("Judul : ");
                        this.statusReq.setText("Status   : Buku telah Diterima");
                        this.statusReq.setForeground(new java.awt.Color(255,0,0));
                        this.judulBukuReq.setText("<html>" + rs.getString("judul_buku") + "</html>");
                        this.buttonACC.setVisible(false);
                        this.apaAdaYangDipinjam.setText("Request Buku");
                        isRequestBuku = true; 
                        String updateSisaWaktu = "UPDATE data_transaksi SET sisa_waktu = CASE \n" +
                                "WHEN TIMESTAMPDIFF(minute,now(), tanggal_pengembalian) = 0 THEN concat_ws(\" \", convert(timestampdiff(second, now(), tanggal_pengembalian), char), \"detik\")\n" +
                                "WHEN TIMESTAMPDIFF(hour,now(), tanggal_pengembalian) = 0 THEN concat_ws(\" \", convert(timestampdiff(minute, now(), tanggal_pengembalian), char), \"menit\")\n" +
                                "WHEN TIMESTAMPDIFF(day,now(), tanggal_pengembalian) = 0 THEN concat_ws(\" \", convert(timestampdiff(hour, now(), tanggal_pengembalian), char), \"jam\")\n" +
                                "WHEN TIMESTAMPDIFF(day,now(), tanggal_pengembalian) > 0 THEN concat_ws(\" \", convert(timestampdiff(day, now(), tanggal_pengembalian), char), \"hari\")\n" +
                                "ELSE concat_ws(\" \", \"Telat\",convert(timestampdiff(day, tanggal_pengembalian, now()), char), \"hari\")\n" +
                                "END;";
                        st.executeUpdate(updateSisaWaktu);
                        String cekDurasiWaktu = String.format("select sisa_waktu from data_transaksi where nim = \"%s\" order by id_transaksi desc", this.nimAnggotaTerpilih.getText());
                        ResultSet rsCekWaktu = this.st.executeQuery(cekDurasiWaktu);
                        if(rsCekWaktu.next()){
                            System.out.println("Ada sisa waktu dari anggota nim tersebut");
                            this.labelSisaWaktu.setVisible(true);
                            if(labelSisaWaktu2.getText().contains("-")){
                                this.labelSisaWaktu.setText("Telat : ");
                            }
                            this.labelSisaWaktu2.setText(rsCekWaktu.getString("sisa_waktu"));
                            this.labelSisaWaktu2.setVisible(true);
                        }
                    }
                }else{
                    this.apaAdaYangDipinjam.setText("Tidak ada buku yang dipinjam");
                    }
                }
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_tombolRefreshActionPerformed

    private void tombolPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolPinjamActionPerformed
        // TODO add your handling code here:
                JOptionPane jop = new JOptionPane();
                int jawab = jop.showConfirmDialog(this, "Ingin meminjam buku tersebut?");
                switch(jawab){
                    case JOptionPane.YES_OPTION: 
                        JOptionPane.showMessageDialog(this, "Permintaan diterima, mohon menunggu");
                        System.out.println("pilih yes");
                        try{
                            String idReq = null;
                            this.st = this.dbConnection.getConnection().createStatement();
                            String query2 = String.format("select status_request from request_peminjaman where nim = \"%s\" order by id_request desc;", this.nimAnggotaTerpilih.getText());
                            this.rs = st.executeQuery(query2);
                            System.out.println("nyari status request");
                            if(rs.next()){
                                if((rs.getString("status_request").equals("Diminta") || rs.getString("status_request").equals("Diterima"))){
                                    System.out.println("Status req diterima\\diminta");
                                    JOptionPane.showMessageDialog(this, "Mohon maaf, hanya bisa meminjam 1 buku per akun selama batas waktu tertentu");
                                }else if(rs.getString("status_request").equals("Ditolak")){
                                    System.out.println("Status req ditolak");
                                    this.st = this.dbConnection.getConnection().createStatement();
                                    String query3 = String.format("select id_request from request_peminjaman where nim = \"%s\" order by id_request desc;", this.nimAnggotaTerpilih.getText());
                                    this.rs = st.executeQuery(query3);
                                    if(rs.next()){
                                        System.out.println("ada id request");
                                        idReq = rs.getString("id_request");
                                        String[] kata = idReq.split(String.format("REQ%s",this.nimAnggotaTerpilih.getText()));
                                        if(!(kata.length == 0)){
                                            System.out.println("Array tidak kosong");
                                            this.st = this.dbConnection.getConnection().createStatement();
                                            String query12 = String.format("select id_buku from data_buku where judul = \"%s\"",this.listJudulBuku.get(curIndex));
                                            this.rs = this.st.executeQuery(query12);
                                            if(this.rs.next()){
                                                String query4 = String.format("insert into request_peminjaman (id_request, nama, nim, judul_buku, status_request, id_buku) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", "REQ" + this.nimAnggotaTerpilih.getText() + String.valueOf(Integer.valueOf(kata[(kata.length - 1)]) + 1), this.namaAnggotaTerpilih.getText(), this.nimAnggotaTerpilih.getText(), this.listJudulBuku.get(curIndex), "Diminta",this.rs.getString("id_buku"));
                                                st.executeUpdate(query4);
                                                this.isRequestBuku = true;
                                            }
                                        } 
                                    }
                                }
                            }else{
                                this.st = this.dbConnection.getConnection().createStatement();
                                String query12 = String.format("select id_buku from data_buku where judul = \"%s\"",this.listJudulBuku.get(curIndex));
                                this.rs = this.st.executeQuery(query12);
                                if(this.rs.next()){
                                    String query5 = String.format("insert into request_peminjaman (id_request, nama, nim, judul_buku, status_request, id_buku) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", "REQ" + this.nimAnggotaTerpilih.getText() + "1", this.namaAnggotaTerpilih.getText(), this.nimAnggotaTerpilih.getText(), this.listJudulBuku.get(curIndex), "Diminta", this.rs.getString("id_buku"));
                                    st.executeUpdate(query5);
                                    System.out.println("Udah ditambahin karena sebelumnya engga ada request");
                                    this.isRequestBuku = true;
                                }
                                
                            }
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                        break;
                    case JOptionPane.NO_OPTION:
                        JOptionPane.showMessageDialog(this, "Buku tidak jadi dipinjam");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(this, "Membatalkan opsi");
                }
        
    }//GEN-LAST:event_tombolPinjamActionPerformed

    private void buttonACCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonACCActionPerformed
        // TODO add your handling code here:
        this.setsetaja.setText("");
        this.statusReq.setText("");
        this.judulBukuReq.setText("");
        this.buttonACC.setVisible(false);
        this.apaAdaYangDipinjam.setText("Tidak ada buku yang dipinjam");
        this.tombolBatalkanReq.setVisible(false);
       
    }//GEN-LAST:event_buttonACCActionPerformed

    private void tombolUbahDataDiriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahDataDiriActionPerformed
        // TODO add your handling code here:
        if(ubahData == null){
            ubahData = new UbahBiodataAnggota();
        }
        
        try{
            this.st = this.dbConnection.getConnection().createStatement();
            String query1 = String.format("select * from data_anggota where nim = \"%s\";", this.nimAnggotaTerpilih.getText());
            this.rs = st.executeQuery(query1);
            if(rs.next()) {
                ubahData.biodata(rs.getString("nama"),rs.getString("nim"), rs.getString("jenis_kelamin"),rs.getString("alamat"),rs.getString("email"), rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        ubahData.setVisible(true);
    }//GEN-LAST:event_tombolUbahDataDiriActionPerformed

    private void tombolBatalkanReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBatalkanReqActionPerformed
        // TODO add your handling code here:
        JOptionPane jop = new JOptionPane();
                int jawab = jop.showConfirmDialog(this, "Ingin meminjam buku tersebut?");
                switch(jawab){
                    case JOptionPane.YES_OPTION: 
                        try{
                            this.st = this.dbConnection.getConnection().createStatement();
                            String query2 = String.format("select status_request from request_peminjaman where nim = \"%s\" and judul = \"%s\" order by id_request desc;", this.nimAnggotaTerpilih.getText(), this.judulBukuReq.getText());
                            this.rs = st.executeQuery(query2);
                            System.out.println("nyari status request");
                            if(this.rs.next()){
                                String query4 = String.format("update request_peminjaman set status_request = \"Dibatalkan\" where nim = \"%s\" and judul = \"%s\" order by id_request desc;", this.nimAnggotaTerpilih.getText(), this.judulBukuReq.getText());
                                st.executeUpdate(query4);
                            }
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(this, "Permintaan Dibatalkan");
                        break;
                    case JOptionPane.NO_OPTION:
                        JOptionPane.showMessageDialog(this, "Peminjaman tidak jadi dibatalkan");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(this, "Membatalkan opsi");
                }
    }//GEN-LAST:event_tombolBatalkanReqActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatAnggotaTerpilih;
    private javax.swing.JLabel apaAdaYangDipinjam;
    private javax.swing.JButton buttonACC;
    private javax.swing.JLabel deskripsiSingkat;
    private javax.swing.JLabel gambarCoverBuku;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel judulBukuReq;
    private javax.swing.JLabel labelSisaWaktu;
    private javax.swing.JLabel labelSisaWaktu2;
    private javax.swing.JLabel namaAnggotaTerpilih;
    private javax.swing.JButton next;
    private javax.swing.JLabel nimAnggotaTerpilih;
    private javax.swing.JPanel panelTampilBiodata;
    private javax.swing.JLabel penulis;
    private javax.swing.JButton prev;
    private javax.swing.JLabel setsetaja;
    private javax.swing.JLabel statusReq;
    private javax.swing.JPanel statusRequest;
    private javax.swing.JLabel stokBuku;
    private javax.swing.JLabel titleBuku;
    private javax.swing.JButton tombolBatalkanReq;
    private javax.swing.JButton tombolLogout;
    private javax.swing.JButton tombolPinjam;
    private javax.swing.JButton tombolRefresh;
    private javax.swing.JButton tombolUbahDataDiri;
    // End of variables declaration//GEN-END:variables
}
