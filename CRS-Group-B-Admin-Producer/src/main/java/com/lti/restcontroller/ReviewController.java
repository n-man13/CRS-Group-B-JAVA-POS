package com.lti.restcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.dto.ClientDetail;

@RestController
@CrossOrigin
public class ReviewController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getClientData/{clientID}")
	public ResponseEntity<?> getClientData(@PathVariable String clientID) throws FileNotFoundException {
		List<ClientDetail> clientDetails = new ArrayList<>();

		InputStream stream = getClass().getClassLoader().getResourceAsStream("ClientDetails.config.json");
		ObjectMapper map = new ObjectMapper();

		try {
			clientDetails = map.readValue(stream, new TypeReference<List<ClientDetail>>() {

			});
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		for (ClientDetail c : clientDetails){
			if(c.getClientID().equalsIgnoreCase(clientID)){
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				HttpEntity<ClientDetail> entity = new HttpEntity<>(c, headers);
				restTemplate.exchange("http://localhost:8094/logClientData", HttpMethod.POST, entity, String.class);
				return new ResponseEntity<>(c, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(clientID, HttpStatus.NOT_FOUND);
		
	}
}
