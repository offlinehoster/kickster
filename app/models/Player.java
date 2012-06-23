package models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import play.db.jpa.Model;

/**
 *
 * @author screencast
 */
@Entity
public class Player extends Model {

    public String name;
    @ManyToMany
    @JoinTable(name = "player_team")
    public List<Team> teams;
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
