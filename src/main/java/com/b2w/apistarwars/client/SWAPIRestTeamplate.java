package com.b2w.apistarwars.client;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.b2w.apistarwars.PedroApiStarWarsApplication;
import com.b2w.apistarwars.exception.ServiceUnavailable;
import com.b2w.apistarwars.models.ResultApiSW;

@Service
public class SWAPIRestTeamplate {
	
    String url = "https://swapi.co/api/planets/";
    
	protected static final Logger LOGGER = LoggerFactory.getLogger(PedroApiStarWarsApplication.class);
	public RestTemplate geraRestTeamplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
		
	}
	public ResponseEntity<ResultApiSW> RetornaAparicoes() {
		
		try {
			
			return geraRestTeamplate().exchange(url, HttpMethod.GET,geraHeader(),ResultApiSW.class);
   		
		}catch(Exception e) {
   			
   			throw new ServiceUnavailable("SWAPI fora do ar");
   		}
   			 
	}
	
	public HttpEntity<String> geraHeader(){
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return entity;
	}
	
}
	    	

