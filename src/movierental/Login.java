package movierental;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    Login login;
    User user = new User();
    ArrayList<Movie> movies;
    
    public Login() throws IOException, SQLException {
        initComponents();
    }
    
    public void Newest10() throws SQLException, MalformedURLException, IOException{
       movies = new ArrayList<>();
       MouseAdapter listener = new MouseImpl();
        
       Verbindung db = new Verbindung();
       db.start();
       Connection conn = db.getVerbindung();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("Select * from movie natural join pricecat order by mid desc");
       
       Statement stmt2 = conn.createStatement();
       
       while(rs.next()){
        ResultSet rs2 = stmt2.executeQuery("Select * from movie natural join haslang where mid = "+rs.getString("mid")+" ");
        rs2.next();
        String language = rs2.getString("Language");
        rs2.last();
        String language2 = rs2.getString("Language");
        
        if(language2.equals(language))
            language2 = "";
        
        Movie movie = new Movie(rs.getString("mid"),rs.getString("title"),rs.getString("picture"),"5", rs.getString("description"),rs.getString("genre"),rs.getString("agerating"),rs.getString("releasedate"),rs.getString("duration"),rs.getString("link"),language, language2, rs.getString("price"));

       movies.add(movie);
       }       
       
        URL imgUrl = new URL(movies.get(0).getImglink()); 
        jLabelBild1.setIcon(new ImageIcon(imgUrl));
        jLabelBild1.setText(null);
        jLabelBild1.addMouseListener(listener);
        
        URL imgUrl2 = new URL(movies.get(1).getImglink()); 
        jLabelBild2.setIcon(new ImageIcon(imgUrl2));
        jLabelBild2.setText(null);
        jLabelBild2.addMouseListener(listener);
        
        URL imgUrl3 = new URL(movies.get(2).getImglink()); 
        jLabelBild3.setIcon(new ImageIcon(imgUrl3));
        jLabelBild3.setText(null);
        jLabelBild3.addMouseListener(listener);

        
        URL imgUrl4 = new URL(movies.get(3).getImglink()); 
        jLabelBild4.setIcon(new ImageIcon(imgUrl4));
        jLabelBild4.setText(null);
        jLabelBild4.addMouseListener(listener);
        
        URL imgUrl5 = new URL(movies.get(4).getImglink()); 
        jLabelBild5.setIcon(new ImageIcon(imgUrl5));
        jLabelBild5.setText(null);
        jLabelBild5.addMouseListener(listener);
        
//        URL imgUrl6 = new URL(movies.get(0).getImglink()); 
//        jLabelBild6.setIcon(new ImageIcon(imgUrl));
//        jLabelBild6.setText(null);
//        jLabelBild6.addMouseListener(listener);
//        
//        URL imgUrl7 = new URL(movies.get(1).getImglink()); 
//        jLabelBild7.setIcon(new ImageIcon(imgUrl7));
//        jLabelBild7.setText(null);
//        jLabelBild7.addMouseListener(listener);
//        
//        URL imgUrl8 = new URL(movies.get(2).getImglink()); 
//        jLabelBild8.setIcon(new ImageIcon(imgUrl8));
//        jLabelBild8.setText(null);
//        jLabelBild8.addMouseListener(listener);
//        
//        URL imgUrl9 = new URL(movies.get(3).getImglink()); 
//        jLabelBild9.setIcon(new ImageIcon(imgUrl9));
//        jLabelBild9.setText(null);
//        jLabelBild9.addMouseListener(listener);
//        
//        URL imgUrl10 = new URL(movies.get(4).getImglink()); 
//        jLabelBild10.setIcon(new ImageIcon(imgUrl10));
//        jLabelBild10.setText(null);
//        jLabelBild10.addMouseListener(listener);
    }
    
    public void Top10() throws SQLException, MalformedURLException{
       ArrayList<Movie> movies = new ArrayList<>();
       MouseAdapter listener = new MouseImpl();
       
       Verbindung db = new Verbindung();
       db.start();
       Connection conn = db.getVerbindung();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM movie");
       
       while(rs.next()){
        Movie movie = new Movie(rs.getString("title"),rs.getString("picture"));
        movies.add(movie);
       }
       
       URL imgUrl = new URL(movies.get(0).getImglink());
       ImageIcon abc = new ImageIcon();
       jLabelBild11.setIcon(new ImageIcon(imgUrl));
       jLabelBild11.setText(null);
       jLabelBild11.addMouseListener(new MouseImpl());

        
        URL imgUrl2 = new URL(movies.get(1).getImglink()); 
        jLabelBild12.setIcon(new ImageIcon(imgUrl2));
        jLabelBild12.setText(null);
        jLabelBild12.addMouseListener(new MouseImpl());
        
        URL imgUrl3 = new URL(movies.get(2).getImglink()); 
        jLabelBild13.setIcon(new ImageIcon(imgUrl3));
        jLabelBild13.setText(null);
        
        URL imgUrl4 = new URL(movies.get(3).getImglink()); 
        jLabelBild14.setIcon(new ImageIcon(imgUrl4));
        jLabelBild14.setText(null);
        
        URL imgUrl5 = new URL(movies.get(4).getImglink()); 
        jLabelBild16.setIcon(new ImageIcon(imgUrl5));
        jLabelBild16.setText(null);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBild5 = new javax.swing.JLabel();
        jLabelBild11 = new javax.swing.JLabel();
        jLabelBild1 = new javax.swing.JLabel();
        jLabelBild2 = new javax.swing.JLabel();
        jButtonForgottenPass = new javax.swing.JButton();
        jButtonRegistry = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabelBild12 = new javax.swing.JLabel();
        jLabelBild9 = new javax.swing.JLabel();
        jLabelBild4 = new javax.swing.JLabel();
        jLabelBild7 = new javax.swing.JLabel();
        jComboGenre = new javax.swing.JComboBox();
        jComboLanguage = new javax.swing.JComboBox();
        jComboAgeRating = new javax.swing.JComboBox();
        jComboRating = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboPrice = new javax.swing.JComboBox();
        jPassword = new javax.swing.JPasswordField();
        jLabelBild13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelBild14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextsearch = new javax.swing.JTextPane();
        jLabelBild15 = new javax.swing.JLabel();
        jLabelBild16 = new javax.swing.JLabel();
        jLabelBild3 = new javax.swing.JLabel();
        jLabelBild17 = new javax.swing.JLabel();
        jLabelBild18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelBild19 = new javax.swing.JLabel();
        jLabelBild10 = new javax.swing.JLabel();
        jLabelBild20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelBild8 = new javax.swing.JLabel();
        jLabelBild6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelBild5.setText("jLabel19");

        jLabelBild11.setText("jLabel17");

        jLabelBild1.setText("jLabel17");

        jLabelBild2.setText("jLabel18");

        jButtonForgottenPass.setText("Forgotten Password");

        jButtonRegistry.setText("Registry");
        jButtonRegistry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistryActionPerformed(evt);
            }
        });

        jLabel16.setText("Password:");

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setText("Top 10");

        jLabel15.setText("Username:");

        jLabelBild12.setText("jLabel9");

        jLabelBild9.setText("jLabel9");

        jLabelBild4.setText("jLabel4");

        jLabelBild7.setText("jLabel7");

        jComboGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Genre", "Item 2", "Item 3", "Item 4" }));
        jComboGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGenreActionPerformed(evt);
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

        jPassword.setText("jPasswor");
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jLabelBild13.setText("jLabel18");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel3.setText("Newest 10");

        jLabelBild14.setText("jLabel4");

        jScrollPane1.setViewportView(jTextsearch);

        jLabelBild15.setText("jLabel19");

        jLabelBild16.setText("jLabel7");

        jLabelBild3.setText("jLabel4");

        jLabelBild17.setText("jLabel8");

        jLabelBild18.setText("jLabel14");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movierental/Logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabelBild19.setText("jLabel4");

        jLabelBild10.setText("jLabel14");

        jLabelBild20.setText("jLabel6");

        jLabelBild8.setText("jLabel8");

        jLabelBild6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonForgottenPass)
                    .addComponent(jButtonRegistry))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jComboRating, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelBild8, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabelBild3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBild4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBild9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelBild10, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabelBild5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelBild20, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabelBild11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelBild16, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabelBild13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelBild17, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jLabelBild19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBild14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelBild12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelBild18, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabelBild15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonRegistry))
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonForgottenPass))
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLogin)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        if(evt.getSource() == jButtonLogin){
            User user = new User();
            try {
                if( (user.login(jTextUsername.getText(),new String(jPassword.getPassword())) ) == 1 ){
                    if(user.checkAdmin() == 1){
                        Admin admin = new Admin();
                        setVisible(false);
                        new Admin().setVisible(true);              
                }else{
                        setVisible(false);
                        new User(user).setVisible(true);
                    }
                }
                
            } catch (SQLException ex) {
                
            }
            
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jComboGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboGenreActionPerformed

    private void jComboLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboLanguageActionPerformed

    private void jComboAgeRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAgeRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAgeRatingActionPerformed

    private void jComboPriceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboPriceItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPriceItemStateChanged

    private void jComboPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPriceActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jButtonRegistryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistryActionPerformed
        new Registry().setVisible(true);
    }//GEN-LAST:event_jButtonRegistryActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login login = new Login();
                    login.Newest10();
//                    login.Top10();
                    login.pack();
                    login.setVisible(true);
                 
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonForgottenPass;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegistry;
    private javax.swing.JComboBox jComboAgeRating;
    private javax.swing.JComboBox jComboGenre;
    private javax.swing.JComboBox jComboLanguage;
    private javax.swing.JComboBox jComboPrice;
    private javax.swing.JComboBox jComboRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextUsername;
    private javax.swing.JTextPane jTextsearch;
    // End of variables declaration//GEN-END:variables

    class MouseImpl extends MouseAdapter {
         @Override
        public void mouseClicked(MouseEvent e) {
            Object source = e.getSource();
             try {
                 user.login("abc","abc");
             } catch (SQLException ex) {
                 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
             }
            if (source == jLabelBild1) {
                try {
                    new MovieInfo(user,movies.get(0)).setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild2) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(1));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
 
            if (source == jLabelBild3) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(2));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild4) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(3));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild5) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(4));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}

