package ac.av8242n.restclient.service;

import ac.av8242n.restclient.json.JokeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    private Logger logger = LoggerFactory.getLogger(JokeService.class);

    private RestTemplate restTemplate;
    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    @Autowired
    public JokeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getJoke(String first, String last) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE, first, last);
        String joke = restTemplate.getForObject(url, JokeResponse.class).getValue().getJoke();
        logger.info(joke);

        ResponseEntity<JokeResponse> response = restTemplate.getForEntity(url, JokeResponse.class);
        logger.info(""+ response.getStatusCode());
        response.getBody().getValue().getJoke();

        return joke;
    }
}
