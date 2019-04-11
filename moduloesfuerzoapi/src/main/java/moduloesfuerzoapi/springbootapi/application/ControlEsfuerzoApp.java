package moduloesfuerzoapi.springbootapi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class ControlEsfuerzoApp  {
	
		public static void main(String[] args){
			System.out.println("***ARRANCA WS CONTROL ESFUERZO INCIDENCIAS***");
			SpringApplication.run(ControlEsfuerzoApp.class, args);
			
		}
		

	
}
