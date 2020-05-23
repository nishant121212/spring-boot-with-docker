package com.learn.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.controller.dto.UserRequest;
import com.learn.controller.dto.UserResponse;
import com.learn.service.UserService;

/**
 * handle users REST APIs
 * @author Nishant
 *
 */
@RestController
public class UserController {

	@Autowired
	@Qualifier("UserServiceElasticImpl")
	private UserService userService;
	
	@PostMapping("/v1/users")
	public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRequest userRequest){
		try {
			String id = userService.registerUser(userRequest);
			URI uri = new URI("/user-service/v1/users/" + id);
			return ResponseEntity.created(uri).body(null);
		} catch (IOException | URISyntaxException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ElasticsearchException es) {
			return new ResponseEntity<>(getHttpStatus(es));
		}
	}
	
	@GetMapping("/v1/users/{id}")
	public ResponseEntity<UserResponse> registerUser(@PathVariable("id") String id){
		try {
			UserResponse userResponse = userService.getUser(id);
			if(null == userResponse) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else return ResponseEntity.ok().body(userResponse);
		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ElasticsearchException es) {
			return new ResponseEntity<>(getHttpStatus(es));
		}
	}
	
	/**
	 * get HttpStatus from ElasticsearchException
	 * @param es ElasticsearchException
	 * @return HttpStatus
	 */
	private HttpStatus getHttpStatus(ElasticsearchException es) {
		RestStatus restStatus = es.status();
		return HttpStatus.resolve(restStatus.getStatus());
	}
}
