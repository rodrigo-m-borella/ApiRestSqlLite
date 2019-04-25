package moduloesfuerzoapi.springbootapi.application.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder.Default;
import lombok.Data;
//import org.springframework.data.annotation.LastModifiedDate;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="CARGA_ESF_EVOL")

//@NamedQuery(
//		name="IncidentRemedy.findByUsrAsignado",
//		query="SELECT i FROM inc_carga_esfuerzo i WHERE i.usr_asignado = :usrAsignado"
//		)

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CargaEsfEvol {
	
	@Id
	Integer carga_esf_evol_id;
	String pry;
	String ot;
    String fecha_actividad;
    String horas;
    String horastasa;
    String titulo;
    String app_afectada;
    String observaciones;
    String eid;
    String actividad;
}



