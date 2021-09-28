package com.conurets.EmployeeInformationSystem.service;

import com.conurets.EmployeeInformationSystem.model.Employee;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.util.Properties;

@Configuration
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

    @Autowired
    CurrentUser currentUser;

    @Override
    public EbeanServer getObject() throws Exception {
        try {
            return createEbeanServer();
        } catch(Exception ex) {
            throw new Exception(ex);
        }
    }

    private EbeanServer createEbeanServer() {
        ServerConfig cfg = new ServerConfig();
        cfg.setName("db");

        Properties properties = new Properties();
        properties.put("datasource.db.databaseUrl","jdbc:postgresql://localhost:5432/postgres_spring_db");
        properties.put("datasource.db.databaseDriver", "org.postgresql.Driver");
        properties.put("datasource.db.username", "postgres");
        properties.put("datasource.db.password", "123");

        properties.put("ebean.db.ddl.generate", false);
        properties.put("ebean.db.ddl.run", false);

        cfg.loadFromProperties(properties);

        cfg.setDefaultServer(true);

        cfg.addClass(Employee.class);

        EbeanServer server = EbeanServerFactory.create(cfg);
        return server;
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
