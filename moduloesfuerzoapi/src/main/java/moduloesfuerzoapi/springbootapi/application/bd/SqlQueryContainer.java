package moduloesfuerzoapi.springbootapi.application.bd;

import org.springframework.stereotype.Component;

@Component
public class SqlQueryContainer {

	public String selectById(String table, String fieldCriteria,int id){
		String q = "select * from "+table+" where "+fieldCriteria + "=" +Integer.toString(id);
		return q;
	}
	
}
