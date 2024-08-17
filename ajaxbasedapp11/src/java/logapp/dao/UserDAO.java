/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logapp.dbutil.DBConnection;
import logapp.dto.UserDTO;

/**
 *
 * @author pc
 */
public class UserDAO {
    public static boolean findUser(String uid,String pwd)throws SQLException{
        boolean userFound=false;
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select password username from users where userid=?");
        ps.setString(1,uid);
        ResultSet rs=ps.executeQuery();
        String username=rs.getString(2);
        if(rs.next()){
            userFound=true;
            String password=rs.getString(1);
            if(pwd.equalsIgnoreCase(password))
            {
                userFound=true;
            }
        }
        return userFound;
    }
        
}
