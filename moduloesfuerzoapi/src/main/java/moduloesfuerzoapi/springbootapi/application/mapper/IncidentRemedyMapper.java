package moduloesfuerzoapi.springbootapi.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import moduloesfuerzoapi.springbootapi.application.model.*;

public class IncidentRemedyMapper {

	
	public IncidentRemedy map(ResultSet rs) throws SQLException{
		
		IncidentRemedy incidentRemedy = new IncidentRemedy();
//		
//		incidentRemedy.setIncidencia(rs.getInt(1));
//		incidentRemedy.setEmp_sop_prop(rs.getString(2));
//		incidentRemedy.setOrg_sop_prop(rs.getString(3));
//		incidentRemedy.setGrupo_prop(rs.getString(4));
//		incidentRemedy.setEmpresa_sop(rs.getString(5));
//		incidentRemedy.setOrg_sop(rs.getString(6));
//		incidentRemedy.setGrupo_asignado(rs.getString(7));
//		incidentRemedy.setUsr_asignado(rs.getString(8));
//		incidentRemedy.setFecha_inicio(convertToDate(rs.getString(9)));
//		incidentRemedy.setFecha_ult_mod(convertToDate(rs.getString(10)));
//		incidentRemedy.setDur_est_ult_fecha(convertToDate(rs.getString(11)));
//		incidentRemedy.setTransferencias(rs.getInt(12));
//		incidentRemedy.setEsfuerzo_asignado(rs.getString(13));
//		incidentRemedy.setEsf_asig_segundos(rs.getInt(14));
//		incidentRemedy.setHoras_laborales(rs.getString(15));
//		incidentRemedy.setHrs_laborales_seg(rs.getInt(16));
//		incidentRemedy.setDuracion_actual(rs.getString(17));
//		incidentRemedy.setDur_actual_seg(rs.getInt(18));
//		incidentRemedy.setTipo_asig(rs.getInt(19));
//		incidentRemedy.setN1_cat_oper(rs.getString(20));
//		incidentRemedy.setN2_cat_oper(rs.getString(21));
//		incidentRemedy.setN3_cat_oper(rs.getString(22));
//		incidentRemedy.setN1_cat_prod(rs.getString(23));
//		incidentRemedy.setN2_cat_prod(rs.getString(24));
//		incidentRemedy.setN3_cat_prod(rs.getString(25));
//		incidentRemedy.setEstado(rs.getString(26));
//		incidentRemedy.setN1_cat_oper_res(rs.getString(27));
//		incidentRemedy.setN2_cat_oper_res(rs.getString(28));
//		incidentRemedy.setN3_cat_oper_res(rs.getString(29));
//		incidentRemedy.setN1_cat_prod_res(rs.getString(30));
//		incidentRemedy.setN2_cat_prod_res(rs.getString(31));
//		incidentRemedy.setN3_cat_prod_res(rs.getString(32));
//		incidentRemedy.setFecha_notif(convertToDate(rs.getString(33)));
//		incidentRemedy.setFecha_estim_res(convertToDate(rs.getString(34)));
//		incidentRemedy.setFecha_ult_res(convertToDate(rs.getString(35)));
//		incidentRemedy.setImpacto(rs.getString(36));
//		incidentRemedy.setUrgencia(rs.getString(37));
//		incidentRemedy.setNombre(rs.getString(38));
//		incidentRemedy.setApellido(rs.getString(39));
//		incidentRemedy.setEmpresa(rs.getString(40));
//		incidentRemedy.setDepartamento(rs.getString(41));
//		incidentRemedy.setOrganizacion(rs.getString(42));
//		incidentRemedy.setPrioridad(rs.getInt(43));
//		incidentRemedy.setFecha_resp(convertToDate(rs.getString(44)));
//		incidentRemedy.setFecha_cierre(convertToDate(rs.getString(45)));
//		incidentRemedy.setFecha_reap(convertToDate(rs.getString(46)));
//		incidentRemedy.setEmp_sop_actual(rs.getString(47));
//		incidentRemedy.setOrg_sop_actual(rs.getString(48));
//		incidentRemedy.setGrp_sop_actual(rs.getString(49));
//		
////		incidentRemedy(rs.getInt(1));
////		incidentRemedy.setOwner(rs.getString(2));
////		incidentRemedy.setDateCreated(rs.getDate(3));
////		incidentRemedy.setState(rs.getString(4));
//		
		return incidentRemedy;
	}	
	
	private Date convertToDate(String dateString){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		if (dateString==null) return null;
		
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
	}
	
}
