/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author vinic
 */
@Entity
@Table(name = "amortizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amortizacion.findAll", query = "SELECT a FROM Amortizacion a")
    , @NamedQuery(name = "Amortizacion.findByIdAmortizacion", query = "SELECT a FROM Amortizacion a WHERE a.idAmortizacion = :idAmortizacion")
    , @NamedQuery(name = "Amortizacion.findByPeriodo", query = "SELECT a FROM Amortizacion a WHERE a.periodo = :periodo")
    , @NamedQuery(name = "Amortizacion.findByInteres", query = "SELECT a FROM Amortizacion a WHERE a.interes = :interes")
    , @NamedQuery(name = "Amortizacion.findByCapitalSin", query = "SELECT a FROM Amortizacion a WHERE a.capitalSin = :capitalSin")
    , @NamedQuery(name = "Amortizacion.findByCouta", query = "SELECT a FROM Amortizacion a WHERE a.couta = :couta")
    , @NamedQuery(name = "Amortizacion.findByDeuda", query = "SELECT a FROM Amortizacion a WHERE a.deuda = :deuda")
    , @NamedQuery(name = "Amortizacion.findByEstado", query = "SELECT a FROM Amortizacion a WHERE a.estado = :estado")
    , @NamedQuery(name = "Amortizacion.findByFecha", query = "SELECT a FROM Amortizacion a WHERE a.fecha = :fecha")})
public class Amortizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAmortizacion")
    private Integer idAmortizacion;
    @Basic(optional = false)
    @Column(name = "periodo")
    private int periodo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "interes")
    private BigDecimal interes;
    @Column(name = "capitalSin")
    private BigDecimal capitalSin;
    @Basic(optional = false)
    @Column(name = "couta")
    private BigDecimal couta;
    @Basic(optional = false)
    @Column(name = "deuda")
    private BigDecimal deuda;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idPrestamo", referencedColumnName = "idPrestamo")
    @ManyToOne(optional = false)
    private Prestamo idPrestamo;

    public Amortizacion() {
    }

    public Amortizacion(Integer idAmortizacion) {
        this.idAmortizacion = idAmortizacion;
    }

    public Amortizacion(Integer idAmortizacion, int periodo, BigDecimal interes, BigDecimal couta, BigDecimal deuda, String estado, Date fecha) {
        this.idAmortizacion = idAmortizacion;
        this.periodo = periodo;
        this.interes = interes;
        this.couta = couta;
        this.deuda = deuda;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Amortizacion(Integer idAmortizacion, int periodo, BigDecimal interes, BigDecimal capitalSin, BigDecimal couta, BigDecimal deuda, String estado, Date fecha, Prestamo idPrestamo) {
        this.idAmortizacion = idAmortizacion;
        this.periodo = periodo;
        this.interes = interes;
        this.capitalSin = capitalSin;
        this.couta = couta;
        this.deuda = deuda;
        this.estado = estado;
        this.fecha = fecha;
        this.idPrestamo = idPrestamo;
    }

    public Integer getIdAmortizacion() {
        return idAmortizacion;
    }

    public void setIdAmortizacion(Integer idAmortizacion) {
        this.idAmortizacion = idAmortizacion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public BigDecimal getCapitalSin() {
        return capitalSin;
    }

    public void setCapitalSin(BigDecimal capitalSin) {
        this.capitalSin = capitalSin;
    }

    public BigDecimal getCouta() {
        return couta;
    }

    public void setCouta(BigDecimal couta) {
        this.couta = couta;
    }

    public BigDecimal getDeuda() {
        return deuda;
    }

    public void setDeuda(BigDecimal deuda) {
        this.deuda = deuda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmortizacion != null ? idAmortizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amortizacion)) {
            return false;
        }
        Amortizacion other = (Amortizacion) object;
        if ((this.idAmortizacion == null && other.idAmortizacion != null) || (this.idAmortizacion != null && !this.idAmortizacion.equals(other.idAmortizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Amortizacion[ idAmortizacion=" + idAmortizacion + " ]";
    }
    
}
