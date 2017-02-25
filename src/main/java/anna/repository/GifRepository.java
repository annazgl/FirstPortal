package anna.repository;

import anna.model.Gif;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {
    private static final List<Gif>ALL_GIFS = Arrays.asList(
        new Gif("android-explosion","anna", false,1),
            new Gif("ben-and-mike",  "anna", true,1),
            new Gif("book-dominos", "anna", false,2),
            new Gif("compiler-bot", "anna", true,3),
            new Gif("cowboy-coder",  "anna", false,2),
            new Gif("infinite-andrew", "anna", true,3)
    );



    public Gif findByName(String name){
        for(Gif gif: ALL_GIFS){
            if(gif.getName().equals(name))
                return gif;
        }
        return null;
    }

    public List<Gif> findByCategoryId(int categoryId){
        List<Gif>gifs = new ArrayList<Gif>();
        for(Gif gif: ALL_GIFS){
            if(gif.getCategoryId()==categoryId)
                gifs.add(gif);
        }
        return gifs;
    }

    public  List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif>getFavorites(){
        List<Gif> favorites = new ArrayList<Gif>();
        for(Gif gif: ALL_GIFS){
            if(gif.isFavorite())
                favorites.add(gif);
        }
        return favorites;
    }

}
