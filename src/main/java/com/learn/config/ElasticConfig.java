package com.learn.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * elasticsearch configuration
 * @author Nishant
 *
 */
@Configuration
public class ElasticConfig {
	
	@Value("${elasticsearch.host}")
    private String host;
	
	@Value("${elasticsearch.port}")
    private int port;

    @Bean
    public RestHighLevelClient client() {
    	return new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port)));
    }
    
    @Bean
    public ObjectMapper objectMapper() {
    	return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}