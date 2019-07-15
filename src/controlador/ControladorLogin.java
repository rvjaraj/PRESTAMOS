/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author vinic
 */
public class ControladorLogin {

    EntityManager em;

    public ControladorLogin() {
        em = MySQLDB.init();
    }

    public boolean loginUsuario(String cedula, String contra) {
        Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.cedula = '"+cedula+"' AND u.contracenia = '"+contra+"'");
        List<Usuario> lis = q.getResultList();
        if(lis.size() == 1){
            System.out.println(lis.get(0).getNombre());
            return true;
        }
        return false;
    }
    
    public boolean loginSecretaria(String cedula, String contra) {
        Query q = em.createQuery("SELECT u FROM Usuario u, Secretaria s WHERE u.cedula = '"+cedula+"' AND u.contracenia = '"+contra+"' AND u.idUsuario = s.idUsuario.idUsuario");
        List<Usuario> lis = q.getResultList();
        if(lis.size() == 1){
            System.out.println(lis.get(0).getNombre());
            return true;
        }
        return false;
    }
    
     public boolean loginAdministrador(String cedula, String contra) {
        Query q = em.createQuery("SELECT u FROM Usuario u, Administrador s WHERE u.cedula = '"+cedula+"' AND u.contracenia = '"+contra+"' AND u.idUsuario = s.idUsuario.idUsuario");
        List<Usuario> lis = q.getResultList();
        if(lis.size() == 1){
            System.out.println(lis.get(0).getNombre());
            return true;
        }
        return false;
    }
}
