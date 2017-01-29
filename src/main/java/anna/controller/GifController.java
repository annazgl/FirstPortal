package anna.controller;

import anna.model.Gif;
import anna.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @GetMapping("/")
    public String listGifs(ModelMap modelMap){
        modelMap.addAttribute("gifs",gifRepository.getAllGifs());
        return "home";
    }


    @GetMapping("/gif")
    public String gifDetails(ModelMap modelMap){
        Gif gif= gifRepository.findByName("android-explosion");
        modelMap.put("gif",gif);
        return "gif-details";
    }
}
