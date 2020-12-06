package restService;

import model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class GetData4 {
    public static void main(String[] args) {
        final String url = "http://91.241.64.178:7081/api/users";

        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<User[]> entity = new HttpEntity<User[]>(headers);

        HttpEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);
        HttpHeaders headers2 = response.getHeaders();
        String set_cookie = headers2.getFirst(headers2.SET_COOKIE);

        System.out.println("Response: " + response.toString() + "\n");
        System.out.println("Set-Cookie: " + set_cookie + "\n");
        System.out.println("********* FINISH *******");
    }
}
