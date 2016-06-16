/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.doctor_details;
import DAO.userLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Scorpius
 */
public class doctorDetailsC {
    
    
    
    
    public static void addNewDoctor(doctor_details doctor,userLogin logIn) throws SQLException, ClassNotFoundException{
    
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO doctors_details (full_name,user_name) VALUES(?,?)";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    pStatement.setString(2,logIn.getUserName());
    pStatement.setString(1,doctor.getFullName());
    int result = pStatement.executeUpdate();
        System.out.println("doctor"+result);
    
        System.out.println("doctor Con");
    
    }
    
    public static ArrayList<doctor_details> serchDoctors(String matches,int patient_id) throws SQLException, ClassNotFoundException{
    
    ArrayList<doctor_details> listOfDoctors=new ArrayList<doctor_details>();
    String userName;
    String full_name;
    doctor_details doctor;
    int i=0;
     Connection connection=database.db_connector.setConneciton().getConnection();
     String sql ="SELECT * FROM doctors_details WHERE full_name LIKE ? AND person_id NOT IN (SELECT doctor_id FROM patient_doctor WHERE patient_id LIKE ?)";
      PreparedStatement pStatement = connection.prepareStatement(sql);
        pStatement.setString(1,"%"+matches+"%");
        pStatement.setInt(2,patient_id );
      ResultSet result=pStatement.executeQuery();
      while(result.next()){
    userName=result.getString("user_name");
    full_name=result.getString("full_name");
    doctor=new doctor_details( full_name,userName);
    listOfDoctors.add(i, doctor);
    i++;
    }
      
    return listOfDoctors;
    }
    
    
    public static int returnid(String userName) throws SQLException, ClassNotFoundException{
    
        
      int person_id;
     Connection connection=database.db_connector.setConneciton().getConnection();
     String sql ="SELECT person_id FROM doctors_details WHERE user_name = ?";
     PreparedStatement pStatement = connection.prepareStatement(sql);
     pStatement.setString(1, userName);
   
        System.out.println("find doctors id from doctorC");
     ResultSet result=pStatement.executeQuery();
     if(result.next()){
     
     person_id=result.getInt("person_id");
     return person_id;
     }
     
     
    return -999;
    }
    
    public static ArrayList<doctor_details> returnListOfDoc(ArrayList<Integer> list) throws SQLException, ClassNotFoundException{
    
    ArrayList<doctor_details> listOfDoc=new ArrayList<doctor_details>();
    doctor_details doctor;
    String fullName;
     String email;
     
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT * from doctors_details WHERE person_id LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    for(int i=0;i<list.size();i++){
    pStatement.setInt(1, list.get(i));
    ResultSet result=pStatement.executeQuery();
    if(result.next()){
     fullName=result.getString("full_name");
     email=result.getString("user_name");
    doctor=new doctor_details(fullName, email);
    listOfDoc.add(doctor);
    
    }
    
    
    }
    
    
    return listOfDoc;
    }
    
    public static int getId(String userName) throws SQLException, ClassNotFoundException{
    
    Connection connection=database.db_connector.setConneciton().getConnection();
        
     String sql ="SELECT person_id FROM doctors_details WHERE user_name LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
     pStatement.setString(1,userName);  
     ResultSet result=pStatement.executeQuery();
        
     if(result.next()){
         
     int person_id=result.getInt("person_id");
        
     return person_id;
     }
     
     else{
         System.out.println("user doesnt exist !!!!! ");
      return -999;
     }
   
    }
    
    
    
    
}
