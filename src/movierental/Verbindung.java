/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package movierental;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author stefano
 */
public class Verbindung {
   public Connection con;
   
    public void start(){
        try{
               Class.forName("com.mysql.jdbc.Driver").newInstance();
               con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/movierental","root","");
               con.setReadOnly(true);
               
        }catch(Exception e){
            System.out.println("Verbindung zur Datenbank fehlgeschlagen!!" + e);
        }
    }
    
    public Connection getVerbindung(){
    return con;
    }

    
}
  