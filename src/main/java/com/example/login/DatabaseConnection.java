package com.example.login;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "Loging";
        String databaseUser = "root";
        String databasePassword = "Taha@1234";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
