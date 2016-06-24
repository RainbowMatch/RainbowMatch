package ch.patrickguenthard.rest;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NameBinding;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.entity.UserDetail;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.exceptions.UserException;
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
    
    @DELETE
    @Path("user")
    public User deleteUser(User user) throws UnsupportedException {
    	userService.deleteUser(user);
    	return user;
    }

    @POST
    @Path("login")
    public Response login(User usr) throws UserException {
    
    	Response resp = Response.status(200)
    			.entity(new LoginResponse("Login Successful",userService.checkUser(usr)))
    			.header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    	
    	return resp;
    }
    
   
}
