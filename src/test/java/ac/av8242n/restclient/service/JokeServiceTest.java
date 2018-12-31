package ac.av8242n.restclient.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokeServiceTest {

    @Autowired
    JokeService jokeService;

    @Test
    public void test() {
        String joke = jokeService.getJoke("Chuck", "Norris");
        assertTrue(joke.contains("Chuck") || joke.contains("Norris"));
    }

}