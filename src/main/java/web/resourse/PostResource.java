package web.resourse;

import web.entitites.PostEntity;
import web.managers.PostManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("posts")
@Produces(MediaType.APPLICATION_JSON)

public class PostResource {
    @Inject
    private PostManager manager;


    @GET
    public Response getAll() {
        return Response.ok(manager.getPosts()).build();
    }

    @GET
    @Path("{id}")
    public Response getPost(@PathParam("id") int id) {
        return  Response.ok(manager.getPost(id)).build();
    }

    @POST
    public Response createPost(PostEntity post){
        if(!manager.create(post))
            return Response.status(400).build();

        return Response.ok(post).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePost(@PathParam("id") int id) {
        if(manager.removePost(id)){
            return Response.ok("Post deleted").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
