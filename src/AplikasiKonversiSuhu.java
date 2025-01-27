/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Saputra
 */
public class AplikasiKonversiSuhu extends javax.swing.JFrame {

    /**
     * Creates new form AplikasiKonversiSuhu
     */
    public AplikasiKonversiSuhu() {
        initComponents();
        // Menambahkan KeyListener untuk memastikan hanya angka dan titik yang bisa dimasukkan
        tfSuhuAwal.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });
        // Menambahkan DocumentListener untuk konversi otomatis saat nilai input berubah
        tfSuhuAwal.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                konversiOtomatis();
            }
            public void removeUpdate(DocumentEvent e) {
                konversiOtomatis();
            }
            public void changedUpdate(DocumentEvent e) {
                konversiOtomatis();
            }
        });
        // Menambahkan ActionListener untuk konversi otomatis saat suhu awal dipilih
        cbPilihSuhu.addActionListener(e -> konversiOtomatis());
        // Menambahkan ActionListener untuk konversi otomatis saat suhu akhir dipilih
        radioCelcius.addActionListener(e -> konversiOtomatis());
        radioReamur.addActionListener(e -> konversiOtomatis());
        radioKelvin.addActionListener(e -> konversiOtomatis());
        radioFahrenheit.addActionListener(e -> konversiOtomatis());
    }

    // Metode untuk melakukan konversi otomatis
    private void konversiOtomatis() {
        try {
            double suhuAwal = Double.parseDouble(tfSuhuAwal.getText());
            double hasil = 0;
            String suhuAwalUnit = cbPilihSuhu.getSelectedItem().toString();
            String suhuAkhirUnit = "";

            if (radioCelcius.isSelected()) {
                suhuAkhirUnit = "Celcius";
            } else if (radioReamur.isSelected()) {
                suhuAkhirUnit = "Reamur";
            } else if (radioKelvin.isSelected()) {
                suhuAkhirUnit = "Kelvin";
            } else if (radioFahrenheit.isSelected()) {
                suhuAkhirUnit = "Fahrenheit";
            }

            if (suhuAwalUnit.equals(suhuAkhirUnit)) {
                btnHasil.setText("Suhu yang dikonversi sama");
                return;
            }

            switch (suhuAwalUnit) {
                case "Celcius":
                    if (suhuAkhirUnit.equals("Reamur")) {
                        hasil = (4.0 / 5.0) * suhuAwal;
                    } else if (suhuAkhirUnit.equals("Kelvin")) {
                        hasil = suhuAwal + 273.15;
                    } else if (suhuAkhirUnit.equals("Fahrenheit")) {
                        hasil = (suhuAwal * 9.0 / 5.0) + 32;
                    }
                    break;
                case "Reamur":
                    if (suhuAkhirUnit.equals("Celcius")) {
                        hasil = (5.0 / 4.0) * suhuAwal;
                    } else if (suhuAkhirUnit.equals("Kelvin")) {
                        hasil = (5.0 / 4.0) * suhuAwal + 273.15;
                    } else if (suhuAkhirUnit.equals("Fahrenheit")) {
                        hasil = (suhuAwal * 9.0 / 4.0) + 32;
                    }
                    break;
                case "Kelvin":
                    if (suhuAkhirUnit.equals("Celcius")) {
                        hasil = suhuAwal - 273.15;
                    } else if (suhuAkhirUnit.equals("Reamur")) {
                        hasil = (suhuAwal - 273.15) * 4.0 / 5.0;
                    } else if (suhuAkhirUnit.equals("Fahrenheit")) {
                        hasil = (suhuAwal - 273.15) * 9.0 / 5.0 + 32;
                    }
                    break;
                case "Fahrenheit":
                    if (suhuAkhirUnit.equals("Celcius")) {
                        hasil = (suhuAwal - 32) * 5.0 / 9.0;
                    } else if (suhuAkhirUnit.equals("Reamur")) {
                        hasil = (suhuAwal - 32) * 4.0 / 9.0;
                    } else if (suhuAkhirUnit.equals("Kelvin")) {
                        hasil = (suhuAwal - 32) * 5.0 / 9.0 + 273.15;
                    }
                    break;
            }

            DecimalFormat df = new DecimalFormat("#.##");
            btnHasil.setText(df.format(hasil));
        } catch (NumberFormatException e) {
            btnHasil.setText("Invalid input");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroupKonversi = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnHasil = new javax.swing.JTextField();
        tfSuhuAwal = new javax.swing.JTextField();
        cbPilihSuhu = new javax.swing.JComboBox<>();
        btnKonversi = new javax.swing.JButton();
        radioCelcius = new javax.swing.JRadioButton();
        radioReamur = new javax.swing.JRadioButton();
        radioKelvin = new javax.swing.JRadioButton();
        radioFahrenheit = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KONVERSI SUHU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnHasil.setFocusable(false);
        btnHasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHasilActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(34, 4, 4, 4);
        jPanel1.add(btnHasil, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(tfSuhuAwal, gridBagConstraints);

        cbPilihSuhu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celcius", "Reamur", "Kelvin", "Fahrenheit" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(cbPilihSuhu, gridBagConstraints);

        btnKonversi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKonversi.setText("Konversi!");
        btnKonversi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonversiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(34, 4, 4, 4);
        jPanel1.add(btnKonversi, gridBagConstraints);

        buttonGroupKonversi.add(radioCelcius);
        radioCelcius.setText("Celcius");
        radioCelcius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCelciusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(radioCelcius, gridBagConstraints);

        buttonGroupKonversi.add(radioReamur);
        radioReamur.setText("Reamur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(radioReamur, gridBagConstraints);

        buttonGroupKonversi.add(radioKelvin);
        radioKelvin.setText("Kelvin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(radioKelvin, gridBagConstraints);

        buttonGroupKonversi.add(radioFahrenheit);
        radioFahrenheit.setText("Fahrenheit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(radioFahrenheit, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Masukan suhu awal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Pilih hasil Konveris");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 4, 4, 4);
        jPanel1.add(jLabel3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHasilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHasilActionPerformed

    private void radioCelciusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCelciusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCelciusActionPerformed

    private void btnKonversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonversiActionPerformed
        konversiOtomatis();
    }//GEN-LAST:event_btnKonversiActionPerformed

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
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplikasiKonversiSuhu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplikasiKonversiSuhu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField btnHasil;
    private javax.swing.JButton btnKonversi;
    private javax.swing.ButtonGroup buttonGroupKonversi;
    private javax.swing.JComboBox<String> cbPilihSuhu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radioCelcius;
    private javax.swing.JRadioButton radioFahrenheit;
    private javax.swing.JRadioButton radioKelvin;
    private javax.swing.JRadioButton radioReamur;
    private javax.swing.JTextField tfSuhuAwal;
    // End of variables declaration//GEN-END:variables
}
