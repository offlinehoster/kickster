# add Team_Players

# --- !Ups

CREATE TABLE Team_Player (
  teams_id bigint(20) NOT NULL,
  players_id bigint(20) NOT NULL,
  FOREIGN KEY (teams_id) REFERENCES Team(id),
  FOREIGN KEY (players_id) REFERENCES Player(id),
  PRIMARY KEY (teams_id,players_id)
);

# --- !Downs

DROP TABLE Team_Player;
