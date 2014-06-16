/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movierental;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author stefano
 */
public class ChangeMovie extends javax.swing.JFrame {
     
    /*
     ChangeMovie Variablen 
     */
     
    String movieid,title,genre,imglink,streamlink,description,duration,releaseyear,suchetext,agerating,pricecat,answer,language,language2;
    int age,price,combogenre,comboagerating,combopricecat,combolanguage,combolanguage2;
    
    Verbindung db;
    Connection conn;
    Statement stmt,stmt2,stmt3,stmt4;
    ResultSet rs,rs2,rs3;
    
      
    /*
    Konstruktor von ChangeMovie
    */ 
    public ChangeMovie() {
        initComponents();
        setLocationRelativeTo(null);
    }//ende Konstruktor
    
    /*
    comboGenre ist eine Methode um das ausgewählte genre Objekt aus der Datenbank anzuzeigen
    */
    public static int comboGenre(String combo){
         switch (combo) {
             case "Action":
                 return 0;
             case "Adventure":
                 return 1;
             case "Thriller":
                 return 2;
             case "Fantasy":
                 return 3;
             case "Animation":
                 return 4;
             default:
                 return 5;
         }// ende switch
    
    }//ende methode comboGenre
    
    /*
    comboAgerating ist eine Methode um das ausgewählte agerating Objekt aus der Datenbank anzuzeigen
    */
    public static int comboAgerating(int combo){
        if(combo == 0){
       return 0;
       }else if(combo == 6){
       return 1;
       }else if(combo == 12){
       return 2;
       }else if(combo == 16){
       return 3;
       }else {
       return 4;
       }// ende if bedingung
    }// ende methode comboAgerating
    
