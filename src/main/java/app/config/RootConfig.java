package app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "app" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/amit");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter() {
//	 OpenJ
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//	  adapter.setDatabase("HSQL");
//	  adapter.setShowSql(true);
//	  adapter.setGenerateDdl(false);
//	  adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
//	  return adapter;
//	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("app.pojos");
		return emfb;
	}
	
//	@Bean
//	public JndiObjectFactoryBean entityManagerFactory() {
//	JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//	  jndiObjectFB.setJndiName("jdbc/SpittrDS");
//	  return jndiObjectFB;
//	}
}
