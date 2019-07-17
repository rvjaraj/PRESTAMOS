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
import modelo.Prestamo;
import modelo.Usuario;

/**
 *
 * @author gusta
 */
public class ControladorPrestamo {

    EntityManager em;

    public ControladorPrestamo() {
        em = MySQLDB.init();
    }

    public void createPrestamo(Prestamo u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Prestamo> findAll() {
        Query query = em.createNamedQuery("Prestamo.findAll");
        return query.getResultList();
    }
    public List<Prestamo> MaxId() {
        Query query = em.createNamedQuery("Prestamo.MaxId");
        return query.getResultList();
    }
    
    public Prestamo findByID(int id) {
        Prestamo u = em.find(Prestamo.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }
    
    public List<Prestamo> findByUsuario(Usuario ced) {
        TypedQuery<Prestamo> consultaUsuario = em.createNamedQuery("Prestamo.findByUsuario", Prestamo.class);
        consultaUsuario.setParameter("usuario", ced);
        List<Prestamo> lista = null;
        try{
             lista = consultaUsuario.getResultList();
        }catch(Exception e){
            lista = null;
        }
        return lista;
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Prestamo u = em.find(Prestamo.class, id);
            em.remove(u);
            em.getTransaction().commit();
            System.out.println("ajajajaj");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean edit(Prestamo u) {
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
