/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import static movierental.Admin.getAgerating;
import static movierental.Admin.getGenre;
import static movierental.Admin.getLanguage;
import static movierental.Admin.getPrice;
import static movierental.Admin.getRating;



public class User extends javax.swing.JFrame {
    User user;
    String uid, username, password, email, isAdmin, activationCode="123", activated, lastLogin, birthday, prename, surname, address, zipcode, city, iban, bic;
    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Movie> movies2 = new ArrayList<>();
    String suchetext,gen,pri,age,rate,lang;
    int genre,price,agerating,rating,language,pages;
        Verbindung db;
        Connection conn;
        Statement stmt,stmt2,stmt3,stmt4,stmtNewest,stmtNewest2,stmtSearch,stmtTop10,stmt2Top10;
        ResultSet rs,rs2,rs3,rsNewest,rsNewest2,rsSearch,rsTop10,rs2Top10;
        static int seitenanzahl = 0;
    public User(){
        initComponents();
        this.uid = "0";
    }
    
    public User(User obj){
        initComponents();
        user = obj;
        
    }
    
    
  
    
    public static void register( String username, String password, String email, String birthday, String prename, String surname, String address, String zipcode, String city, String iban, String bic) throws SQLException{
       Verbindung db = new Verbindung();
       db.start();
       Connection conn = db.getVerbindung();
       Statement stmt = conn.createStatement();
       stmt.executeUpdate("INSERT INTO `movierental`.`user`(`username`, `password`, `email`, `isAdmin`, `activationCode`, `birthday`, `prename`, `surname`, `address`, `zipcode`, `city`, `iban`, `bic`) VALUES "
+ "('" + username + "','" + password + "','" + email + "', 0, '" + "123" + "',\"" +  birthday + "\",'" + prename + "','" + surname + "','" + address + "','" + zipcode + "','" + city + "','" + iban + "','" + bic + "')");
    }
    
    public int login(String username, String password) throws SQLException{
       Verbindung db = new Verbindung();
       db.start();
       Connection conn = db.getVerbindung();
       Statement stmt = conn.createStatement();
       
       ResultSet rs = stmt.executeQuery("Select * from user natural join bank where username = '"+username+"' and password = '" +password+ "'");
       if(rs.next()){
        uid = String.valueOf(rs.getInt("uid"));
        this.username = rs.getString("username");
        this.password = rs.getString("password");
        email = rs.getString("email");
        isAdmin = rs.getString("isAdmin");
        lastLogin = rs.getString("lastLogin");
        activated = String.valueOf(rs.getInt("activated"));
        birthday = rs.getString("birthday");
        prename = rs.getString("prename");
        surname = rs.getString("surname");
        address = rs.getString("address");
        zipcode = rs.getString("zipcode");
        city = rs.getString("city");
        iban = rs.getString("iban");
        bic = rs.getString("bic");
       
       if(activated.equals("1")){
           JOptionPane.showMessageDialog(null,"Successfully logged in.");
           stmt.executeUpdate("UPDATE user SET lastLogin = now() where username ='"+username+"'");
           return 1;
                   }else{
           JOptionPane.showMessageDialog(null,"You aren't activated! Please activate first.");
           return 0;
       }
    }else{
          JOptionPane.showMessageDialog(null,"Wrong username or password!");
          return 0;
    }
}
    
    public int checkAdmin(){
        return Integer.parseInt(this.isAdmin);
    }
    
    public int rentMovie(String mid) throws SQLException{
        Verbindung db = new Verbindung();
        db.start();
        Connection conn = db.getVerbindung();
        Statement stmt = conn.createStatement();
        if(stmt.executeUpdate("INSERT INTO rents VALUES ('"+this.uid+"','"+mid+"',now())") == 1)
            return 1;
        else
            return 0;
    }
    
