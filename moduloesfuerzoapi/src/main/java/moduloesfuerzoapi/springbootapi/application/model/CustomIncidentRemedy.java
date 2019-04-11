package moduloesfuerzoapi.springbootapi.application.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
//import org.springframework.data.annotation.LastModifiedDate;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;




//@NamedQuery(
//		name="IncidentRemedy.findByUsrAsignado",
//		query="SELECT i FROM inc_carga_esfuerzo i WHERE i.usr_asignado = :usrAsignado"
//		)

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomIncidentRemedy {
	
	int id;
	String NroInc;
    String usrAsignado;
    String estado;

}



