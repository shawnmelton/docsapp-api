package com.docs.app.repos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.docs.app.beans.DatabaseResultItem;
import com.docs.app.beans.DatabaseResultItem.DatabaseResultItemType;
import com.docs.app.beans.User;
import com.docs.app.services.DatabaseClient;

@Repository
public class UsersRepo {
	
	@Autowired
	private DatabaseClient dbClient;
	
	public int create(final User user) {
		final ArrayList<Object> params = new ArrayList<Object>();
		params.add(user.getFirstName());
		params.add(user.getLastName());
		params.add(user.getEmailAddress());
		params.add(user.getScreenName());
		
		final ArrayList<DatabaseResultItem> columns = new ArrayList<DatabaseResultItem>();
		columns.add(new DatabaseResultItem("user_id", DatabaseResultItemType.INTEGER));
		
		this.dbClient.query("INSERT INTO users "
				+ "(user_first_name, user_last_name, user_email_address, user_screen_name) "
				+ "VALUES (?, ?, ?, ?)"
				+ "RETURNING user_id", params, columns);
		
		return 0;
	}
	
	/**
	 * Allows the Service layer to read by id or screen name.
	 * @param <Object> param - Expecting <Integer> for user_id or <String> for user_screen_name
	 * @return <User>
	 */
	public User read(final Object param) {
		final ArrayList<DatabaseResultItem> columns = new ArrayList<DatabaseResultItem>();
		columns.add(new DatabaseResultItem("user_id", DatabaseResultItemType.INTEGER));
		columns.add(new DatabaseResultItem("user_first_name", DatabaseResultItemType.STRING));
		columns.add(new DatabaseResultItem("user_last_name", DatabaseResultItemType.STRING));
		columns.add(new DatabaseResultItem("user_email_address", DatabaseResultItemType.STRING));
		columns.add(new DatabaseResultItem("user_screen_name", DatabaseResultItemType.STRING));
		
		final ArrayList<Object> params = new ArrayList<Object>();
		
		String paramName;
		if (param instanceof Integer) {
			params.add(param);
			paramName = "user_id";
		} else {
			params.add(param);
			paramName = "user_screen_name";
		}
		
		final ArrayList<Object> results = this.dbClient.query(""
				+ "SELECT user_id, user_first_name, user_last_name, user_email_address, user_screen_name "
				+ "FROM users "
				+ "WHERE "+ paramName +" = ? "
				+ "LIMIT 1", params, columns);
		
		if (results != null && results.size() > 0) {
			final User user = new User();
			user.setId((Integer) results.get(0));
			user.setFirstName((String) results.get(1));
			user.setLastName((String) results.get(2));
			user.setEmailAddress((String) results.get(3));
			user.setScreenName((String) results.get(4));
			return user;
		}
		
		return null;
	}
}
