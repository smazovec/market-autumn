DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), coast int, PRIMARY KEY (id));
INSERT INTO products (title, coast) VALUES ('Milk', 100), ('Bread', 25), ('Fish', 120);
