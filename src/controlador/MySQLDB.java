/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author gusta
 */
public class MySQLDB {

    public static EntityManager em = null;

    public static EntityManager init() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PRESTAMOSPU");
        MySQLDB.em = factory.createEntityManager();
        return em;
    }
}
