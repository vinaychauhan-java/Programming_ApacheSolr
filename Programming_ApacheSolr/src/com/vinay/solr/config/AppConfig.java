package com.vinay.solr.config;

// Maven Settings : C:\Users\<<UserID>>\.m2\settings.xml
// Code Reference : https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-solr-example/

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories("com.vinay.solr.repo")
@PropertySource("classpath:SpringConfig.properties")
public class AppConfig {

	@Value("${appConfig.solrServer}")
	private String solrServer;

	@Bean
	public SolrServer solrServer() {
		return new HttpSolrServer(solrServer);
	}

	@Bean
	public SolrTemplate solrTemplate(SolrServer server) throws Exception {
		return new SolrTemplate(server);
	}

	// To resolve ${} in @Value
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
