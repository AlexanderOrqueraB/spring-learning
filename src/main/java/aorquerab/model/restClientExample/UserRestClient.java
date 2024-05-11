package aorquerab.model.restClientExample;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

//After all this example, your "app" will act as a CLIENT, doing requests to a SERVER (API) and receiving responses with
//info from the API
@Component
public class UserRestClient {
    private final RestClient restClient;

    public UserRestClient(RestClient.Builder restClient) {
        this.restClient = RestClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }

    //Methods to interact with the API
    //GET ALL USERS
    public List<User> findAll(){
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    //GET ONE USER
    public User findUserById(Integer id) {
        return restClient.get()
                .uri("/users/{id}",id)
                .retrieve()
                .body(User.class);
    }
}
