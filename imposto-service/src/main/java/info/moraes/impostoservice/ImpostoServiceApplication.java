package info.moraes.impostoservice;
import org.springframework.cloud.openfeign.EnableFeignClients;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class ImpostoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImpostoServiceApplication.class, args);
	}

}
