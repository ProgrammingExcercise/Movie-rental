/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movierental;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Movie {
    String mid, title, imglink, rating, description, genre, agerating, releasedate, duration, link;
    
    public static void addMovie(String title,String genre,String agerating,String description,String releaseyear,String duration,String streamlink,String imglink,String pricecat){
        
           Verbindung db = new Verbindung();
           db.start();
           Connection conn = db.getVerbindung();
      
           try {
              Statement stmt = conn.createStatement();
               stmt.executeUpdate("INSERT INTO `movierental`.`movie`(`title`, `genre`, `ageRating`, `description`, `releaseDate`, `duration`, `link`, `Picture`, `Pid`) VALUES "
                       + "('" + title + "','" + genre + "','" + agerating + "','" + description + "','" +  releaseyear + "','" + duration + "','" + streamlink + "','" + imglink + "','" + pricecat +"')");
           } catch (SQLException ex) {
               Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
           }
           JOptionPane.showMessageDialog(null, "Movie was added."+ pricecat);
    
    
    
    }
    public static void changeMovie(String title,String genre,String agerating,String description,String releaseyear,String duration,String streamlink,String imglink,String pricecat){
           Verbindung db = new Verbindung();
           db.start();
           Connection conn = db.getVerbindung();
           
           try {
              Statement stmt = conn.createStatement();
               stmt.executeUpdate("INSERT INTO `movierental`.`movie`(`title`, `genre`, `ageRating`, `description`, `releaseDate`, `duration`, `link`, `Picture`, `Pid`) VALUES "
               + "('" + title + "','" + genre + "','" + agerating + "','" + description + "','" +  releaseyear + "','" + duration + "','" + streamlink + "','" + imglink + "','" + pricecat +"')");
           } catch (SQLException ex) {
               Logger.getLogger(AddMovie.class.getName()).log(Level.SEVERE, null, ex);
           }
           JOptionPane.showMessageDialog(null, "Movie was added."+ pricecat);
    
    }
}
