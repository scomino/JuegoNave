/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entidades.CogarGames;
import Entidades.CogarUsers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author sergi
 */
public class GamesServices {
    EntityManager em;
    
    public GamesServices(EntityManager em){
      this.em=em;        
    }
    
    
 public void addUser(CogarGames a) {
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
    
 
 
public List<CogarGames> getPointsListTop3(){ 
  Query query;
        query = em.createQuery("SELECT p FROM CogarGames p JOIN FETCH p.idPlayer ORDER BY p.score ASC").setMaxResults(5);
  return (List<CogarGames>) query.getResultList();
}
    
    
    public List<CogarGames> getOnline() {
        Query query = em.createQuery("SELECT r FROM CogarGames r JOIN FETCH r.idPlayer ORDER BY  r.playEnd DESC ").setMaxResults(5);
        return (List<CogarGames>) query.getResultList();
    }

    
    
    

      public void addFullGame(Integer score,Date d) {
        Query query2 = em.createQuery("SELECT max(c.idGame) FROM CogarGames c");
        Integer i=(Integer) query2.getSingleResult();
        System.out.println(i);
        Query query = em.createQuery("SELECT c FROM CogarGames c WHERE c.idGame = :idGame").setParameter("idGame", i);
        CogarGames cg = new CogarGames();
        cg = (CogarGames)query.getSingleResult();
        cg.setScore(score);
        cg.setPlayEnd(d);
        modificarPartida(cg);
    }
      
      public CogarGames lastPlay(){
          CogarGames cg= new CogarGames(); 
          Query query2 = em.createQuery("SELECT max(c.idGame) FROM CogarGames c");
        Integer i=(Integer) query2.getSingleResult();
        Query query = em.createQuery("SELECT c FROM CogarGames c WHERE c.idGame = :idGame").setParameter("idGame", i);
        cg = (CogarGames)query.getSingleResult();
          return cg;
      }
    
    
     public void removeGame(CogarGames cog) {
  EntityTransaction tx = em.getTransaction();
  try {
   tx.begin();
  if(cog != null){
      em.remove(cog);
  }
   tx.commit();
  } catch (Exception e) {
   if (tx.isActive()) {
   tx.rollback();
  }
   e.printStackTrace();
  }
 }
     
     

     
     
     
public void modificarPartida(CogarGames p) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.flush();
            em.refresh(p);
            em.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
}//end of class
