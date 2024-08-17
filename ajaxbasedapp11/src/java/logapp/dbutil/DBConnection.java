package logapp.dbutil;

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
           conn=DriverManager.getConnection("jdbc:oracle:thin:@//MEGHA-GOYAL:1521/XE","project","assignment");
       } 
       catch(Exception ex){
           System.out.println("Exception in DB"+ex);
       }
    }

    public static Connection getConnection() {
        return conn;
    }    }
    

