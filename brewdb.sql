/**
Some elements repurposed from the Chinook sample database
https://github.com/lerocha/chinook-database

All other content by M. Andrew Juby (jubydoo@gmail.com)
(c)2018
*/

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
DROP USER brewnotes CASCADE;


/*******************************************************************************
   Create database
********************************************************************************/
CREATE USER brewnotes
IDENTIFIED BY p4ssw0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to brewnotes;
GRANT resource to brewnotes;
GRANT create session TO brewnotes;
GRANT create table TO brewnotes;
GRANT create view TO brewnotes;

conn brewnotes/p4ssw0rd

/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Brusers
(
    u_id NUMBER NOT NULL,
    u_name VARCHAR2(20) NOT NULL,
    u_full_name VARCHAR2(150) NOT NULL,
    CONSTRAINT pk_brusers PRIMARY KEY  (u_id)
);

CREATE TABLE Brews
(
    b_id NUMBER NOT NULL,
    b_brewer NUMBER NOT NULL,
    b_recipe NUMBER NOT NULL,
    b_brewdate DATE NOT NULL,
    b_secondarydate DATE,
    b_rackdate DATE,
    b_isbottled NUMBER(1),
    b_iskegged NUMBER(1),
    b_notes VARCHAR2(4000),
    CONSTRAINT pk_brews PRIMARY KEY (b_id)
);

CREATE TABLE Recipes
(
    r_id NUMBER NOT NULL,
    r_name VARCHAR2(200) NOT NULL,
    r_boiltime NUMBER NOT NULL,
    r_yeast NUMBER NOT NULL,
    r_notes VARCHAR(4000),
    CONSTRAINT pk_recipes PRIMARY KEY (r_id)
);

CREATE TABLE Hops_Recipes
(
    h_r_id NUMBER NOT NULL,
    h_r_recipe NUMBER NOT NULL,
    h_r_hops NUMBER NOT NULL,
    h_r_oz NUMBER NOT NULL,
    h_r_add_time NUMBER NOT NULL,
    CONSTRAINT pk_hops_recipes PRIMARY KEY (h_r_id)
);

CREATE TABLE Malts_Recipes
(
    m_r_id NUMBER NOT NULL,
    m_r_recipe NUMBER NOT NULL,
    m_r_malt NUMBER NOT NULL,
    m_r_oz NUMBER NOT NULL,
    CONSTRAINT pk_malts_recipes PRIMARY KEY (m_r_id)
);

CREATE TABLE Yeasts
(
    y_id NUMBER NOT NULL,
    y_name VARCHAR2(150) NOT NULL,
    y_isDry NUMBER(1),
    y_notes VARCHAR(4000),
    CONSTRAINT pk_yeasts PRIMARY KEY (y_id)
);

CREATE TABLE Hops
(
    h_id NUMBER NOT NULL,
    h_name VARCHAR2(150) NOT NULL,
    h_alpha_acids NUMBER,
    h_notes VARCHAR(4000),
    CONSTRAINT pk_hops PRIMARY KEY (h_id)
);

CREATE TABLE Malts
(
    m_id NUMBER NOT NULL,
    m_name VARCHAR(150) NOT NULL,
    m_isDry NUMBER(1) NOT NULL,
    m_notes VARCHAR(4000),
    CONSTRAINT pk_malts PRIMARY KEY (m_id)
);

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE Brews ADD CONSTRAINT fk_breweruserid
    FOREIGN KEY (b_brewer) REFERENCES Brusers (u_id);
    
ALTER TABLE Brews ADD CONSTRAINT fk_recipeid
    FOREIGN KEY (b_recipe) REFERENCES Recipes (r_id);
    
ALTER TABLE Hops_Recipes ADD CONSTRAINT fk_hopsrecipeid
    FOREIGN KEY (h_r_recipe) REFERENCES Recipes (r_id);
    
ALTER TABLE Hops_Recipes ADD CONSTRAINT fk_hopsid
    FOREIGN KEY (h_r_hops) REFERENCES Hops (h_id);
    
ALTER TABLE Malts_Recipes ADD CONSTRAINT fk_maltsrecipeid
    FOREIGN KEY (m_r_recipe) REFERENCES Recipes (r_id);
    
ALTER TABLE Malts_Recipes ADD CONSTRAINT fk_maltid
    FOREIGN KEY (m_r_malt) REFERENCES Malts (m_id);
    
ALTER TABLE Recipes ADD CONSTRAINT fk_yeastrecipeid
    FOREIGN KEY (r_yeast) REFERENCES Yeasts (y_id);
    
-- Sequences
CREATE SEQUENCE sq_brusers_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_brews_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_recipes_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_hops_recipes_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_malts_recipes_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_yeasts_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_hops_pk START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE sq_malts_pk START WITH 1 INCREMENT BY 1;

-- Triggers
CREATE OR REPLACE TRIGGER tr_insert_bruser
BEFORE INSERT ON brusers
FOR EACH ROW
BEGIN
    SELECT sq_brusers_pk.NEXTVAL INTO :NEW.u_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_brews
BEFORE INSERT ON brews
FOR EACH ROW
BEGIN
    SELECT sq_brews_pk.NEXTVAL INTO :NEW.b_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_recipes
BEFORE INSERT ON recipes
FOR EACH ROW
BEGIN
    SELECT sq_recipes_pk.NEXTVAL INTO :NEW.r_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_hops_recipes
BEFORE INSERT ON hops_recipes
FOR EACH ROW
BEGIN
    SELECT sq_hops_recipes_pk.NEXTVAL INTO :NEW.h_r_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_malts_recipes
BEFORE INSERT ON malts_recipes
FOR EACH ROW
BEGIN
    SELECT sq_malts_recipes_pk.NEXTVAL INTO :NEW.m_r_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_yeasts
BEFORE INSERT ON yeasts
FOR EACH ROW
BEGIN
    SELECT sq_yeasts_pk.NEXTVAL INTO :NEW.y_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_hops
BEFORE INSERT ON hops
FOR EACH ROW
BEGIN
    SELECT sq_hops_pk.NEXTVAL INTO :NEW.h_id FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER tr_insert_malts
BEFORE INSERT ON malts
FOR EACH ROW
BEGIN
    SELECT sq_malts_pk.NEXTVAL INTO :NEW.m_id FROM DUAL;
END;
/

--Some basic inserts
Insert into brusers (u_name, u_full_name) values ('andrew', 'Andrew Juby');
Insert into yeasts (y_name, y_isdry, y_notes) values('Safale S-04', 1, 'The old standby.');
Insert into recipes (r_name, r_boiltime, r_yeast, r_notes) values ('Berliner Weisse', 60, 1, 'A basic wheat beer.');
Insert into malts (m_name, m_isdry, m_notes) values ('American 2-row', 1, 'Basic 2 row malted barley');
Insert into malts (m_name, m_isdry, m_notes) values ('White wheat', 1, 'Basic wheat malt');
Insert into malts_recipes (m_r_recipe, m_r_malt, m_r_oz) values (1, 1, 84);
Insert into malts_recipes (m_r_recipe, m_r_malt, m_r_oz) values (1, 2, 20);
Insert into hops (h_name, h_alpha_acids, h_notes) values ('Tettnang', 4.5, 'A spicy, herbal aroma hop');
Insert into hops_recipes (h_r_recipe, h_r_hops, h_r_oz, h_r_add_time) values (1, 1, .5, 45);
Insert into brews (b_brewer, b_recipe, b_brewdate) values (1, 1, TO_DATE('2018-7-16 00:00:00','yyyy-mm-dd hh24:mi:ss'));