    /*
    comboPricecat ist eine Methode um das ausgewählte Pricecat Objekt aus der Datenbank anzuzeigen
    */
    public static int comboPricecat(int combo){
         if(combo == 1){
       return 0;
       }else if(combo == 2){
       return 1;
       }else{ 
       return 2;
       }// ende if bedingung
    }// ende der methode comboPricecat
    public static int comboLanguage(String lang){
        switch(lang){
            case "English":
                return 1;
            case "German":
                return 2;
            case "Spanish":
                return 3;
            default:
                return 0;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldImgLink = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextStreamlink = new javax.swing.JTextField();
        jTextReleaseYear = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextDuration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboGenre = new javax.swing.JComboBox();
        jComboAgeRating = new javax.swing.JComboBox();
        jComboPriceCategory = new javax.swing.JComboBox();
        jButtonReturn = new javax.swing.JButton();
        jButtonChange = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDescription = new javax.swing.JTextArea();
        jTextSuchText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonSuche = new javax.swing.JButton();
        jLabelMovieid = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboLanguage = new javax.swing.JComboBox();
        jComboLanguage2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Duration :");

        jLabel7.setText("Release Year :");

        jLabel6.setText("Age Rating :");

        jTextStreamlink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStreamlinkActionPerformed(evt);
            }
        });

        jTextReleaseYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextReleaseYearActionPerformed(evt);
            }
        });

        jLabel15.setText("Description :");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setText("Change a Movie");

        jTextDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDurationActionPerformed(evt);
            }
        });

        jLabel3.setText("Genre :");

        jLabel4.setText("Title :");

        jTextTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTitleActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movierental/Logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel9.setText("IMG-Link :");

        jLabel10.setText("Streamlink :");

        jLabel11.setText("Price Cat. :");

        jComboGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Action", "Adventure", "Thriller", "Fantasy", "Animation", "Comedy" }));
        jComboGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGenreActionPerformed(evt);
            }
        });

        jComboAgeRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "6", "12", "16", "18" }));

        jComboPriceCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3" }));

        jButtonReturn.setText("Return");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        jButtonChange.setText("Change");
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChangeActionPerformed(evt);
            }
        });

        jTextDescription.setColumns(20);
        jTextDescription.setRows(5);
        jTextDescription.setText("\n");
        jScrollPane1.setViewportView(jTextDescription);

        jLabel5.setText("Suche:");

        jButtonSuche.setText("Suche");
        jButtonSuche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSucheActionPerformed(evt);
            }
        });

        jLabel12.setText("Language:");

        jComboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First", "English", "German", "Spanish" }));

        jComboLanguage2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Second", "English", "German", "Spanish" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel6))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabelMovieid)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboLanguage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboPriceCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonChange)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextSuchText, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel9))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldImgLink, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                                                .addComponent(jTextStreamlink))))))
                            .addComponent(jButtonReturn))
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextSuchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButtonSuche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboLanguage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMovieid))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldImgLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextStreamlink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboPriceCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonReturn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonChange)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextReleaseYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextReleaseYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextReleaseYearActionPerformed

    private void jComboGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboGenreActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButtonReturnActionPerformed

    private void jTextTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTitleActionPerformed

    private void jTextDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDurationActionPerformed

    private void jTextStreamlinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStreamlinkActionPerformed
    }//GEN-LAST:event_jTextStreamlinkActionPerformed

    private void jButtonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChangeActionPerformed
       
       if(evt.getSource() == jButtonChange){
       
       title = jTextTitle.getText();
       genre = (String) jComboGenre.getSelectedItem();
       agerating = (String) jComboAgeRating.getSelectedItem();
       duration = jTextDuration.getText();
       releaseyear = jTextReleaseYear.getText();
       description = jTextDescription.getText();
       pricecat = (String) jComboPriceCategory.getSelectedItem();
       imglink = jTextFieldImgLink.getText();
       streamlink = jTextStreamlink.getText();
       movieid = jLabelMovieid.getText();
       language = (String)jComboLanguage.getSelectedItem();
       language2 = (String)jComboLanguage2.getSelectedItem();
          
       db = new Verbindung();
       db.start();
       conn = db.getVerbindung();
       if(suchetext != null){
       
           try {
               stmt2 = conn.createStatement();
               stmt2.executeUpdate("UPDATE movie SET title='"+ title + "', genre='"+ genre +"', ageRating='"+ agerating +"', description='"+ description 
                                   + "', releaseDate='"+ releaseyear +"', duration='"+ duration + "', link='"+ streamlink + "', Picture='"+ imglink + "', Pid='"+ pricecat + "' WHERE mid = '"+ movieid + "'");
               JOptionPane.showMessageDialog(null, "Change was succesfull.");
               this.dispose();
               
           } catch (SQLException ex) {
               Logger.getLogger(ChangeMovie.class.getName()).log(Level.SEVERE, null, ex);
               
           }
       }else{
           JOptionPane.showMessageDialog(null, "You must search a movie before you can change one. ");
       }
       }   
    }//GEN-LAST:event_jButtonChangeActionPerformed

    private void jButtonSucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSucheActionPerformed
        
        suchetext = jTextSuchText.getText();
    
            db = new Verbindung();
            db.start();
            conn = db.getVerbindung();
        if(evt.getSource() == jButtonSuche){
            
                ArrayList<String> liste = new ArrayList();
               
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM movie WHERE title LIKE '%"+ suchetext +"%' ");
                
                rs.last();
               
                if(rs.getRow() <= 1){
                
                    
                    movieid = rs.getString(1);
                    title = rs.getString(2);
                    genre = rs.getString(3);
                    age = rs.getInt(4);
                    description = rs.getString(5);
                    releaseyear = rs.getString(6);
                    duration = rs.getString(7);
                    streamlink = rs.getString(8);
                    imglink = rs.getString(9);
                    price = rs.getInt(10);
                    
                    stmt4 = conn.createStatement();
                    rs3 = stmt4.executeQuery("SELECT Language FROM haslang WHERE Mid = '"+ movieid+"' ");
                    
                    rs3.first();
                    language = rs3.getString("Language");
                    if(rs3.next()){
                    language2 = rs3.getString("Language");
                    combolanguage2 = comboLanguage(language2);
                    jComboLanguage2.setSelectedIndex(combolanguage2);
                    }
                    
                    combogenre = comboGenre(genre);
                    comboagerating = comboAgerating(age);
                    combopricecat = comboPricecat(price);
                    combolanguage = comboLanguage(language);
                    
                    
                    jTextTitle.setText(title);
                    jComboGenre.setSelectedIndex(combogenre);
                    jTextDescription.setText(description);
                    jTextReleaseYear.setText(releaseyear);
                    jTextDuration.setText(duration);
                    jTextStreamlink.setText(streamlink);
                    jTextFieldImgLink.setText(imglink);
                    jComboPriceCategory.setSelectedIndex(combopricecat);
                    jComboAgeRating.setSelectedIndex(comboagerating);
                    jLabelMovieid.setText(movieid);
                    jLabelMovieid.setVisible(false);
                    jComboLanguage.setSelectedIndex(combolanguage);
                   
                    
                    
               }else{
                    rs.beforeFirst();
                    while(rs.next()){
                        liste.add(rs.getString(2));
                         }
                    switch (liste.size()){
                        case 2:
                    Object Res = JOptionPane.showInputDialog(null,
                    "Choose One?", "More than 1 hit",
                    JOptionPane.QUESTION_MESSAGE, null, new String[] { liste.get(0), liste.get(1) },
                    liste.get(0));
                    if(!(Res == null)){
                    answer = Res.toString();
                    }else{
                        JOptionPane.showMessageDialog(null, "Search operation aborted");
                    }
                        break;
                        case 3:
                    Object Resp = JOptionPane.showInputDialog(null,
                    "Choose One?", "More than 1 hit",
                    JOptionPane.QUESTION_MESSAGE, null, new String[] { liste.get(0), liste.get(1),liste.get(2) },
                    liste.get(0));
                    if(!(Resp == null)){
                    answer = Resp.toString();
                    }else{
                        JOptionPane.showMessageDialog(null, "Search operation aborted");
                    }
                        break;
                        case 4:
                    Object Respo = JOptionPane.showInputDialog(null,
                    "Choose One?", "More than 1 hit",
                    JOptionPane.QUESTION_MESSAGE, null, new String[] { liste.get(0), liste.get(1),liste.get(2),liste.get(3) },
                    liste.get(0));
                    if(!(Respo == null)){
                    answer = Respo.toString();
                    }else{
                        JOptionPane.showMessageDialog(null, "Search operation aborted");
                    }
                         break;
                         case 5:
                    Object Respon = JOptionPane.showInputDialog(null,
                    "Choose One?", "More than 1 hit",
                    JOptionPane.QUESTION_MESSAGE, null, new String[] { liste.get(0), liste.get(1),liste.get(2),liste.get(3),liste.get(4) },
                    liste.get(0));
                    if(!(Respon == null)){
                    answer = Respon.toString();
                    }else{
                        JOptionPane.showMessageDialog(null, "Search operation aborted");
                    }
                         break;
                         case 6:
                    JOptionPane.showMessageDialog(null, "Please be more accurate.");
                    
                         break;
                    }
                    
                    stmt3 = conn.createStatement();
                    rs2 = stmt3.executeQuery("SELECT * FROM movie WHERE title = '" + answer +"'");
                   
                    if(rs2.next()){
                        
                    movieid = rs2.getString(1);
                    title = rs2.getString(2);
                    genre = rs2.getString(3);
                    age = rs2.getInt(4);
                    description = rs2.getString(5);
                    releaseyear = rs2.getString(6);
                    duration = rs2.getString(7);
                    streamlink = rs2.getString(8);
                    imglink = rs2.getString(9);
                    price = rs2.getInt(10);
                    
                    stmt4 = conn.createStatement();
                    rs3 = stmt4.executeQuery("SELECT Language FROM haslang WHERE Mid = '"+movieid+"' ");
                    
                    rs3.first();
                    language = rs3.getString("Language");
                    if(rs3.next()){
                    language2 = rs3.getString("Language");
                    combolanguage2 = comboLanguage(language2);
                    jComboLanguage2.setSelectedIndex(combolanguage2);
                    }
                    combogenre = comboGenre(genre);
                    comboagerating = comboAgerating(age);
                    combopricecat = comboPricecat(price);
                    combolanguage = comboLanguage(language);
                   
                   
                    jTextTitle.setText(title);
                    jComboGenre.setSelectedIndex(combogenre);
                    jTextDescription.setText(description);
                    jTextReleaseYear.setText(releaseyear);
                    jTextDuration.setText(duration);
                    jTextStreamlink.setText(streamlink);
                    jTextFieldImgLink.setText(imglink);
                    jComboPriceCategory.setSelectedIndex(combopricecat);
                    jComboAgeRating.setSelectedIndex(comboagerating);
                    jLabelMovieid.setText(movieid);
                    jLabelMovieid.setVisible(false);
                    jComboLanguage.setSelectedIndex(combolanguage);
                    
                    }
               }
              
             
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No match found");
            }
            }
        
    }//GEN-LAST:event_jButtonSucheActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              
                new ChangeMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChange;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonSuche;
    private javax.swing.JComboBox jComboAgeRating;
    private javax.swing.JComboBox jComboGenre;
    private javax.swing.JComboBox jComboLanguage;
    private javax.swing.JComboBox jComboLanguage2;
    private javax.swing.JComboBox jComboPriceCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMovieid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextDescription;
    private javax.swing.JTextField jTextDuration;
    private javax.swing.JTextField jTextFieldImgLink;
    private javax.swing.JTextField jTextReleaseYear;
    private javax.swing.JTextField jTextStreamlink;
    private javax.swing.JTextField jTextSuchText;
    private javax.swing.JTextField jTextTitle;
    // End of variables declaration//GEN-END:variables
}
