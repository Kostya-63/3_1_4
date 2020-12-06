package restService;

import model.User;
import org.springframework.web.client.RestTemplate;

public class GetData1 {

    static final String URL_EMPLOYEES = "http://91.241.64.178:7081/api/users";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method and default Headers.
        User[] list = restTemplate.getForObject(URL_EMPLOYEES, User[].class);

        if (list != null) {
            for (User e : list) {
                System.out.println("User: " + e.getId() + " - " + e.getName() + " - " + e.getLastName() + " - " + e.getAge());
            }
        }
    }
}