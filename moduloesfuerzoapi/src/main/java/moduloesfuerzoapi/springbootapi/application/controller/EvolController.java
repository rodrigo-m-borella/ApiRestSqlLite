package moduloesfuerzoapi.springbootapi.application.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import moduloesfuerzoapi.springbootapi.application.dao.CargaEsfEvolDao;
import moduloesfuerzoapi.springbootapi.application.model.CargaEsfEvol;
import moduloesfuerzoapi.springbootapi.application.model.CargaEsfEvolSelected;

@RestController
@RequestMapping("/ppm")
public class EvolController {
	

	@Autowired
	CargaEsfEvolDao cargaEsfEvolDao;
	
	
	EvolController(){
		System.out.println("***ENTRANDO AL CONTROLLER EvolController***");
	}
	
	
	/*get all incidents from CARGA_ESF_INC*/
	@CrossOrigin(origins = "*")
	@GetMapping("/myevols")
	public List<CargaEsfEvolSelected> getAllMyEvol(@RequestParam(value="eid", defaultValue="0") String eid){
		List<CargaEsfEvol> ir =  cargaEsfEvolDao.findByUsrAsignado(eid);
		
		List<CargaEsfEvolSelected> es =  new ArrayList<CargaEsfEvolSelected>();
		int cont=0;
		for (CargaEsfEvol cargaEsfEvol: ir){
			CargaEsfEvolSelected cees = new CargaEsfEvolSelected();
					cees.setActividad( cargaEsfEvol.getActividad());
					cees.setApp_afectada( cargaEsfEvol.getApp_afectada());
					cees.setFrontEndManualChargeTableId(++cont);
					cees.setCarga_esf_evol_id(cargaEsfEvol.getCarga_esf_evol_id());
					cees.setEid( cargaEsfEvol.getEid());
					cees.setFecha_actividad( cargaEsfEvol.getFecha_actividad());
					cees.setHoras( cargaEsfEvol.getHoras());
					cees.setHorastasa( cargaEsfEvol.getHorastasa());
					cees.setPry( cargaEsfEvol.getPry());
					cees.setOt( cargaEsfEvol.getOt());
					cees.setObservaciones( cargaEsfEvol.getObservaciones());
					cees.setTitulo( cargaEsfEvol.getTitulo());
					es.add(cees);
		}			
		
		return es;
	}
	

	@CrossOrigin(origins = "*")
	@PostMapping("/updateManualChargeEvol")
//	public ResponseEntity<IncidentRemedy> updateIncidentById(@PathVariable(value="incidencia") Long incId, @Valid @RequestBody IncidentRemedy irWhithUpdates){
		public ResponseEntity<@Valid ArrayList<CargaEsfEvolSelected>> updateEvolById(@Valid @RequestBody ArrayList<CargaEsfEvolSelected> cargaEsfEvolSelectedArr){
		
		for (CargaEsfEvolSelected cees: cargaEsfEvolSelectedArr){
			CargaEsfEvol cargaEsfEvol = new CargaEsfEvol();
			if (cees.getCarga_esf_evol_id()!=null)
				cargaEsfEvol.setCarga_esf_evol_id(cees.getCarga_esf_evol_id());
			else
				cargaEsfEvol.setCarga_esf_evol_id(cargaEsfEvolDao.getMaxRowNum()+1);
				cargaEsfEvol.setActividad(cees.getActividad());
				cargaEsfEvol.setApp_afectada(cees.getApp_afectada());
				cargaEsfEvol.setEid(cees.getEid());
				cargaEsfEvol.setFecha_actividad(cees.getFecha_actividad());
				cargaEsfEvol.setHoras(cees.getHoras());
				cargaEsfEvol.setHorastasa(cees.getHorastasa());
				cargaEsfEvol.setPry(cees.getPry());
				cargaEsfEvol.setOt(cees.getOt());
				cargaEsfEvol.setObservaciones(cees.getObservaciones());
				cargaEsfEvol.setTitulo(cees.getTitulo());
				cargaEsfEvolDao.save(cargaEsfEvol);
		}
		return ResponseEntity.ok().body(cargaEsfEvolSelectedArr);	
	}
		
	
	@CrossOrigin(origins = "*")
	@PostMapping("/deleteManualChargeEvol")
//	public ResponseEntity<IncidentRemedy> updateIncidentById(@PathVariable(value="incidencia") Long incId, @Valid @RequestBody IncidentRemedy irWhithUpdates){
		public ResponseEntity<@Valid ArrayList<CargaEsfEvolSelected>> deleteEvolById(@Valid @RequestBody ArrayList<CargaEsfEvolSelected> cargaEsfEvolSelectedArr){
		System.out.println("Entra al delete");
		for (CargaEsfEvolSelected cees: cargaEsfEvolSelectedArr){
			if (cees.getCarga_esf_evol_id()!=null){
				cargaEsfEvolDao.deleteById(cees.getCarga_esf_evol_id());
			}
		}
		return ResponseEntity.ok().body(cargaEsfEvolSelectedArr);	
	}
	
}
