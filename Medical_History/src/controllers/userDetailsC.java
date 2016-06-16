/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.patientD;
import DAO.userLogin;
import DAO.user_details;
import java.sql.Connection;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Scorpius
 */
public class userDetailsC {
    
    public static void addNewUser(user_details newUser,userLogin newUserLogin) throws SQLException, ClassNotFoundException{
    
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO patient_details (full_name,user_name) VALUES(?,?)";
     //   System.out.println(newUser.getFullName());
    PreparedStatement pStatement = connection.prepareStatement(sql);
    // pStatement.setNull(1,java.sql.Types.INTEGER);
    pStatement.setString(2,newUserLogin.getUserName());
    pStatement.setString(1,newUser.getFullName());
    int result = pStatement.executeUpdate();
        System.out.println("patient"+result);
    }
    
    public static int getId(String userName) throws SQLException, ClassNotFoundException{
    
    Connection connection=database.db_connector.setConneciton().getConnection();
        System.out.println("userNAME @ userDEtailsC "+userName);
    //String sql="SELECT person_id FROM patient_details WHERE user_name = ?";
     String sql ="SELECT person_id FROM patient_details WHERE user_name LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
     pStatement.setString(1,userName);  
     ResultSet result=pStatement.executeQuery();
        System.out.println("djadjagdjhsag");
     if(result.next()){
         
     int person_id=result.getInt("person_id");
     System.out.println("Person Id"+person_id);    
     return person_id;
     }
     
     else{
         System.out.println("user doesnt exist !!!!! ");
      return -999;
     }
   
    }
    
    public static ArrayList<patientD> returnListP(ArrayList<Integer> list) throws SQLException, ClassNotFoundException{
    
    ArrayList<patientD> listOfP=new ArrayList<patientD>();
    patientD patient;
    String fullName;
     String email;
     
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT * from patient_details WHERE person_id LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    for(int i=0;i<list.size();i++){
    pStatement.setInt(1, list.get(i));
    ResultSet result=pStatement.executeQuery();
    if(result.next()){
     fullName=result.getString("full_name");
     email=result.getString("user_name");
    patient=new patientD(fullName, email);
    listOfP.add(patient);
    
    }
    
    
    }
    
    
    return listOfP;
    }
    
}
