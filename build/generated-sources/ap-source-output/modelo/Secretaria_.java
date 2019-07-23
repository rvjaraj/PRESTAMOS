package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-22T20:58:08")
@StaticMetamodel(Secretaria.class)
public class Secretaria_ { 

    public static volatile SingularAttribute<Secretaria, Date> fechaIngreso;
    public static volatile SingularAttribute<Secretaria, Integer> idSecretaria;
    public static volatile SingularAttribute<Secretaria, Usuario> idUsuario;

}