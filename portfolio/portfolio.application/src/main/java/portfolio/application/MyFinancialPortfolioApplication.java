package portfolio.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class that starts the application
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@SpringBootApplication
@EntityScan({ 
	"portfolio.domain.entity.b3", 
	"portfolio.domain.entity.user",
	"portfolio.dataprovider.model.b3",
	"portfolio.dataprovider.model.user"})
@EnableJpaRepositories({ 
	"portfolio.dataprovider.dao", })
@ComponentScan(basePackages = { 
		"portfolio.application", 
		"portfolio.domain.usecase", 
		"portfolio.dataprovider.repository",
		"portfolio.service",
		"portfolio.shared.util" })
public class MyFinancialPortfolioApplication {

	/**
	 * Main method that launches the application
	 * 
	 * @param args - Array of strings as parameters
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyFinancialPortfolioApplication.class, args);
	}

}
