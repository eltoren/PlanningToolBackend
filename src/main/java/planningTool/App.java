package planningTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "planningTool")
@PropertySource("classpath:application.properties")
@EntityScan("planningTool")
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}
}
