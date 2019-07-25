package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-24T21:23:07")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, Date> fechaIngreso;
    public static volatile SingularAttribute<Administrador, Integer> idAdministrador;
    public static volatile SingularAttribute<Administrador, Usuario> idUsuario;

}