//package moduloesfuerzoapi.springbootapi.application.bd;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//import org.springframework.stereotype.Component;
//
//import lombok.Data;
//
//@Component
//@Data
//public class SqliteConnection {
//	
//	private static SqliteConnection instance;
//	private Connection connection = null;
//	
//	private SqliteConnection(){
////		static Statement stmt = null;
//			 try{
//				 Class.forName("org.sqlite.JDBC");
//				 connection = DriverManager.getConnection("jdbc:sqlite:controldehoras-db.db");
//			 }catch(Exception e){
//				System.out.print(e.getMessage()); 
//			 }
//	}
//	
//	public static SqliteConnection getSqliteConnection(){
//		if (instance == null){
//			synchronized (SqliteConnection.class){
//				if (instance == null){
//					instance = new SqliteConnection();
//				}
//			}
//		}
//		return instance;
//	}
//
//}
