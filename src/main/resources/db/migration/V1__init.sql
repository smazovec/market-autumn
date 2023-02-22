CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), coast int, PRIMARY KEY (id));
INSERT INTO products (title, coast) VALUES ('Milk', 100), ('Bread', 25), ('Fish', 120), ('Meat', 250);
CREATE TABLE IF NOT EXISTS clients (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO clients (name) VALUES ('MR First'), ('MR Second');