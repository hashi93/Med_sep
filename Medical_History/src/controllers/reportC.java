/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Scorpius
 */
public class reportC {
    
    public static void addNewReport(report newReport) throws SQLException, ClassNotFoundException {
    
    Connection connection=database.db_connector.setConneciton().getConnection();
    String sql="INSERT INTO report (patient_id,image,added_on) VALUES(?,?,?)";
    PreparedStatement pStatement = connection.prepareStatement(sql);
    
    pStatement.setInt(1,newReport.getPatient_id());
    pStatement.setBlob(2,newReport.getImage());
    pStatement.setString(3,newReport.getAdded_on());
    int result = pStatement.executeUpdate();
    
    }
   
    
    
    
}
