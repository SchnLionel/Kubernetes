CREATE DATABASE sales;

\c sales

CREATE TABLE IF NOT EXISTS transaction (
  id UUID,
  date_order TIMESTAMP,
  date_shipping TIMESTAMP,
  quantity SMALLINT,
  customer_id UUID,
  street_number INT,
  street_name VARCHAR,
  city VARCHAR,
  postcode INT,
  region VARCHAR,
  product_id UUID,
  product_price FLOAT
);
