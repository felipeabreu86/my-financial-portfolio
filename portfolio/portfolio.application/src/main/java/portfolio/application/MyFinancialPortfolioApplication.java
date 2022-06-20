package portfolio.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class that starts the application
 * 
 * @author Felipe Abreu
 * @version 0.01
 * @since 0.01
 */
@SpringBootApplication
@ComponentScan(basePackages = { 
		"portfolio.domain.repository",
		"portfolio.domain.usecase.b3",
		"portfolio.domain.usecase",
		"portfolio.application.controller" })
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
