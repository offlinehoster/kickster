# add Teams

# --- !Ups

CREATE TABLE Team (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);


# --- !Downs

DROP TABLE Team;
