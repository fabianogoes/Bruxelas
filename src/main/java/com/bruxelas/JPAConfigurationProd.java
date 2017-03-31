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
public class JPAConfigurationProd implements JPAConfiguration {

	/***************************************************************************************************** 
	 * Openshift - MySQL
	 *****************************************************************************************************
		MySQL 5.5 database added.  Please make note of these credentials:
		
		       Root User: adminCUBivEk
		   Root Password: b4be_AuNYSPh
		   Database Name: bruxelas
		
		Connection URL: mysql://$OPENSHIFT_MYSQL_DB_HOST:$OPENSHIFT_MYSQL_DB_PORT/
		
		You can manage your new MySQL database by also embedding phpmyadmin.
		The phpmyadmin username and password will be the same as the MySQL credentials above.	
	
	 ***************************************************************************************************** 
	 * Openshift - PhpMyAdmin
	 *****************************************************************************************************
		Please make note of these MySQL credentials again:
		  Root User: adminCUBivEk
		  Root Password: b4be_AuNYSPh
		URL: https://bruxelas-fabianoggoes.rhcloud.com/phpmyadmin/
	 *****************************************************************************************************/
	
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
    	System.out.println( "<<< Profile = prod >>>" );

    	String host = System.getenv().get("OPENSHIFT_MYSQL_DB_HOST") == null ? "localhost" : System.getenv().get("OPENSHIFT_MYSQL_DB_HOST");
		String port = System.getenv().get("OPENSHIFT_MYSQL_DB_PORT") == null ? "3306" : System.getenv().get("OPENSHIFT_MYSQL_DB_PORT");
		String user = System.getenv().get("OPENSHIFT_MYSQL_DB_USERNAME") == null ? "bruxelas" : System.getenv().get("OPENSHIFT_MYSQL_DB_USERNAME");
		String pass = System.getenv().get("OPENSHIFT_MYSQL_DB_PASSWORD") == null ? "bruxelas" : System.getenv().get("OPENSHIFT_MYSQL_DB_PASSWORD");
		
		String database = "bruxelas";
		String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&useSSL=false";
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(user);
		dataSourceBuilder.password(pass);
		return dataSourceBuilder.build();
    } 
    
}