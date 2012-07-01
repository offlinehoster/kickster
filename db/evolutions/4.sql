# add Matches

# --- !Ups

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
