package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import play.data.validation.Required;
import play.db.jpa.Model;

/**
 *
 * @author screencast
 */
@Entity
@Table(name="Matches")
public class Match extends Model {

    @ManyToOne
    @Required
    public Team team1;
    @ManyToOne
    @Required
    public Team team2;
    public int scoreTeam1;
    public int scoreTeam2;
    @Temporal(TemporalType.DATE)
    @Column(name="dateOfMatch")
    public Date date;

    public Match() {
        date = new Date();
    }

    public Set<Player> getPlayers() {
        Set<Player> players = new HashSet<Player>();
        if (team1 != null) {
            for (Player p : team1.players) {
                players.add(p);
            }
        }
        if (team1 != null) {
            for (Player p : team2.players) {
                players.add(p);
            }
        }
        return players;
    }

    public boolean isOpen() {
        return getPlayers().size() < 4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player p : getPlayers()) {
            sb.append(p).append(" ");
        }
        return sb.toString();
    }
}
