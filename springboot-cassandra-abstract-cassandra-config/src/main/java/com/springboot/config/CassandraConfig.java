package com.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keySpace;

	@Value("${spring.data.cassandra.contact-points}")
	private String contactPoints;

	@Value("${spring.data.cassandra.port}")
	private int port;

	@Value("${spring.data.cassandra.username}")
	private String userName;

	@Value("${spring.data.cassandra.password}")
	private String password;

	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

	@Override
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException{
		CassandraMappingContext context = new CassandraMappingContext();
		context.setUserTypeResolver(new SimpleUserTypeResolver(cluster().getObject(), keySpace));
		return context;
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setUsername(userName);
		cluster.setPassword(password);
		cluster.setContactPoints(contactPoints);
		cluster.setPort(port);
		cluster.setJmxReportingEnabled(false);
		return cluster;
	}
}
