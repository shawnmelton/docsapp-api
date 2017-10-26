package com.docs.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.app.beans.DatabaseResultItem;
import com.docs.app.config.PostgresConfig;
import com.docs.app.services.mappers.DatabaseResultSetMapper;

@Service
public class DatabaseClient {
	@Autowired
	private PostgresConfig config;
	
	@Autowired
	private DatabaseResultSetMapper mapper;
	
	private Connection conn;
	
	private void connect() {
		if (this.conn != null) {
			return;
		}
		
		try {
			this.conn = DriverManager.getConnection(this.getConnectionUrl(),
				this.getConnectionProperties());
		} catch (SQLException e) {
			System.out.println("Unable to connect to database");
			System.out.println("Database Error: "+ e.getMessage());
		}
	}
	
	private Properties getConnectionProperties() {
		final Properties props = new Properties();
		props.setProperty("user", this.config.getUser());
		props.setProperty("password", this.config.getPassword());
		
		return props;
	}
	
	private String getConnectionUrl() {
		final StringBuilder sb = new StringBuilder();
		sb.append("jdbc:postgresql://");
		sb.append(config.getHost());
		sb.append("/");
		sb.append(config.getDatabase());
		return sb.toString();
	}
	
	public ArrayList<Object> query(final String query, final ArrayList<Object> params, final ArrayList<DatabaseResultItem> columns) {
		this.connect();
		
		ArrayList<Object> results = new ArrayList<Object>();
		
		try {
			final PreparedStatement st = this.conn.prepareStatement(query);
			
			if (params != null && params.size() > 0) {
				int index = 1;
				for (final Object param : params) {
					try {
						if (param instanceof String) {
							st.setString(index++, (String) param);
						} else if (param instanceof Integer) {
							st.setInt(index++, (Integer) param);
						}
					} catch (SQLException ex) {
						System.out.println("Unable to set statement parameter: "+ ex.getMessage());
					}
				};
			}
	
			final ResultSet rs = st.executeQuery();
			results = this.mapper.map(rs, columns);
				
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out.println("Unable to execute query.");
			System.out.println("Query Error: "+ e.getMessage());
		}
		
		return results;
	}
}
