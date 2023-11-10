package me.kbh.elktoy.commercial.component;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestComponent {
  RestTemplate restTemplate;
  String baseUrl;

  public RestComponent() {
    this.restTemplate = new RestTemplate();
    this.baseUrl = "http://localhost:9200";
  }

  public <T> T sendGetRequest(String path, Class<T> responseType) {
    String url = baseUrl + path;
    ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
    return response.getBody();
  }

  public <T> T sendPostRequest(String path, Object requestBody, Class<T> responseType) {
    String url = baseUrl + path;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);

    ResponseEntity<T> response =
        restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
    return response.getBody();
  }

  public <T> T sendPutRequest(String path, Object requestBody, Class<T> responseType) {
    String url = baseUrl + path;

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);

    ResponseEntity<T> response =
        restTemplate.exchange(url, HttpMethod.PUT, requestEntity, responseType);
    return response.getBody();
  }

  public <T> T sendDeleteRequest(String path, Class<T> responseType) {
    String url = baseUrl + path;
    ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.DELETE, null, responseType);
    return response.getBody();
  }
}
