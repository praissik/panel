package com.project.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteWorker {
	
	public boolean deleteWorker(int id) {
		
		PreparedStatement statement;
		String sql = "DELETE FROM workers WHERE id=?;";
		
		ConnectDb c = new ConnectDb();
		Connection db = c.connect();
		
		try {

			statement = db.prepareStatement(sql);

			statement.setInt(1, id);
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
