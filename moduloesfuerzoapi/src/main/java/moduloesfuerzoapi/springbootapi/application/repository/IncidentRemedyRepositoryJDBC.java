package moduloesfuerzoapi.springbootapi.application.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import moduloesfuerzoapi.springbootapi.application.mapper.IncidentRemedyMapper;
import moduloesfuerzoapi.springbootapi.application.mapper.UsuarioRemedyMapper;
import moduloesfuerzoapi.springbootapi.application.model.IncidentRemedy;
import moduloesfuerzoapi.springbootapi.application.model.Usuario;
@Component
public class IncidentRemedyRepositoryJDBC {
	
	static Connection c = null;
	static Statement stmt = null;
	
	 IncidentRemedyRepositoryJDBC(){
		 try{
			 Class.forName("org.sqlite.JDBC");
			 c = DriverManager.getConnection("jdbc:sqlite:controldehoras-db.db");
			 
		 }catch(Exception e){
			System.out.print(e.getMessage()); 
			 
		 }
		 
	 }
	 
	 public Usuario getUserById (int id){
		 String query = "select * from usuarios where usuarioid="+Integer.toString(id);
		 
		 try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			UsuarioRemedyMapper mapper = new UsuarioRemedyMapper();
			return mapper.map(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Usuario();
		}
		 
		 
		 
		 
	 }
	 
	public static IncidentRemedy save(IncidentRemedy ir){
		try {
			String insertQuery = "INSERT INTO Inc_carga_esfuerzo (incidencia)VALUES (24);";
			stmt = c.createStatement();
			stmt.execute(insertQuery);
			
			return ir;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public static List<IncidentRemedy> findAll() {
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Inc_carga_esfuerzo");
			System.out.println("RESULTADO: "+rs.getString(1));
			List<IncidentRemedy> incidentsList = new ArrayList<IncidentRemedy>() ;
			IncidentRemedyMapper incidentRemedyMapper = new IncidentRemedyMapper();
			while (rs.next()){
//				int incidentNumeber = rs.getInt(1);
//				String owner = rs.getString(2);
//				System.out.println("Incidencia: "+ incidentNumeber );
//				System.out.println("owner: "+ owner );
				
				incidentsList.add(incidentRemedyMapper.map(rs));
				
				
			}
			return incidentsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				c.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		// TODO Auto-generated method stub
		
	}

}
