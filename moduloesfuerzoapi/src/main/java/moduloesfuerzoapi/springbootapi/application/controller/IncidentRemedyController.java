package moduloesfuerzoapi.springbootapi.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import moduloesfuerzoapi.springbootapi.application.dao.CargaEsfIncDao;
import moduloesfuerzoapi.springbootapi.application.dao.IncidentRemedyDao;
import moduloesfuerzoapi.springbootapi.application.dao.UsuarioRemedyDao;
import moduloesfuerzoapi.springbootapi.application.model.CargaEsfInc;
import moduloesfuerzoapi.springbootapi.application.model.CargaEsfIncSelected;
import moduloesfuerzoapi.springbootapi.application.model.CustomIncidentRemedy;
import moduloesfuerzoapi.springbootapi.application.model.IncidentRemedy;
import moduloesfuerzoapi.springbootapi.application.model.Usuario;

@RestController
@RequestMapping("/informe")
public class IncidentRemedyController {
	
	@Autowired
	IncidentRemedyDao incidentRemedyDao;
	
	@Autowired
	UsuarioRemedyDao usuarioRemedyDao;
	
	@Autowired
	CargaEsfIncDao cargaEsfIncDao;
	
	
	IncidentRemedyController(){
		System.out.println("***ENTRANDO AL CONTROLLER IncidentRemedyController***");
	}
	

//	@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "*")
	@PostMapping("/incident")
	public IncidentRemedy CreateIncidentRemedy(@Valid @RequestBody IncidentRemedy ir){
		System.out.println("ENTRO POR EL CONTROLLER, METODO  CreateIncidentRemedy");
		return incidentRemedyDao.save(ir);
	}
	
	/* to save an incident*/
//	@PostMapping("/incident")
//	public IncidentRemedy createIncidentRemedy(@Valid @RequestBody IncidentRemedy ir){
//		return incidentRemedyDao.save(ir);
//		
//	}
	
	/*get all incidents*/
	@CrossOrigin(origins = "*")
	@GetMapping("/incidents")
	public List<CustomIncidentRemedy> getAllIncidents(){
		System.out.println("ENTRO POR EL CONTROLLER, METODO getAllIncidents");
		
		List<IncidentRemedy> list = new ArrayList<IncidentRemedy>();
		List<CustomIncidentRemedy> customlist = new ArrayList<CustomIncidentRemedy>();
		list = incidentRemedyDao.findAll();
		int cont =0;
		for (IncidentRemedy ir: list ){
			CustomIncidentRemedy crr = new CustomIncidentRemedy();
			crr.setId(++cont);
			crr.setEstado(ir.getEstado());
			crr.setNroInc(ir.getIncidencia());
			crr.setUsrAsignado(ir.getUsr_asignado());
			customlist.add(crr);
		}
		
		return customlist;
	}
	
	/*get all incidents from CARGA_ESF_INC*/
	@CrossOrigin(origins = "*")
	@GetMapping("/myincidents")
	public List<CargaEsfIncSelected> getAllMyIncidents(@RequestParam(value="eid", defaultValue="0") String eid){
		System.out.println("ENTRO POR EL CONTROLLER, METODO getAllMyIncidents");
		List<CargaEsfInc> ir =  cargaEsfIncDao.findByUsrAsignado(eid);
		
		List<CargaEsfIncSelected> is =  new ArrayList<CargaEsfIncSelected>();
		int cont=0;
		for (CargaEsfInc cargaEsfInc: ir){
			CargaEsfIncSelected ceis = new CargaEsfIncSelected();
					ceis.setActividad( cargaEsfInc.getActividad());
					ceis.setApp_afectada( cargaEsfInc.getApp_afectada());
					ceis.setFrontEndManualChargeTableId(++cont);
					ceis.setCarga_esf_inc_id(cargaEsfInc.getCarga_esf_inc_id());
					ceis.setEid( cargaEsfInc.getEid());
					ceis.setFecha_actividad( cargaEsfInc.getFecha_actividad());
					ceis.setHoras( cargaEsfInc.getHoras());
					ceis.setHorastasa( cargaEsfInc.getHorastasa());
					ceis.setInc_id( cargaEsfInc.getInc_id());
					ceis.setObservaciones( cargaEsfInc.getObservaciones());
					ceis.setTitulo( cargaEsfInc.getTitulo());
					is.add(ceis);
		}			
		
		return is;
	}
	
	
	
