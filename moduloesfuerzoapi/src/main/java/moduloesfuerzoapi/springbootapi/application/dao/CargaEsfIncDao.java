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

import moduloesfuerzoapi.springbootapi.application.model.CargaEsfInc;
import moduloesfuerzoapi.springbootapi.application.model.IncidentRemedy;
import moduloesfuerzoapi.springbootapi.application.repository.CargaEsfIncRepository;
import moduloesfuerzoapi.springbootapi.application.repository.IncidentRemedyRepository;
import moduloesfuerzoapi.springbootapi.application.repository.IncidentRemedyRepositoryJDBC;

@Service
public class CargaEsfIncDao {
	
	@Autowired
	CargaEsfIncRepository cargaEsfIncRepository;
	
	
//	@Autowired 
//	IncidentRemedyRepositoryJDBC incidentRemedyRepositoryJDBC;
	
	public int getMaxRowNum(){
		return cargaEsfIncRepository.getMaxRowNum();
	}
	
	
	/* save informe remedy*/
	public CargaEsfInc save(CargaEsfInc ir){
		return cargaEsfIncRepository.save(ir);	
	}
//	
//	/* search entire list of indicidents*/
//	public List<IncidentRemedy> findAll(){
//			return incidentRemedyRepositoryJDBC.findAll();
//	}
	
	public List<CargaEsfInc> findAll(){
	return cargaEsfIncRepository.findAll();
}

	/* get a particular incident by id*/
	public Object findById(Integer incidencia){
		return cargaEsfIncRepository.findById(incidencia);
		
	}
	
	public Object getOne(Integer id){
		
		return cargaEsfIncRepository.getOne(id);
		
	} 
	
	public void deleteById(Integer id){
		cargaEsfIncRepository.deleteById(id);
	}
	
	public List<CargaEsfInc> findByUsrAsignado(String eid){

		List<CargaEsfInc> result = cargaEsfIncRepository.findByUsrAsignado(eid);
		
		return result;
		
	}
	
}
