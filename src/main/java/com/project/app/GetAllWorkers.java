package com.project.app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class GetAllWorkers {
	
    public List<Worker> getAllWorkers() {

        ResultSet result;
        PreparedStatement statement;
        String sql = "SELECT * FROM workers";
        List<Worker> allWorkers = new ArrayList<>();

        ConnectDb c = new ConnectDb();
        Connection db = c.connect();

        try {
        	
            statement = db.prepareStatement(sql);
            result = statement.executeQuery();

            while(result.next()) {
            	
            	Worker worker = new Worker(
            			result.getInt("id"),
            			result.getString("firstname"),
            			result.getString("lastname"),
            			result.getString("street"),
            			result.getString("number"),
            			result.getString("flat"),
            			result.getString("postcode"),
            			result.getString("city"),
            			result.getString("email")
            			);
            	
                allWorkers.add(worker);
            }
            statement.close();
            result.close();
            db.close();
            
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        allWorkers.sort(Comparator.comparing(Worker::getId));
        return allWorkers;
    }
}
