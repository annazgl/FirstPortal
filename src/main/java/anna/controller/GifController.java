package anna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifController {

    @GetMapping("/")
    public String listsGifs(){
        return "home";
    }
}
