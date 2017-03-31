package com.bruxelas;

//@Profile("test")
//@Configuration
//@EnableJpaRepositories({"com.bruxelas.repositories"})
//@ComponentScan("com.bruxelas.entities")
//public class JPAConfigurationTest implements JPAConfiguration {
//
//	@Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//            .setType(EmbeddedDatabaseType.HSQL)
//            //.addScript("classpath:schema.sql")
//            //.addScript("classpath:test-data.sql")
//            .build();
//    }	
//	
//	
////    @Bean(destroyMethod = "close")
////    public DataSource dataSource() {
////    	System.out.println( "<<< Profile = dev >>>" );
////		
////		String url = "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB";
////
////		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////		dataSourceBuilder.url(url);
////		dataSourceBuilder.username("SA");
////		dataSourceBuilder.password("");
////		return dataSourceBuilder.build();
////    	
////		//DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
////		//return dataSourceBuilder.build();    	
////		
////    } 
//    
//}
