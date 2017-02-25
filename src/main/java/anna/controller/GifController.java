package anna.controller;

import anna.model.Gif;
import anna.repository.CategoryRepository;
import anna.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

import static javafx.scene.text.FontPosture.findByName;

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

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap){
        modelMap.addAttribute("gifs",gifRepository.getFavorites());
        return "favorites";
    }

    @GetMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        modelMap.put("gif", gifRepository.findByName(name));
        return "gif-details";
    }

    @GetMapping("/search")
    public String gifSearch(@RequestParam("q") String name, ModelMap modelMap) {
        modelMap.addAttribute("gifs", gifRepository.findByName(name));
        return "search";
    }

}
