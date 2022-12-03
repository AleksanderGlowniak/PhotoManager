/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aleks
 */
public class ConnectionProvider {
    
        public static Connection getCon(){
    
        Connection con = null;
        try
        {
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/clients","root","");
        
        if (con == null){
            System.out.println("No connection to db.");
        } else{
            System.out.println("Connection to database exist");
        }
        }
        catch(SQLException e)
                {
                        
                    e.printStackTrace();
                }
        catch(Exception e)
                {
                
                    e.printStackTrace();
                }
        return con;

        }
}
