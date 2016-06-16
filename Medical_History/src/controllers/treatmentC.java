/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.disease;
import DAO.treatments;
import java.sql.Connection;
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
public class treatmentC {
    
    
     public static void addNewTreatment(treatments newTreatment) throws SQLException, ClassNotFoundException{
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO treatment_details (patient_id,disease_name,date,treatment,description,added_by,added_on) VALUES(?,?,?,?,?,?,?)";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    pStatement.setInt(1,newTreatment.getPatientId());
    pStatement.setString(2,newTreatment.getDiseasename());
   
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {
            
       java.util.Date startDate = df.parse(newTreatment.getDate());
            pStatement.setDate(3, new java.sql.Date(startDate.getTime()));
            System.out.println("parsed");
        } catch (ParseException ex) {
            
            
            
            Logger.getLogger(diseaseC.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    pStatement.setString(4,newTreatment.getTreatment());
    pStatement.setString(5,newTreatment.getDescription());
    pStatement.setString(6,newTreatment.getAddedBy());
    pStatement.setString(7,newTreatment.getAddedOn());
    
         System.out.println(newTreatment.getPatientId());
         System.out.println(newTreatment.getDiseasename());
         System.out.println(newTreatment.getTreatment());
    
    int result = pStatement.executeUpdate();
    
    }
    
    public static ArrayList<treatments> returnListOfT(int patient_id) throws SQLException, ClassNotFoundException{
    
    ArrayList<treatments> listOfTr=new ArrayList<treatments>();
    treatments tr;
    String name;
     String date;
     String treatment;
     String description;
     String addedBy;
     String addedOn;
     
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="SELECT * from treatment_details WHERE patient_id LIKE ? ORDER BY date DESC";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    
    pStatement.setInt(1,patient_id);
    ResultSet result=pStatement.executeQuery();
    while(result.next()){
     name=result.getString("disease_name");
     date=result.getString("date");
     treatment=result.getString("treatment");
     description=result.getString("description");
     addedBy=result.getString("added_by");
     addedOn=result.getString("added_on");
    tr=new treatments(name,date,treatment,description,addedBy,addedOn);
    listOfTr.add(tr);
    
    }
    
    
    
    
    
    return listOfTr;
    }
    
    
    
}
