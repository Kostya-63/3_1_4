package restService;

import model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class GetData3 {
    public static void main(String[] args) {
        User James = new User(3L, "James", "Brown", Byte.valueOf("27"));
        User Thomas = new User(3L, "Thomas", "Shelby", Byte.valueOf("28"));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<User[]> entity1 = new HttpEntity<>(headers);

        ResponseEntity<User[]> response1 = restTemplate.exchange(
                "http://91.241.64.178:7081/api/users",
                HttpMethod.GET, entity1, User[].class);

        String cookie = response1.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        System.out.println(cookie);

        HttpHeaders headers1 = new HttpHeaders();
        headers1.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers1.setContentType(MediaType.APPLICATION_JSON);
        headers1.set("Cookie", cookie);

        HttpEntity<User> entity2 = new HttpEntity<>(James, headers1);
        ResponseEntity<String> response2 = restTemplate.postForEntity(
                "http://91.241.64.178:7081/api/users",
                entity2, String.class);

        HttpEntity<User> entity3 = new HttpEntity<>(Thomas, headers1);
        ResponseEntity<String> response3 = restTemplate.exchange(
                "http://91.241.64.178:7081/api/users",
                HttpMethod.PUT, entity3, String.class);

        HttpEntity entity4 = new HttpEntity(headers1);
        ResponseEntity<String> response4 = restTemplate.exchange(
                "http://91.241.64.178:7081/api/users/3",
                HttpMethod.DELETE, entity4, String.class);

        System.out.println(response2.toString());
        System.out.println(response3.toString());
        System.out.println(response4.toString());
    }
}
