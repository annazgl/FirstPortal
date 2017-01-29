package anna.controller;

import anna.model.Category;
import anna.model.Gif;
import anna.repository.CategoryRepository;
import anna.repository.GifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;


    @GetMapping("/categories")
    public String listCategories(ModelMap modelMap){
        modelMap.addAttribute("categories",categoryRepository.getAllCategories());
        return "categories";
    }

    @RequestMapping ("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        modelMap.put("category", categoryRepository.findById(id));
        modelMap.put("gifs",gifRepository.findByCategoryId(id));
        return "category";
    }
}
