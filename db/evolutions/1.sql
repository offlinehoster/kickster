# Initial DB Setup

# --- !Ups


CREATE TABLE Player (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  playerName varchar(255) DEFAULT NULL,
  score int(11) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Team (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

CREATE TABLE Team_Player (
  teams_id bigint(20) NOT NULL,
  players_id bigint(20) NOT NULL,
  FOREIGN KEY (teams_id) REFERENCES Team(id),
  FOREIGN KEY (players_id) REFERENCES Player(id),
  PRIMARY KEY (teams_id,players_id)
);

CREATE TABLE Matches (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dateOfMatch date DEFAULT NULL,
  scoreTeam1 int(11) NOT NULL,
  scoreTeam2 int(11) NOT NULL,
  team1_id bigint(20) DEFAULT NULL,
  team2_id bigint(20) DEFAULT NULL,
  FOREIGN KEY (team1_id) REFERENCES Team(id),
  FOREIGN KEY (team2_id) REFERENCES Team(id),
  PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE Matches;

DROP TABLE Team_Player;

DROP TABLE Player;

DROP TABLE Team;

