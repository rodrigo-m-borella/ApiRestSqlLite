package moduloesfuerzoapi.springbootapi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import moduloesfuerzoapi.springbootapi.application.model.Usuario;

@Component
public interface UsuarioRemedyRepository extends JpaRepository<Usuario,String>{

}
