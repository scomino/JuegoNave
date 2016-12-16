/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entidades.CogarUsers;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author sergi
 */
public class UsersService {

    EntityManager em;

    public UsersService(EntityManager em) {
        this.em = em;
    }

    public void addUser(CogarUsers a) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(a);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean findUser(String nick, String pass) {
        boolean ok = false;
        CogarUsers cs = new CogarUsers();
        try {
            Query query = em.createQuery("SELECT c FROM CogarUsers c WHERE c.nick = :nick").setParameter("nick", nick);
            cs = (CogarUsers) query.getSingleResult();
            if (cs.getPass().equalsIgnoreCase(pass)) {
                ok = true;
            } else {
                ok = false;
            }
        } catch (Exception e) {

        }
        return ok;
    }

    public CogarUsers copyUser(String nick, String pass) {
        boolean ok = false;
        CogarUsers cs = new CogarUsers();
        try {
            Query query = em.createQuery("SELECT c FROM CogarUsers c WHERE c.nick = :nick").setParameter("nick", nick);
            cs = (CogarUsers) query.getSingleResult();
            if (cs.getPass().equalsIgnoreCase(pass)) {
                return cs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cs;
    }

}//end of class
