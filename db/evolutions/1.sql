# add Players

# --- !Ups

CREATE TABLE Player (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  playerName varchar(255) DEFAULT NULL,
  score int(11) NOT NULL,
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Player;
