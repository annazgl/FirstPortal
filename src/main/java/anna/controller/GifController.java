package anna.controller;

import anna.model.Gif;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GifController {

    @GetMapping("/")
    public String listsGifs(){
        return "home";
    }

    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        Gif gif= new Gif("android-explosion", "anna",true);
        modelMap.put("gif",gif);
        return "gif-details";
    }
}
