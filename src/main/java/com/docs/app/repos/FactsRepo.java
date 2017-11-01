package com.docs.app.repos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.docs.app.beans.DatabaseResultItem;
import com.docs.app.beans.DatabaseResultItem.DatabaseResultItemType;
import com.docs.app.beans.Fact;
import com.docs.app.services.DatabaseClient;

@Repository
public class FactsRepo {
	@Autowired
	private DatabaseClient dbClient;
	
	public Fact read(final int id) {
		final ArrayList<DatabaseResultItem> columns = new ArrayList<DatabaseResultItem>();
		columns.add(new DatabaseResultItem("fact_id", DatabaseResultItemType.INTEGER));
		columns.add(new DatabaseResultItem("fact_title", DatabaseResultItemType.INTEGER));
		columns.add(new DatabaseResultItem("fact_content", DatabaseResultItemType.INTEGER));
		
		final ArrayList<Object> params = new ArrayList<Object>();
		params.add(id);
		
		final ArrayList<Object> results = this.dbClient.query(""
				+ "SELECT fact_id, fact_title, fact_content "
				+ "FROM facs "
				+ "WHERE fact_id = ? "
				+ "LIMIT 1", params, columns);
		
		if (results != null && results.size() > 0) {
			final Fact fact = new Fact();
			fact.setId((Integer) results.get(0));
			fact.setTitle((String) results.get(1));
			fact.setContent((String) results.get(2));
			return fact;
		}
		
		return null;
	}
}
