package moduloesfuerzoapi.springbootapi.application.dao;

import java.sql.SQLException;
import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloesfuerzoapi.springbootapi.application.model.Usuario;
import moduloesfuerzoapi.springbootapi.application.repository.UsuarioRemedyRepository;
//import moduloesfuerzoapi.springbootapi.application.repository.UsuarioRemedyRepositoryJDBC;

@Service
public class UsuarioRemedyDao {
	@Autowired
	UsuarioRemedyRepository usuarioRemedyRepository;
	
//	@Autowired
//	UsuarioRemedyRepositoryJDBC usuarioRemedyRepositoryJDBC;
	
	
	public Optional<Usuario> getUsuarioById(String id){
			
		Optional<Usuario> optionalUsuarioRemedyObject=usuarioRemedyRepository.findById(id);
		return optionalUsuarioRemedyObject;
		
	}
	
	
	public Object getOne(String id){
		
		return usuarioRemedyRepository.getOne(id);
		
	}
	
	
//	public Usuario getUsuarioByIdCustom(int id) {
//		
//		try {
//			return (Usuario)usuarioRemedyRepositoryJDBC.getEntityById(id);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
	
	
//	public Object getOnex(int id){
//		
//		Example ex= new Example(ex, null); 
//		usuarioRemedyRepository.findOne(example)
//		return usuarioRemedyRepository.findAllById(ids)(id);
//		
//	}
	
	
//	public Object getOne(Usuario usuario){
//		Example ex;
//		ex.create(usuario)
//		return usuarioRemedyRepository.findOne(ex.create(usuario));
//		
//	}

	
}
