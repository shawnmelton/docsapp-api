package com.docs.app.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "postgres")
public class PostgresConfig {
	private String database;
	private String host;
	private String password;
	private String user;
	
	public String getDatabase() {
		return this.database;
	}
	
	public String getHost() {
		return this.host;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setDatabase(final String database) {
		this.database = database;
	}
	
	public void setHost(final String host) {
		this.host = host;
	}
	
	public void setPassword(final String password) {
		this.password = password;
	}
	
	public void setUser(final String user) {
		this.user = user;
	}
}
