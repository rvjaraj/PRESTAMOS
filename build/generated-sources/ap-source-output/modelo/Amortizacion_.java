package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Prestamo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-15T03:24:42")
@StaticMetamodel(Amortizacion.class)
public class Amortizacion_ { 

    public static volatile SingularAttribute<Amortizacion, BigDecimal> couta;
    public static volatile SingularAttribute<Amortizacion, BigDecimal> deuda;
    public static volatile SingularAttribute<Amortizacion, BigDecimal> capitalSin;
    public static volatile SingularAttribute<Amortizacion, Integer> idAmortizacion;
    public static volatile SingularAttribute<Amortizacion, Integer> periodo;
    public static volatile SingularAttribute<Amortizacion, Prestamo> idPrestamo;
    public static volatile SingularAttribute<Amortizacion, BigDecimal> interes;

}