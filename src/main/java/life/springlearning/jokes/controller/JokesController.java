package life.springlearning.jokes.controller;

import life.springlearning.jokes.service.GetJokeService;
import life.springlearning.jokes.service.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    private final JokeService jokeService;

    public JokesController(JokeService jokeService) {
        this.jokeService=jokeService;
    }

    @RequestMapping({"/"," "})
    public String showJoke(Model model) throws Exception{
        //Model is the data object that is going to be passed to the view
        //we have to return the name of the view object from the function
        model.addAttribute("joke",jokeService.getJoke());
        return "jokes";
    }
}
