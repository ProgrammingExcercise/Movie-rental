/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movierental;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Movie {
    String mid, title, imglink, rating, description, genre, agerating, releasedate, duration, link, language, language2, price;
    
    Movie(String mid,String title,String imglink, String rating, String description,String genre,String agerating,String releasedate,String duration,String link, String language, String language2, String price){
    this.mid = mid;
    this.title = title;
    this.imglink = imglink;
    if(rating == null)    
        this.rating = "N/A";
    else    
        this.rating = rating.substring(0, 3);
        
    this.description = description;
    this.genre = genre;
    this.agerating = agerating;
    this.releasedate = releasedate;
    this.duration = duration;
    this.link = link;
    this.language = language;
    this.language2 = language2;
    this.price = price;
    
    }

    
    public Movie(String title, String imglink){
        this.title = title;
        this.imglink = imglink;
    }
    
    
    public static void addMovie(String title,String genre,String agerating,String description,String releaseyear,String duration,String streamlink,String imglink,String pricecat,String language,String language2) throws SQLException{
        
           Verbindung db = new Verbindung();
           db.start();
           Connection conn = db.getVerbindung();
      
         
           Statement stmt = conn.createStatement();
           stmt.executeUpdate("INSERT INTO `movierental`.`movie`(`title`, `genre`, `ageRating`, `description`, `releaseDate`, `duration`, `link`, `Picture`, `Pid`) VALUES "
                              + "('" + title + "','" + genre + "','" + agerating + "','" + description + "','" +  releaseyear + "','" + duration + "','" + streamlink + "','" + imglink + "','" + pricecat +"')");
           
           Statement stmt2 = conn.createStatement();
           stmt2.executeUpdate("INSERT INTO haslang (`Mid`,`Language`) VALUES ((SELECT mid FROM movie WHERE title = '"+ title +"'),'"+ language + "')");
           
           if(language2.equals("Second")){
           JOptionPane.showMessageDialog(null, "Movie was added.");
           }else{
           stmt2.executeUpdate("INSERT INTO haslang (`Mid`,`Language`) VALUES ((SELECT mid FROM movie WHERE title = '"+ title +"'),'"+ language2 + "')");
           JOptionPane.showMessageDialog(null, "Movie was added.");
           }
    
    
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

    public String getTitle() {
        return title;
    }

    public String getImglink() {
        return imglink;
    }

    public String getMid() {
        return mid;
    }

    public String getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getAgerating() {
        return agerating;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public String getDuration() {
        return duration;
    }

    public String getLink() {
        return link;
    }

    public String getLanguage() {
        return language;
    }
    
    public String getLanguage2() {
        return language2;
    }
    
    public String getPrice() {
        return price;
    }
    
}
