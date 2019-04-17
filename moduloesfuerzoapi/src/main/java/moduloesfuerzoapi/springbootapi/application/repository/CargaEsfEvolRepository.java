package moduloesfuerzoapi.springbootapi.application.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import moduloesfuerzoapi.springbootapi.application.model.CargaEsfEvol;



@Repository
public interface CargaEsfEvolRepository extends JpaRepository<CargaEsfEvol, Integer>{
	
	@Query("SELECT c FROM CargaEsfEvol c WHERE c.eid = :eid ORDER BY c.fecha_actividad")
    public List<CargaEsfEvol> findByUsrAsignado(@Param("eid") String usrAsignado);
	
	@Query("SELECT COALESCE(MAX(c.carga_esf_evol_id),0) FROM CargaEsfEvol c")
	public int getMaxRowNum();
	

}
