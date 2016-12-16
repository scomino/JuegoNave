/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "cogar_games")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CogarGames.findAll", query = "SELECT c FROM CogarGames c"),
    @NamedQuery(name = "CogarGames.findByIdGame", query = "SELECT c FROM CogarGames c WHERE c.idGame = :idGame"),
    @NamedQuery(name = "CogarGames.findByScore", query = "SELECT c FROM CogarGames c WHERE c.score = :score"),
    @NamedQuery(name = "CogarGames.findByPlayBegin", query = "SELECT c FROM CogarGames c WHERE c.playBegin = :playBegin"),
    @NamedQuery(name = "CogarGames.findByPlayEnd", query = "SELECT c FROM CogarGames c WHERE c.playEnd = :playEnd")})
public class CogarGames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_game")
    private Integer idGame;
    @Column(name = "score")
    private Integer score;
    @Column(name = "play_begin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date playBegin;
    @Column(name = "play_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date playEnd;
    @JoinColumn(name = "id_player", referencedColumnName = "id")
    @ManyToOne
    private CogarUsers idPlayer;

    public CogarGames() {
    }

    public CogarGames(Integer idGame) {
        this.idGame = idGame;
    }

    public Integer getIdGame() {
        return idGame;
    }

    public void setIdGame(Integer idGame) {
        this.idGame = idGame;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getPlayBegin() {
        return playBegin;
    }

    public void setPlayBegin(Date playBegin) {
        this.playBegin = playBegin;
    }

    public Date getPlayEnd() {
        return playEnd;
    }

    public void setPlayEnd(Date playEnd) {
        this.playEnd = playEnd;
    }

    public CogarUsers getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(CogarUsers idPlayer) {
        this.idPlayer = idPlayer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGame != null ? idGame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CogarGames)) {
            return false;
        }
        CogarGames other = (CogarGames) object;
        if ((this.idGame == null && other.idGame != null) || (this.idGame != null && !this.idGame.equals(other.idGame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CogarGames[ idGame=" + idGame +playBegin+ idPlayer+playEnd+score+" ]";
    }
    
    
    
    
    
    
    
    
    
}
