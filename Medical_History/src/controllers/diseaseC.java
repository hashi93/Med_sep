/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.disease;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Scorpius
 */
public class diseaseC {
    
    
    public static void addNewDisease(disease newDisease) throws SQLException, ClassNotFoundException{
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO disease_details (patient_id,disease_name,date,symptoms,description,addedBy,addedOn) VALUES(?,?,?,?,?,?,?)";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    pStatement.setInt(1,newDisease.getPatientId());
    pStatement.setString(2,newDisease.getDiseasename());
   
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {
            
       java.util.Date startDate = df.parse(newDisease.getDate());
            pStatement.setDate(3, new java.sql.Date(startDate.getTime()));
            System.out.println("parsed");
        } catch (ParseException ex) {
            
            
            
            Logger.getLogger(diseaseC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    pStatement.setString(4,newDisease.getSymptoms());
    pStatement.setString(5,newDisease.getDescription());
    pStatement.setString(6,newDisease.getAddedBy());
    pStatement.setString(7,newDisease.getAddedOn());
    int result = pStatement.executeUpdate();
    
    }
    
     public static ArrayList<disease> returnListOfDis(int patient_id) throws SQLException, ClassNotFoundException{
    
    ArrayList<disease> listOfDis=new ArrayList<disease>();
    disease dis;
    String name;
     String date;
     String symptom;
     String description;
     String addedBy;
     String addedOn;
     
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT * from disease_details WHERE patient_id LIKE ? ORDER BY date DESC";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    
    pStatement.setInt(1,patient_id);
    ResultSet result=pStatement.executeQuery();
    while(result.next()){
     name=result.getString("disease_name");
     date=result.getString("date");
     symptom=result.getString("symptoms");
     description=result.getString("description");
     addedBy=result.getString("addedBy");
     addedOn=result.getString("addedOn");
    dis=new disease(name,date,symptom,description,addedBy,addedOn);
    listOfDis.add(dis);
    
    }
    
    
    
    
    
    return listOfDis;
    }
    
    
    
    
    
    
}
