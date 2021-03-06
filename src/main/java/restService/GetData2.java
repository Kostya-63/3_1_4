package restService;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class GetData2 {

    static final String URL_EMPLOYEES = "http://91.241.64.178:7081/api/users";

    public static void main(String[] args) {

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();

        System.out.println(result);
    }
}