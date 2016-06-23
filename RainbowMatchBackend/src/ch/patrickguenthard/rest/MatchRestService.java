package ch.patrickguenthard.rest;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ch.patrickguenthard.entity.Match;
import ch.patrickguenthard.entity.NonBinaryGender;
import ch.patrickguenthard.entity.Profile;
import ch.patrickguenthard.entity.Region;
import ch.patrickguenthard.entity.SexualOrientation;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.service.MatchService;
import ch.patrickguenthard.service.MatchServiceImpl;
import ch.patrickguenthard.service.NonBinaryGenderService;
import ch.patrickguenthard.service.NonBinaryGenderServiceImpl;
import ch.patrickguenthard.service.ProfileService;
import ch.patrickguenthard.service.ProfileServiceImpl;
import ch.patrickguenthard.service.RegionService;
import ch.patrickguenthard.service.RegionServiceImpl;
import ch.patrickguenthard.service.SexualOrientationService;
import ch.patrickguenthard.service.SexualOrientationServiceImpl;


@Path("api/match")
@Produces({"application/json"})
public class MatchRestService {
    
	private MatchService matchService;
	
    public MatchRestService() {
    	matchService = new MatchServiceImpl();
    }
        
    @GET
    @Path("requests/{userid}/")
    public List<Match> searchRequestedMatches(@PathParam("userid") Long userid) {
    	return matchService.listRequestedByUser(userid);
    }
    
    @GET
    @Path("approvals/{userid}/")
    public List<Match> searchApprovedMatches(@PathParam("userid") Long userid) {
    	return matchService.listApprovesByUser(userid);
    }
    
}
