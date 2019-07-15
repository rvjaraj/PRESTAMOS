/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author gusta
 */
public class ControladorUsuario {

    EntityManager em;

    public ControladorUsuario() {
        em = MySQLDB.init();
    }

    public void createUsuario(Usuario u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Usuario> findAll() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }
    
    public List<Usuario> findAdmin() {
        Query query = em.createNamedQuery("Usuario.findAdmin");
        return query.getResultList();
    }
    
    public List<Usuario> findSecre() {
        Query query = em.createNamedQuery("Usuario.findSecre");
        return query.getResultList();
    }
    
    public List<Usuario> findAproNO() {
        Query query = em.createNamedQuery("Usuario.findAproNO");
        return query.getResultList();
    }
    
     public List<Usuario> findAproSI() {
        Query query = em.createNamedQuery("Usuario.findAproSI");
        return query.getResultList();
    }

    public Usuario findByID(int id) {
        Usuario u = em.find(Usuario.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }

    public Usuario findByCedula(String ced) {
        TypedQuery<Usuario> consultaUsuario = em.createNamedQuery("Usuario.findByCedula", Usuario.class);
        consultaUsuario.setParameter("cedula", ced);
        Usuario u;
        try{
             u = consultaUsuario.getSingleResult();
        }catch(Exception e){
            u = null;
        }
        return u;
    }
    
    public Usuario findByCedula2(String ced) {
        TypedQuery<Usuario> consultaUsuario = em.createNamedQuery("Usuario.findByCedula2", Usuario.class);
        consultaUsuario.setParameter("cedula", ced);
        Usuario u;
        try{
             u = consultaUsuario.getSingleResult();
        }catch(Exception e){
            u = null;
        }
        return u;
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Usuario u = em.find(Usuario.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean edit(Usuario u) {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
