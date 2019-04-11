package moduloesfuerzoapi.springbootapi.application.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloesfuerzoapi.springbootapi.application.model.IncidentRemedy;
import moduloesfuerzoapi.springbootapi.application.repository.IncidentRemedyRepository;
import moduloesfuerzoapi.springbootapi.application.repository.IncidentRemedyRepositoryJDBC;

@Service
public class IncidentRemedyDao {
	
	@Autowired
	IncidentRemedyRepository incidentRemedyRepository;
	
	@Autowired
	EntityManager entityManager; 
	
//	@Autowired 
//	IncidentRemedyRepositoryJDBC incidentRemedyRepositoryJDBC;
	
	
	/* save informe remedy*/
	public IncidentRemedy save(IncidentRemedy ir){
		return incidentRemedyRepository.save(ir);	
	}
//	
//	/* search entire list of indicidents*/
//	public List<IncidentRemedy> findAll(){
//			return incidentRemedyRepositoryJDBC.findAll();
//	}
	
	public List<IncidentRemedy> findAll(){
	return incidentRemedyRepository.findAll();
}

	/* get a particular incident by id*/
	public Object findById(String incidencia){
		return incidentRemedyRepository.findById(incidencia);
		
	}
	
	public Object getOne(String id){
		
		return incidentRemedyRepository.getOne(id);
		
	} 
	
	public void deleteById(String id){
		incidentRemedyRepository.deleteById(id);
	}
	
	public List<IncidentRemedy> findByUsrAsignado(String usr){

		List<IncidentRemedy> result = incidentRemedyRepository.findByUsrAsignado(usr);
		
		return result;
		
	}
	
}
