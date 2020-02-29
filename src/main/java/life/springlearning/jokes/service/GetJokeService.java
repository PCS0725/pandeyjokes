package life.springlearning.jokes.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Chuck")
@Service
public class GetJokeService implements JokeService {
    private String joke;
    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public GetJokeService() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    public String getJoke(){
        joke = chuckNorrisQuotes.getRandomQuote();
        return joke;
    }
}
