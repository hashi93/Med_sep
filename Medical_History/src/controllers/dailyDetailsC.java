/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.daily_details;
import DAO.disease;
import DAO.doctor_details;
import database.db_handler;
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
public class dailyDetailsC {

    public static void addNewDetail(daily_details newDetail) throws SQLException, ClassNotFoundException {
        Connection connection = database.db_connector.setConneciton().getConnection();
        String sql = "INSERT INTO daily_details (type,date,patient_id,value) VALUES(?,?,?,?)";
        PreparedStatement pStatement = connection.prepareStatement(sql);

        pStatement.setInt(1, newDetail.getType());

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {

            java.util.Date startDate = df.parse(newDetail.getDate());
            System.out.println("date brfor " + startDate);
            pStatement.setDate(2, new java.sql.Date(startDate.getTime()));
//              pStatement.setDate(2,);
            System.out.println("parsed");
        } catch (ParseException ex) {

            Logger.getLogger(diseaseC.class.getName()).log(Level.SEVERE, null, ex);
        }

        pStatement.setInt(3, newDetail.getPatient_id());
        pStatement.setFloat(4, newDetail.getValue());
        int result = pStatement.executeUpdate();
    }

    public static ArrayList<daily_details> serchDetails(String dateF, String dateT, int Patient_id, int type) throws SQLException, ClassNotFoundException {

        ArrayList<daily_details> listOfDetails = new ArrayList<daily_details>();

        String date;
        float value;
        int i = 0;
        daily_details newD;
        Connection connection = database.db_connector.setConneciton().getConnection();

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try {

            java.util.Date startDate = df.parse(dateF);
            java.util.Date endDate = df.parse(dateT);

            System.out.println(new java.sql.Date(startDate.getTime()));
            System.out.println(new java.sql.Date(endDate.getTime()));
            System.out.println("parsed22");
//            String sql ="SELECT * FROM daily_details WHERE patient_id='"+Patient_id+"' AND type='"+type+"' AND date BETWEEN '"+new java.sql.Date(startDate.getTime())+"' AND '"+ new java.sql.Date(endDate.getTime())+"'";
            String sql = "SELECT * FROM daily_details WHERE patient_id='" + Patient_id + "' AND type='" + type + "' AND date BETWEEN '" + new java.sql.Date(startDate.getTime()) + "' AND '" + new java.sql.Date(endDate.getTime()) + "' ORDER BY date ASC";
            ResultSet result = db_handler.getData(connection, sql);
            while (result.next()) {
                System.out.println("results");
                date = result.getString("date");
                value = result.getFloat("value");
                System.out.println("date" + date + " value" + value);

                newD = new daily_details(date, value);
                listOfDetails.add(i, newD);
                i++;
            }

        } catch (ParseException ex) {

            Logger.getLogger(diseaseC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfDetails;
    }

}
