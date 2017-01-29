package anna.repository;

import anna.model.Category;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES= Arrays.asList(
            new Category(1,"Gifs"),
            new Category(2,"Mems"),
            new Category(3, "Technology")

    );

    public List<Category>getAllCategories(){
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for(Category category:ALL_CATEGORIES){
            if(category.getId()==id)
                return category;
        }
        return null;
    }
}
