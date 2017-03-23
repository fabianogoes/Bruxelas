package com.bruxelas;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("prod")
@Configuration
@EnableJpaRepositories({"com.bruxelas.repositories"})
@ComponentScan("com.bruxelas.entities")
public class JPAConfigurationProduction implements JPAConfiguration {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
    	System.out.println( "<<< Profile = dev >>>" );
		String host = System.getenv().get("OPENSHIFT_MYSQL_DB_HOST") == null ? "localhost" : System.getenv().get("OPENSHIFT_MYSQL_DB_HOST");
		String port = System.getenv().get("OPENSHIFT_MYSQL_DB_PORT") == null ? "3306" : System.getenv().get("OPENSHIFT_MYSQL_DB_PORT");
		String user = System.getenv().get("OPENSHIFT_MYSQL_DB_USERNAME") == null ? "root" : System.getenv().get("OPENSHIFT_MYSQL_DB_USERNAME");
		String pass = System.getenv().get("OPENSHIFT_MYSQL_DB_PASSWORD") == null ? "root" : System.getenv().get("OPENSHIFT_MYSQL_DB_PASSWORD");
		
		String database = "bruxelas";
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";

		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(pass);
		return dataSourceBuilder.build();
    } 
    
}