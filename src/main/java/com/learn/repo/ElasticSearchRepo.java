package com.learn.repo;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.elasticsearch.action.DocWriteRequest.OpType;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Repository for elasticsearch
 * @author Nishant
 *
 */
@Repository("UserElasticRepo")
public class ElasticSearchRepo{
	private static final String TYPE = "_doc";
	
	@Autowired
	private RestHighLevelClient restHighLevelClient;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * save data with unique id
	 * @param index Index Name
	 * @param t data to be saved
	 * @param id Id
	 * @return Id
	 * @throws IOException
	 */
	public <T> String save(String index, T t, String id) throws IOException{
		IndexRequest indexRequest = new IndexRequest(index).type(TYPE)
				.source(objectMapper.convertValue(t, Map.class))
		if(null != id) {
			indexRequest.opType(OpType.CREATE);
			indexRequest.id(id);
		}
		IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		return indexResponse.getId();
	}
	
	/**
	 * save data with id auto-generated
	 * @param index Index Name
	 * @param t data to be saved
	 * @return Id
	 * @throws IOException
	 */
	public <T> String save(String index, T t) throws IOException{
		return save(index, t, null);
	}

	/**
	 * fetch record by id
	 * @param index Index Name
	 * @param id Id
	 * @param classT Requested object class
	 * @return Optional<T> Requested object optional
	 */
	public <T> Optional<T> findById(String index, String id, Class<T> classT) throws IOException{
		GetRequest getRequest = new GetRequest(index).type(TYPE)
				.id(id);
		GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
		if(getResponse.isExists()) return Optional.of(objectMapper.readValue(getResponse.getSourceAsBytes(), classT));
		else return Optional.empty();
	}
	
}
