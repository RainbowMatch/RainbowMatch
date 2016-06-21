package ch.patrickguenthard.rest;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserDetail;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.service.UserDetailService;
import ch.patrickguenthard.service.UserDetailServiceImpl;
import ch.patrickguenthard.service.UserService;
import ch.patrickguenthard.service.UserServiceImpl;


@Path("api/users")
@Produces({"application/json"})
public class UserRestService {
    
    private UserDetailService userDetailService;
    private UserService userService;
    
    public UserRestService() {
	userDetailService = new UserDetailServiceImpl();
	userService = new UserServiceImpl();
    }
    
    @GET
    @Path("users")
    public List<UserDetail> searchUsers() {
	return userDetailService.searchAllUserDetails();
    }
    
    @POST
    @Path("user")
    public User createUser(User user) throws UnsupportedException{
	userService.addUser(user);
	System.out.println(user);
	return user;
    }

   
}
