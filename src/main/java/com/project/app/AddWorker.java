package com.project.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddWorker {

	public boolean addWorkerToDatabase(Worker worker) {

        PreparedStatement statement = null;
        String sql = "INSERT INTO workers (firstname, lastname, email, street, number, flat, postcode, city)"
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        
		ConnectDb c = new ConnectDb();
		Connection db = c.connect();
		
        try {
        	
        	statement = db.prepareStatement(sql);
			
        	statement.setString(1, worker.getFirstname());
        	statement.setString(2, worker.getLastname());
        	statement.setString(3, worker.getEmail());
        	statement.setString(4, worker.getStreet());
        	statement.setString(5, worker.getNumber());
        	statement.setString(6, worker.getFlat());
        	statement.setString(7, worker.getPostcode());
        	statement.setString(8, worker.getCity());
			
        	statement.execute();
        	
        	statement.close();
        	db.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    	return true;
    }
}
