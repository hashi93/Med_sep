/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Scorpius
 */
public class db_handler {
    
    static Statement stm;
    static ResultSet rst;


    public static int setData(Connection connection, String sql) throws SQLException {
        stm = connection.createStatement();
        int result = stm.executeUpdate(sql);
        return result;
    }
    public static ResultSet getData(Connection connection,String sql) throws SQLException {
        stm = connection.createStatement();
        rst = stm.executeQuery(sql);
        return rst;
}
}