/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Scorpius
 */
public class patient_doctorC {
  
    public static void addDoctor(int doctor_id,int patient_id) throws SQLException, ClassNotFoundException{
    
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO patient_doctor (patient_id,doctor_id) VALUES(?,?)";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    pStatement.setInt(1, patient_id);
    pStatement.setInt(2, doctor_id);
    int result = pStatement.executeUpdate();
    
    }
    
    public static ArrayList<Integer> returnListOfDoctors(int patient_id) throws SQLException, ClassNotFoundException{
    
    ArrayList<Integer> listOfDoc=new ArrayList<Integer>();
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT doctor_id FROM patient_doctor WHERE patient_id LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    pStatement.setInt(1, patient_id);
    ResultSet result=pStatement.executeQuery();
    while(result.next()){
    listOfDoc.add(result.getInt("doctor_id"));
    
    
    }
    
    return listOfDoc;
    }
    
     public static void removeDoctor(int doctor_id,int patient_id) throws SQLException, ClassNotFoundException{
    
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="DELETE FROM patient_doctor WHERE patient_id LIKE ? AND doctor_id LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    pStatement.setInt(1, patient_id);
    pStatement.setInt(2, doctor_id);
    int result = pStatement.executeUpdate();
    
    }
    
     
      public static ArrayList<Integer> returnListI(int doctor_id) throws SQLException, ClassNotFoundException{
    
    ArrayList<Integer> listOfP=new ArrayList<Integer>();
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT patient_id FROM patient_doctor WHERE doctor_id LIKE ?";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    pStatement.setInt(1, doctor_id);
    ResultSet result=pStatement.executeQuery();
    while(result.next()){
    listOfP.add(result.getInt("patient_id"));
    
    
    }
    
    return listOfP;
    }
     
     
     
     
     
}
