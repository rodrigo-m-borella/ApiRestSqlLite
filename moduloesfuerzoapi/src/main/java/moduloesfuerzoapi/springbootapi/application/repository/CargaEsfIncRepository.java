package moduloesfuerzoapi.springbootapi.application.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import moduloesfuerzoapi.springbootapi.application.model.CargaEsfInc;


@Repository
public interface CargaEsfIncRepository extends JpaRepository<CargaEsfInc, Integer>{
	
	@Query("SELECT c FROM CargaEsfInc c WHERE c.eid = :eid")
    public List<CargaEsfInc> findByUsrAsignado(@Param("eid") String usrAsignado);
	
	@Query("SELECT COALESCE(MAX(c.carga_esf_inc_id),0) FROM CargaEsfInc c")
	public int getMaxRowNum();
	

}
