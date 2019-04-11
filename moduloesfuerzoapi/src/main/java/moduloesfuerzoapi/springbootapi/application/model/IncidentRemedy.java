package moduloesfuerzoapi.springbootapi.application.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.LastModifiedDate;

//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Setter;


@Entity
@Table(name="inc_carga_esfuerzo")

//@NamedQuery(
//		name="IncidentRemedy.findByUsrAsignado",
//		query="SELECT i FROM inc_carga_esfuerzo i WHERE i.usr_asignado = :usrAsignado"
//		)

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class IncidentRemedy {

	@Id
	String incidencia;
    String emp_sop_prop;
    String org_sop_prop;
    String grupo_prop;
    String empresa_sop;
    String org_sop;
    String grupo_asignado;
    String usr_asignado;
    String fecha_inicio;//Fecha
    String fecha_ult_mod;//Fecha
    String dur_est_ult_fecha;//Fecha
    int transferencias;
    String esfuerzo_asignado;
    int esf_asig_segundos;
    String horas_laborales;
    int hrs_laborales_seg;
    String duracion_actual;
    int dur_actual_seg;
    int tipo_asig;
    String n1_cat_oper;
    String n2_cat_oper;
    String n3_cat_oper;
    String n1_cat_prod;
    String n2_cat_prod;
    String n3_cat_prod;
    String estado;
    String n1_cat_oper_res;
    String n2_cat_oper_res;
    String n3_cat_oper_res;
    String n1_cat_prod_res;
    String n2_cat_prod_res;
    String n3_cat_prod_res;
    String fecha_notif;//Fecha
    String fecha_estim_res;//Fecha
    String fecha_ult_res;//Fecha
    String impacto;
    String urgencia;
    String nombre;
    String apellido;
    String empresa;
    String departamento;
    String organizacion;
    int prioridad;
    String fecha_resp;//Fecha
    String fecha_cierre;//Fecha
    String fecha_reap;//Fecha
    String emp_sop_actual;
    String org_sop_actual;
    String grp_sop_actual;


//    public Long getIncidencia(){
//    	Number tmp=this.incidencia;
//    	return tmp.longValue();
//    	
//    }
//    
//    public void setIncidencia(Long id){
//    	
//    	this.incidencia=id.intValue();
//    	
//    }
    
    
//    public void setfecha_inicio(String dateString){
//    	this.fecha_inicio= convertToDate(dateString);
//    }
//    
//    
//	private Date convertToDate(String dateString){
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//		
//		if (dateString==null) return null;
//		
//		Date date = null;
//		try {
//			date = formatter.parse(dateString);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return date;
//		
//	}
    
    
}



