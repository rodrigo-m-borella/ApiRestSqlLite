package moduloesfuerzoapi.springbootapi.application.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import moduloesfuerzoapi.springbootapi.application.model.CargaEsfEvol;

import moduloesfuerzoapi.springbootapi.application.repository.CargaEsfEvolRepository;

@Service
public class CargaEsfEvolDao {
	
	@Autowired
	CargaEsfEvolRepository cargaEsfEvolRepository;
	
	
//	@Autowired 
//	IncidentRemedyRepositoryJDBC incidentRemedyRepositoryJDBC;
	
	public int getMaxRowNum(){
		return cargaEsfEvolRepository.getMaxRowNum();
	}
	
	
	/* save informe remedy*/
	public CargaEsfEvol save(CargaEsfEvol ir){
		return cargaEsfEvolRepository.save(ir);	
	}
//	
//	/* search entire list of indicidents*/
//	public List<IncidentRemedy> findAll(){
//			return incidentRemedyRepositoryJDBC.findAll();
//	}
	
	public List<CargaEsfEvol> findAll(){
	return cargaEsfEvolRepository.findAll();
}

	/* get a particular incident by id*/
	public Object findById(Integer incidencia){
		return cargaEsfEvolRepository.findById(incidencia);
		
	}
	
	public Object getOne(Integer id){
		
		return cargaEsfEvolRepository.getOne(id);
		
	} 
	
	public void deleteById(Integer id){
		cargaEsfEvolRepository.deleteById(id);
	}
	
	public List<CargaEsfEvol> findByUsrAsignado(String eid){

		List<CargaEsfEvol> result = cargaEsfEvolRepository.findByUsrAsignado(eid);
		
		return result;
		
	}
	
}
