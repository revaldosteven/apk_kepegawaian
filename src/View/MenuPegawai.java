/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Kelas.Kategori;
import Kelas.Bagian;
import Kelas.Jabatan;
import Kelas.Pegawai;
import PopUp.PopUpPegawai;
import PopUp.PopUpBagian;
import PopUp.PopUpPegawai;
import static PopUp.PopUpPegawai.DateTanggalMasuk;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Good_Poeple
 */
public class MenuPegawai extends javax.swing.JPanel {

    /**
     * Creates new form Devisi
     */
    public MenuPegawai() {
        initComponents();
        loadTable();
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String keyword = txtCari.getText().trim(); // Ambil teks pencarian
                cariPegawai(keyword); // Panggil metode pencarian
            }
        });
//        comboBoxBagian();
//        comboBoxJabatan();
    }
  void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("NIDN");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Alamat");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Status");
        model.addColumn("Kategori");
        model.addColumn("Bagian");
        model.addColumn("Jabatan");
        
        

        try {
            Kelas.Pegawai pg = new Kelas.Pegawai();
            ResultSet data = pg.tampilPegawai();
            
            

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("nik"),
                    data.getString("nama"),
                    data.getString("nidn"),
                    data.getString("jenis_kelamin"),
                    data.getString("email"),
                    data.getString("telepon"),
                    data.getString("alamat"),
                    data.getDate("tanggal_masuk"),
                    data.getString("status"),
                    data.getString("nama_kategori"),
                    data.getString("nama_bagian"),
                    data.getString("nama_jabatan"),});

            }

        } catch (SQLException sQLException) {

        }

        tblPegawai.setModel(model);
    }
  
    void cariPegawai(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("NIDN");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Alamat");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Kategori");
        model.addColumn("Bagian");
        model.addColumn("Jabatan");
        model.addColumn("Status");

        try {
            Pegawai pg = new Pegawai(); // Instansiasi kelas Pegawai
            ResultSet data = pg.cariPegawai(keyword); // Panggil metode dari kelas Pegawai

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("nik"),
                    data.getString("nama"),
                    data.getString("nidn"),
                    data.getString("jenis_kelamin"),
                    data.getString("email"),
                    data.getString("telepon"),
                    data.getString("alamat"),
                    data.getDate("tanggal_masuk"), 
                    data.getString("status"),
                    data.getString("id_kategori"),
                    data.getString("id_bagian"),
                    data.getString("id_jabatan")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

        tblPegawai.setModel(model); // Set hasil pencarian ke tabel
    }
   
  
  
//  void loadFilterDevisi() {
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("ID Pegawai");
//        model.addColumn("Nama");
//        model.addColumn("Nip");
//        model.addColumn("Nidn");
//        model.addColumn("Jenis Kelamin");
//        model.addColumn("Email");
//        model.addColumn("Telepon");
//        model.addColumn("Alamat");
//        model.addColumn("Tanggal Masuk");
//        model.addColumn("Status");
//        model.addColumn("Devisi");
//        model.addColumn("Jabatan");
//        
//        
//
//        try {
//            Kelas.Pegawai pg = new Kelas.Pegawai();
//            ResultSet data = pg.tampilPegawai();
//
//            while (data.next()) {
//                model.addRow(new Object[]{
//                    data.getString("id_pegawai"),
//                    data.getString("nama"),
//                    data.getString("nip"),
//                    data.getString("nidn"),
//                    data.getString("jenis_kelamin"),
//                    data.getString("email"),
//                    data.getString("telepon"),
//                    data.getString("alamat"),
//                    data.getString("tanggal_masuk"),
//                    data.getString("status"),
//                    data.getString("nama_devisi"),
//                    data.getString("nama_jabatan"),});
//
//            }
//
//        } catch (SQLException sQLException) {
//
//        }
//
//        tblPegawai.setModel(model);
//    }
//  
//    
//    void loadFilterJabatan() {
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("ID Pegawai");
//        model.addColumn("Nama");
//        model.addColumn("Nip");
//        model.addColumn("Nidn");
//        model.addColumn("Jenis Kelamin");
//        model.addColumn("Email");
//        model.addColumn("Telepon");
//        model.addColumn("Alamat");
//        model.addColumn("Tanggal Masuk");
//        model.addColumn("Status");
//        model.addColumn("Devisi");
//        model.addColumn("Jabatan");
//        
//        
//
//        try {
//            Kelas.Pegawai pg = new Kelas.Pegawai();
//            ResultSet data = pg.tampilPegawai();
//
//            while (data.next()) {
//                model.addRow(new Object[]{
//                    data.getString("id_pegawai"),
//                    data.getString("nama"),
//                    data.getString("nip"),
//                    data.getString("nidn"),
//                    data.getString("jenis_kelamin"),
//                    data.getString("email"),
//                    data.getString("telepon"),
//                    data.getString("alamat"),
//                    data.getString("tanggal_masuk"),
//                    data.getString("status"),
//                    data.getString("nama_devisi"),
//                    data.getString("nama_jabatan"),});
//
//            }
//
//        } catch (SQLException sQLException) {
//
//        }
//
//        tblPegawai.setModel(model);
//    }
//    
//        void loadFilterDevisiDanJabatan() {
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("ID Pegawai");
//        model.addColumn("Nama");
//        model.addColumn("Nip");
//        model.addColumn("Nidn");
//        model.addColumn("Jenis Kelamin");
//        model.addColumn("Email");
//        model.addColumn("Telepon");
//        model.addColumn("Alamat");
//        model.addColumn("Tanggal Masuk");
//        model.addColumn("Status");
//        model.addColumn("Devisi");
//        model.addColumn("Jabatan");
//        
//        
//
//        try {
//            Kelas.Pegawai pg = new Kelas.Pegawai();
//            ResultSet data = pg.tampilDevisiDanJabatan();
//
//            while (data.next()) {
//                model.addRow(new Object[]{
//                    data.getString("id_pegawai"),
//                    data.getString("nama"),
//                    data.getString("nip"),
//                    data.getString("nidn"),
//                    data.getString("jenis_kelamin"),
//                    data.getString("email"),
//                    data.getString("telepon"),
//                    data.getString("alamat"),
//                    data.getString("tanggal_masuk"),
//                    data.getString("status"),
//                    data.getString("nama_devisi"),
//                    data.getString("nama_jabatan"),});
//
//            }
//
//        } catch (SQLException sQLException) {
//
//        }
//
//        tblPegawai.setModel(model);
//    }
//        
//        void comboBoxKategori() {
//
//        try {
//            Kategori kt = new Kategori();
//            ResultSet data = kt.tampilComBoxKategori();
//
//            while (data.next()) {
//                String isi = data.getString("nama_kategori");
//                cbDVTampilan.addItem(isi);
//            }
//
//        } catch (SQLException ex) {
//
//        }
//
//    }
//    
//        void comboBoxBagian() {
//
//        try {
//            Bagian bg = new Bagian();
//            ResultSet data = bg.tampilComBoxBagian();
//
//            while (data.next()) {
//                String isi = data.getString("nama_bagian");
//                cbDVTampilan.addItem(isi);
//            }
//
//        } catch (SQLException ex) {
//
//        }
//
//    }
//
//    void comboBoxJabatan() {
//
//        try {
//            Jabatan jb = new Jabatan();
//            ResultSet data = jb.tampilComBoxJabatan();
//
//            while (data.next()) {
//                String isi = data.getString("nama_jabatan");
//                cbJBTampilan.addItem(isi);
//            }
//
//        } catch (SQLException ex) {
//
//        }
//
//    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPegawai = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 102));

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Daftar Pegawai");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tblPegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPegawai);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnTambah)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(jLabel2)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
       // PopUp.PopUpPegawai pegawai = new PopUpPegawai();
