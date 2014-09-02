/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Uli
 */
public class Db {
    
    final private String dbUrl = "jdbc:postgresql://localhost:5432/test";
    final private String user = "postgres";
    final private String password = "password";
    
    public ResultSet performQuery(String query) throws ClassNotFoundException, SQLException {
        System.out.println("Loading DB driver...");
        Class.forName("org.postgresql.Driver");
        System.out.println("Loading DB driver...erfolgreich!");
        
        System.out.println("Connection wird aufgebaut...");
        Connection connection = DriverManager.getConnection(dbUrl, user, password);
        System.out.println("Connection wird aufgebaut...erfolgreich!");
        
        System.out.println("Querying...");
        Statement statement = connection.createStatement();
        statement.execute(query);
        System.out.println("Querying...erfolgreich!");

        return statement.getResultSet();
    } 
}
