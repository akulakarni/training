----------------------------------START....Each time it will drop table to create fresh table-------------------------------------------------------
drop table if exists player;
drop sequence if exists player_Q1;

------------------------------------------------------------------------

CREATE TABLE player (
  player_id INTEGER(11) NOT NULL PRIMARY KEY,
  name varchar(45) NOT NULL,
  age int(4) NOT NULL,
  club varchar(45) NOT NULL,
  position varchar(45) NOT NULL,
  country varchar(45) NOT NULL,
  jersey_nbr int(4) NOT NULL,
  goals INTEGER(4) NOT NULL,
  assists INTEGER(4) NOT NULL
);

create sequence player_Q1 increment by 1 start with 100 maxvalue 999999999;
