package models;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import play.db.jpa.Model;

/**
 *
 * @author screencast
 */
@Entity
public class Player extends Model {

    public String name;
    @ManyToMany(mappedBy="players")
    public Set<Team> teams;
    public int score;

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
