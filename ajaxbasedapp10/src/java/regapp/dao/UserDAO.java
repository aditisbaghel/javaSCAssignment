/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import regapp.dbutil.DBConnection;
import regapp.dto.UserDTO;

/**
 *
 * @author pc
 */
public class UserDAO {
    public static boolean findUser(String uid)throws SQLException{
        boolean userFound=false;
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select userid from users where userid=?");
        ps.setString(1,uid);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            userFound=true;
        }
        return userFound;
    }
    public static boolean registerUser(UserDTO user)throws SQLException{
        boolean done=false;
       Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?)");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getUserName());
        ps.setString(3,user.getPassword());
        int ans=ps.executeUpdate();
        if(ans!=0)
            return true;
        return done;
    }     
}
