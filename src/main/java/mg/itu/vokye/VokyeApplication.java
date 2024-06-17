package mg.itu.vokye;

import mg.itu.vokye.repository.DepenseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VokyeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext apkContext =  SpringApplication.run(VokyeApplication.class, args);
	}

}
