package com.vilibrary;


import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;



@SpringBootApplication
public class LibraryAplication  extends SpringBootServletInitializer{
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.url}")
	private String url;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	       return application.sources(LibraryAplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryAplication.class, args);
				
	}

	@Lazy
	@Bean(destroyMethod="")
	public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	    dataSourceBuilder.url(url);
	    dataSourceBuilder.username(user);
	    dataSourceBuilder.password(password);
	    dataSourceBuilder.driverClassName(driverClassName);
	    return dataSourceBuilder.build();  
	}

	@Component
	public class CorsFilter extends OncePerRequestFilter {

	    @Override
	    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
	                                    final FilterChain filterChain) throws ServletException, IOException {
	        response.addHeader("Access-Control-Allow-Origin", "*");
	        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
	        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
	        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
	        response.addHeader("Access-Control-Allow-Credentials", "true");
	        response.addIntHeader("Access-Control-Max-Age", 10);
	        filterChain.doFilter(request, response);
	    }
	}
}
