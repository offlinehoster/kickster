package models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import play.db.jpa.Model;

/**
 *
 * @author screencast
 */
@Entity
public class Player extends Model {

    @Column(name="playerName")
    public String name;
    @ManyToMany(mappedBy="players")
    public Set<Team> teams;
    public long score;

    @Override
    public String toString() {
        return this.name;
    }

    public static Player findOrCreateByName(String name) {
        Player player = Player.find("name = ?", name).first();
        if (player == null) {
            player = new Player();
            player.name = name;
            player.save();
        }
        return player;
    }
}
