CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    user_first_name VARCHAR(75) NOT NULL,
    user_last_name VARCHAR(75) NOT NULL,
    user_email_address VARCHAR(255) NOT NULL,
    user_screen_name VARCHAR(75) NOT NULL,
    user_date_added TIMESTAMP NOT NULL DEFAULT NOW(),
    user_date_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(75) NOT NULL,
    category_date_added TIMESTAMP NOT NULL DEFAULT NOW(),
    category_date_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS articles (
    article_id SERIAL PRIMARY KEY,
    article_initial_author INTEGER NOT NULL REFERENCES users(user_id),
    article_title VARCHAR(75) NOT NULL,
    article_content TEXT NOT NULL,
    article_date_added TIMESTAMP NOT NULL DEFAULT NOW(),
    article_date_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS article_categories (
    article_id INTEGER NOT NULL REFERENCES articles(article_id),
    category_id INTEGER NOT NULL REFERENCES categories(category_id)
);

CREATE TABLE IF NOT EXISTS article_revisions (
    revision_id SERIAL PRIMARY KEY,
    article_id INTEGER NOT NULL REFERENCES articles(article_id),
    user_id INTEGER NOT NULL REFERENCES users(user_id),
    revision_date_added TIMESTAMP NOT NULL DEFAULT NOW()
);