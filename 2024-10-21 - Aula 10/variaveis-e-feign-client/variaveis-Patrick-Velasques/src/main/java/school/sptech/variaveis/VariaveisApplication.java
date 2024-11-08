package school.sptech.variaveis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class VariaveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(VariaveisApplication.class, args);
	}

}
