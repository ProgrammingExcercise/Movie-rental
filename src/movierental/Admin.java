/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movierental;

/**
 *
 * @author stefano
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboPrice = new javax.swing.JComboBox();
        jComboLanguage = new javax.swing.JComboBox();
        jComboAgeRating = new javax.swing.JComboBox();
        jComboRating = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButtonChangeMovie = new javax.swing.JButton();
        jButtonAddMovie = new javax.swing.JButton();
        jComboGenre = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButtonLogOut = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextSearch = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonrentedMovies = new javax.swing.JButton();
        jLabelBild1 = new javax.swing.JLabel();
        jLabelBild9 = new javax.swing.JLabel();
        jLabelBild2 = new javax.swing.JLabel();
        jLabelBild4 = new javax.swing.JLabel();
        jLabelBild5 = new javax.swing.JLabel();
        jLabelBild7 = new javax.swing.JLabel();
        jLabelBild8 = new javax.swing.JLabel();
        jLabelBild10 = new javax.swing.JLabel();
        jLabelBild3 = new javax.swing.JLabel();
        jLabelBild6 = new javax.swing.JLabel();
        jLabelBild11 = new javax.swing.JLabel();
        jLabelBild12 = new javax.swing.JLabel();
        jLabelBild13 = new javax.swing.JLabel();
        jLabelBild14 = new javax.swing.JLabel();
        jLabelBild15 = new javax.swing.JLabel();
        jLabelBild16 = new javax.swing.JLabel();
        jLabelBild17 = new javax.swing.JLabel();
        jLabelBild18 = new javax.swing.JLabel();
        jLabelBild19 = new javax.swing.JLabel();
        jLabelBild20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setText("Top 10");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Verbindung/Turbo.jpg"))); // NOI18N

        jComboPrice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Price", "Item 2", "Item 3", "Item 4" }));
        jComboPrice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboPriceItemStateChanged(evt);
            }
        });
        jComboPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPriceActionPerformed(evt);
            }
        });

        jComboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Language", "Item 2", "Item 3", "Item 4" }));
        jComboLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboLanguageActionPerformed(evt);
            }
        });

        jComboAgeRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Age rating", "Item 2", "Item 3", "Item 4" }));
        jComboAgeRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAgeRatingActionPerformed(evt);
            }
        });

        jComboRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rating", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Search:");

        jButtonChangeMovie.setText("Change Movie");
        jButtonChangeMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeMovieActionPerformed(evt);
            }
        });

        jButtonAddMovie.setText("Add Movie");
        jButtonAddMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMovieActionPerformed(evt);
            }
        });

        jComboGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Genre", "Item 2", "Item 3", "Item 4" }));
        jComboGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGenreActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movierental/Logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jButtonLogOut.setText("Log Out");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel3.setText("Newest 10");

        jScrollPane1.setViewportView(jTextSearch);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Verbindung/Mighty.jpg"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Verbindung/RunnerRunner.jpg"))); // NOI18N

        jButtonrentedMovies.setText("Rented Movies");
        jButtonrentedMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonrentedMoviesActionPerformed(evt);
            }
        });

        jLabelBild1.setText("jLabel17");

        jLabelBild9.setText("jLabel9");

        jLabelBild2.setText("jLabel18");

        jLabelBild4.setText("jLabel4");

        jLabelBild5.setText("jLabel19");

        jLabelBild7.setText("jLabel7");

        jLabelBild8.setText("jLabel8");

        jLabelBild10.setText("jLabel14");

        jLabelBild3.setText("jLabel4");

        jLabelBild6.setText("jLabel6");

        jLabelBild11.setText("jLabel17");

        jLabelBild12.setText("jLabel9");

        jLabelBild13.setText("jLabel18");

        jLabelBild14.setText("jLabel4");

        jLabelBild15.setText("jLabel19");

        jLabelBild16.setText("jLabel7");

        jLabelBild17.setText("jLabel8");

        jLabelBild18.setText("jLabel14");

        jLabelBild19.setText("jLabel4");

        jLabelBild20.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddMovie)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonChangeMovie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonrentedMovies)
                                .addGap(12, 12, 12)
                                .addComponent(jButtonLogOut))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBild1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild2)
                                            .addComponent(jLabelBild7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBild8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBild9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild5)
                                            .addComponent(jLabelBild10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel11))
                                            .addComponent(jLabel3)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBild11))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild13)
                                            .addComponent(jLabelBild16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBild17, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelBild14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelBild12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelBild18, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                            .addComponent(jLabelBild15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jComboRating, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddMovie)
                            .addComponent(jButtonChangeMovie)
                            .addComponent(jButtonrentedMovies)
                            .addComponent(jButtonLogOut)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelBild1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelBild3)
                                .addComponent(jLabelBild4)
                                .addComponent(jLabelBild5)
                                .addComponent(jLabelBild2)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelBild8)
                                .addComponent(jLabelBild9)
                                .addComponent(jLabelBild10))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelBild6)
                                .addComponent(jLabelBild7)))
                        .addGap(18, 18, 18)))
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBild11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild19)
                        .addComponent(jLabelBild14)
                        .addComponent(jLabelBild15)
                        .addComponent(jLabelBild13)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild17)
                        .addComponent(jLabelBild12)
                        .addComponent(jLabelBild18))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild20)
                        .addComponent(jLabelBild16)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboPriceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboPriceItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPriceItemStateChanged

    private void jComboPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPriceActionPerformed

    private void jComboLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboLanguageActionPerformed

    private void jComboAgeRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAgeRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAgeRatingActionPerformed

    private void jComboGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboGenreActionPerformed

    private void jButtonChangeMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeMovieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChangeMovieActionPerformed

    private void jButtonAddMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMovieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddMovieActionPerformed

    private void jButtonrentedMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonrentedMoviesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonrentedMoviesActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddMovie;
    private javax.swing.JButton jButtonChangeMovie;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonrentedMovies;
    private javax.swing.JComboBox jComboAgeRating;
    private javax.swing.JComboBox jComboGenre;
    private javax.swing.JComboBox jComboLanguage;
    private javax.swing.JComboBox jComboPrice;
    private javax.swing.JComboBox jComboRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBild1;
    private javax.swing.JLabel jLabelBild10;
    private javax.swing.JLabel jLabelBild11;
    private javax.swing.JLabel jLabelBild12;
    private javax.swing.JLabel jLabelBild13;
    private javax.swing.JLabel jLabelBild14;
    private javax.swing.JLabel jLabelBild15;
    private javax.swing.JLabel jLabelBild16;
    private javax.swing.JLabel jLabelBild17;
    private javax.swing.JLabel jLabelBild18;
    private javax.swing.JLabel jLabelBild19;
    private javax.swing.JLabel jLabelBild2;
    private javax.swing.JLabel jLabelBild20;
    private javax.swing.JLabel jLabelBild3;
    private javax.swing.JLabel jLabelBild4;
    private javax.swing.JLabel jLabelBild5;
    private javax.swing.JLabel jLabelBild6;
    private javax.swing.JLabel jLabelBild7;
    private javax.swing.JLabel jLabelBild8;
    private javax.swing.JLabel jLabelBild9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextSearch;
    // End of variables declaration//GEN-END:variables
}
