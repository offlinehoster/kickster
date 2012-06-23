package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import play.db.jpa.Model;

/**
 *
 * @author screencast
 */
@Entity
public class Match extends Model {
    @ManyToOne
    public Team team1;
    @ManyToOne
    public Team team2;
    public int scoreTeam1;
    public int scoreTeam2;

    @Temporal(TemporalType.DATE)
    public Date date;

    public Match(){
        date = new Date();
    }
}
