# docs_app database

CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    user_first_name VARCHAR(75) NOT NULL,
    user_last_name VARCHAR(75) NOT NULL,
    user_email_address VARCHAR(255) NOT NULL,
    user_screen_name VARCHAR(75) NOT NULL,
    user_password VARCHAR(75) NOT NULL,
    user_date_added TIMESTAMP NOT NULL DEFAULT NOW(),
    user_date_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(75) NOT NULL,
    category_date_added TIMESTAMP NOT NULL DEFAULT NOW(),
    category_date_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS facts (
    fact_id SERIAL PRIMARY KEY,
    fact_initial_author INTEGER NOT NULL REFERENCES users(user_id),
    fact_title VARCHAR(75) NOT NULL,
    fact_content TEXT NOT NULL,
    fact_date_added TIMESTAMP NOT NULL DEFAULT NOW(),
    fact_date_updated TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS fact_categories (
    fact_id INTEGER NOT NULL REFERENCES facts(fact_id),
    category_id INTEGER NOT NULL REFERENCES categories(category_id)
);

CREATE TABLE IF NOT EXISTS fact_revisions (
    revision_id SERIAL PRIMARY KEY,
    fact_id INTEGER NOT NULL REFERENCES facts(fact_id),
    user_id INTEGER NOT NULL REFERENCES users(user_id),
    revision_date_added TIMESTAMP NOT NULL DEFAULT NOW()
);