
CREATE OR REPLACE TABLE TBAE_USER(
	USER_ID			INTEGER 	NOT NULL AUTO_INCREMENT,
	USER_NAME		VARCHAR(64)	NOT NULL,
	USER_PASSWORD	VARCHAR(64)	NOT NULL,
	
	PRIMARY KEY(USER_ID)
);


CREATE OR REPLACE TABLE TBAE_ROLE(
	ROLE_ID			INTEGER 	NOT NULL AUTO_INCREMENT,
	ROLE_NAME		VARCHAR(64)	NOT NULL,
	
	PRIMARY KEY(ROLE_ID)
);



CREATE OR REPLACE TABLE TBAE_USER_ROLE(
	USER_ROLE_ID	INTEGER		NOT NULL AUTO_INCREMENT,
	ROLE_ID			INTEGER		NOT NULL,
	USER_ID			INTEGER 	NOT NULL,
	
	PRIMARY KEY(USER_ROLE_ID)
);


CREATE OR REPLACE TABLE TBAE_PROFILE(
	PROFILE_ID				INTEGER 		NOT NULL AUTO_INCREMENT,
	USER_ID					INTEGER			NOT NULL,
	GENDER					FLOAT			NOT NULL,
	NON_BINARY_GENDER		INTEGER			DEFAULT 0 ,
	NON_BINARY_GENDER_ID	INTEGER			DEFAULT NULL,
	BIOGRAPHY				VARCHAR(4096)	DEFAULT "",
	PROFILE_PICTURE			BLOB(65536)	NOT NULL,
	
	PRIMARY KEY	(PROFILE_ID)
);

CREATE OR REPLACE TABLE TBAE_NON_BINARY_GENDER(
	NON_BINARY_GENDER_ID	INTEGER		NOT NULL AUTO_INCREMENT,
	GENDER_DESCRIPTION		VARCHAR(64) NOT NULL,
	
	PRIMARY KEY(NON_BINARY_GENDER_ID)
);

CREATE OR REPLACE TABLE TBAE_SEXUAL_ORIENTATION(
	SEXUAL_ORIENTATION_ID	INTEGER		NOT NULL AUTO_INCREMENT,
	ORIENTATION_DESCRIPTION	VARCHAR(64) NOT NULL,
	
	PRIMARY KEY(SEXUAL_ORIENTATION_ID)
);

CREATE OR REPLACE TABLE TBAE_REGION (
	REGION_ID	INTEGER 	NOT NULL AUTO_INCREMENT,
	REGION		VARCHAR(64)	NOT NULL,
	
	PRIMARY KEY(REGION_ID)
);

CREATE OR REPLACE TABLE TBAE_MATCH (
	MATCH_ID		INTEGER 	NOT NULL AUTO_INCREMENT,
	REQUEST_USER_ID	INTEGER		NOT NULL,
	MATCHED_USER_ID	INTEGER		NOT NULL,
	APPROVED		INTEGER 	DEFAULT 0 ,
	SEEN			INTEGER		DEFAULT 0 ,
	PRIMARY KEY (MATCH_ID)
);