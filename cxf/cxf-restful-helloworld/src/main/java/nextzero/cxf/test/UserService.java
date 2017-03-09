package nextzero.cxf.test;

import javax.ws.rs.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Path("/userservice")
public class UserService {
    protected static Map<String, User> userList = new ConcurrentHashMap<String, User>();

    public UserService() {
        System.out.println("UserService对象构造函数！");
    }

    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public User getUser(@PathParam("id")String id ){
        System.out.println("get user by id= "+id);
        return userList.get(id);
    }

    @POST
    @Produces("application/xml")
    public void addUser(@FormParam("id") String id,@FormParam("name") String name){
        System.out.println("add user which id is:" + id);
        User user = new User();
        user.setId(id);
        user.setName(name);
        userList.put(id, user);
    }

    @PUT
    @Produces("application/xml")
    public void updateUser(@FormParam("id") String id,@FormParam("name") String name){
        System.out.println("put user which id is:" + id);
        User user = new User();
        user.setId(id);
        user.setName(name);
        userList.put(id, user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id")String id){
        System.out.println("remove user by id= " + id);
        userList.remove(id);
    }
}
