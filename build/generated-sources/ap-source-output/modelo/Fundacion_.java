package modelo;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-24T21:23:07")
@StaticMetamodel(Fundacion.class)
public class Fundacion_ { 

    public static volatile SingularAttribute<Fundacion, Integer> idBanco;
    public static volatile SingularAttribute<Fundacion, BigDecimal> valorNeto;
    public static volatile SingularAttribute<Fundacion, String> direccion;
    public static volatile SingularAttribute<Fundacion, String> nombre;

}