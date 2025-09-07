DROP DATABASE if exists retailer;

CREATE DATABASE retailer;

USE retailer;



CREATE TABLE retailer (

retailer_id INT NOT NULL,

transaction_date date NOT NULL,

amount INT NOT NULL

);



INSERT INTO retailer VALUES (1, '2025-08-15', 100 );

INSERT INTO retailer VALUES (1, '2025-07-15', 120 );

INSERT INTO retailer VALUES (1, '2025-04-15', 60 );

INSERT INTO retailer VALUES (2, '2025-08-15', 200 );

INSERT INTO retailer VALUES (2, '2025-07-15', 70 );

INSERT INTO retailer VALUES (2, '2025-04-15', 130 );



select * from retailer;