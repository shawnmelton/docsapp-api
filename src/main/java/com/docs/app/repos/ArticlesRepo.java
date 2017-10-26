package com.docs.app.repos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.docs.app.beans.Article;
import com.docs.app.beans.DatabaseResultItem;
import com.docs.app.beans.DatabaseResultItem.DatabaseResultItemType;
import com.docs.app.services.DatabaseClient;

@Repository
public class ArticlesRepo {
	@Autowired
	private DatabaseClient dbClient;
	
	public Article read(final int id) {
		final ArrayList<DatabaseResultItem> columns = new ArrayList<DatabaseResultItem>();
		columns.add(new DatabaseResultItem("article_id", DatabaseResultItemType.INTEGER));
		columns.add(new DatabaseResultItem("article_title", DatabaseResultItemType.INTEGER));
		columns.add(new DatabaseResultItem("article_content", DatabaseResultItemType.INTEGER));
		
		final ArrayList<Object> params = new ArrayList<Object>();
		params.add(id);
		
		final ArrayList<Object> results = this.dbClient.query(""
				+ "SELECT article_id, article_title, article_content "
				+ "FROM articles "
				+ "WHERE article_id = ? "
				+ "LIMIT 1", params, columns);
		
		if (results != null && results.size() > 0) {
			final Article article = new Article();
			article.setId((Integer) results.get(0));
			article.setTitle((String) results.get(1));
			article.setContent((String) results.get(2));
			return article;
		}
		
		return null;
	}
}
