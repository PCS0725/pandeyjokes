package life.springlearning.jokes.service;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.io.IOException;
import java.nio.charset.Charset;

@Profile("Named")
@Service
public class NamedJokeService implements JokeService {
    private static String joke = " ";
    //private final OkHttpClient httpClient = new OkHttpClient();
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static org.json.JSONObject readJsonFromUrl(String url) throws IOException ,JSONException{
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            org.json.JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    @Override
    public String getJoke() throws Exception {
        JSONObject json = readJsonFromUrl("http://api.icndb.com/jokes/random?firstName=Vikas&lastName=Pandey");
//        System.out.println(json.toString());
//        System.out.println(json.get("value"));
        JSONObject obj2 = (JSONObject) json.get("value");
        joke = (String) obj2.get("joke");

        return joke;
    }
}
