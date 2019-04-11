package moduloesfuerzoapi.springbootapi.application.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import moduloesfuerzoapi.springbootapi.application.dao.UsuarioRemedyDao;
import moduloesfuerzoapi.springbootapi.application.model.Usuario;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	
	@Autowired
	UsuarioRemedyDao usuarioRemedyDao;
	
	
	Logger logger = (Logger) LoggerFactory.getLogger("foo");
	
	@GetMapping("/getuser")
	@Transactional
	public ResponseEntity<Usuario> getUsuarioById(@RequestParam(value="usuarioid") String ui){
		
		Usuario ur = (Usuario) usuarioRemedyDao.getOne(ui);		

		if (ur==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ur);
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/checkuser")
	@Transactional
	public boolean checkUser(@Valid @RequestBody Usuario u){
		logger.info("VALIDANDO EL USUARIO");
		Usuario up = (Usuario) usuarioRemedyDao.getOne(u.getUsuarioid());		
		
		try{
			if (up.getPassword().compareTo(u.getPassword())==0) 
				return true;
			else
				return false;
		}catch (javax.persistence.EntityNotFoundException e){
			return false;
		}
			
	}
	

}