    public int changeInformation(String password, String password2, String email, String prename, String surname, String address, String zipcode, String city, String iban, String bic) throws SQLException{
        Verbindung db = new Verbindung();
        db.start();
        Connection conn = db.getVerbindung();

        //Eingabe des alten Passworts
            //Überprüfung ob Email bereits vorhanden
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from user where email = '"+email+"' and uid != '"+this.uid+"'");

            if(rs.next()){
                JOptionPane.showMessageDialog(null,"EMail already used!");
                return 0;
            }else if(!password.equals(password2)){
                JOptionPane.showMessageDialog(null,"The two passwords aren't the same!");
                return 0;
            }
            else{
                String query = "UPDATE user SET password = '"+password+"' , email = '"+email+"', prename = '"+prename+"' , surname = '" + surname + "' , address = '" + address + "' , zipcode = '" + zipcode + "', city = '" + city + "' WHERE uid = '" + this.uid + "' ";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account information successfully changed.");
                return 1;
            }   
    }


    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPrename() {
        return prename;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void searchResult(ArrayList<Movie> movies2) throws MalformedURLException{
                MouseAdapter listener = new MouseImpl();
                        jLabelBild1.setVisible(false);
                        jLabelBild2.setVisible(false);
                        jLabelBild3.setVisible(false);
                        jLabelBild4.setVisible(false);
                        jLabelBild5.setVisible(false);
                        jLabelBild6.setVisible(false);
                        jLabelBild7.setVisible(false);
                        jLabelBild8.setVisible(false);
                        jLabelBild9.setVisible(false);
                        jLabelBild10.setVisible(false);
                        jLabelBild11.setVisible(false);
                        jLabelBild12.setVisible(false);
                        jLabelBild13.setVisible(false);
                        jLabelBild14.setVisible(false);
                        jLabelBild15.setVisible(false);
                        jLabelBild16.setVisible(false);
                        jLabelBild17.setVisible(false);
                        jLabelBild18.setVisible(false);
                        jLabelBild19.setVisible(false);
                        jLabelBild20.setVisible(false);
                        
                        jLabelTop10.setVisible(false);
                        jLabelNewest.setText("Search Result for '"+ suchetext +"':");
                        
                        jLabelBild1.setIcon(new ImageIcon(new URL(movies2.get(0+seitenanzahl).getImglink())));
                        jLabelBild1.setText(null);
                        jLabelBild1.addMouseListener(listener);
                        jLabelBild1.setVisible(true);
                       
                        jLabelBild2.setIcon(new ImageIcon(new URL(movies2.get(1+seitenanzahl).getImglink())));
                        jLabelBild2.setText(null);
                        jLabelBild2.addMouseListener(listener);
                        jLabelBild2.setVisible(true);
                     
                        jLabelBild3.setIcon(new ImageIcon(new URL(movies2.get(2+seitenanzahl).getImglink())));
                        jLabelBild3.setText(null);
                        jLabelBild3.addMouseListener(listener);
                        jLabelBild3.setVisible(true);
                        
                        jLabelBild4.setIcon(new ImageIcon(new URL(movies2.get(3+seitenanzahl).getImglink())));
                        jLabelBild4.setText(null);
                        jLabelBild4.addMouseListener(listener);
                        jLabelBild4.setVisible(true);
                        
                        jLabelBild5.setIcon(new ImageIcon(new URL(movies2.get(4+seitenanzahl).getImglink())));
                        jLabelBild5.setText(null);
                        jLabelBild5.addMouseListener(listener);
                        jLabelBild5.setVisible(true);
                        
                        jLabelBild6.setIcon(new ImageIcon(new URL(movies2.get(5+seitenanzahl).getImglink())));
                        jLabelBild6.setText(null);
                        jLabelBild6.addMouseListener(listener);
                        jLabelBild6.setVisible(true);
                        
                        jLabelBild7.setIcon(new ImageIcon(new URL(movies2.get(6+seitenanzahl).getImglink())));
                        jLabelBild7.setText(null);
                        jLabelBild7.addMouseListener(listener);
                        jLabelBild7.setVisible(true);
                        
                        jLabelBild8.setIcon(new ImageIcon(new URL(movies2.get(7+seitenanzahl).getImglink())));
                        jLabelBild8.setText(null);
                        jLabelBild8.addMouseListener(listener);
                        jLabelBild8.setVisible(true);
                        
                        jLabelBild9.setIcon(new ImageIcon(new URL(movies2.get(8+seitenanzahl).getImglink())));
                        jLabelBild9.setText(null);
                        jLabelBild9.addMouseListener(listener);
                        jLabelBild9.setVisible(true);
                        
                        jLabelBild10.setIcon(new ImageIcon(new URL(movies2.get(9+seitenanzahl).getImglink())));
                        jLabelBild10.setText(null);
                        jLabelBild10.addMouseListener(listener);
                        jLabelBild10.setVisible(true);
                        
                         if(movies2.size() > 10){
                            jButtonNext.setVisible(true);
                         }
                         if(movies2.size() == seitenanzahl+10){
                            jButtonNext.setVisible(false);
                         }
                         if(seitenanzahl != 0){
                             jButtonPrevious.setVisible(true);
                            
                         }else{
                             jButtonPrevious.setVisible(false);
                         }
     }

   public void Newest10() throws SQLException, MalformedURLException, IOException{
       MouseAdapter listener = new MouseImpl();
        
      movies = Movie.getNewestAndTop10();
           
        jLabelBild1.setIcon(new ImageIcon(new URL(movies.get(0).getImglink())));
        jLabelBild1.setText(null);
        jLabelBild1.addMouseListener(listener);
        
        jLabelBild2.setIcon(new ImageIcon(new URL(movies.get(1).getImglink())));
        jLabelBild2.setText(null);
        jLabelBild2.addMouseListener(listener);
        
        jLabelBild3.setIcon(new ImageIcon(new URL(movies.get(2).getImglink())));
        jLabelBild3.setText(null);
        jLabelBild3.addMouseListener(listener);

        jLabelBild4.setIcon(new ImageIcon(new URL(movies.get(3).getImglink())));
        jLabelBild4.setText(null);
        jLabelBild4.addMouseListener(listener);
        
        jLabelBild5.setIcon(new ImageIcon(new URL(movies.get(4).getImglink())));
        jLabelBild5.setText(null);
        jLabelBild5.addMouseListener(listener);
        
        jLabelBild6.setIcon(new ImageIcon(new URL(movies.get(5).getImglink())));
        jLabelBild6.setText(null);
        jLabelBild6.addMouseListener(listener);
        
        jLabelBild7.setIcon(new ImageIcon(new URL(movies.get(6).getImglink())));
        jLabelBild7.setText(null);
        jLabelBild7.addMouseListener(listener);
        
        jLabelBild8.setIcon(new ImageIcon(new URL(movies.get(7).getImglink())));
        jLabelBild8.setText(null);
        jLabelBild8.addMouseListener(listener);
        
        jLabelBild9.setIcon(new ImageIcon(new URL(movies.get(8).getImglink())));
        jLabelBild9.setText(null);
        jLabelBild9.addMouseListener(listener);
        
        jLabelBild10.setIcon(new ImageIcon(new URL(movies.get(9).getImglink())));
        jLabelBild10.setText(null);
        jLabelBild10.addMouseListener(listener);
    }
   public void Top10() throws SQLException, MalformedURLException{
       MouseAdapter listener = new MouseImpl();

       movies = Movie.getNewestAndTop10();
       
        jLabelBild11.setIcon(new ImageIcon(new URL(movies.get(0).getImglink())));
        jLabelBild11.setText(null);
        jLabelBild11.addMouseListener(listener);

        jLabelBild12.setIcon(new ImageIcon(new URL(movies.get(1).getImglink())));
        jLabelBild12.setText(null);
        jLabelBild12.addMouseListener(listener);
        
        jLabelBild13.setIcon(new ImageIcon(new URL(movies.get(2).getImglink())));
        jLabelBild13.setText(null);
        jLabelBild13.addMouseListener(listener);
        
        jLabelBild14.setIcon(new ImageIcon(new URL(movies.get(3).getImglink())));
        jLabelBild14.setText(null);
        jLabelBild14.addMouseListener(listener);
        
        jLabelBild15.setIcon(new ImageIcon(new URL(movies.get(4).getImglink())));
        jLabelBild15.setText(null);
        jLabelBild15.addMouseListener(listener);
        
        jLabelBild16.setIcon(new ImageIcon(new URL(movies.get(5).getImglink())));
        jLabelBild16.setText(null);
        jLabelBild16.addMouseListener(listener);
        
        jLabelBild17.setIcon(new ImageIcon(new URL(movies.get(6).getImglink())));
        jLabelBild17.setText(null);
        jLabelBild17.addMouseListener(listener);
        
        jLabelBild18.setIcon(new ImageIcon(new URL(movies.get(7).getImglink())));
        jLabelBild18.setText(null);
        jLabelBild18.addMouseListener(listener);
        
        jLabelBild19.setIcon(new ImageIcon(new URL(movies.get(8).getImglink())));
        jLabelBild19.setText(null);
        jLabelBild19.addMouseListener(listener);
        
        jLabelBild20.setIcon(new ImageIcon(new URL(movies.get(9).getImglink())));
        jLabelBild20.setText(null);
        jLabelBild20.addMouseListener(listener);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboPrice = new javax.swing.JComboBox();
        jComboGenre = new javax.swing.JComboBox();
        jComboAgeRating = new javax.swing.JComboBox();
        jComboLanguage = new javax.swing.JComboBox();
        jButtonAccount = new javax.swing.JButton();
        jButtonVideoLibrary = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextSearch = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();
        jComboRating = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelBild9 = new javax.swing.JLabel();
        jLabelBild4 = new javax.swing.JLabel();
        jButtonReturn = new javax.swing.JButton();
        jLabelBild5 = new javax.swing.JLabel();
        jLabelBild17 = new javax.swing.JLabel();
        jLabelBild3 = new javax.swing.JLabel();
        jLabelBild7 = new javax.swing.JLabel();
        jLabelNewest = new javax.swing.JLabel();
        jLabelBild11 = new javax.swing.JLabel();
        jLabelBild18 = new javax.swing.JLabel();
        jLabelBild10 = new javax.swing.JLabel();
        jLabelBild20 = new javax.swing.JLabel();
        jLabelBild2 = new javax.swing.JLabel();
        jLabelBild1 = new javax.swing.JLabel();
        jLabelBild12 = new javax.swing.JLabel();
        jLabelBild14 = new javax.swing.JLabel();
        jLabelBild19 = new javax.swing.JLabel();
        jLabelBild13 = new javax.swing.JLabel();
        jButtonNext = new javax.swing.JButton();
        jLabelBild15 = new javax.swing.JLabel();
        jLabelTop10 = new javax.swing.JLabel();
        jLabelBild16 = new javax.swing.JLabel();
        jLabelBild8 = new javax.swing.JLabel();
        jButtonPrevious = new javax.swing.JButton();
        jLabelBild6 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/movierental/Logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jComboPrice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Price", "Category 1", "Category 2", "Category 3" }));
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

        jComboGenre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Genre", "Action", "Adventure", "Thriller", "Fantasy", "Animation", "Comedy" }));
        jComboGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGenreActionPerformed(evt);
            }
        });

        jComboAgeRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Age rating", "0", "6", "12", "16", "18" }));
        jComboAgeRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAgeRatingActionPerformed(evt);
            }
        });

        jComboLanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Language", "English", "German", "Spanish" }));
        jComboLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboLanguageActionPerformed(evt);
            }
        });

        jButtonAccount.setText("Account");
        jButtonAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccountActionPerformed(evt);
            }
        });

        jButtonVideoLibrary.setText("Video library");
        jButtonVideoLibrary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVideoLibraryActionPerformed(evt);
            }
        });

        jButtonLogOut.setText("Log out");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextSearch);

        jComboRating.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rating", "5 Best", "4", "3", "2", "1 Badest" }));

        jLabel1.setText("Search:");

        jLabelBild9.setText("jLabel9");

        jLabelBild4.setText("jLabel4");

        jButtonReturn.setText("Return");
        jButtonReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReturnActionPerformed(evt);
            }
        });

        jLabelBild5.setText("jLabel19");

        jLabelBild17.setText("jLabel8");

        jLabelBild3.setText("jLabel4");

        jLabelBild7.setText("jLabel7");

        jLabelNewest.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelNewest.setText("Newest 10");

        jLabelBild11.setText("jLabel17");

        jLabelBild18.setText("jLabel14");

        jLabelBild10.setText("jLabel14");

        jLabelBild20.setText("jLabel6");

        jLabelBild2.setText("jLabel18");

        jLabelBild1.setText("jLabel17");

        jLabelBild12.setText("jLabel9");

        jLabelBild14.setText("jLabel4");

        jLabelBild19.setText("jLabel4");

        jLabelBild13.setText("jLabel18");

        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jLabelBild15.setText("jLabel19");

        jLabelTop10.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabelTop10.setText("Top 10");

        jLabelBild16.setText("jLabel7");

        jLabelBild8.setText("jLabel8");

        jButtonPrevious.setText("<");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jLabelBild6.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTop10)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBild1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild2)
                                    .addComponent(jLabelBild7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelBild8, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(jLabelBild3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBild9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild5)
                                    .addComponent(jLabelBild10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelNewest)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBild11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild13)
                                    .addComponent(jLabelBild16, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelBild17, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(jLabelBild19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBild14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelBild12, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelBild18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelBild15, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonReturn)
                        .addGap(286, 286, 286)
                        .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelNewest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBild1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild3)
                        .addComponent(jLabelBild4)
                        .addComponent(jLabelBild5)
                        .addComponent(jLabelBild2)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild8)
                        .addComponent(jLabelBild9)
                        .addComponent(jLabelBild10))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild6)
                        .addComponent(jLabelBild7)))
                .addGap(18, 18, 18)
                .addComponent(jLabelTop10)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBild11)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild19)
                        .addComponent(jLabelBild14)
                        .addComponent(jLabelBild15)
                        .addComponent(jLabelBild13)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild17)
                        .addComponent(jLabelBild12)
                        .addComponent(jLabelBild18))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBild20)
                        .addComponent(jLabelBild16)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNext)
                        .addComponent(jButtonPrevious))
                    .addComponent(jButtonReturn))
                .addGap(184, 184, 184))
        );

        jScrollPane2.setViewportView(jPanel1);

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAccount)
                .addGap(18, 18, 18)
                .addComponent(jButtonVideoLibrary)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogOut)
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jComboRating, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSearch)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAccount)
                            .addComponent(jButtonVideoLibrary)
                            .addComponent(jButtonLogOut)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboAgeRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboPriceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboPriceItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPriceItemStateChanged

    private void jComboPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboPriceActionPerformed

    private void jComboGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboGenreActionPerformed

    private void jComboAgeRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAgeRatingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboAgeRatingActionPerformed

    private void jComboLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboLanguageActionPerformed

    private void jButtonAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccountActionPerformed
        if(evt.getSource() == jButtonAccount){
            new Account(user).setVisible(true);
        }
    }//GEN-LAST:event_jButtonAccountActionPerformed

    private void jButtonVideoLibraryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVideoLibraryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVideoLibraryActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        setVisible(false);
        JOptionPane.showMessageDialog(null, "Successfully logged out!");
        try {
            new Login().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jButtonReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReturnActionPerformed
        this.dispose();
        new User().setVisible(true);

    }//GEN-LAST:event_jButtonReturnActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if(jButtonNext == evt.getSource()){
            System.out.println(movies2.size());
            seitenanzahl = seitenanzahl + 10;
            try {
                this.searchResult(movies2);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        if(jButtonPrevious == evt.getSource()){
            seitenanzahl = seitenanzahl - 10;
            try {
                this.searchResult(movies2);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
            db = new Verbindung();
            db.start();
            conn = db.getVerbindung();
            
            jButtonReturn.setVisible(true);
            suchetext = jTextSearch.getText();
            genre = jComboGenre.getSelectedIndex();
            price = jComboPrice.getSelectedIndex();
            agerating = jComboAgeRating.getSelectedIndex();
            rating = jComboRating.getSelectedIndex();
            language = jComboLanguage.getSelectedIndex();
     
            if(evt.getSource() == jButtonSearch){
                movies2 = new ArrayList<>();
                    try {
                        gen = getGenre(genre);
                        pri = getPrice(price);
                        age = getAgerating(agerating);
                        rate = getRating(rating);
                        lang = getLanguage(language);
                        
                        if(!(rate.equals("%"))){
                        stmt4 = conn.createStatement();
                        rs3 = stmt4.executeQuery("SELECT *,avg(rating) as average FROM movierental.movie natural left join rates natural join haslang WHERE title LIKE '%"+ suchetext +"%' and genre LIKE '%" + gen + "%' and Pid LIKE '%" + pri + "%' and ageRating LIKE '%"+ age +"%' and Language LIKE '%"+ lang +"%' group by mid having average >= "+rate+"");
                        stmtSearch = conn.createStatement();
                        
                        while(rs3.next()){
                        rsSearch = stmtSearch.executeQuery("Select * from movie natural join haslang where mid = "+rs3.getString("mid")+" ");
                        rsSearch.next();
                        String language1 = rsSearch.getString("Language");
                        rsSearch.last();
                        String language2 = rsSearch.getString("Language");
                        
                        if(language2.equals(language1)){
                            language2 = "";
                        }
                        Movie movie = new Movie(rs3.getString("mid"),rs3.getString("title"),rs3.getString("picture"),rs3.getString("average"), rs3.getString("description"),rs3.getString("genre"),rs3.getString("agerating"),rs3.getString("releasedate"),rs3.getString("duration"),rs3.getString("link"),language1, language2, rs3.getString("Pid"),"");
                        movies2.add(movie);
                        }
                        
                        while(movies2.size() %10 != 0){
                        Movie dump = new Movie("","","http://stefano.bplaced.net/nothing.png",null,"","","","","","","","","","");
                        movies2.add(dump);
                        }
                        this.searchResult(movies2);
                        
                        }else{
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT *,avg(rating) as average FROM movie natural join haslang natural left join rates natural join pricecat WHERE title LIKE '%"+ suchetext +"%' and genre LIKE '%" + gen + "%' and Pid LIKE '%" + pri + "%' and ageRating LIKE '%"+ age +"%' and Language LIKE '%"+ lang +"%' group by mid");
                        stmtSearch = conn.createStatement();
                        
                        while(rs.next()){
                     
                        rsSearch = stmtSearch.executeQuery("Select * from movie natural join haslang where mid = "+rs.getString("mid")+" ");
                        rsSearch.next();
                        String language1 = rsSearch.getString("Language");
                        rsSearch.last();
                        String language2 = rsSearch.getString("Language");
                        
                        if(language2.equals(language1)){
                            language2 = "";
                        }
                        Movie movie = new Movie(rs.getString("mid"),rs.getString("title"),rs.getString("picture"),rs.getString("average"), rs.getString("description"),rs.getString("genre"),rs.getString("agerating"),rs.getString("releasedate"),rs.getString("duration"),rs.getString("link"),language1, language2, rs.getString("price"),"");
                        movies2.add(movie);
                        }
                        while(movies2.size() %10 != 0){
                        Movie dump = new Movie("","","http://stefano.bplaced.net/nothing.png",null,"","","","","","","","","","");
                        movies2.add(dump);
                        }
                        this.searchResult(movies2);
                        }
                        
                    } catch (        SQLException | MalformedURLException ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccount;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonReturn;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonVideoLibrary;
    private javax.swing.JComboBox jComboAgeRating;
    private javax.swing.JComboBox jComboGenre;
    private javax.swing.JComboBox jComboLanguage;
    private javax.swing.JComboBox jComboPrice;
    private javax.swing.JComboBox jComboRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabelNewest;
    private javax.swing.JLabel jLabelTop10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane jTextSearch;
    // End of variables declaration//GEN-END:variables

class MouseImpl extends MouseAdapter {
         @Override
        public void mouseClicked(MouseEvent e) {
            Object source = e.getSource();
            if (source == jLabelBild1) {
                try {
                    new MovieInfo(user,movies.get(0)).setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
            if (source == jLabelBild6) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(5));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild7) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(6));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild8) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(7));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            if (source == jLabelBild9) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(8));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild10) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(9));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }
            if (source == jLabelBild11) {
                try {
                    new MovieInfo(user,movies.get(10)).setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild12) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(11));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
 
            if (source == jLabelBild13) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(12));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild14) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(13));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild15) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(14));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild16) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(15));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild17) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(16));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild18) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(17));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            if (source == jLabelBild19) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(18));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (source == jLabelBild20) {
                 try {
                    MovieInfo window = new MovieInfo(user,movies.get(19));
                    window.pack();
                    window.setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }
    }
}
}

