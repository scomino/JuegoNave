/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sergi
 */
@Entity
@Table(name = "cogar_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CogarUsers.findAll", query = "SELECT c FROM CogarUsers c"),
    @NamedQuery(name = "CogarUsers.findById", query = "SELECT c FROM CogarUsers c WHERE c.id = :id"),
    @NamedQuery(name = "CogarUsers.findByNick", query = "SELECT c FROM CogarUsers c WHERE c.nick = :nick"),
    @NamedQuery(name = "CogarUsers.findByPass", query = "SELECT c FROM CogarUsers c WHERE c.pass = :pass")})
public class CogarUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nick")
    private String nick;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;
    @OneToMany(mappedBy = "idPlayer")
    private Collection<CogarGames> cogarGamesCollection;

    public CogarUsers() {
    }

    public CogarUsers(Integer id) {
        this.id = id;
    }

    public CogarUsers(Integer id, String nick, String pass) {
        this.id = id;
        this.nick = nick;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @XmlTransient
    public Collection<CogarGames> getCogarGamesCollection() {
        return cogarGamesCollection;
    }

    public void setCogarGamesCollection(Collection<CogarGames> cogarGamesCollection) {
        this.cogarGamesCollection = cogarGamesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CogarUsers)) {
            return false;
        }
        CogarUsers other = (CogarUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CogarUsers[ id=" + id + " ]";
    }
    
}