//        
//        PopUpPegawai pg = new PopUpPegawai();
//        pg.setVisible(true);
//        pg.bEdit.setVisible(false);
//        pg.otoID();PopUpPegawai sk = new PopUpPegawai();
//        sk.setVisible(true);
//        sk.bEdit.setVisible(false);
//        sk.otoID();
//           PopUp.PopUpKaryawan karyawan = new PopUpKaryawan();
//           karyawan.setVisible(true);
            PopUp.PopUpPegawai pegawai = new PopUpPegawai();
            pegawai.setVisible(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void tblPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPegawaiMouseClicked
        // TODO add your handling code here:
        try {
        int baris = tblPegawai.rowAtPoint(evt.getPoint());
        if (baris >= 0) { // Pastikan baris valid
            String Nik = tblPegawai.getValueAt(baris, 0) != null ? tblPegawai.getValueAt(baris, 0).toString() : "";
            String Nama = tblPegawai.getValueAt(baris, 1) != null ? tblPegawai.getValueAt(baris, 1).toString() : "";
            String id_kategori = tblPegawai.getValueAt(baris, 2) != null ? tblPegawai.getValueAt(baris, 2).toString() : "";
            String id_bagian = tblPegawai.getValueAt(baris, 3) != null ? tblPegawai.getValueAt(baris, 3).toString() : "";
            String id_jabatan = tblPegawai.getValueAt(baris, 4) != null ? tblPegawai.getValueAt(baris, 4).toString() : "";
            String Nidn = tblPegawai.getValueAt(baris, 5) != null ? tblPegawai.getValueAt(baris, 5).toString() : "";
            String Jenis_kelamin = tblPegawai.getValueAt(baris, 6) != null ? tblPegawai.getValueAt(baris, 6).toString() : "";
            String Email = tblPegawai.getValueAt(baris, 7) != null ? tblPegawai.getValueAt(baris, 7).toString() : "";
            String Telepon = tblPegawai.getValueAt(baris, 8) != null ? tblPegawai.getValueAt(baris, 8).toString() : "";
            String Alamat = tblPegawai.getValueAt(baris, 9) != null ? tblPegawai.getValueAt(baris, 9).toString() : "";
            String Tanggal_masuk = tblPegawai.getValueAt(baris, 10) != null ? tblPegawai.getValueAt(baris, 10).toString() : "";
//            if (Tanggal_masuk != null && !Tanggal_masuk.isEmpty()) {
//                    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("dd MMMM yyyy", new java.util.Locale("id", "ID"));
//                    java.util.Date date = formatter.parse(Tanggal_masuk);
//                    DateTanggalMasuk.setDate(date);
//                }
            String Status = tblPegawai.getValueAt(baris, 11) != null ? tblPegawai.getValueAt(baris, 11).toString() : "";
            
            // Membuka FrameBarang dan mengirimkan data
            PopUpPegawai pg = new PopUpPegawai();
            pg.setData(Nik, Nama, Nidn, id_kategori, id_bagian, id_jabatan, Jenis_kelamin, Email, Telepon, Alamat, Tanggal_masuk, Status);
            pg.setVisible(true);
            
        }
    } catch (Exception ex) {
            System.out.println("gagal " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memilih data: " + ex.getMessage());
            //System.out.println("ex"+ex.getMessage());
    } finally {
       //isTableSelection = false; // Selesai seleksi dari tabel
    }
    }//GEN-LAST:event_tblPegawaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPegawai;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
