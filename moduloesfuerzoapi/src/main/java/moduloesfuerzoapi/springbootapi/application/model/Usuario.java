package moduloesfuerzoapi.springbootapi.application.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="USUARIOS")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario{

	
	@Id
	String usuarioid;
	String nombre;
	String apellido;
	String password;
	String perfil;
	String telefono;
	String email;
	String equipo;
}
