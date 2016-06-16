/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.userLogin;
import database.db_connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Scorpius
 */
public class loginInfoC {
    
    
    
    //add new user to the system
    public static void addNewUser(userLogin userLogin) throws SQLException, ClassNotFoundException{
    
        
    
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO logininfo VALUES(?,MD5(?),?)";
    PreparedStatement pStatement = connection.prepareStatement(sql);
     pStatement.setString(1,userLogin.getUserName());
     pStatement.setString(2,userLogin.getPssword());
     pStatement.setInt(3, userLogin.getType());
     int result = pStatement.executeUpdate();
        System.out.println("login"+result);
    }
    
 
    //verify user
    public static boolean verifyUser(userLogin user) throws SQLException, ClassNotFoundException{
    
        
        System.out.println("inside login C");
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT * FROM logininfo WHERE user_name=? AND password=MD5(?)";
    PreparedStatement pStatement=connection.prepareStatement(sql);
    pStatement.setString(1,user.getUserName());
    pStatement.setString(2,(user.getPssword()));
    ResultSet rst=pStatement.executeQuery();
    if(rst.next()){
        System.out.println("User Exist");
        return true;
    
    }
    else{
    
    return false;
    }
    }
    
    public static int returnUserType(String userName) throws SQLException, ClassNotFoundException{
    int type;
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT * FROM logininfo WHERE user_name=?";
    PreparedStatement pStatement=connection.prepareStatement(sql);
    pStatement.setString(1,userName);
    ResultSet rst=pStatement.executeQuery();
    if(rst.next()){
        type=rst.getInt("type");
        
        return type;
    
    }
    else{
    
    return -99;
    }
    
    
    }
    
    
}
