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
import modelo.Amortizacion;
import modelo.Prestamo;

/**
 *
 * @author gusta
 */
public class ControladorAmortizacion {

    EntityManager em;

    public ControladorAmortizacion() {
        em = MySQLDB.init();
    }

    public void Crear(Amortizacion u) {
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<Amortizacion> findAll() {
        Query query = em.createNamedQuery("Amortizacion.findAll");
        return query.getResultList();
    }

    public Amortizacion findByID(int id) {
        Amortizacion u = em.find(Amortizacion.class, id);
        if (u == null) {
            u = null;
        }
        return u;
    }

    public boolean eliminar(int id) {
        try {
            em.getTransaction().begin();
            Amortizacion u = em.find(Amortizacion.class, id);
            em.remove(u);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
        return true;
    }

    public boolean edit(Amortizacion u) {
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
    
    public List<Amortizacion> listar(int id) {
        Query q = em.createQuery("SELECT u FROM Amortizacion u WHERE u.idPrestamo.idPrestamo = "+id);
        List<Amortizacion> lis = q.getResultList();
        return lis;
    }
    
    public void eliminarALL(int id) {
        List<Amortizacion> lis = listar(id);
        for (Amortizacion li : lis) {
            eliminar(li.getIdAmortizacion());
        }
    }
}
