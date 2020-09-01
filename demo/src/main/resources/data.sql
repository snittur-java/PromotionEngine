DROP TABLE IF EXISTS paymentdata;

CREATE TABLE paymentdata (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  item_name VARCHAR(250) NOT NULL,
  item_price INT NOT NULL
);
 
INSERT INTO paymentdata (item_name, item_price) VALUES
  ('A', 50),
  ('B', 30),
  ('C', 20),
   ('D', 15);


