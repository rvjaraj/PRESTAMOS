/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vinic
 */
@Entity
@Table(name = "fundacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fundacion.findAll", query = "SELECT f FROM Fundacion f")
    , @NamedQuery(name = "Fundacion.findByIdBanco", query = "SELECT f FROM Fundacion f WHERE f.idBanco = :idBanco")
    , @NamedQuery(name = "Fundacion.findByNombre", query = "SELECT f FROM Fundacion f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Fundacion.findByDireccion", query = "SELECT f FROM Fundacion f WHERE f.direccion = :direccion")
    , @NamedQuery(name = "Fundacion.findByValorNeto", query = "SELECT f FROM Fundacion f WHERE f.valorNeto = :valorNeto")})
public class Fundacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBanco")
    private Integer idBanco;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Direccion")
    private String direccion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ValorNeto")
    private BigDecimal valorNeto;

    public Fundacion() {
    }

    public Fundacion(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public Fundacion(Integer idBanco, String nombre, String direccion, BigDecimal valorNeto) {
        this.idBanco = idBanco;
        this.nombre = nombre;
        this.direccion = direccion;
        this.valorNeto = valorNeto;
    }

    public Integer getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigDecimal getValorNeto() {
        return valorNeto;
    }

    public void setValorNeto(BigDecimal valorNeto) {
        this.valorNeto = valorNeto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBanco != null ? idBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fundacion)) {
            return false;
        }
        Fundacion other = (Fundacion) object;
        if ((this.idBanco == null && other.idBanco != null) || (this.idBanco != null && !this.idBanco.equals(other.idBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Fundacion[ idBanco=" + idBanco + " ]";
    }
    
}
