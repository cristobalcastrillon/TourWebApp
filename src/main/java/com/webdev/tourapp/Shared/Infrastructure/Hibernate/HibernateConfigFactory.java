package com.webdev.tourapp.Shared.Infrastructure.Hibernate;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {

    @Autowired
    Environment env;

    @Bean("session-factory")
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(this.dataSource());
        sessionFactory.setHibernateProperties(this.hibernateProperties());

        FileSystemResource tourInstanceResource = new FileSystemResource("./src/main/java/com/webdev/tourapp/Tours/TourInstance/Infrastructure/Hibernate/TourInstance.hbm.xml");
        FileSystemResource tourResource = new FileSystemResource("./src/main/java/com/webdev/tourapp/Tours/Tour/Infrastructure/Hibernate/Tour.hbm.xml");
        FileSystemResource userResource = new FileSystemResource("./src/main/java/com/webdev/tourapp/Users/User/Infrastructure/Hibernate/User.hbm.xml");
        FileSystemResource guideResource = new FileSystemResource("./src/main/java/com/webdev/tourapp/Users/Guide/Infrastructure/Hibernate/Guide.hbm.xml");
        FileSystemResource transportCompanyResource = new FileSystemResource("./src/main/java/com/webdev/tourapp/TransportCompany/Company/Infrastructure/Hibernate/Company.hbm.xml");
        FileSystemResource locationResource = new FileSystemResource("./src/main/java/com/webdev/tourapp/Location/Infrastructure/Hibernate/Location.hbm.xml");

        sessionFactory.setMappingLocations(tourInstanceResource, tourResource, userResource, guideResource, transportCompanyResource, locationResource);

        return sessionFactory;
    }

    @Bean("transactional-manager")
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MariaDBDialect");
        return hibernateProperties;
    }

    private DataSource dataSource(){
        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String driverClassName = env.getProperty("spring.datasource.driver-class-name");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

}
