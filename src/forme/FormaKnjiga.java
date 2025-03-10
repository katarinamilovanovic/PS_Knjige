/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import controller.Controller;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author kmilo
 */
public class FormaKnjiga extends javax.swing.JDialog {

    //private Controller kontroler;
    /**
     * Creates new form FormaKnjiga
     */
    private GlavnaForma gf;
    private Knjiga knjigaZaIzmenu;

    public FormaKnjiga(java.awt.Frame parent, boolean modal, Knjiga knjigaZaIzmenu) {
        super(parent, modal);
        initComponents();
        //kontroler = Controller.getInstance();
        this.gf = (GlavnaForma) parent;
        popuniComboBoxAutorima();

        if (knjigaZaIzmenu != null) {
            this.knjigaZaIzmenu = knjigaZaIzmenu;
            txtNaslov.setText(knjigaZaIzmenu.getNaslov());
            cmbAutor.setSelectedItem(knjigaZaIzmenu.getAutor());
            txtISBN.setText(knjigaZaIzmenu.getISBN());
            txtISBN.setEnabled(false);
            txtGodinaIzdanja.setText(String.valueOf(knjigaZaIzmenu.getGodinaIzdanja()));
            //  txtGodinaIzdanja.setText(knjigaZaIzmenu.getGodinaIzdanja() + "");
            cmbZanr.setSelectedItem(knjigaZaIzmenu.getZanr());
            btnDodaj.setVisible(false);

        } else {
            btnIzmeni.setVisible(false);
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

        jLabel1 = new javax.swing.JLabel();
        txtNaslov = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtGodinaIzdanja = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbAutor = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbZanr = new javax.swing.JComboBox<>();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Naziv: ");

        jLabel3.setText("Autor: ");

        jLabel4.setText("Godina izdanja:");

        jLabel5.setText("ISBN:");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jButton2.setText("Odustani");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Zanr:");

        cmbZanr.setModel(new DefaultComboBoxModel(Zanr.values()));

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIzmeni))
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        String naslov = txtNaslov.getText();
        if (naslov == null || naslov.trim().isEmpty() || naslov.trim().length() < 3) {
            JOptionPane.showMessageDialog(this, "Naslov nije u dobrom formatu", "Greska", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String isbn = txtISBN.getText();
        int godinaIzdanja;
        try {
            godinaIzdanja = Integer.parseInt(txtGodinaIzdanja.getText());
            if (godinaIzdanja < 1800 || godinaIzdanja > 2023) {
                JOptionPane.showMessageDialog(this, "Godina izdanja mora biti veca od 1800 i manja od 2023", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Godina izdanja mora biti broj", "Greska", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Zanr zanr = (Zanr) cmbZanr.getSelectedItem();
        Autor autor = (Autor) cmbAutor.getSelectedItem();

        Random rand = new Random();
        int id = 101 + rand.nextInt(Integer.MAX_VALUE - 100);

        Knjiga novaKnjiga = new Knjiga(id, naslov, autor, isbn, godinaIzdanja, zanr);

        Controller.getInstance().dodajKnjiguUBazu(novaKnjiga);
        //Controller.getInstance().dodajKnjigu(novaKnjiga);
        JOptionPane.showMessageDialog(this, "Knjiga je uspesno dodata", "Uspesno", JOptionPane.INFORMATION_MESSAGE);

        gf.osveziTabelu();
        this.dispose();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        String naziv = txtNaslov.getText();
        //String isbn = txtISBN.getText();
        int godinaIzdanja;
        try {
            godinaIzdanja = Integer.parseInt(txtGodinaIzdanja.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Godina izdanja mora biti broj", "Greska", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Zanr zanr = (Zanr) cmbZanr.getSelectedItem();
        Autor autor = (Autor) cmbAutor.getSelectedItem();

        knjigaZaIzmenu.setNaslov(naziv);
        knjigaZaIzmenu.setAutor(autor);
        knjigaZaIzmenu.setGodinaIzdanja(godinaIzdanja);
        // knjigaZaIzmenu.setISBN(isbn);
        knjigaZaIzmenu.setZanr(zanr);

        JOptionPane.showMessageDialog(this, "Knjiga je uspesno izmenjena", "Uspesno", JOptionPane.INFORMATION_MESSAGE);

        Controller.getInstance().azurirajKnjigu(knjigaZaIzmenu);
        gf.osveziTabelu();
        this.dispose();

    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JComboBox<Autor> cmbAutor;
    private javax.swing.JComboBox<String> cmbZanr;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtGodinaIzdanja;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtNaslov;
    // End of variables declaration//GEN-END:variables

    private void popuniComboBoxAutorima() {
        cmbAutor.removeAllItems();

        List<Autor> autori = Controller.getInstance().ucitajListuAutoraIzBaze();
        for (Autor autor : autori) {
            cmbAutor.addItem(autor);
        }
    }
}
