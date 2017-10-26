package com.docs.app.services.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.docs.app.beans.DatabaseResultItem;

@Service
public class DatabaseResultSetMapper {
	public ArrayList<Object> map(final ResultSet results, final ArrayList<DatabaseResultItem> columns) {
		final ArrayList<Object> mappedValues = new ArrayList<Object>();
		
		try {
			while (results.next()) {
				for (DatabaseResultItem column : columns) {
					switch (column.getColumnType()) {
						case INTEGER:
							mappedValues.add(
								results.getInt(column.getColumnName())
							);
							break;
						
						case STRING:
						default:
							mappedValues.add(
								results.getString(column.getColumnName())
							);
							break;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Unable to map database resultset.");
			System.out.println("Error: "+ e.getMessage());
		}
		
		
		return mappedValues;
	}
}
