//package moduloesfuerzoapi.springbootapi.application.repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import moduloesfuerzoapi.springbootapi.application.bd.SqlQueryContainer;
//import moduloesfuerzoapi.springbootapi.application.bd.SqliteConnection;
//import moduloesfuerzoapi.springbootapi.application.mapper.UsuarioRemedyMapper;
//
//@Component
//public class UsuarioRemedyRepositoryJDBC {
//	
//	
//	public UsuarioRemedyRepositoryJDBC(){};
//	
//	@Autowired
//	SqliteConnection sqliteConnection; 
//	@Autowired
//	UsuarioRemedyMapper usuarioRemedyMapper; 
//	@Autowired SqlQueryContainer sqlQueryContainer;
//	
//	
//	private String table="usuarios";
//	private String usuarioIdField = "usuarioid";
//	
//	public Object getEntityById(int id) throws SQLException{
//		
//		ResultSet rs = prepareStatementMethod().executeQuery(sqlQueryContainer.selectById(table,usuarioIdField,id));
//		
//		return usuarioRemedyMapper.map(rs);
//		
//	}
//	
//	private Statement prepareStatementMethod () throws SQLException{
//		 Statement	st = 
//			sqliteConnection
//			.getSqliteConnection()
//			.getConnection()
//			.createStatement();
//		return st;
//	}
//	
//}
