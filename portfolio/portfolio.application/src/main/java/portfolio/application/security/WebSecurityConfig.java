package portfolio.application.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import portfolio.application.controller.type.PageOptions;

@Configuration
public class WebSecurityConfig implements HttpSessionListener {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		String defaultSucessUrl = String.format("/%s", PageOptions.DASHBOARD.toString().toLowerCase());		
		String[] authorizedResources = { 
				"/login/**", 
				"/img/**", 
				"/h2-console/**",
				"/",
				"/login" };

		return http
				.authorizeRequests()
				.antMatchers(authorizedResources)
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl(defaultSucessUrl, true)
					.permitAll())
				.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true))
				.csrf().disable()
		        .headers().frameOptions().disable()
		        .and()
				.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web
				.ignoring()
				.antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Setting 30 minutes (1800ms) timeout to HTTP Session
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(1800);
	}

}
