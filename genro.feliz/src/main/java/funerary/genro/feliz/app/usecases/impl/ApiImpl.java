package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.usecases.ApiGateway;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiImpl implements ApiGateway {

    private final RestTemplate restTemplate;

    private final String API_KEY = "AIzaSyC4xATHngK6zJ2FOgiVTCs6usKJHrrkpxo";
    private final String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + API_KEY;

    public ApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateContent(String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                URL,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to call API: " + response.getStatusCode());
        }
    }
}
