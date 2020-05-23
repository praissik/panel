package com.project.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EditWorker {
	
	public boolean editWorker(Worker worker) {
		
		PreparedStatement statement;
		String sql = "UPDATE workers SET firstname=?, lastname=?, email=?, street=?, "
				+ "number=?, flat=?, postcode=?, city=? WHERE id=?";
		
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
			statement.setInt(9, worker.getId());
			
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
    	return true;
	}
}
