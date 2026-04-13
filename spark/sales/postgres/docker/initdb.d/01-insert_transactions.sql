\c sales

COPY transaction (id, date_order, date_shipping, quantity, customer_id, street_number, street_name, city, postcode, region, product_id, product_price)
FROM '/data/transaction.csv'
DELIMITER ','
CSV HEADER;
