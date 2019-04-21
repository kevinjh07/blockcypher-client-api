package com.blockcypher.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockcypher.response.AddressBalanceResult;
import com.blockcypher.response.NewAddressResult;
import com.blockcypher.util.UrlConstants;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@RestController
@RequestMapping("/address")
public class AddressEndpoint {
	
	@GetMapping("/balance/{address}")
	public ResponseEntity<Integer> getBalance(@PathVariable String address) {
		ClientConfig configuration = new ClientConfig(JacksonJsonProvider.class);
		Client client = ClientBuilder.newClient(configuration);
		WebTarget target = client.target(UrlConstants.BLOCKCYPHER_API_BASE_URL).path(String.format("/btc/main/addrs/%s/balance", address));
		AddressBalanceResult addressBalance = target.request(MediaType.APPLICATION_JSON).get(AddressBalanceResult.class);
		
		return new ResponseEntity<>(addressBalance.getBalance(), HttpStatus.OK);
	}
	
	@GetMapping("/public-key")
	public ResponseEntity<String> getAddressPublicKey() {
		ClientConfig configuration = new ClientConfig(JacksonJsonProvider.class);
		Client client = ClientBuilder.newClient(configuration);
		WebTarget target = client.target(UrlConstants.BLOCKCYPHER_API_BASE_URL).path("/btc/test3/addrs");
		Response response = target.request(MediaType.APPLICATION_JSON).post(null);
		NewAddressResult address = response.readEntity(NewAddressResult.class);
		
		return new ResponseEntity<>(address.getPublicKey(), HttpStatus.OK);
	}

}
