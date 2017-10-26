package com.docs.app.beans;

public class DatabaseResultItem {
	private String columnName;
	private DatabaseResultItemType columnType;
	
	public enum DatabaseResultItemType {
		INTEGER, STRING
	}
	
	public DatabaseResultItem(final String columnName, final DatabaseResultItemType columnType) {
		this.columnName = columnName;
		this.columnType = columnType;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public DatabaseResultItemType getColumnType() {
		return columnType;
	}
	
	public void setColumnName(final String columnName) {
		this.columnName = columnName;
	}
	
	public void setColumnType(final DatabaseResultItemType columnType) {
		this.columnType = columnType;
	}
}
