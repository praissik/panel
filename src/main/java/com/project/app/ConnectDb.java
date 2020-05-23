package com.project.app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
	
    private Connection c = null;

    private final String url = "jdbc:postgresql://127.0.0.1:5432/factory";
    private final String user = "postgres";
    private final String pass = "admin";

    public Connection connect() {

        try {
        	Class.forName("org.postgresql.Driver");
        	
            c = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return c;
    }
}
