DROP TABLE IF EXISTS Employee_tl;

CREATE TABLE IF NOT EXISTS Employee_tl (
        id Serial NOT NULL,
     	name VARCHAR(100),
     	cnic VARCHAR(15),
     	age INTEGER,
     	dob DATE,
     	role VARCHAR,
     	created_date timestamp without time zone not null,
        updated_date timestamp without time zone,
    	is_active BOOLEAN,
     	primary key (id)
 );
