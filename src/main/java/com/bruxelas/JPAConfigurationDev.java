package com.bruxelas;

//import javax.sql.DataSource;
//
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
////@Profile("dev")
////@Configuration
////@EnableJpaRepositories({"com.bruxelas.repositories"})
////@ComponentScan("com.bruxelas.entities")
//public class JPAConfigurationDev implements JPAConfiguration {
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//    	System.out.println( "<<< Profile = dev >>>" );
//		
////		String user = "bruxelasdev";
////		String pass = "bruxelasdev";
////		String url = "jdbc:mysql://localhost:3306/bruxelasdev?autoReconnect=true&useSSL=false";
////
////		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////		dataSourceBuilder.url(url);
////		dataSourceBuilder.username(user);
////		dataSourceBuilder.password(pass);
////		return dataSourceBuilder.build();
//    	
//		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//		return dataSourceBuilder.build();    	
//		
//    } 
//    
//}
