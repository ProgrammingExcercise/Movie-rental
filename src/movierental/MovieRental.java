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

/**
 *
 * @author stefano
 */
public class MovieRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
       String password = "stefano!";
       String username = "stefano";
       Verbindung db = new Verbindung();
       db.start();
       Connection conn = db.getVerbindung();
       Statement stmt = conn.createStatement();
       
       ResultSet rs = stmt.executeQuery("Select * from user where password = SHA2('" +password+ "',0) and username = '"+username+"'");
       if(rs.next()){
           System.out.println(rs.getString("Uid"));
       }
    }
    
}
