package moduloesfuerzoapi.springbootapi.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CargaEsfIncSelected extends CargaEsfInc {
	
	int frontEndManualChargeTableId;
    String selected = "";
    
}



