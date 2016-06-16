/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Scorpius
 */
public final class db_connector {
    
    
    private static db_connector connector;
    private Connection connection;
    
    private db_connector() throws ClassNotFoundException, SQLException{
    
    Class.forName("com.mysql.jdbc.Driver");
    connection= DriverManager.getConnection("jdbc:mysql://localhost/medical_history","med","1234");
// connection= DriverManager.getConnection("mysql://127.5.64.2:3306/medicalhistory","adminNe2ArvD","dn1TzhrhbCC_");
    }
    
    public static db_connector setConneciton() throws SQLException, ClassNotFoundException {

        if(connector==null){
            synchronized (db_connector.class){
                if(connector==null){
                    connector=new db_connector();
                }
            }
        }


     return connector;
    }
    public Connection getConnection(){
    return connection;
}
    
    
    
    
}
