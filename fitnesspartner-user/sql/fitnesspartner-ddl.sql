CREATE TABLE fitnesspartner.`user` (
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NULL,
	weight_in_kg INT NULL,
	height_in_cm INT NULL,
	bmi BIGINT NULL,
	email varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
	age INT NULL,
	gender CHAR NULL,
	CONSTRAINT user_pk PRIMARY KEY (email)
)


ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='User Details';

CREATE USER 'springuser'@'%';
ALTER USER 'springuser'@'%'
IDENTIFIED BY 'springuser' ;

GRANT Update ON fitnesspartner.* TO 'springuser'@'%';
GRANT Select ON fitnesspartner.* TO 'springuser'@'%';
GRANT Insert ON fitnesspartner.* TO 'springuser'@'%';
GRANT Delete ON fitnesspartner.* TO 'springuser'@'%';
