package models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import play.db.jpa.Model;

/**
 *
 * @author screencast
 */
@Entity
public class Team extends Model {

    @ManyToMany
    @JoinTable(name = "player_team")
    public Set<Player> players;
    @OneToMany(mappedBy = "team1")
    public Set<Match> matches1;
    @OneToMany(mappedBy = "team2")
    public Set<Match> matches2;

    public void addPlayer(Player player) {
        if (players.size() < 2) {
            players.add(player);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player p : players) {
            sb.append(p.name);
            sb.append(" ");
        }
        return sb.toString();
    }
}
