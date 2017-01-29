package anna.repository;

import anna.model.Gif;
import org.springframework.stereotype.Repository;
import sun.net.www.content.image.gif;

import java.util.Arrays;
import java.util.List;

@Repository
public class GifRepository {
    private static final List<Gif>ALL_GIFS = Arrays.asList(
        new Gif("android-explosion","anna", false),
            new Gif("ben-and-mike",  "anna", true),
            new Gif("book-dominos", "anna", false),
            new Gif("compiler-bot", "anna", true),
            new Gif("cowboy-coder",  "anna", false),
            new Gif("infinite-andrew", "anna", true)
    );

    public Gif findByName(String name){
        for(Gif gif: ALL_GIFS){
            if(gif.getName().equals(name))
                return gif;
        }
        return null;
    }

    public  List<Gif> getAllGifs() {
        return ALL_GIFS;
    }
}
