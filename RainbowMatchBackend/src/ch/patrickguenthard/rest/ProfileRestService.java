package ch.patrickguenthard.rest;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ch.patrickguenthard.entity.NonBinaryGender;
import ch.patrickguenthard.entity.Profile;
import ch.patrickguenthard.entity.Region;
import ch.patrickguenthard.entity.SexualOrientation;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.service.NonBinaryGenderService;
import ch.patrickguenthard.service.NonBinaryGenderServiceImpl;
import ch.patrickguenthard.service.ProfileService;
import ch.patrickguenthard.service.ProfileServiceImpl;
import ch.patrickguenthard.service.RegionService;
import ch.patrickguenthard.service.RegionServiceImpl;
import ch.patrickguenthard.service.SexualOrientationService;
import ch.patrickguenthard.service.SexualOrientationServiceImpl;


@Path("api/profile")
@Produces({"application/json"})
public class ProfileRestService {
    
	private ProfileService profileService;
	private NonBinaryGenderService nbgService;
	private SexualOrientationService soService;
	private RegionService regionService;
	
    public ProfileRestService() {
    	profileService = new ProfileServiceImpl();
    	nbgService = new NonBinaryGenderServiceImpl();
    	soService = new SexualOrientationServiceImpl();
    	regionService = new RegionServiceImpl();
	}
    
    @GET
    @Path("info/{userid}")
    public Profile userInfo(@PathParam("userid") Long userid){
    	return profileService.getProfileByUser(userid);
    }
    
    @POST
    @Path("update/")
    public Profile updateProfile(Profile pr) throws UnsupportedException {
    	profileService.updateProfile(pr);
    	return pr;
    }
    
    @GET
    @Path("nbgender/all")
    public List<NonBinaryGender> searchAllNonBinaryGender() {
    	return nbgService.searchAllNonBinaryGender();
    }
    
    @GET
    @Path("sorientation/all")
    public List<SexualOrientation> searchAllSexualOrientation() {
    	return soService.searchAllSexualOrientation();
    }
    
    
    @GET
    @Path("regions/all")
    public List<Region> searchAllRegion() {
    	return regionService.searchAllRegion()	;
    }
    
}
