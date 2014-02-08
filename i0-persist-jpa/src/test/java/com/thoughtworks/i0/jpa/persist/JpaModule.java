package com.thoughtworks.i0.jpa.persist;

import com.thoughtworks.i0.config.Configuration;
import com.thoughtworks.i0.container.grizzly.EmbeddedGrizzly;
import com.thoughtworks.i0.core.Application;
import com.thoughtworks.i0.core.ApplicationModule;
import com.thoughtworks.i0.core.Servlet3;
import com.thoughtworks.i0.jpa.JpaConfiguration;
import com.thoughtworks.i0.jpa.JpaPersist;
import com.thoughtworks.i0.jpa.config.H2;
import com.thoughtworks.i0.jpa.config.Hibernate;

import static com.thoughtworks.i0.config.Configuration.config;
import static com.thoughtworks.i0.jpa.DatabaseConfiguration.database;


@JpaPersist(unit = "domain")
@EmbeddedGrizzly
@Servlet3
@Application("jpa")
public class JpaModule extends ApplicationModule<JpaConfiguration> {
    @Override
    protected JpaConfiguration createDefaultConfiguration(Configuration.ConfigurationBuilder config) {
        return new JpaConfiguration(config().logging().console().end().end().build(),
                database().with(H2.driver, H2.tempFileDB, H2.compatible("ORACLE"),
                        Hibernate.dialect("Oracle10g"), Hibernate.showSql)
                        .user("sa").password("").build());
    }
}
