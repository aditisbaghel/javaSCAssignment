/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */
public class DBConnection {
    private static Connection conn;
    static
    {
       try{
           Class.forName("oracle.jdbc.OracleDriver");
           System.out.println("Drver sucessfully loaded");
           conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ora", "myshop2", "myshop2");
       } 
       catch(Exception ex){
           System.out.println("Exception in DB"+ex);
       }
    }

    public static Connection getConnection() {
        return conn;
    }    }
    

