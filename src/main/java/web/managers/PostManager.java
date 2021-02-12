package web.managers;
import web.entitites.PostEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class PostManager {
    private ArrayList<PostEntity> postEntities = new ArrayList<>();

    public ArrayList<PostEntity> getPosts(){
        return postEntities;
    }

    public boolean create(PostEntity postDetail) {
        if(postDetail.getRating() < 0 || postDetail.getRating() > 100)
            return false;
        int generatedId = (int) (Math.random()*(100 +1));
        if (postCheck(generatedId)){
            postDetail.setId(generatedId);
        }
        return true;
    }
    public PostEntity getPost (int id){
        return postEntities.stream()
                .filter(gameDetailStream -> id == gameDetailStream.getId())
                .findAny()
                .orElse(null);
    }
    public boolean removePost(int id){
        return  postEntities.remove(getPost(id));
    }
    public boolean postCheck(int id) {
        for (int i = 0; i < 100; i++){
            if (id != postEntities.get(id).id) {
            return false;
        }
    }
        return true;
    }



}
