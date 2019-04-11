package moduloesfuerzoapi.springbootapi.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import moduloesfuerzoapi.springbootapi.application.model.Usuario;

@Component
public class UsuarioRemedyMapper {

	
	public Usuario map(ResultSet rs) throws SQLException{
		Usuario usr = new Usuario();

		usr.setUsuarioid(rs.getString(1));
		usr.setNombre(rs.getString(2));
		usr.setApellido(rs.getString(3));
		usr.setEquipo(rs.getString(4));
		
		return usr;
	}
	
	
}