	/* get incident by id*/
	@CrossOrigin(origins = "*")
	@GetMapping("/incident")
	public ResponseEntity<IncidentRemedy> getIncidentById(@RequestParam(value="incidencia", defaultValue="0") String incidencia){
		
		IncidentRemedy ir = (IncidentRemedy) incidentRemedyDao.getOne(incidencia);
		
		if (ir==null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(ir);
	}

	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/updateManualCharge")
//	public ResponseEntity<IncidentRemedy> updateIncidentById(@PathVariable(value="incidencia") Long incId, @Valid @RequestBody IncidentRemedy irWhithUpdates){
		public ResponseEntity<@Valid ArrayList<CargaEsfIncSelected>> updateIncidentById(@Valid @RequestBody ArrayList<CargaEsfIncSelected> cargaEsfIncSelectedArr){
		
		for (CargaEsfIncSelected cris: cargaEsfIncSelectedArr){
			CargaEsfInc cargaEsfInc = new CargaEsfInc();
			if (cris.getCarga_esf_inc_id()!=null)
				cargaEsfInc.setCarga_esf_inc_id(cris.getCarga_esf_inc_id());
			else
				cargaEsfInc.setCarga_esf_inc_id(cargaEsfIncDao.getMaxRowNum()+1);
//			cargaEsfInc.setCarga_esf_inc_id(4);
			cargaEsfInc.setActividad(cris.getActividad());
			cargaEsfInc.setApp_afectada(cris.getApp_afectada());
			cargaEsfInc.setEid(cris.getEid());
			cargaEsfInc.setFecha_actividad(cris.getFecha_actividad());
			cargaEsfInc.setHoras(cris.getHoras());
			cargaEsfInc.setHorastasa(cris.getHorastasa());
			cargaEsfInc.setInc_id(cris.getInc_id());
			cargaEsfInc.setObservaciones(cris.getObservaciones());
			cargaEsfInc.setTitulo(cris.getTitulo());
			cargaEsfIncDao.save(cargaEsfInc);
		}
		
//		IncidentRemedy ir = (IncidentRemedy) incidentRemedyDao.getOne(irWhithUpdates.getIncidencia());
//		if (ir==null){
//			return ResponseEntity.notFound().build();
//		}
		
//		IncidentRemedy updateIncidentRemedy = incidentRemedyDao.save(irWhithUpdates);
		
		return ResponseEntity.ok().body(cargaEsfIncSelectedArr);	
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/update")
//	public ResponseEntity<IncidentRemedy> updateIncidentById(@PathVariable(value="incidencia") Long incId, @Valid @RequestBody IncidentRemedy irWhithUpdates){
		public ResponseEntity<IncidentRemedy> updateIncidentById(@Valid @RequestBody IncidentRemedy irWhithUpdates){
		IncidentRemedy ir = (IncidentRemedy) incidentRemedyDao.getOne(irWhithUpdates.getIncidencia());
		if (ir==null){
			return ResponseEntity.notFound().build();
		}
		
		IncidentRemedy updateIncidentRemedy = incidentRemedyDao.save(irWhithUpdates);
		
		return ResponseEntity.ok().body(updateIncidentRemedy);	
	}
	
	/* delete an incident by id*/
	@CrossOrigin(origins = "*")
//	@DeleteMapping(value="/delincident")	
	@PostMapping(value="/delincident")	
	
	public ResponseEntity<IncidentRemedy> deleteIncidentRemedyById(@RequestParam(value="id") String incId){
		IncidentRemedy ir = (IncidentRemedy) incidentRemedyDao.getOne(incId);
		
		if (ir==null){
			return ResponseEntity.notFound().build();
		}		
		incidentRemedyDao.deleteById(incId);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/incidentByUsr")
	public List<IncidentRemedy> getIncidentByUsr(@RequestParam(value="usr", defaultValue="0") String usr){
		
		List<IncidentRemedy> ir =  incidentRemedyDao.findByUsrAsignado(usr);
		
		return ir;
	}
	
	
}
