package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Amortizacion;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T20:58:08")
@StaticMetamodel(Prestamo.class)
public class Prestamo_ { 

    public static volatile CollectionAttribute<Prestamo, Amortizacion> amortizacionCollection;
    public static volatile SingularAttribute<Prestamo, Integer> meses;
    public static volatile SingularAttribute<Prestamo, Usuario> idUsuario;
    public static volatile SingularAttribute<Prestamo, Integer> idPrestamo;
    public static volatile SingularAttribute<Prestamo, BigDecimal> cantidad;
    public static volatile SingularAttribute<Prestamo, Integer> interes;

}