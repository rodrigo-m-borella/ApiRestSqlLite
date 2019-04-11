package moduloesfuerzoapi.springbootapi.application.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import moduloesfuerzoapi.springbootapi.application.model.IncidentRemedy;


@Repository
public interface IncidentRemedyRepository extends JpaRepository<IncidentRemedy, String>{
	
	@Query("SELECT i FROM IncidentRemedy i WHERE i.usr_asignado = :usrAsignado")
    public List<IncidentRemedy> findByUsrAsignado(@Param("usrAsignado") String usrAsignado);

}
